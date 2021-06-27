package com.icu.ctyk.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-10 11:04
 */
public class NumKLenSubstrNoRepeats {

    public static void main(String[] args) {
        System.out.println(new NumKLenSubstrNoRepeats().numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }

    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> occur = new HashMap<>();
        int slow = 0;
        int fast = 0;
        int res = 0;
        while (fast < s.length()) {
            Character character = s.charAt(fast);
            int index = occur.getOrDefault(character, -1);
            if (index >= slow && index < fast) {
                occur.put(character, fast);
                slow = index+1;
            } else if (fast - slow + 1 == k) {
                System.out.println(s.substring(slow, fast + 1));
                occur.put(character, fast);
                res++;
                fast++;
                slow++;
            } else if (fast - slow + 1 < k) {
                occur.put(character, fast);
                fast++;
            }
        }
        return res;
    }
}
