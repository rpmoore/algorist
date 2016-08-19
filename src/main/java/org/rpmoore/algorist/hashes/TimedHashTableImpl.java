package org.rpmoore.algorist.hashes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimedHashTableImpl implements TimedHashTable {

    private final Map<String, List<ValuePair>> map = new HashMap<>();

    @Override
    public void put(final String key, final String value, final int time) {
        final List<ValuePair> valueList = getList(key);
        valueList.add(new ValuePair(time, value));
    }

    private List<ValuePair> getList(final String key) {
        List<ValuePair> valueList = map.get(key);
        if (valueList == null) {
            valueList = new ArrayList<>();
            map.put(key, valueList);
        }
        return  valueList;
    }

    @Override
    public String get(final String key, final int time) {
        final List<ValuePair> valueList = map.get(key);
        if (valueList == null) {
            return null;
        }

        return null;

    }

    private class ValuePair {
        private final int time;
        private final String value;

        private ValuePair(final int time, final String value) {
            this.time = time;
            this.value = value;
        }

        public int getTime() {
            return time;
        }

        public String getValue() {
            return value;
        }
    }
}
