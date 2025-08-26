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


/* Brute force approach: O(n^2)

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

*/





/* Not efficient algorithm, produces substring with greatest length and also substring itself, but we don't need to know the substring

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

*/