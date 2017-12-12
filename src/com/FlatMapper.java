package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by jsst_ on 12/11/2017.
 */
public class FlatMapper {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Jess","Angie","Johnny","Jenny","Daisy","Glen","Gavin");
        List<String> strings1 = Arrays.asList("Jess","Johnny","Daisy");
        List<String> strings2 = Arrays.asList("Angie","Glen","Gavin");

        List<List<String>> lists = Arrays.asList(strings, strings1, strings2);

        System.out.println(lists);

        Function<List<?>,Integer> function = a -> a.size();


        Function<List<String>,Stream<String>> function1 = a -> a.stream();

        lists.stream()
                .flatMap(function1)
                .forEach(System.out::println);

    }
}
