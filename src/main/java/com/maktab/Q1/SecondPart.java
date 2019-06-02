package com.maktab.Q1;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SecondPart {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad", "Ali", "Davood", "Reza", "Mohsen");
        Map<Integer, List<String>> result = names.stream().collect(groupingBy(String::length));
        TreeMap<Integer, Long> result2 = names.stream().collect(groupingBy(String::length, TreeMap::new, counting()));
        System.out.println(result);
        System.out.println(result2);
    }
}
