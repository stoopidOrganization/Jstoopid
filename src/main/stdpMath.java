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

        /* debug code to print out the rpn equasion
        System.out.print("Equasion: ");
        for (String str : equasionInRPN) System.out.print(str + " ");
        System.out.println();
         */

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

    /**
     * Converts an infix equasion into a reverse polish notation equasion
     * @param equasion
     * @return Queue in rpn
     * @throws InvalidOperatorException
     */
    private static Queue<String> convertToRPN(ArrayList<String> equasion) throws InvalidOperatorException {
        Queue<String> equasionInRPN = new LinkedList<>();
        
        // saves the operators in a list of stacks, each stack is a bracket an will be deleted when bracket is closed
        ArrayList<Stack<String>> operators = new ArrayList<>();
        operators.add(new Stack<>());
        int currentStack = 0;

        for (int i = 0; i < equasion.size(); i++) {
            String current = equasion.get(i);

            if (Utils.isNumber(current)) {
                // if number then add to result
                equasionInRPN.add(current);
            } else if (isOperator(current) && operators.get(currentStack).isEmpty()) {
                // if first operator then add to stack
                operators.get(currentStack).add(current);
            } else if (isOperator(current) && calcOperatorScore(current) >= calcOperatorScore(operators.get(currentStack).peek())) {
                // if another operator thats better or equal to the one the top of the stack that add it to that
                operators.get(currentStack).add(current);
            } else if (current.contains("(")) {
                // move to a higher stack when open bracket is found
                currentStack++;
                operators.add(new Stack<>());
            } else if (current.contains(")")) {
                // clear the highest stack and add the contents to the result when close bracket is found
                while (!operators.get(currentStack).isEmpty()) {
                    equasionInRPN.add(operators.get(currentStack).peek());
                    operators.get(currentStack).pop();
                }

                operators.remove(currentStack);
                currentStack--;
            } else {
                // if an operator with a lower status is found add all operators to the queue until the current operator is better or equal to the top of the stack
                while (!operators.get(currentStack).isEmpty()) {
                    if (calcOperatorScore(current) < calcOperatorScore(operators.get(currentStack).peek())) {
                        equasionInRPN.add(operators.get(currentStack).peek());
                        operators.get(currentStack).pop();
                    } else break;
                }

                operators.get(currentStack).add(current);
            }
        }

        // clear all remainging elements in the stack
        while (currentStack >= 0) {
            while (!operators.get(currentStack).isEmpty()) {
                equasionInRPN.add(operators.get(currentStack).peek());
                operators.get(currentStack).pop();
            }
            currentStack--;
        }

        return equasionInRPN;
    }
    
    /**
     * Spilts the equasion into its parts
     * @param equasion
     * @return list of all parts in the equasion
     */
    private static ArrayList<String> splitEquasion(String equasion) {
        String cache = "";
        // puts the equasion into a list of chars without spaceys
        char[] list = equasion.replaceAll(" ", "").toCharArray();
        ArrayList<String> equasionAsList = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if (Utils.isNumber(String.valueOf(list[i])) || list[i] == '.') {
                // if number add to cache
                cache += list[i];
            } else {
                // if operator is actually part of a negative number then add it to the cache
                if (list[i] == '-') {
                    if (i == 0) {
                        cache += list[i];
                        continue;
                    } else if (isOperator(String.valueOf(list[i - 1]))) {
                        cache += list[i];
                        continue;
                    }
                }

                // if the cache isnt empty and an operator is found, add it to the result
                if (cache != "") {
                    equasionAsList.add(cache);
                    cache = "";
                }

                // add operators and brackets to the list
                if (isOperator(String.valueOf(list[i]))) {
                    equasionAsList.add(String.valueOf(list[i]));
                } else if (list[i] == '(') {
                    equasionAsList.add("(");
                } else if (list[i] == ')') {
                    equasionAsList.add(")");
                }
            }
        }
        
        equasionAsList.add(cache);
        
        return equasionAsList;
    }

    /**
     * solves a simple 2 number 1 operator equasion
     * @param num1
     * @param num2
     * @param operator
     * @return the solved equasion
     * @throws InvalidOperatorException
     */
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
    private static int calcOperatorScore(String operator) throws InvalidOperatorException {
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
