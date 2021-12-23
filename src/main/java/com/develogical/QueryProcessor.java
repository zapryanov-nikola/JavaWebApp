package com.develogical;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class QueryProcessor {

    public String process(String query) {
        String lowerCaseQuery = query.toLowerCase().split(":")[1].trim();
        if (lowerCaseQuery.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (lowerCaseQuery.contains("horse")) {
            return "this is a horse";
        } else if (lowerCaseQuery.contains("what is your name")) {
            return "nikraphael";
        } else if (lowerCaseQuery.contains("what is") && lowerCaseQuery.contains("plus")) {
            int first = Integer.parseInt(lowerCaseQuery.split(" ")[2]);
            int second = Integer.parseInt(lowerCaseQuery.split(" ")[4]);
            int sum = first + second;

            return String.format("%d", sum);
        } else if (lowerCaseQuery.contains("which of the following numbers is the largest")) {
            List<String> numbers = Arrays.asList(query.toLowerCase().split(":")[2].trim().split(", "));
            int max = 0;
            for (String number :
                    numbers) {
                max = Math.max(max, Integer.parseInt(number));
            }

            return String.format("%d", max);
        } else if (lowerCaseQuery.contains("what is") && lowerCaseQuery.contains("multiplied by")) {
            int first = Integer.parseInt(lowerCaseQuery.toLowerCase().split(" ")[2]);
            int second = Integer.parseInt(lowerCaseQuery.toLowerCase().split(" ")[5]);
            int product = first * second;

            return String.format("%d", product);
        } else if (lowerCaseQuery.contains("which of the following numbers is both a square and a cube")) {
            List<String> numbers = Arrays.asList(query.toLowerCase().split(":")[2].trim().split(", "));
            int both = 0;
            for (String number :
                    numbers) {
                int actualNumber = Integer.parseInt(number);
                if (isCube(actualNumber) && isSquareRoot(actualNumber)) {
                    both = actualNumber;
                }
            }
            if (both == 0) {
                return "";
            }
            return String.format("%d", both);
        } else if (lowerCaseQuery.contains("which city is the eiffel tower in")) {
            return "Paris";
        }
        return "";
    }

    private boolean isCube(double input) {
        double cubeRoot = Math.cbrt(input); // get the cube root
        return Math.round(cubeRoot) == cubeRoot; // determine if number is integral
    }

    private boolean isSquareRoot(double input) {
        double squareRoot = Math.sqrt(input); // get the cube root
        return Math.round(squareRoot) == squareRoot; // determine if number is integral
    }
}
