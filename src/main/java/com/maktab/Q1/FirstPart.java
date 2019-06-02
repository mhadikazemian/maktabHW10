package com.maktab.Q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class FirstPart {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad", "Ali", "Davood", "Reza", "Mohsen");
        Map<Integer, List<String>> result = names.stream().collect(groupingBy(String::length));
        System.out.println(result);
    }//end of main method
}//end of FirstPart class
