package ru.project.system.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Generator {
    public static Map<Integer, Integer> genMeth() {
        Map<Integer, Integer> genResult = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int num = (int) (Math.random() * 100);
            genResult.merge(num, 1, Integer::sum);
        }
        return genResult;
    }

    public static double pi() {
        double n = 10_000_000;
        double w = 0;

        for (int i = 0; i < n; i++) {
            double x = Math.random();
            double y = Math.random();
            if ((x * x + y * y) < 1.0) w++;
        }

        double numerator = (4 * w);
        double pi = numerator / n;
        return pi;
    }

}
