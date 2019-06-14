package prob3;

import java.util.ArrayList;
import java.util.List;

public class TestStream {
	public static long countWords(List<String> words, char c, char d, int len) {
		return words.stream()
				.filter(x -> x.contains(String.valueOf(c)))
				.filter(x -> !x.contains(String.valueOf(d)))
				.filter(x -> x.length() == len).count();
	}
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("abce");
		words.add("abcd");
		words.add("abde");
		words.add("cd");
		words.add("abec");
		words.add("abcde");
		words.add("acd");
		System.out.println(countWords(words, 'c', 'd', 4));
	}

}
