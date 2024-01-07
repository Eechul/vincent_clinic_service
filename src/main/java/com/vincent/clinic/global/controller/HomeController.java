package com.vincent.clinic.global.controller;

import com.vincent.clinic.global.annotation.DController;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@DController
@RequestMapping("/")
public class HomeController extends BaseController {

    @GetMapping("")
    public String index() {
        return redirect("/clinic");
    }
}
