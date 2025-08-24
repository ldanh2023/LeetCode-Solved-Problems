import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Step 1 - Create Set
        HashSet<Integer> elements = new HashSet<>();

        //Step 2 - Create HashMap with frequencies
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        
        //Step 3 - Create HashMap with list of indices
        HashMap<Integer, ArrayList<Integer>> indices = new HashMap<>();

        //Setup hashmaps, arrays
        for (int i = 0; i < nums.length; i++) {
            elements.add(nums[i]);
            frequencies.put(nums[i], frequencies.getOrDefault(nums[i], 0) + 1);
            
            if (indices.get(nums[i]) == null) {
                indices.put(nums[i], new ArrayList<>());
            }

            indices.get(nums[i]).add(i);
        }


        int leftover;
        for (int i = 0; i < nums.length; i++) {
            leftover = target - nums[i];

            if (elements.contains(leftover)) {
                if (leftover == nums[i] && frequencies.get(nums[i]) >= 2) {
                    int[] arr = {indices.get(nums[i]).get(0), indices.get(nums[i]).get(1)};
                    return arr;
                }
                else if (leftover != nums[i]) {
                    int[] arr = {indices.get(nums[i]).get(0), indices.get(leftover).get(0)};
                    return arr;
                }
            }
        }

        return null; //shouldn't happen if problem input is valid
    }
}