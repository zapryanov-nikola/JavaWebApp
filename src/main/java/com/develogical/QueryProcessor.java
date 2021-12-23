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
                    return String.format("%d", both);
                }
            }
            return "";
        } else if (lowerCaseQuery.contains("which city is the eiffel tower in")) {
            return "Paris";
        } else if (lowerCaseQuery.contains("which of the following numbers are primes")) {
            List<String> numbers = Arrays.asList(query.toLowerCase().split(":")[2].trim().split(", "));
            String answer = "";
            for (String number :
                    numbers) {
                int actualNumber = Integer.parseInt(number);
                if (isPrime(actualNumber)) {
                    answer = answer + String.format("%d", actualNumber) + ", ";
                }
            }
            return removeLastChar(answer, 2);
        } else if (lowerCaseQuery.contains("number in the fibonacci sequence")) {
            int term = Integer.parseInt(removeLastChar(lowerCaseQuery.split(" ")[3], 2));

            return String.format("%d", fibonacci(term - 1));
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

    private boolean isPrime(int n) {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    private static String removeLastChar(String s, int index) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - index));
    }

    public static int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return fibonacci(n - 2) + (fibonacci(n - 1));
    }
}