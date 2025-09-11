package com.example.sis.service;

import java.math.BigDecimal;
import java.util.Map;

public class GradeConverter {
    private static BigDecimal bd(double d){ return BigDecimal.valueOf(d).setScale(2); }

    private static final Map<String, BigDecimal> MAP = Map.ofEntries(
            Map.entry("A+",bd(4.0)),Map.entry("A", bd(4.0)), Map.entry("A-", bd(3.7)),
            Map.entry("B+", bd(3.3)), Map.entry("B", bd(3.0)), Map.entry("B-", bd(2.7)),
            Map.entry("C+", bd(2.3)), Map.entry("C", bd(2.0)), Map.entry("C-", bd(1.7)),
            Map.entry("D+", bd(1.3)), Map.entry("D", bd(1.0)), Map.entry("F", bd(0.0)), Map.entry("W",bd(0.0)));

    public static BigDecimal toPoints(String letter){
        if(letter==null) return null;
        return MAP.get(letter.trim().toUpperCase());
    }
}
