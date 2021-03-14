package com.company;

import java.util.Comparator;
import java.util.Map;

public class ComparatorClass<E> implements Comparator<Map.Entry<String,Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        Integer v1 = o1.getValue();
        Integer v2 = o2.getValue();
        return v1.compareTo(v2);
    }

}
