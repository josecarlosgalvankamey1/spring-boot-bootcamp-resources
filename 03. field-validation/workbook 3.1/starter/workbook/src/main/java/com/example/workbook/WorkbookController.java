package com.example.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkbookController {

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @GetMapping("/result")
    public String getResult() {
        return "result";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "sign-up";
        }
        System.out.println(user);
        return "redirect:result";
    }
}
