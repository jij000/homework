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
        WordCount<String, Long> wordCount = new WordCount<>();
        wordCount.setMapperList(WordCount.WordCountFromFile("testDataForW1D1.txt"));
        wordCount.setReducerList(new ArrayList<>());
        GroupByPair<String, Long> g = null;
        Collections.sort(wordCount.getMapperList(), new Pair<String, Long>());
        System.out.println("Mapper Output");
        for (Pair<String, Long> pair : wordCount.getMapperList()) {
            System.out.println(pair);
            if (wordCount.getReducerList().size() == 0 || !wordCount.getReducerList().get(wordCount.getReducerList().size()-1).getKey().equals(pair.getKey())) {
                g = new GroupByPair<>();
                g.setKey(pair.getKey());
                wordCount.getReducerList().add(g);
            }
            g.addValueList(pair.getWordCounts());
        }
        System.out.println("Reducer Input");
        for (GroupByPair<String, Long> groupByPair : wordCount.getReducerList()) {
            System.out.println(groupByPair);
        }
        System.out.println("Reducer Output");
        for (GroupByPair<String, Long> groupByPair : wordCount.getReducerList()) {
            Long sum = groupByPair.getValueList().stream().reduce(0L, (a, b) -> a + b);
            Pair<String, Long> pair = new Pair<String, Long>(groupByPair.getKey(), sum);
            System.out.println(pair);
        }
    }
}
