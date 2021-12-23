package com.develogical;

import java.util.Locale;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("horse")) {
            return "this is a horse";
        } else if (query.toLowerCase().contains("what is your name")) {
            return "nikraphael";
        } else if (query.toLowerCase().startsWith("what is") && query.toLowerCase().contains("plus")) {
            int first = Integer.parseInt(query.toLowerCase().split(" ")[2]);
            int second  = Integer.parseInt(query.toLowerCase().split(" ")[4]);
            int sum = first + second;

            return String.format("%d", sum);
        }
        return "";
    }
}
