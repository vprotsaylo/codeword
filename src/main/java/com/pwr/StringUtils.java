package com.pwr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.InvalidParameterException;

import static com.pwr.Abc.ENGLISH_ALPHABET_LETTERS;

public class StringUtils {

    private static final Logger logger = LogManager.getLogger(StringUtils.class);

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String removeDuplicateLetters(String stringWithDuplicates) {
        StringBuilder sb = new StringBuilder();
        stringWithDuplicates.chars().distinct().forEach(letter -> sb.append((char) letter));
        String duplicatesRemoved = sb.toString();
        logger.info("String '{}' after duplicates removed: '{}'", stringWithDuplicates, duplicatesRemoved);
        return duplicatesRemoved;
    }

    public static String removeNonLetters(String string) {
        return removeNonLetters(string, ENGLISH_ALPHABET_LETTERS);
    }

    public static String removeNonLetters(String string, String alphabetLetters) {
        StringBuilder sb = new StringBuilder();
        string.chars().distinct().forEach(letter -> {
            if (alphabetLetters.indexOf(letter) > -1) {
                sb.append((char) letter);
            }
        });
        return sb.toString();
    }

    public static String removeLettersFromString(String letters, String fromString) {
        StringBuilder sb = new StringBuilder();
        sb.append(fromString.replaceAll("[" + letters + "]", ""));
        String lettersLeft = sb.toString();
        logger.info("String '{}' with '{}' letters removed: '{}'", fromString, letters, lettersLeft);
        return lettersLeft;
    }

    public static String lettersOnly(String string) {
        return removeNonLetters(removeDuplicateLetters(string.toLowerCase()), removeDuplicateLetters(ENGLISH_ALPHABET_LETTERS.toLowerCase()));
    }

    public static String makeCodeAlphabet(String codeWord) {
        return makeCodeAlphabet(lettersOnly(codeWord), lettersOnly(ENGLISH_ALPHABET_LETTERS));
    }

    public static String makeCodeAlphabet(String codeWord, String alphabetLetters) {
        StringBuilder sb = new StringBuilder();
        String codeWordWithRemovedDuplicates = removeDuplicateLetters(codeWord);
        sb.append(codeWordWithRemovedDuplicates);
        sb.append(removeLettersFromString(codeWordWithRemovedDuplicates, alphabetLetters));
        String codeAlphabet = sb.toString();
        logger.info("CodeAlphabet made from '{}' alphabet with codeword '{}': {}", alphabetLetters, codeWord, codeAlphabet);
        return codeAlphabet;
    }

    public static String codePhraseWithCodeWord(String phrase, String codeWord) {
        return  codePhraseWithCodeWord(phrase, codeWord, lettersOnly(ENGLISH_ALPHABET_LETTERS) + " ");
    }

    public static String codePhraseWithCodeWord(String phrase, String codeWord, String alphabetLetters) {
        String codeAlphabet = makeCodeAlphabet(codeWord, alphabetLetters);
        StringBuilder sb = new StringBuilder();
        phrase.chars().forEach(ch -> {
            if (alphabetLetters.indexOf(ch) == -1) {
                throw new InvalidParameterException(String.format("Character '%c' is invalid", ch));
            }
                    sb.append(transposeCharacter((char) ch, alphabetLetters, codeAlphabet));
                }
        );
        String codePhraseWithCodeWord = sb.toString();
        logger.info("Code Phrase: '{}' with codeword '{}': '{}'", phrase, codeWord, codePhraseWithCodeWord);
        return codePhraseWithCodeWord;
    }

    public static char transposeCharacter(char character, String transposeFromString, String transposeToString) {
        if (transposeFromString.length() != transposeToString.length()) {
            throw new InvalidParameterException("transposeFrom and transposeTo strings has different length");
        }
        int charPos = transposeFromString.indexOf(character);
        if (charPos != -1) {
            return transposeToString.charAt(charPos);
        } else {
            return '\0';
        }
    }

}
