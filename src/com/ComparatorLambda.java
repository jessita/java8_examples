package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jsst_ on 12/8/2017.
 */
public class ComparatorLambda {
    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };

        Comparator<String> lambdaComparator = (String o1, String o2) ->  Integer.compare(o1.length(),o2.length());

        List<String> strings = Arrays.asList("Jessita","Johnson","Jack","Jason");
        strings.sort(lambdaComparator);
        for (String s:strings
             ) {
            System.out.println(s);
        }
    }
}
