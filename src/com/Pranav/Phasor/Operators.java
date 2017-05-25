package com.Pranav.Phasor;

/**
 * Created on 22-04-17 at 02:36 PM
 *
 * @author Pranav Raut
 * @version 1
 */
public class Operators {

    public static final Operator addition = new Operator('+', 100, Operator.BINARY, false) {
        @Override
        public double call(double leftArg, double rightArg) {
            return leftArg + rightArg;
        }
    };
    public static final Operator subtraction = new Operator('-', 100, Operator.BINARY, false) {
        @Override
        public double call(double leftArg, double rightArg) {
            return leftArg - rightArg;
        }
    };
    public static final Operator multiplication = new Operator('*', 400, Operator.BINARY, false) {
        @Override
        public double call(double leftArg, double rightArg) {
            return leftArg * rightArg;
        }
    };
    public static final Operator division = new Operator('/', 400, Operator.BINARY, false) {
        @Override
        public double call(double leftArg, double rightArg) {
            if (rightArg == 0)
                throw new ArithmeticException("Cannot Divide by Zero");
            return leftArg / rightArg;
        }
    };

    public static final Operator power = new Operator('^', 900, Operator.BINARY, false) {
        @Override
        public double call(double leftArg, double rightArg) {
            return Math.pow(leftArg, rightArg);
        }
    };


    public static final Operator factorial = new Operator('!', 1000, Operator.UNARY_ON_LEFT, false) {
        @Override
        public double call(double leftArg, double rightArg) {
            int i = (int) leftArg;
            if (leftArg > i)
                throw new ArithmeticException("Factorial of a floating point (" + leftArg + ") number cannot be found");
            if (leftArg < 0)
                throw new ArithmeticException("Factorial of a negative number(" + leftArg + ")  cannot be found");
            return fact(i);
        }
    };

    static Operator[] getAllOperator() {
        return new Operator[]{
                addition, subtraction, multiplication, division, factorial, power
        };
    }
    
    public static long fact(int num) {
        return num == 0 ? 1 : num * fact(num - 1);
    }

}
