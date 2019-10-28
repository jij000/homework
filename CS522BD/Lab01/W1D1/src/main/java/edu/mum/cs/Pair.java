package edu.mum.cs;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Pair<T> implements Comparator<T>{
    T key;
    Long wordCounts;

    @Override
    public String toString() {
        return "(" + key + ", " + String.valueOf(wordCounts) + ")";
    }

    @Override
    public int compare(T o1, T o2) {
        return String.valueOf(o1).compareTo(String.valueOf(o2));
    }
}