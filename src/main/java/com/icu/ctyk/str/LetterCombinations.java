package com.icu.ctyk.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-05 15:50
 */
public class LetterCombinations {


    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }

    private static final Map<Character, String> DIGIT_STR_MAP = new HashMap<>();

    static {
        DIGIT_STR_MAP.put('2', "abc");
        DIGIT_STR_MAP.put('3', "def");
        DIGIT_STR_MAP.put('4', "ghi");
        DIGIT_STR_MAP.put('5', "jkl");
        DIGIT_STR_MAP.put('6', "mno");
        DIGIT_STR_MAP.put('7', "pqrs");
        DIGIT_STR_MAP.put('8', "tuv");
        DIGIT_STR_MAP.put('9', "wxyz");
    }

    //2-9
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        generate(result, digits.toCharArray(), 0, new StringBuilder());
        return result;
    }

    private void generate(List<String> result, char[] input, int index, StringBuilder builder) {
        if (input.length == index) {
            result.add(builder.toString());
            return;
        }
        String zChars = DIGIT_STR_MAP.get(input[index]);
        for (int i = 0; i < zChars.length(); i++) {
            generate(result, input, index + 1, builder.append(zChars.charAt(i)));
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
