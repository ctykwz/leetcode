package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-10 20:24
 */
public class CharacterReplacement {


    public static void main(String[] args) {
        System.out.println(new CharacterReplacement().characterReplacement("AABABBA", 1));
    }

    //可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次,也就是实际上允许的windowWidth是 maxCharOccurCnt+k
    public int characterReplacement(String s, int k) {
        int[] charOccurCnt = new int[26];
        int right = 0;
        int left = 0;
        int maxOccur = 0;
        while (right < s.length()) {
            int charIndex = s.charAt(right) - 'A';
            charOccurCnt[charIndex]++;
            maxOccur = Math.max(maxOccur, charOccurCnt[charIndex]);
            // 其实这里最重要的是 一旦出现maxOccur的相同字符串，那么会出现 maxOccur + k = windowWidth ，此时及时后续再不会出现最长子串
            // 也会因为left、right是在平移而保持widowWidth不变
            if (right - left + 1 > maxOccur + k) {
                charOccurCnt[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return s.length() - left;
    }
}
