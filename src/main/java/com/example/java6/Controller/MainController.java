package com.example.java6.Controller;

import com.example.java6.Entity.SinhVien3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lab3")
public class MainController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/home")
    public String home() {
        return "lab3/index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "lab3/contact";
    }


    @GetMapping("/student/form")
    @PreAuthorize("hasAuthority('USER')")
    public String studenForm(Model model) {
        SinhVien3 sv3 = new SinhVien3();
        model.addAttribute("sv",sv3);
        return "lab3/student-form";
    }

    @PostMapping("/student/save")
    public String studenSave(@Validated @ModelAttribute("sv") SinhVien3 form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "lab3/student-form";
        }
        return "lab3/student-result";
    }

    @GetMapping("/muttip-file")
    public String mutipFile() {
        return "view/multipfile";
    }





}
