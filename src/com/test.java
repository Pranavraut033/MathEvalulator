package com;

import com.Pranav.Phasor.Evaluator;
import com.Pranav.Phasor.Function;
import com.Pranav.Phasor.Operator;
import com.Pranav.Phasor.Variable;

/**
 * tests
 *
 * @author Pranav
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Evaluator evaluator = new Evaluator("per(3$2#,o)");
        evaluator.addFunction(new Function("per", 2) {
            @Override
            public double call(double... args) {
                return args[0] / args[1] * 100;
            }
        }).addVariable(new Variable("o") {
            @Override
            public double getVariableValue() {
                return 100;
            }
        }).addOperator(new Operator('$', 50, Operator.BINARY) {
            @Override
            public double call(double leftArg, double rightArg) {
                return (leftArg - rightArg) * 3;
            }
        }).addOperator(new Operator('#', 600, Operator.UNARY_ON_LEFT) {
            @Override
            public double call(double leftArg, double rightArg) {
                return Math.pow(leftArg, 3.0);
            }
        });
        System.out.println(evaluator.eval());
    }
}
