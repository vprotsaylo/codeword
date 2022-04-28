package com.pwr;

import org.junit.jupiter.api.Test;

import static com.pwr.StringUtils.removeDuplicateLetters;
import static com.pwr.StringUtils.removeNonLetters;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AbcTest {

    @Test
    void testRemoveDuplicatesFromString() {
        assertEquals("abcd", removeDuplicateLetters("abbcabcd"));
    }

    @Test
    void testRemoveNonLetters() {
        assertEquals("AbcdEf", removeNonLetters("Ab.c,dEf"));
    }

}