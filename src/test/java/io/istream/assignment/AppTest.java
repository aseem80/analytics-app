package io.istream.assignment;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 

{
    @Test
    public void getMostFrequentWordPositiveInput() {
        String text = "A blue shirt cost is twenty-four dollars but a white shirt is only twenty so I" +
                " bought the white shirt.";
        assertEquals("shirt", App.getMostFrequentWord(text));
    }

    @Test
    public void getMostFrequentWordWhiteSpacesInput() {
        String text = "A blue shirt     cost is twenty-four " +
                "dollars but a white     shirt     is only twenty so I bought the white shirt   .   ";
        assertEquals("shirt", App.getMostFrequentWord(text));
    }

    @Test
    public void getMostFrequentWordNullInput() {
        String text = null;
        assertNull(App.getMostFrequentWord(text));
    }

    @Test
    public void getMostFrequentWordEmptyInput() {
        String text = "";
        assertEquals("", App.getMostFrequentWord(text));
    }

    @Test
    public void getMostFrequentWordSingleCharInput() {
        String text = "c";
        assertEquals(text, App.getMostFrequentWord(text));
    }


    @Test
    public void getMostFrequentWord2Input() {
        String text = "A blue shirt cost is twenty-four dollars but a white shirt is only twenty so I bought the white ";
        List<String> expectedWords = Arrays.asList("is","shirt");
        assertTrue(expectedWords.contains(App.getMostFrequentWord(text)));
    }

    @Test
    public void getMostFrequentWordPunctuations() {
        String text = "A blue \"shirt\" cost is twenty-four dollars but a white \"shirt\" is only twenty so I bought " +
                "the white shirt.";
        assertEquals("shirt", App.getMostFrequentWord(text));
    }

}
