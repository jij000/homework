package edu.mum.cs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        WordCount<String, Long> wordCount = new WordCount();
        List<Pair<String, Long>> pairList = WordCount.WordCountFromFile("testDataForW1D1.txt");
        List<GroupByPair<String, Long>> groupByPairList = new ArrayList<>();
        GroupByPair<String, Long> g = null;
        Collections.sort(pairList, new Pair<String, Long>());
        System.out.println("Mapper Output");
        for (Pair<String, Long> pair : pairList) {
            System.out.println(pair);
            if (groupByPairList.size() == 0 || !groupByPairList.get(groupByPairList.size()-1).getKey().equals(pair.getKey())) {
                g = new GroupByPair<>();
                g.setKey(pair.getKey());
                groupByPairList.add(g);
            }
            g.addValueList(pair.getWordCounts());
        }
        System.out.println("Reducer Input");
        for (GroupByPair<String, Long> groupByPair : groupByPairList) {
            System.out.println(groupByPair);
        }
        System.out.println("Reducer Output");
        for (GroupByPair<String, Long> groupByPair : groupByPairList) {
            Long sum = groupByPair.getValueList().stream().reduce(0L, (a, b) -> a + b);
            Pair<String, Long> pair = new Pair<String, Long>(groupByPair.getKey(), sum);
            System.out.println(pair);
        }
    }
}
