package words;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Words {
        public static List<String> getUniqueWordsFromSentence(String sentence) {

            String lowerCaseSentence = sentence.toLowerCase();

            String cleanedSentence = lowerCaseSentence.replaceAll("[^a-zA-Z\\s]", " ");

            String[] wordsArray = cleanedSentence.split("\\s+");

            Set<String> uniqueWordsSet = new HashSet<>();
            for (String word : wordsArray) {
                if (!word.isEmpty()) {
                    uniqueWordsSet.add(word);
                }
            }

            List<String> uniqueWordsList = new ArrayList<>(uniqueWordsSet);
            
            return uniqueWordsList;
        }
    }

