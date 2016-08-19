package org.rpmoore.algorist.hashes;

public interface TimedHashTable {
    void put(final String key, final String value, final int time);
    String get(final String key, final int time);
}
