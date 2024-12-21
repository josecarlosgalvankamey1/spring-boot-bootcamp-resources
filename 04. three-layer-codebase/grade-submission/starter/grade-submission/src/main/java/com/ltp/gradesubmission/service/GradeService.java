package com.ltp.gradesubmission.service;

import java.util.List;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;

public class GradeService {

    GradeRepository gradeRepository = new GradeRepository();

    public Grade getGrade(int id) {
        return gradeRepository.getGrade(id);
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(int index, Grade grade) {
        gradeRepository.updateGrade(index, grade);
    }

    public List<Grade> getGrades() {
        return gradeRepository.getGrades();
    }

    public int getGradeIndex(String id) {
        List<Grade> studentGrades = getGrades();
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeByIndex(String id) {
        int index = getGradeIndex(id);
        return (index == Constants.NOT_FOUND ? new Grade() : getGrade(index));
    }

    public void submitGrade(Grade grade) {
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
        } else {
            updateGrade(index, grade);
        }
    }
}
