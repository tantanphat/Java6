package com.example.java6.Controller;

import com.example.java6.Entity.Student2;
import com.example.java6.Security.service.UserPrincipal;
import com.example.java6.Security.service.UserPrincipalService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class HelloController {
    public static String JSON_STUDENTS = System.getProperty("user.dir") + "/src/main/resources/static/students.json";
    public static String JSON_STUDENT = System.getProperty("user.dir") + "/src/main/resources/static/student.json";
    @Autowired
    HttpServletRequest req;
    @Autowired
    HttpSession session;
    @Autowired
    ServletContext context;

    @GetMapping("/hello")
    public String helloWorld(Model model) throws Exception {
        model.addAttribute("message", "Xin chào Tấn Phát");
        ObjectMapper mapper = new ObjectMapper();
        Student2 student = mapper.readValue(new File(JSON_STUDENT),Student2.class);
        model.addAttribute("student", student);
        return "index";
    }

    @GetMapping("/scope")
    public String scope(Model model) {
        model.addAttribute("model","I am Model");
        req.setAttribute("request", "I am Request");
        session.setAttribute("session", "I am Session");
        context.setAttribute("context", "I am Context");
        return "scope";
    }

    @GetMapping("/student")
    public String student(Model model, @RequestParam("index")Optional<Integer> index ) throws Exception {
       ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student2>> type = new TypeReference<>() {};
       List<Student2> list = mapper.readValue(new File(JSON_STUDENTS),type);

       Student2 student = list.get(index.orElse(0));
        model.addAttribute("sv", student);
        model.addAttribute("index", index.orElse(0));

        return "student";
    }

    @GetMapping("/operator")
    public String operator(Model model) {
        model.addAttribute("x", 10);
        model.addAttribute("y", 5);
        return "operator";
    }


    @GetMapping("/student/list")
    public String studentList(Model model, @RequestParam("index")Optional<Integer> index ) throws Exception {
        File file = new ClassPathResource("/static/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student2>> type = new TypeReference<>() {};
        List<Student2> list = mapper.readValue(file,type);

//        Student2 student = list.get(index.orElse(0));
        model.addAttribute("sv", list.get(index.orElse(0)));
        model.addAttribute("dssv", list);
        return "list";
    }


    @GetMapping("/utilities")
    public String utilities(Model model) throws Exception {
        File file = new ClassPathResource("/static/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student2>> type = new TypeReference<>() {};
        List<Student2> list = mapper.readValue(file,type);

        model.addAttribute("dssv", list);
        model.addAttribute("now", new Date());
        return "utilities";
    }


    @GetMapping("/firbase-sinh-vien")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String firbaseSinhVien() {
        return "view/index";
    }


    @GetMapping("/account")
    @PreAuthorize("hasAuthority('USER')")
    public String account() {
        return "view/account";
    }


    @GetMapping("/students")
    @PreAuthorize("hasAnyAuthority('USER','GUEST')")
    public String students() {
        return "view/students";
    }


    @GetMapping("/my-information")
    @PreAuthorize("isAuthenticated()")
    public String myInformation(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//        Collection<? extends GrantedAuthority> authorities = userPrincipal.getAuthorities();
//        String roles = authorities.stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(", "));
        model.addAttribute("username", userPrincipal.getUsername());
        model.addAttribute("roles", userPrincipal.getAuthorities().stream().toList());

        return "lab7/my-information";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }


    @GetMapping("/manager-authorities")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String managerAuthorities() {
        return "lab7/manager-authorities";
    }
}
