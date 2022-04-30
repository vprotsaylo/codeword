package com.pwr;

import org.junit.jupiter.api.Test;

import static com.pwr.Abc.ENGLISH_ALPHABET_LETTERS;
import static com.pwr.StringUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilsTest {

    @Test
    void testRemoveDuplicatesFromString() {
        assertEquals("abcd", removeDuplicateLetters("abbcabcd"));
    }

    @Test
    void testRemoveNonLetters() {
        assertEquals("AbcdEf", removeNonLetters("Ab.c,dEf"));
    }

    @Test
    void testFilterLoverCaseLettersOnly() {
        assertEquals("ab", lettersOnly("1a2Aba3"));
    }

    @Test
    void testMakeCodeAlphabetSimpleEnglish() {
        assertEquals("tesabcdfghijklmnopqruvwxyz", StringUtils.makeCodeAlphabet("test"));
        assertEquals("tesabcdfghijklmnopqruvwxyz", StringUtils.makeCodeAlphabet("test123"));
    }

    @Test
    void testTransposeCharacter() {
        assertEquals('y', transposeCharacter('b', "abc", "xyz"));
        assertEquals('\0', transposeCharacter('z', "abc", "xyz"));
    }

    @Test()
    void negativeTestTransposeCharacter() {
        assertThrows(IllegalArgumentException.class, () ->
                        transposeCharacter('a', "abcd", "xyz"),
                "transposeFrom and transposeTo strings has different length"
        );
    }

    @Test
    void testCodePhraseWithCodeWord() {
        assertEquals("tesab", codePhraseWithCodeWord("abcde", "test"));
        assertEquals("fbjjm", codePhraseWithCodeWord("hello", "test"));
        assertEquals("fbjjm rbqr", codePhraseWithCodeWord("hello test", "test"));

        // English lovercase and uppercase letters
        assertEquals("fbjjmtesa", codePhraseWithCodeWord("helloabcd", "test", removeDuplicateLetters(ENGLISH_ALPHABET_LETTERS.toLowerCase())));
        // English lovercase letters only
        assertEquals("fbjjmtesXYZUVWxyz", codePhraseWithCodeWord("helloABCabcXYZxyz", "test", ENGLISH_ALPHABET_LETTERS));
        // Extended alphabet
        assertEquals("beggjxyz123", codePhraseWithCodeWord("hello123abc", "123test", removeDuplicateLetters(ENGLISH_ALPHABET_LETTERS.toLowerCase()) + "123"));
        assertEquals("bYggjxyz123", codePhraseWithCodeWord("hello123ABC", "123test", ENGLISH_ALPHABET_LETTERS + "123"));


        assertThrows(IllegalArgumentException.class, () ->
                        codePhraseWithCodeWord("hello123", "test"),
                "Character '1' is invalid"
        );
        assertThrows(IllegalArgumentException.class, () ->
                        codePhraseWithCodeWord("hello", "test123"),
                "Character '1' is invalid"
        );
    }
}