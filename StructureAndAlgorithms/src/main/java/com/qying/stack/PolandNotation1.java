/*
package com.qying.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation1 {

    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);

    }

    private static List<String> parseSuffixExpressionList(List<String> infixExpressionList) {

        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();

        for (String item : infixExpressionList){
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while (s1.size() != 0 && Operation)
            }
        }
    }

    private static List<String> toInfixExpressionList(String expression) {
        return null;
    }

}
*/
