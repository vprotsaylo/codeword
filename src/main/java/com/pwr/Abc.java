package com.pwr;

import java.math.BigDecimal;

public class Abc {

    public static final String ENGLISH_ALPHABET_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private final int letters;
    private BigDecimal maxPasswords;

    public Abc(int letters) {
        this.letters = letters;
        maxPasswords = calcMaxPossiblePasswords(letters);
    }

    public BigDecimal calcMaxPossiblePasswords(int passwordLength) {
        return MathUtils.factorialBig(letters).divide(MathUtils.factorialBig(letters - passwordLength));
    }

    public BigDecimal getMaxPasswords() {
        return maxPasswords;
    }
}
