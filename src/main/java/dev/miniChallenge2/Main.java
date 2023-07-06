package dev.miniChallenge2;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    // TODO write the following method as a lambda expression
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }


    public static void main(String[] args) {

         UnaryOperator<String> everySecondCharLambda = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondCharLambda.apply("1234567890"));
//        24680
    }

    public static String everySecondChar(Function<String, String> function, String parameter) {
        return function.apply(parameter);
    }
}
