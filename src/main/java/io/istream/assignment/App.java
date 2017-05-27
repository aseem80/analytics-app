package io.istream.assignment;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {

    private static final Character TEXT_DELIMITER = ' ';
    private static final Set<Character> SENTENCE_SEPARATORS = new HashSet<>();

    static {
        SENTENCE_SEPARATORS.add(',');
        SENTENCE_SEPARATORS.add('.');
        SENTENCE_SEPARATORS.add('"');
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (int index = 0; index < args.length; index++) {
                System.out.println("For String at Index : " + index +
                        " Most frequent word : " + getMostFrequentWordUsingMap(args[index]));
            }
        } else {
            throw new RuntimeException("No args provided.");
        }

    }


    /**
     * Time and Space complexity of this function is
     * Time:- O(n+n)=O(n)
     * Space :- O(n)
     */
    public static String getMostFrequentWordUsingMap(String text) {

        if (null != text) {
            String mostFrequentWord = "";
            Integer max_frequency = 0;
            Map<String, Integer> wordFrequencyMap = getMap(text);
            Set<String> words = wordFrequencyMap.keySet();

            //Time Complexity in iterating over Map of n words is also O(n) where key look up is constant time look up
            // based on HashCode
            for (String word : words) {
                Integer frequency = wordFrequencyMap.get(word);
                if (max_frequency.compareTo(frequency) == -1) {
                    max_frequency = frequency;
                    mostFrequentWord = word;
                }
            }
            return mostFrequentWord;
        } else {
            return null;
        }

    }


    /**
     * Constructing Map has Time Complexity O(n) and Space complexity of O(n) where n is number of words in input Text
     */
    private static Map<String, Integer> getMap(String text) {
        final Map<String, Integer> wordFrequencyMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (TEXT_DELIMITER != ch) {
                if (!SENTENCE_SEPARATORS.contains(ch)) {
                    sb.append(ch);
                }
            } else {
                String word = sb.toString().trim();
                setMap(wordFrequencyMap, word);
                sb = new StringBuilder();
            }
        }
        //Add the Last word
        String word = sb.toString().trim();
        if (!word.isEmpty()) {
            setMap(wordFrequencyMap, word);
        }
        return wordFrequencyMap;
    }

    private static void setMap(Map<String, Integer> wordFrequencyMap, String word) {
        Integer frequency = wordFrequencyMap.get(word);
        if (frequency == null) {
            wordFrequencyMap.put(word, 1);
        } else {
            wordFrequencyMap.put(word, ++frequency);
        }
    }


}
