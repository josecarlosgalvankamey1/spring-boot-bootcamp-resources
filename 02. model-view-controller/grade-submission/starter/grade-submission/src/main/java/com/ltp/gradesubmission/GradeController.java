package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String name) {
        Grade grade;
        int index = getGradeIndex(name);
        grade = index == -1 ? new Grade() : studentGrades.get(index);
        model.addAttribute("grade", grade);
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
        int index = getGradeIndex(grade.getName());
        if (index == -1) {
            studentGrades.add(grade);
        } else {
            studentGrades.set(index, grade);
        }
        return "redirect:/grades";
    }

    public int getGradeIndex(String name) {
        for (int i = 0; i < studentGrades.size(); i++) {
            Grade currentGrade = studentGrades.get(i);
            if (currentGrade.getName().equals(name))
                return i;
        }
        return -1;
    }
}
