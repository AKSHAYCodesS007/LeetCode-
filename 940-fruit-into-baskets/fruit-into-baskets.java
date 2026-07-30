class Solution {
    public int totalFruit(int[] fruits) {
        // Find the maximum fruit ID to size our array dynamically, 
        // or use an array of size 100001 based on constraints
        int maxType = 0;
        for (int fruit : fruits) {
            maxType = Math.max(maxType, fruit);
        }

        int[] count = new int[maxType + 1];
        int left = 0;
        int distinctTypes = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            // 1. If this is a new type of fruit, increase distinct count
            if (count[fruits[right]] == 0) {
                distinctTypes++;
            }
            count[fruits[right]]++;

            // 2. Shrink window if we exceed 2 distinct fruit types
            while (distinctTypes > 2) {
                count[fruits[left]]--;
                if (count[fruits[left]] == 0) {
                    distinctTypes--; // Removed this fruit type completely
                }
                left++;
            }

            // 3. Keep track of maximum window size
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}