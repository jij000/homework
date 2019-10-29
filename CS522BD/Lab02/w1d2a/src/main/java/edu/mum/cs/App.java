package edu.mum.cs;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        List<Pair<String>> pairList = WordCount.WordCountFromFile("testDataForW1D1.txt");
        List<GroupByPair<String, Long>> groupByPairList = new ArrayList<>();
        Collections.sort(pairList, new Pair<String>());
        for (Pair<String> pair : pairList) {
            System.out.println(pair);
            GroupByPair<String, Long> g = groupByPairList.getMember(pair.getKey());
            if (g == null) {
                groupByPairList.addPair(pair);
            } else {
                g.getValue().add(pair.getWordCounts());
            }
        }
    }
}
