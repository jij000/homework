package edu.mum.cs;

import java.util.ArrayList;
import java.util.Collections;

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
        // set mapper
        for(Integer i=0; i< wordCount.getM(); i++) {
            wordCount.getMapperList().add(WordCount.WordCountFromFile("Mapper" + String.valueOf(i)+ "Input.txt"));
            Collections.sort(wordCount.getMapperList().get(i), new Pair<String, Long>());
            // print mapper
            System.out.println("Mapper " + String.valueOf(i)+ " Output");
            for (Pair<String, Long> pair : wordCount.getMapperList().get(i)) {
                System.out.println(pair);
            }
        }

        // set Reducer
        for (Integer j = 0; j < wordCount.getR(); j++) { // init
            wordCount.getReducerList().add(new ArrayList<GroupByPair<String, Long>>());
        }
        for (Integer i = 0; i < wordCount.getM(); i++) { // mapper count
            GroupByPair<String, Long> g = null;
            for (Integer j = 0; j < wordCount.getR(); j++) {
                System.out.println(
                        "Pairs send from Mapper " + String.valueOf(i) + " Reducer " + String.valueOf(j) + "");
                for (Pair<String, Long> pair : wordCount.getMapperList().get(i)) {
                    int reducerNo = wordCount.getPartition(pair.getKey());
                    if (reducerNo != j) {
                        continue;
                    }
                    System.out.println(pair);
                    if (wordCount.getReducerList().get(reducerNo).size() == 0 || !wordCount.getReducerList().get(reducerNo)
                            .get(wordCount.getReducerList().get(reducerNo).size() - 1).getKey().equals(pair.getKey())) {
                        g = new GroupByPair<>();
                        g.setKey(pair.getKey());
                        wordCount.getReducerList().get(reducerNo).add(g);
                    }
                    g.addValueList(pair.getWordCounts());
                }
            }
        }
        // Reducer Input
        for (Integer j = 0; j < wordCount.getR(); j++) { // init
            System.out.println("Reducer " + String.valueOf(j) + " Input");
            // merge the same key Reducer Input
            Collections.sort(wordCount.getReducerList().get(j), new GroupByPair<String, Long>());
            for (int k = 1; k<wordCount.getReducerList().get(j).size(); ) {
                if (wordCount.getReducerList().get(j).get(k-1).getKey().equals(wordCount.getReducerList().get(j).get(k).getKey())) {
                    wordCount.getReducerList().get(j).get(k-1).getValueList().addAll(wordCount.getReducerList().get(j).get(k).getValueList());
                    wordCount.getReducerList().get(j).remove(k);
                } else {
                    k++;
                }
            }
            for (GroupByPair<String, Long> groupByPair : wordCount.getReducerList().get(j)) {
                System.out.println(groupByPair);
            }
        }
        // Reducer Output
        for (Integer j = 0; j < wordCount.getR(); j++) { // init
            System.out.println("Reducer " + String.valueOf(j) + " Output");
            for (GroupByPair<String, Long> groupByPair : wordCount.getReducerList().get(j)) {
                Long sum = groupByPair.getValueList().stream().reduce(0L, (a, b) -> a + b);
                Pair<String, Long> pair = new Pair<String, Long>(groupByPair.getKey(), sum);
                System.out.println(pair);
            }
        }
        
    }
}
