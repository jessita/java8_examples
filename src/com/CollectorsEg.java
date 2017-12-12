package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jsst_ on 12/11/2017.
 */
public class CollectorsEg {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(CollectorsEg.class.getResourceAsStream("persons.txt")));


        Optional<Person> min = bufferedReader.lines()
                .map(l -> {
            String[] strings = l.split(" ");
            Person p = new Person(strings[0].trim(), Integer.parseInt(strings[1].trim()));
             people.add(p);
            return p;
        })
                .filter(p -> p.getAge() >= 20)
                .min(Comparator.comparingInt(Person::getAge));

        System.out.println(min);

        System.out.println("-------------------------");

        System.out.println(people.stream().max(Comparator.comparingInt(Person::getAge)));

        System.out.println("-------------------------");

         Map<Integer, String> collect = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.joining(", "))
                ));

        System.out.println(collect);
    }
}
