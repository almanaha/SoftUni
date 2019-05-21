package StacksAndQueues.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixToPostfix {
    private Stack theStack;
    private String input;
    private String output = "";

    public InfixToPostfix(String in) {
        input = in;
        int stackSize = input.length();
        theStack = new Stack(stackSize);
    }

    public String getOutput() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty()) {
            output = output + theStack.pop();
        }
        return output;
    }

    private void gotOper(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) {
                    theStack.push(opTop);
                    break;
                } else output = output + opTop;
            }
        }
        theStack.push(opThis);
    }

    private void gotParen(char ch) {
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(')
                break;
            else output = output + chx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        InfixToPostfix infixToPostfix = new InfixToPostfix(sc.readLine());
        String output = infixToPostfix.getOutput();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < output.length(); i++) {
            if (output.charAt(i) != ' ') {
                sb.append(output.charAt(i)).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    class Stack {
        private char[] stackArray;
        private int top;

        Stack(int max) {
            stackArray = new char[max];
            top = -1;
        }

        public void push(char j) {
            stackArray[++top] = j;
        }

        public char pop() {
            return stackArray[top--];
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }
}
