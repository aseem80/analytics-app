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
    public void getMostFrequentWordUsingMapPositiveInput() {
        String text = "A blue shirt cost is twenty-four dollars but a white shirt is only twenty so I bought the white shirt.";
        assertEquals("shirt", App.getMostFrequentWordUsingMap(text));
    }

    @Test
    public void getMostFrequentWordUsingMapNullInput() {
        String text = null;
        assertNull(App.getMostFrequentWordUsingMap(text));
    }

    @Test
    public void getMostFrequentWordUsingMapEmptyInput() {
        String text = "";
        assertEquals("", App.getMostFrequentWordUsingMap(text));
    }

    @Test
    public void getMostFrequentWordUsingMapSingleCharInput() {
        String text = "c";
        assertEquals(text, App.getMostFrequentWordUsingMap(text));
    }


    @Test
    public void getMostFrequentWordUsingMap2Input() {
        String text = "A blue shirt cost is twenty-four dollars but a white shirt is only twenty so I bought the white ";
        List<String> expectedWords = Arrays.asList("is","shirt");
        assertTrue(expectedWords.contains(App.getMostFrequentWordUsingMap(text)));
    }

    @Test
    public void getMostFrequentWordUsingMapPositiveInputPunctuations() {
        String text = "A blue \"shirt\" cost is twenty-four dollars but a white \"shirt\" is only twenty so I bought the white shirt.";
        assertEquals("shirt", App.getMostFrequentWordUsingMap(text));
    }

}
