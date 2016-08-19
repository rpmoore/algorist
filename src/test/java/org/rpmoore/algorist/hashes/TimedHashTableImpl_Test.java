package org.rpmoore.algorist.hashes;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TimedHashTableImpl_Test {
    @Test
    public void singleValuePut() {
        final TimedHashTable timedHashTable = new TimedHashTableImpl();
        timedHashTable.put("key", "value", 1);
        assertThat(timedHashTable.get("key", 1), is("value"));
    }

    @Test
    public void differentTimesSameKey() {
        final TimedHashTable timedHashTable = new TimedHashTableImpl();
        timedHashTable.put("key", "value2", 2);
        timedHashTable.put("key", "value", 1);
        assertThat(timedHashTable.get("key", 2), is("value2"));

    }

}
