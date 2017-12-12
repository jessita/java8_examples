package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * Created by jsst_ on 12/11/2017.
 */
public class ReductionEg {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList();
        //BinaryOperator<Integer> binaryOperator = (a1,a2 ) -> (a1+a2);
        Optional<Integer> reduce = integerList.stream().reduce( Integer::max);
        System.out.println(reduce);
    }
}
