package com.example.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowsController {

    @GetMapping("/")
    public String home() {
        return "shows";
    }
}
