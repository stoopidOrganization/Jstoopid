package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stdpMath {
    private String calculation;
    private ArrayList<String> calcList;
    private Stack<String> operator;
    private Queue<String> calcQueue;

    public stdpMath(String calculation) {
        this.calculation = calculation.replaceAll(" ", "");
        this.calcList = new ArrayList<>();
        this.operator = new Stack<>();
        this.calcQueue = new LinkedList<>();

        convert();
    }

    public double solve() {
        double result = 0.0;

        return result;
    }
    
    private void convert() {
        String s = "";
        char[] list = this.calculation.toCharArray();

        for (int i = 0; i < list.length; i++) {
            if (lib.isNumber(String.valueOf(list[i]))) {
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
}
