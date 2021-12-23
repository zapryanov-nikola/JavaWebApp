package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutHorses() throws Exception {
        assertThat(queryProcessor.process("horse"), containsString("horse"));
    }

    @Test
    public void knowsMyName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("nikraphael"));
    }

    @Test
    public void sumsNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 20 plus 50"), containsString("70"));
    }

    @Test
    public void findsLargest() throws Exception {
        assertThat(queryProcessor.process("11f0d840: which of the following numbers is the largest: 998, 6"), containsString("998"));
    }

    
    
    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
