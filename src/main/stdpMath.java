package main;

public class stdpMath {
    public static double solveSimpleEquasion(double num1, char operator, double num2) {
        double result = 0.0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                result = num1 / num2;
                break;

            case '%':
                result = num1 % num2;
                break;

            case '^':
                result = Math.pow(num1, num2);
                break;

            default:
                break;
        }

        return result;
    }
}
