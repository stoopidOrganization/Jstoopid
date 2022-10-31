package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stdpMath {
    private String equasion;
    private ArrayList<String> calcList;
    private Stack<String> operator;
    private Queue<String> calcQueue;

    public stdpMath(String equasion) {
        this.equasion = equasion.replaceAll(" ", "");
        this.calcList = new ArrayList<>();
        this.operator = new Stack<>();
        this.calcQueue = new LinkedList<>();

        convert();
    }

    public double solve() {
        double result = 0.0;

        for (int i = 0; i < calcList.size(); i++) {
            String current = calcList.get(i);

            System.out.println(current);

            if (Utils.isNumber(current)) {
                this.calcQueue.add(current);
            } else if (this.operator.isEmpty()) {
                this.operator.add(current);
            } else if (calcOperatorScore(current) >= calcOperatorScore(this.operator.peek())) {
                this.operator.add(current);
            } else {
                while (!this.operator.isEmpty()) {
                    if (calcOperatorScore(current) < calcOperatorScore(this.operator.peek())) {
                        this.calcQueue.add(this.operator.peek());
                        this.operator.pop();
                    } else break;
                }

                this.operator.add(current);
            }
        }

        while (!this.operator.isEmpty()) {
            this.calcQueue.add(this.operator.peek());
            this.operator.pop();
        }

        System.out.println("\n\nqueueuueueuueue");
        for (String str : calcQueue) {
            System.out.println(str);
        }

        return result;
    }
    
    private void convert() {
        String s = "";
        char[] list = this.equasion.toCharArray();

        for (int i = 0; i < list.length; i++) {
            if (Utils.isNumber(String.valueOf(list[i]))) {
                s += list[i];
            } else {
                this.calcList.add(s);
                this.calcList.add(String.valueOf(list[i]));
                s = "";
            }
        }

        this.calcList.add(s);
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
