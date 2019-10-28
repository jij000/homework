package edu.mum.cs;

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
        List<Pair<String>> pairList = WordCount.WordCountFromFile("testDataForW1D1.txt");
        Collections.sort(pairList, new Pair<String>());
        for (Pair<String> pair : pairList) {
            System.out.println(pair);
        }
    }
}
