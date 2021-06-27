package com.icu.ctyk.array;

import java.util.Stack;

/**
 * @author ctykwz on 2021-06-26 17:33
 */
public class EvalRPN {

    public static void main(String[] args) {
        System.out.println(
                new EvalRPN().evalRPN(new String[]{"4", "13", "5", "/", "+"})
        );
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-": {
                    int right = stack.pop();
                    stack.push(stack.pop() - right);
                    break;
                }
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    int right = stack.pop();
                    stack.push(stack.pop() / right);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }

}
