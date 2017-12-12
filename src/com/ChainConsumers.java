package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by jsst_ on 12/11/2017.
 */
public class ChainConsumers {
    public static void main(String[] args) {


        List<String> strings = Arrays.asList("Jess","Angie","Johnny","Jenny");
        List<String> resultList = new ArrayList<>();

        Consumer<String> consumer= System.out::println;
        Consumer<String> consumer1 = resultList::add;


        //strings.forEach(consumer.andThen(consumer1));

        //create a stream from a list
        //strings.stream().forEach(consumer);

        Predicate<String> predicate = s -> s.length()>5;

        strings.stream().filter(predicate).forEach(consumer);

        System.out.println("-------------------------------");

        Predicate<String> predicate1 = Predicate.isEqual("Jenny");
        Predicate<String> predicate2 = Predicate.isEqual("Johnny");

        strings.stream().filter(predicate1).forEach(consumer);

        System.out.println("-------------------------------");

        strings.stream().filter(predicate1.or(predicate2)).forEach(consumer);

        System.out.println("-------------------------------");

        strings.stream().peek(System.out::println).filter(predicate1.or(predicate2)).peek(resultList::add);

        System.out.println("-------------------------------");


    }
}
