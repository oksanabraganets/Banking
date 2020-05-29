package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main( String[] args )throws Exception {

        final String NAME = "[А-ЗЙ-ЩЮЯЇІЄҐ][а-щьюяїієґ']{1,20}";
        String s = "Ыра";
        List<String> list = new ArrayList<>();
        list.add("Ёсип");
        list.add("Йосип");
        list.add("Ьосип");
        list.add("похто");
        list.add("Cергий");
        list.add("Иергий");
        list.add("Тергий");
        list.stream().map(x-> x.matches(NAME)).forEach(System.out::println);
    }
}
