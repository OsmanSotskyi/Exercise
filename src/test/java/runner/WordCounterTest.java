package runner;

import glue.WordCounter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {
    @Test
    public void testCountWords() {
        WordCounter wc = new WordCounter();
        assertEquals(0, wc.countWords(""));
        assertEquals(1, wc.countWords("hello"));
        assertEquals(2, wc.countWords("hello world"));
        assertEquals(3, wc.countWords("hello world again"));
    }
}