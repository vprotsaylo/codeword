package com.pwr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Abc {
    private static final Logger logger = LogManager.getLogger(Abc.class);

    public static final String ENGLISH_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private final int letters;
    private BigDecimal maxPasswords;

    public Abc(int letters) {
        this.letters = letters;
        maxPasswords = calcMaxPossiblePasswords(letters);
    }

    public BigDecimal calcMaxPossiblePasswords(int passwordLength) {
        return MathUtil.factorialBig(letters).divide(MathUtil.factorialBig(letters - passwordLength));
    }

    public String removeDuplicateLetters(String stringWithDuplicates) {
        StringBuilder sb = new StringBuilder();
        stringWithDuplicates.chars().distinct().forEach(letter -> sb.append((char) letter));
        String duplicatesRemoved = sb.toString();
        logger.info("String {} after duplicates removed: {}", stringWithDuplicates, duplicatesRemoved);
        return duplicatesRemoved;
    }

    public String removeNonLetters(String string) {
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

    public BigDecimal getMaxPasswords() {
        return maxPasswords;
    }
}
