package com.pwr;

import java.math.BigDecimal;

public class MathUtil {

    private MathUtil() {
        throw new UnsupportedOperationException("This is utility class, so it can not be instantiated!");
    }

    static long factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    static BigDecimal factorialBig(int n) {
        BigDecimal nn = BigDecimal.valueOf(n);
        if (nn.equals(BigDecimal.ZERO))
            return BigDecimal.ONE;
        else
            return (nn.multiply(factorialBig(n - 1)));
    }
}
