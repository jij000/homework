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
        WordCount<String, PairValue> wordCount = new WordCount<>();
        wordCount.setM(4); // Number of Input-Splits: 4
        wordCount.setR(3); // Number of Reducers: 3
        // set mapper
        for(Integer i=0; i< wordCount.getM(); i++) {
            wordCount.getMapperList().add(WordCount.WordCountFromFile("Mapper" + String.valueOf(i)+ "Input.txt"));
            // Collections.sort(wordCount.getMapperList().get(i), new Pair<String, PairValue>());
            // print mapper
            System.out.println("Mapper " + String.valueOf(i)+ " Output");
            for (String key : wordCount.getMapperList().get(i).keySet()) {
                System.out.println(wordCount.getMapperList().get(i).get(key));
            }
        }

        // set Reducer
        for (Integer j = 0; j < wordCount.getR(); j++) { // init
            wordCount.getReducerList().add(new ArrayList<GroupByPair<String, PairValue>>());
        }
        for (Integer i = 0; i < wordCount.getM(); i++) { // mapper count
            GroupByPair<String, PairValue> g = null;
            for (Integer j = 0; j < wordCount.getR(); j++) {
                System.out.println(
                        "Pairs send from Mapper " + String.valueOf(i) + " Reducer " + String.valueOf(j) + "");
                for (String key : wordCount.getMapperList().get(i).keySet()) {
                    int reducerNo = wordCount.getPartition(wordCount.getMapperList().get(i).get(key).getKey());
                    if (reducerNo != j) {
                        continue;
                    }
                    System.out.println(wordCount.getMapperList().get(i).get(key));
                    if (wordCount.getReducerList().get(reducerNo).size() == 0 || !wordCount.getReducerList().get(reducerNo)
                            .get(wordCount.getReducerList().get(reducerNo).size() - 1).getKey().equals(wordCount.getMapperList().get(i).get(key).getKey())) {
                        g = new GroupByPair<>();
                        g.setKey(wordCount.getMapperList().get(i).get(key).getKey());
                        wordCount.getReducerList().get(reducerNo).add(g);
                    }
                    g.addValueList(wordCount.getMapperList().get(i).get(key).getWordCounts());
                }
            }
        }
        // Reducer Input
        for (Integer j = 0; j < wordCount.getR(); j++) { // init
            System.out.println("Reducer " + String.valueOf(j) + " Input");
            // merge the same key Reducer Input
            Collections.sort(wordCount.getReducerList().get(j), new GroupByPair<String, PairValue>());
            for (int k = 1; k<wordCount.getReducerList().get(j).size(); ) {
                if (wordCount.getReducerList().get(j).get(k-1).getKey().equals(wordCount.getReducerList().get(j).get(k).getKey())) {
                    wordCount.getReducerList().get(j).get(k-1).getValueList().addAll(wordCount.getReducerList().get(j).get(k).getValueList());
                    wordCount.getReducerList().get(j).remove(k);
                } else {
                    k++;
                }
            }
            for (GroupByPair<String, PairValue> groupByPair : wordCount.getReducerList().get(j)) {
                System.out.println(groupByPair);
            }
        }
        // Reducer Output
        // for (Integer j = 0; j < wordCount.getR(); j++) { // init
        //     System.out.println("Reducer " + String.valueOf(j) + " Output");
        //     for (GroupByPair<String, PairValue> groupByPair : wordCount.getReducerList().get(j)) {
        //         PairValue sum = groupByPair.getValueList().stream().reduce(0L, (a, b) -> a + b);
        //         Pair<String, PairValue> pair = new Pair<String, PairValue>(groupByPair.getKey(), sum);
        //         System.out.println(pair);
        //     }
        // }
        
    }
}
