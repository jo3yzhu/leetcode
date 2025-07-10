package org.jo3yzhu.system;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class PriceWindowAggregator {

    private static class AvgAgg<T> extends ConcurrentSkipListMap<Long, T> {
    }

    private final int windowSizeSeconds;

    private final Map<String, AvgAgg<Double>> state;

    public PriceWindowAggregator(int windowSizeSeconds) {
        this.windowSizeSeconds = windowSizeSeconds;
        this.state = new ConcurrentHashMap<>();
    }

    public void add(String symbol, double price, long timestamp) {
        throw new NotImplementedException();
    }

    public double getAveragePrice(String symbol, long currentTimestamp) {
        throw new NotImplementedException();
    }
}
