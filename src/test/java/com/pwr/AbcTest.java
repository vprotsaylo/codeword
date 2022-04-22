package com.pwr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbcTest {

    Abc abc = new Abc(26); // English Alphabet

    @Test
    void testRemoveDuplicatesFromString() {
        assertEquals("abcd", abc.removeDuplicateLetters("abbcabcd"));
    }

    @Test
    void testRemoveNonLetters() {
        assertEquals("AbcdEf", abc.removeNonLetters("Ab.c,dEf"));
    }

}