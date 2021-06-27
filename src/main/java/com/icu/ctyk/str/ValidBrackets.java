package com.icu.ctyk.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @author ctykwz on 2021-06-03 17:42
 */
public class ValidBrackets {

    public static void main(String[] args) {
        int[][] val = new int[][]{new int[]{2, 3}};
        System.out.println(new ValidBrackets().isValid("(]"));
    }

    // 由于不存在交叉，所以有效括号的开关至少有一个是连续的
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> characters = new Stack<>();
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('}', '{');
        characterMap.put(')', '(');
        characterMap.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (characterMap.containsKey(character)) {
                // 遇到右括号，那么上一个肯定要是左括号
                if (characters.isEmpty() || !Objects.equals(characterMap.get(character), characters.peek())) {
                    return false;
                }
                characters.pop();
            } else {
                characters.push(character);
            }
        }
        return characters.isEmpty();
    }
}
