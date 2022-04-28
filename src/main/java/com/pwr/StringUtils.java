package com.pwr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.pwr.Abc.ENGLISH_LETTERS;

public class StringUtils {

    private static final Logger logger = LogManager.getLogger(StringUtils.class);

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String removeDuplicateLetters(String stringWithDuplicates) {
        StringBuilder sb = new StringBuilder();
        stringWithDuplicates.chars().distinct().forEach(letter -> sb.append((char) letter));
        String duplicatesRemoved = sb.toString();
        logger.info("String {} after duplicates removed: {}", stringWithDuplicates, duplicatesRemoved);
        return duplicatesRemoved;
    }

    public static String removeNonLetters(String string) {
        StringBuilder sb = new StringBuilder();
        string.chars().distinct().forEach(letter -> {
            if (ENGLISH_LETTERS.indexOf(letter) > -1) {
                sb.append((char) letter);
            }
        });
        String lettersOnly = sb.toString();
        logger.info("String {} with non-letters removed: {}}", string, lettersOnly);
        return lettersOnly;
    }
}
