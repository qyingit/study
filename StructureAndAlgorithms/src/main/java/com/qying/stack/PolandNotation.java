package com.qying.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {
        //先定义逆波兰表达式
        //(30 + 4)*5-6 => 30 4 + 5*6 - =>164
        //4 * 5 -8 + 60 + 8/2 => 45*8 - 60 + 8 2 / +

        String  suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList = "+ list);
        int res = calculate(list);
        System.out.println("计算的结果是="+res);
    }

    private static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele: split){
            list.add(ele);
        }
        return list;
    }
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<String>();
        for (String item : list){
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1+num2;
                }else if(item.equals("-")){
                    res = num1 -num2;
                }else if(item.equals("*")){
                    res = num1* num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算有吴");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
