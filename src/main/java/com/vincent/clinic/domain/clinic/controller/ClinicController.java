package com.vincent.clinic.domain.clinic.controller;

import com.vincent.clinic.domain.clinic.dto.ClinicAcceptRequest;
import com.vincent.clinic.domain.clinic.dto.ClinicDto;
import com.vincent.clinic.domain.clinic.dto.ClinicEditRequest;
import com.vincent.clinic.domain.clinic.dto.ClinicServiceRequest;
import com.vincent.clinic.domain.clinic.service.ClinicService;
import com.vincent.clinic.domain.department.dto.DepartmentDto;
import com.vincent.clinic.domain.department.service.DepartmentService;
import com.vincent.clinic.global.annotation.DController;
import com.vincent.clinic.global.model.Paging;
import com.vincent.clinic.global.model.SearchQ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Tag(name = "Clinic", description = "진료일지에 관한 API")
@DController
@RequestMapping("/clinic")
@RequiredArgsConstructor
public class ClinicController {

    private final DepartmentService departmentService;
    private final ClinicService clinicService;

    @GetMapping("")
    public String index() {
        return "redirect:/clinic/internal";
    }

    @Operation(summary = "진료일지 전체환자 검색결과 페이지")
    @GetMapping("/all")
    public String departmentIndex(
            @RequestParam(defaultValue = "") final String q,
            @RequestParam(defaultValue = "1") final Integer page,
            @RequestParam(defaultValue = "200") final Integer size,
            Model model) {
        Paging<ClinicDto> datas = clinicService.paging(
                ClinicServiceRequest.of(SearchQ.create("patientNumber", q), PageRequest.of(page-1, size))
        );
        model.addAttribute("name", "clinic-all");
        model.addAttribute("col", "patientNumber");
        model.addAttribute("q", q);
        model.addAttribute("datas", datas);
        return "all";
    }

    @Operation(summary = "진료일지 과별 메인 페이지(목록 페이지)")
    @GetMapping("/{path}")
    public String departmentIndex(
            @PathVariable String path,
            @RequestParam(defaultValue = "") final String col,
            @RequestParam(defaultValue = "") final String q,
            @RequestParam(defaultValue = "1") final Integer page,
            @RequestParam(defaultValue = "200") final Integer size,
            Model model) {
        DepartmentDto dept = departmentService.findOneByPath(path);
        Paging<ClinicDto> datas = clinicService.pagingByDepartmentNo(
                dept.getNo(),
                ClinicServiceRequest.of(SearchQ.create(col, q), PageRequest.of(page-1, size))
        );
        model.addAttribute("name", "clinic-"+dept.getPath());
        model.addAttribute("dept", dept);
        model.addAttribute("col", col);
        model.addAttribute("q", q);
        model.addAttribute("datas", datas);
        return "index";
    }

    @Operation(summary = "진료일지 상세 페이지")
    @GetMapping("/{path}/{no}")
    public String clinicContent(@PathVariable final String path, @PathVariable final Long no, final Model model) {
        departmentService.findOneByPath(path);
        ClinicDto clinic = clinicService.findOne(no);
        model.addAttribute("name", "clinic-"+clinic.getDepartment().getPath());
        model.addAttribute("clinic", clinic);
        return "content";
    }

    @Operation(summary = "접수하기")
    @PostMapping("/accept")
    public String accept(final ClinicAcceptRequest request) {
        clinicService.accept(request.toService());
        return "redirect:/patient/accept/success?patientName="
                +URLEncoder.encode(request.getPatientName(), StandardCharsets.UTF_8);
    }

    @Operation(summary = "진료일지 수정 페이지")
    @GetMapping("/{no}/edit")
    public String editView(final Model model, @PathVariable final Long no) {
        ClinicDto clinic = clinicService.findOne(no);
        model.addAttribute("name", "clinic-"+clinic.getDepartment().getPath());
        model.addAttribute("no", no);
        model.addAttribute("clinic", clinic);
        return "add";
    }

    @Operation(summary = "진료일지 수정")
    @PostMapping("/{no}/edit")
    public String edit(@PathVariable final Long no, final ClinicEditRequest request) {
        ClinicDto clinic = clinicService.modify(request.toService());
        return "redirect:/clinic/"+clinic.getDepartment().getPath()+"/"+no;
    }

    @Operation(summary = "진료일지 삭제")
    @DeleteMapping("/{no}/delete")
    public String delete(final @PathVariable Long no) {
        ClinicDto existClinic = clinicService.findOne(no);
        clinicService.delete(no);
        return "redirect:/clinic/"+existClinic.getDepartment().getPath();
    }

}