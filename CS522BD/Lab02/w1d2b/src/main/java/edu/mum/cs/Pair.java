package edu.mum.cs;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Pair<T, V> implements Comparator<Pair<T, V>>{
    T key;
    V wordCounts;

    @Override
    public String toString() {
        return "(" + key.toString() + ", " + String.valueOf(wordCounts) + ")";
    }

    @Override
    public int compare(Pair<T, V> o1, Pair<T, V> o2) {
        return String.valueOf(o1.getKey()).compareTo(String.valueOf(o2.getKey()));
    }
}