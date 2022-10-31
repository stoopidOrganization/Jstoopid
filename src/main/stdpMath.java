package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stdpMath {
    private ArrayList<String> equasionAsList;

    public stdpMath(String equasion) {
        this.equasionAsList = new ArrayList<>();
        splitEquasion(equasion.replaceAll(" ", ""));
    }

    public double solveEquasion() {
        double result = 0.0;

        // TODO implement solver

        return result;
    }

    private Queue<String> convertToRPN() {
        Stack<String> operators = new Stack<>();
        Queue<String> equasionInRPN = new LinkedList<>();;

        for (int i = 0; i < equasionAsList.size(); i++) {
            String current = equasionAsList.get(i);

            System.out.println(current);

            if (Utils.isNumber(current)) {
                equasionInRPN.add(current);
            } else if (operators.isEmpty()) {
                operators.add(current);
            } else if (calcOperatorScore(current) >= calcOperatorScore(operators.peek())) {
                operators.add(current);
            } else {
                while (!operators.isEmpty()) {
                    if (calcOperatorScore(current) < calcOperatorScore(operators.peek())) {
                        equasionInRPN.add(operators.peek());
                        operators.pop();
                    } else break;
                }

                operators.add(current);
            }
        }

        while (!operators.isEmpty()) {
            equasionInRPN.add(operators.peek());
            operators.pop();
        }

        System.out.println("\n\nqueueuueueuueue");
        for (String str : equasionInRPN) {
            System.out.println(str);
        }

        return equasionInRPN;
    }
    
    private void splitEquasion(String equasion) {
        String s = "";
        char[] list = equasion.toCharArray();

        for (int i = 0; i < list.length; i++) {
            if (Utils.isNumber(String.valueOf(list[i]))) {
                s += list[i];
            } else {
                this.equasionAsList.add(s);
                this.equasionAsList.add(String.valueOf(list[i]));
                s = "";
            }
        }

        this.equasionAsList.add(s);
    }

    /**
     * Calculates a score based on the operater
     * <br><br>
     * higher = more important
     * @param operator
     * @return score
     */
    public static int calcOperatorScore(String operator) {
        switch (operator) {
            case "+":
                return 0;

            case "-":
                return 1;

            case "*":
                return 2;

            case "/":
                return 3;

            case "%":
                return 4;

            case "^":
                return 5;
        
            default:
                return -1;
        }
    }

    /**
     * @param operator
     * @return if input is an operator
     */
    public static boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("%") || operator.equals("^");
    }
}
