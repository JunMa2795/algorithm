package algorithms.search;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 10:33
 */
public class MostFrequent {

    private static int mostFrequent(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int key : arr) {
            freqMap.computeIfPresent(key, (k, v) -> ++v);
            freqMap.computeIfAbsent(key, k -> 1);
        }

        Integer max_count = freqMap.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(null);

        List<Integer> res = freqMap.entrySet().stream()
                .filter(e -> e.getValue().equals(max_count))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return res.get(0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 1, 3, 2, 1};

        System.out.println(mostFrequent(arr));
    }
}
