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
        }
        return "";
    }
}
