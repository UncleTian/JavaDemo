package com.art2cat.dev;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.Test;

public class CollectorTest {
    
    @Test
    public void test() {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            partitionPrimesWithCustomCollector(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
        }
        System.out.println(
            "Fastest execution done in " + fastest + " msecs");
    }
    
    private Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
            .collect(new PrimeNumbersCollector());
    }
}
