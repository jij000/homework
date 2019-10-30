package edu.mum.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class GroupByPair<T, V>  implements Comparator<GroupByPair<T, V>>{
    T key;
    List<V> valueList = new ArrayList<>();

    public GroupByPair<T, V> addValueList(V value) {
        this.valueList.add(value);
        return this;
    }

    @Override
    public String toString() {
        return "(" + key.toString() + ", " + Arrays.toString(valueList.toArray()) + ")";
    }

    @Override
    public int compare(GroupByPair<T, V> o1, GroupByPair<T, V> o2) {
        return String.valueOf(o1.getKey()).compareTo(String.valueOf(o2.getKey()));
    }

}