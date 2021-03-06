package edu.mum.cs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class WordCount<T, V> {
    List<Map<T, Pair<T, V>>> mapperList = new ArrayList<>();
    List<List<GroupByPair<T, V>>> reducerList = new ArrayList<>();
    int m = 3;  // number of mappaer
    int r = 4;  // number of reducer

    static Boolean isWord(String str) {
        if (Pattern.matches("[A-Za-z]+", str) || Pattern.matches("[A-Za-z]+\\.", str)
                || Pattern.matches("[A-Za-z]+,", str) || Pattern.matches("\"[A-Za-z]+", str)
                || Pattern.matches("[A-Za-z]+\"", str) || Pattern.matches("\'[A-Za-z]+", str)
                || Pattern.matches("[A-Za-z]+\'", str)) {
            return true;
        } else {
            return false;
        }
    }

    public int getPartition(String key){
		return (int) key.hashCode() % r;
	}

    static Map<String, Pair<String, Long>> WordCountFromFile(String filePath) {

        Map<String, Pair<String, Long>> pairMap = new TreeMap<>();

        try
        {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // check if file exists
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    String[] words = lineTxt.split(" |-");
                    for(String str : words) {
                        if (isWord(str)) {
                            str = str.replaceAll(",", "");
                            str = str.replaceAll("\\.", "");
                            str = str.replaceAll("\"", "");
                            str = str.replaceAll("\'", "");
                            Pair<String, Long> pair = new Pair<String, Long>(str.toLowerCase(), 1L);
                            if (pairMap.get(str.toLowerCase()) == null) {
                                pairMap.put(str.toLowerCase(), pair);
                            } else {
                                pairMap.get(str.toLowerCase())
                                        .setWordCounts(pairMap.get(str.toLowerCase()).getWordCounts() + 1);
                                ;
                            }
                        }
                    }
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("File not found!");
            }
        }
        catch (Exception e)
        {
            System.out.println("read exception!");
            e.printStackTrace();
        }

        return pairMap;
    }
}