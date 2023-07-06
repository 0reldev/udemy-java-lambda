package dev.miniChallenge1;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        // TODO: convert the following method into a lambda expression
        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[]  parts = sentence.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printThePartsLambda = sentence -> {
            String[]  parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        printTheParts.accept("Let's split this up into an array.");
//        Let's
//        split
//        this
//        up
//        into
//        an
//        array.
        printThePartsLambda.accept("Let's split this up into an array.");
//        Let's
//        split
//        this
//        up
//        into
//        an
//        array.

        Consumer<String> printThePartsForEach = sentence -> {
            String[]  parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };
        printThePartsForEach.accept("Let's split this up into an array.");
//        Let's
//        split
//        this
//        up
//        into
//        an
//        array.

        Consumer<String> printThePartsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };
        printThePartsConcise.accept("Let's split this up into an array.");
//        Let's
//        split
//        this
//        up
//        into
//        an
//        array.
    }
}
