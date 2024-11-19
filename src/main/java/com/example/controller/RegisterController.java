package com.example.controller;

import com.example.model.dto.RegisterDTO;
import com.example.model.entity.RegisterEntity;
import com.example.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String registerPage() {

        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public RegisterEntity register(RegisterDTO dto) {
        return registerService.register(dto);
    }
}
