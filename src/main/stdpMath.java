package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import exceptions.InvalidOperatorException;

/**
 * Handles all math systems of the language
 */
public class stdpMath {
    /**
     * Solves the given equasion
     * @param equasion
     * @return solved equasion
     * @throws InvalidOperatorException
     */
    public static double solveEquasion(String equasion) throws InvalidOperatorException {
        Queue<String> equasionInRPN = convertToRPN(splitEquasion(equasion));
        Stack<String> storage = new Stack<>();

        while (!equasionInRPN.isEmpty()) {
            String current = equasionInRPN.peek();
            equasionInRPN.remove();

            if (isOperator(current)) {
                String num2 = storage.peek();
                storage.pop();
                String num1 = storage.peek();
                storage.pop();

                storage.add(solveSimpleEquasion(num1, num2, current));
                
            } else {
                storage.push(current);
            }
        }

        return Double.parseDouble(storage.peek());
    }

    private static Queue<String> convertToRPN(ArrayList<String> equasion) throws InvalidOperatorException {
        ArrayList<Stack<String>> operators = new ArrayList<>();
        Queue<String> equasionInRPN = new LinkedList<>();

        operators.add(new Stack<>());
        int currentStack = 0;

        for (int i = 0; i < equasion.size(); i++) {
            String current = equasion.get(i);

            if (Utils.isNumber(current)) {
                equasionInRPN.add(current);
            } else if (isOperator(current) && operators.get(currentStack).isEmpty()) {
                operators.get(currentStack).add(current);
            } else if (isOperator(current) && calcOperatorScore(current) >= calcOperatorScore(operators.get(currentStack).peek())) {
                operators.get(currentStack).add(current);
            } else if (current.contains("(")) {
                currentStack++;
                operators.add(new Stack<>());
            } else if (current.contains(")")) {
                while (!operators.get(currentStack).isEmpty()) {
                    equasionInRPN.add(operators.get(currentStack).peek());
                    operators.get(currentStack).pop();
                }

                operators.remove(currentStack);
                currentStack--;
            } else {
                while (!operators.get(currentStack).isEmpty()) {
                    if (calcOperatorScore(current) < calcOperatorScore(operators.get(currentStack).peek())) {
                        equasionInRPN.add(operators.get(currentStack).peek());
                        operators.get(currentStack).pop();
                    } else break;
                }

                operators.get(currentStack).add(current);
            }
        }

        while (!operators.get(currentStack).isEmpty()) {
            equasionInRPN.add(operators.get(currentStack).peek());
            operators.get(currentStack).pop();
        }

        return equasionInRPN;
    }
    
    private static ArrayList<String> splitEquasion(String equasion) {
        String s = "";
        char[] list = equasion.replaceAll(" ", "").toCharArray();
        ArrayList<String> equasionAsList = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if (Utils.isNumber(String.valueOf(list[i])) || list[i] == '.') {
                s += list[i];
            } else {
                if (list[i] == '-') {
                    if (i == 0) {
                        s += list[i] +'\0';
                        continue;
                    } else if (isOperator(String.valueOf(list[i - 1]))) {
                        s += list[i] +'\0';
                        continue;
                    }
                }

                if (s != "") {
                    equasionAsList.add(s);
                    s = "";
                }

                if (isOperator(String.valueOf(list[i]))) {
                    equasionAsList.add(String.valueOf(list[i]));
                } else if (list[i] == '(') {
                    equasionAsList.add("(");
                } else if (list[i] == ')') {
                    equasionAsList.add(")");
                }
            }
        }
        
        equasionAsList.add(s);
        
        return equasionAsList;
    }

    private static String solveSimpleEquasion(String num1, String num2, String operator) throws InvalidOperatorException {
        switch (operator) {
            case "+":
                return String.valueOf(Double.parseDouble(num1) + Double.parseDouble(num2));
            
            case "-":
                return String.valueOf(Double.parseDouble(num1) - Double.parseDouble(num2));

            case "*":
                return String.valueOf(Double.parseDouble(num1) * Double.parseDouble(num2));

            case "/":
                return String.valueOf(Double.parseDouble(num1) / Double.parseDouble(num2));

            case "%":
                return String.valueOf(Double.parseDouble(num1) % Double.parseDouble(num2));

            case "^":
                return String.valueOf(Math.pow(Double.parseDouble(num1), Double.parseDouble(num2)));
        
            default:
                throw new InvalidOperatorException(operator);
        }
    }
    
    /**
     * Calculates a score based on the operater
     * <br><br>
     * higher = more important
     * @param operator
     * @return score
     * @throws InvalidOperatorException
     */
    public static int calcOperatorScore(String operator) throws InvalidOperatorException {
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
                throw new InvalidOperatorException(operator);
        }
    }

    /**
     * @param operator
     * @return if input is an operator
     */
    public static boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("%") || operator.equals("^");
    }

    /**
     * @param str to be checked
     * @return if given input is an equasion
     */
    public static boolean isEquasion(String str) {
        char[] list = str.toCharArray();
        
        for (char c : list) {
            if (!(Utils.isNumber(String.valueOf(c)) || isOperator(String.valueOf(c)) || c == '(' || c == ')' || c == '.')) return false;
        }

        return true;
    }
}
