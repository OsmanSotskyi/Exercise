package words;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Words {


        public static List<String> getUniqueWordsFromSentence(String sentence) {
            // conv the sentences to lowercase
            String lowerCaseSentence = sentence.toLowerCase();

            // Remove punctuation by replacing all non-word characters (except spaces) with space
            String cleanedSentence = lowerCaseSentence.replaceAll("[^a-zA-Z\\s]", " ");

            // Split the cleaned sentence into words
            String[] wordsArray = cleanedSentence.split("\\s+");

            // Use a set to collect unique words
            Set<String> uniqueWordsSet = new HashSet<>();
            for (String word : wordsArray) {
                if (!word.isEmpty()) {
                    uniqueWordsSet.add(word);
                }
            }

            // Convert the set back to a list
            List<String> uniqueWordsList = new ArrayList<>(uniqueWordsSet);

            // Return the list of unique words
            return uniqueWordsList;
        }
    }

