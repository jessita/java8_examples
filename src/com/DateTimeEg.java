package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by jsst_ on 12/12/2017.
 */
public class DateTimeEg {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(CollectorsEg.class.getResourceAsStream("personsWithDob.txt")));


        Stream<String> lines = bufferedReader.lines();

        lines.map(line ->{
            String[] split = line.split(" ");
            String name = split[0];
            int year = Integer.parseInt(split[1]);
            Month month = Month.of(Integer.parseInt(split[2]));
            int day = Integer.parseInt(split[3]);

            Person p = new Person(name, LocalDate.of(year,month,day));
            people.add(p);
            return p;

        }).forEach(System.out::println);

        LocalDate date = LocalDate.now();
        people.stream().forEach(person -> {
            Period period = Period.between(person.getDob(), date);
            System.out.println(person.getName()+"'s age is "+period.getYears()+" "+ period.get(ChronoUnit.YEARS)+" "+ period.get(ChronoUnit.MONTHS)+" " + period.getMonths());
            System.out.println((person.getName()+"'s age in months "+ person.getDob().until(date,ChronoUnit.MONTHS)));
        });

    }
}
