package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("1c0c0400: test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("1c0c0400: Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutHorses() throws Exception {
        assertThat(queryProcessor.process("1c0c0400: horse"), containsString("horse"));
    }

    @Test
    public void knowsMyName() throws Exception {
        assertThat(queryProcessor.process("1c0c0400: what is your name"), containsString("nikraphael"));
    }

    @Test
    public void sumsNumbers() throws Exception {
        assertThat(queryProcessor.process("1c0c0400: what is 6 plus 3"), containsString("9"));
    }

    @Test
    public void miltipliesNumbers() throws Exception {
        assertThat(queryProcessor.process("f8d2e550: what is 5 multiplied by 6"), containsString("30"));
    }

    @Test
    public void findsLargest() throws Exception {
        assertThat(queryProcessor.process("11f0d840: which of the following numbers is the largest: 998, 6"), containsString("998"));
    }

    @Test
    public void findsCubeAndSquare() throws Exception {
        assertThat(queryProcessor.process("b15a1560: which of the following numbers is both a square and a cube: 196, 469, 2209, 974"), containsString(""));
    }

    @Test
    public void knowsWhereEiffelTowerIs() throws Exception {
        assertThat(queryProcessor.process("49cfac60: which city is the Eiffel tower in"), containsString("Paris"));
    }

    @Test
    public void findsPrimeNumber() throws Exception {
        assertThat(queryProcessor.process("addc8f80: which of the following numbers are primes: 339, 717, 227, 73"), containsString("227, 73"));
    }

    @Test
    public void findsNthFibonacciTerm() throws Exception {
        assertThat(queryProcessor.process("1d944e40: what is the 10th number in the Fibonacci sequence" ), containsString("55"));
    }

    @Test
    public void canSubstract() throws Exception {
        assertThat(queryProcessor.process("26add640: what is 8 minus 4" ), containsString("4"));
    }


    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("1c0c0400: shakespeare"), containsString("playwright"));
    }
}

