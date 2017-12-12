package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jsst_ on 12/12/2017.
 */
public class MapsEg {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                CollectorsEg.class.getResourceAsStream("persons.txt")
                        )
                )

        ) {
            Stream<String> lines = bufferedReader.lines();
            lines.map(line -> {
                String[] split = line.split(" ");
                Person p = new Person(split[0].trim(), Integer.parseInt(split[1]), split[2].trim());
                people.add(p);
                return p;
            }).forEach(System.out::println);

            /**
             Merging Maps example
             */
            List<Person> list1 = people.subList(0, 5);
            List<Person> list2 = people.subList(5, people.size());

            Map<Integer, List<Person>> iListMap = mapByAge(list1);
            Map<Integer, List<Person>> iListMap2 = mapByAge(list2);
            System.out.println("Map 1");
            iListMap.forEach((i, l) -> System.out.println(i + " -> " + l));
            System.out.println("Map 2");
            iListMap2.forEach((i, l) -> System.out.println(i + " -> " + l));

            iListMap2.entrySet().stream().forEach(
                    entry -> {
                        iListMap.merge(entry.getKey(), entry.getValue(), (l1, l2) -> {
                            l1.addAll(l2);
                            return l1;
                        });
                    }
            );

            System.out.println("Map 1 after adding map 2 to it");
            iListMap.forEach((i, l) -> System.out.println(i + " -> " + l));


            /**
             * Builing a BiMap
             */
            System.out.println("Building Bi Map");
            Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();
            people.forEach(person -> {
                biMap.computeIfAbsent(person.getAge(), HashMap::new).merge(person.getGender(), new ArrayList(Arrays.asList(person)),
                        ((list, list21) -> {
                            list.addAll(list21);
                            return list;
                        }));

            });

            System.out.println("bimap");
            biMap.forEach((i, l) -> System.out.println(i + " -> " + l));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<Integer, List<Person>> mapByAge(List<Person> list) {
        return list.stream().collect(Collectors.groupingBy(Person::getAge));
    }

}
