package com.example.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {

    @GetMapping("/")
    public String getForm() {
        return "sign-up";
    }

    @GetMapping("/result")
    public String getResult() {
        return "result";
    }
}
