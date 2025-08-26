# Solved Solution

## Efficient solution: uses O(n) for space and time complexity

**Explanation:**

Right slider loops from beginning to end trying to find the longest substring
    - If right slider lands on character that is already in substring, iterate the left slider all the way until the character is gone
        - Character could be the first character or it could be in middle, therefore left slider may or may not be on its index
            - Therefore have a while loop to shift the left slider until the repeated character is gone
    - Each iteration of right slider, calculate the new length of the substring and set it to be the max if it's larger than the current max

```
//Efficent approach: O(n), slider approach, left and right pointer
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max_length = 0;
        HashSet<Character> set = new HashSet<>();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            max_length = Math.max(max_length, right - left + 1);
        }

        return max_length;
    }
}
```



## Brute force approach: uses O(n^2) for time complexity
```
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max_length = 0;

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                
                set.add(s.charAt(j));
            }

            if (max_length < set.size()) {
                max_length = set.size();

                //If special case: set.size() == s.length() then return immediately because it can't be greater
                if (set.size() == s.length()) {
                    break;
                }
            }
        }

        return max_length;
    }
}
```


## Algorithm below produces the longest substring and stores all candidate substrings (not needed for this problem):

```
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));

            String candidate = new String();
            candidate = candidate + s.charAt(i);

            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                
                set.add(s.charAt(j));
                candidate = candidate + s.charAt(j);
            }

            max_heap.add(candidate.length());

            if (map.containsKey(candidate.length())) {
                map.get(candidate.length()).add(candidate);
            }
            else {
                map.put(candidate.length(), new ArrayList<>());
                map.get(candidate.length()).add(candidate);
            }
        }

        if (max_heap.isEmpty()) {
            return 0;
        } else {
            return max_heap.peek();
        }
    }
}
```