package io.istream.assignment;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {

    private static final Character TEXT_DELIMITER = ' ';
    private static final Set<Character> PUNCTUATION_CHARS = new HashSet<>();

    static {
        PUNCTUATION_CHARS.add(',');
        PUNCTUATION_CHARS.add('.');
        PUNCTUATION_CHARS.add('"');
        PUNCTUATION_CHARS.add('?');
        PUNCTUATION_CHARS.add(';');
        PUNCTUATION_CHARS.add(TEXT_DELIMITER);

    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (int index = 0; index < args.length; index++) {
                System.out.println("For String at Index : " + index +
                        " Most frequent word : " + getMostFrequentWord(args[index]));
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
    public static String getMostFrequentWord(String text) {

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
        for (int index = 0; index < text.length(); index++) {
            char ch = text.charAt(index);
            if (TEXT_DELIMITER != ch ) {
                if(!PUNCTUATION_CHARS.contains(ch)) {
                    sb.append(ch);
                }
            } else {
                String word = sb.toString();
                //It should handle white_spaces
                if(!word.isEmpty()) {
                    setMap(wordFrequencyMap, word);
                }
                sb = new StringBuilder();
            }
        }
        //Add the Last word
        String word = sb.toString();
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
