package org.rpmoore.algorist.util;

public final class Compare {
    public static <T extends Comparable<T>> boolean lessThan(final T orig, final T compareTo) {
        return orig.compareTo(compareTo) < 1;
    }
}
