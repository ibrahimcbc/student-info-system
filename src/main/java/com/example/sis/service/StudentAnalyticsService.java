package com.example.sis.service;

import com.example.sis.model.Enrollment;
import com.example.sis.model.Student;

import java.math.BigDecimal;
import java.util.List;

public class StudentAnalyticsService {

    public static BigDecimal calculateGPA(Student student) {
        List<Enrollment> enrollments = student.getEnrollments();

        if (enrollments == null || enrollments.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalPoints = BigDecimal.ZERO;
        int totalCredits = 0;

        for (Enrollment e : enrollments) {
            int credits = e.getCourse().getCredits();
            BigDecimal gradePoint = GradeConverter.toPoints(e.getLetterGrade());

            if (gradePoint == null) continue; // geçersiz harf notu varsa atla

            totalPoints = totalPoints.add(gradePoint.multiply(BigDecimal.valueOf(credits)));
            totalCredits += credits;
        }

        if (totalCredits == 0) return BigDecimal.ZERO;

        return totalPoints.divide(BigDecimal.valueOf(totalCredits), 2, BigDecimal.ROUND_HALF_UP);
    }
}
