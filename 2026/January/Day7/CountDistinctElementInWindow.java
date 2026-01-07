import java.util.*;

class Solution {

    ArrayList<Integer> countDistinct(int arr[], int k) {

        // Result list: stores distinct counts for each window
        ArrayList<Integer> result = new ArrayList<>();

        int n = arr.length;

        // Frequency map for current window
        Map<Integer, Integer> freqMap = new HashMap<>();

        // -------------------------------
        // STEP 1: Process first window
        // -------------------------------
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        // Number of distinct elements in first window
        result.add(freqMap.size());

        // ------------------------------------
        // STEP 2: Slide the window
        // ------------------------------------
        for (int i = k; i < n; i++) {

            // 1️⃣ Add new element (right side of window)
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);

            // 2️⃣ Remove element going out (left side of window)
            int outElement = arr[i - k];
            freqMap.put(outElement, freqMap.get(outElement) - 1);

            // If frequency becomes zero, remove it
            if (freqMap.get(outElement) == 0) {
                freqMap.remove(outElement);
            }

            // 3️⃣ Store distinct count for current window
            result.add(freqMap.size());
        }

        return result;
    }
}
