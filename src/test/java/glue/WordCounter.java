package glue;

public class WordCounter {
    public int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.trim().split("\s+");
        return words.length;
    }
}
