package com.Pranav.Phasor;

/**
 * Created on 22-04-17 at 13:38
 *
 * @author Pranav Raut
 * @version 1
 */

public abstract class Operator {

    /**
     * Effect on number (operand) on right eg 12+#3+4 => valid (@ is an operator with operand 3)
     */
    public static final int UNARY_ON_RIGHT = 1;
    /**
     * Effect on number (operand) on left eq 12+3&+4 => valid (& is an operator with operand 3)
     */
    public static final int UNARY_ON_LEFT = -1;
    public static final int BINARY = 2;
    private final boolean isUnary;
    private final char operatorSign;
    private final int precedence;
    private final int mode;


    public Operator(char operatorSign, int precedence, int mode) {
        this(operatorSign, precedence, mode, true);
    }

    Operator(char operatorSign, int precedence, int mode, boolean b) {
        this.operatorSign = b ? ValidityHelper.checkValidity(operatorSign) : operatorSign;
        this.precedence = precedence;
        this.mode = mode;
        isUnary = mode == Operator.UNARY_ON_LEFT || mode == Operator.UNARY_ON_RIGHT;
        check();
    }

    private void check() {
        if (isUnary && precedence <= 500 && precedence > 1000)
            throw new ExceptionInInitializerError("Unary operator (" + operatorSign + ") should have precedence less than and near 1000");
        if (!isUnary && precedence > 500 && precedence <= 0)
            throw new ExceptionInInitializerError("Binary operator (" + operatorSign + ") should have precedence between 0 and 500");
    }

    public boolean isUnary() {
        return isUnary;
    }

    public abstract double call(double leftArg, double rightArg);

    public char getOperatorSign() {
        return operatorSign;
    }

    public int getPrecedence() {
        return precedence;
    }

    public int getMode() {
        return mode;
    }

    public boolean equal(char c) {
        return operatorSign == c;
    }
}
