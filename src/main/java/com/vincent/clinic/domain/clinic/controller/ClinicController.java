package com.vincent.clinic.domain.clinic.controller;

import com.vincent.clinic.domain.clinic.dto.ClinicAcceptRequest;
import com.vincent.clinic.domain.clinic.service.ClinicService;
import com.vincent.clinic.domain.department.dto.DepartmentDto;
import com.vincent.clinic.domain.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clinic", description = "진료일지에 관한 API")
@Controller
@RequestMapping("/clinic")
@RequiredArgsConstructor
public class ClinicController {

    private final DepartmentService departmentService;
    private final ClinicService clinicService;

    @GetMapping("")
    public String index() {
        return "redirect:/clinic/internal";
    }

    @Operation(summary = "진료일지 과별 메인 페이지(목록 페이지)")
    @GetMapping("/{path}")
    public String departmentIndex(@PathVariable String path, Model model) {
        DepartmentDto department = departmentService.findOneByPath(path);
        model.addAttribute("name", "clinic-"+department.getPath());
        model.addAttribute("department", department);
        return "index";
    }

    @Operation(summary = "진료일지 상세 페이지")
    @GetMapping("/{path}/{no}")
    public String clinicContent(
            @PathVariable Long no,
            Model model
    ) {
        model.addAttribute("name", "home");
        return "content";
    }

    @Operation(summary = "진료일지 추가 페이지")
    @GetMapping("/{path}/add")
    public String addView(Model model) {
        model.addAttribute("name", "add");
        return "add";
    }

    @Operation(summary = "접수하기")
    @PostMapping("/accept")
    public String accept(
            ClinicAcceptRequest request,
            Model model) {
        clinicService.accept(request.toServiceRequest());
        return "redirect:/patient/accept?result=success";
    }

    @Operation(summary = "진료일지 수정 페이지")
    @GetMapping("/{no}/edit")
    public String editView(Model model, @PathVariable Long no) {
        model.addAttribute("name", "edit");
        model.addAttribute("no", no);
        return "add";
    }

    @Operation(summary = "진료일지 수정")
    @PatchMapping("/{no}/edit")
    public String edit(@PathVariable Long no) {
        // 수정
        return "redirect:/clinic/"+no;
    }

    @Operation(summary = "진료일지 삭제")
    @DeleteMapping("/{no}/delete")
    public String delete(@PathVariable Long no) {
        // 삭제
        return "redirect:/clinic";
    }
}
