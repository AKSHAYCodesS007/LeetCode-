import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        Set<Integer> uniqueSet = new HashSet<>();
        int maxVal = 0;
        for (int num : nums) {
            uniqueSet.add(num);
            maxVal = Math.max(maxVal, num);
        }
        
        int[] uniqueNums = new int[uniqueSet.size()];
        int idx = 0;
        for (int num : uniqueSet) {
            uniqueNums[idx++] = num;
        }

       
        int m = 1;
        while (m <= maxVal) {
            m <<= 1;
        }

  
        boolean[] hasPair = new boolean[m];
        for (int i = 0; i < uniqueNums.length; i++) {
            for (int j = i; j < uniqueNums.length; j++) {
                hasPair[uniqueNums[i] ^ uniqueNums[j]] = true;
            }
        }

       
        boolean[] hasTriplet = new boolean[m];
        for (int x = 0; x < m; x++) {
            if (hasPair[x]) {
                for (int num : uniqueNums) {
                    hasTriplet[x ^ num] = true;
                }
            }
        }

        
        int count = 0;
        for (boolean present : hasTriplet) {
            if (present) {
                count++;
            }
        }

        return count;
    }
}