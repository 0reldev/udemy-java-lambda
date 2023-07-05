package dev.otherExample;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));
        for (String s : list) {
            System.out.println(s);
        }
//        alpha
//        bravo
//        charlie
//        delta

        System.out.println("---------");
        list.forEach((var myString) -> System.out.println(myString));
//        alpha
//        bravo
//        charlie
//        delta

        System.out.println("----------");
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });
//        nato alpha means a
//        nato bravo means b
//        nato charlie means c
//        nato delta means d
    }
}
