package edu.mum.cs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class GroupByPair<T, V> {
    T key;
    List<V> value;

    @Override
    public String toString() {
        return "(" + key.toString() + ", " + value.stream().map(x -> String.valueOf(x)) + ")";
    }

}