package com.Pranav.temp;

/**
 * Created on 09-05-17 at 18:41
 *
 * @author Pranav
 * @version 1
 */

public class temp {
    /*
    static Operator[] sortOperator(Operator[] operators) {
        for (int i = 1; i < operators.length; i++)
            for (int j = 0; j < operators.length - i; j++)
                if (operators[j].getPrecedence() < operators[j + 1].getPrecedence()) {
                    Operator temp = operators[j];
                    operators[j] = operators[j + 1];
                    operators[j + 1] = temp;
                }
        return operators;
    }
     */
    /*
        private double solve(String s) throws Exception {
            lastSolvedEx = s;
            char[] chars = s.toCharArray();
            double[] operands = new double[0];
            char[] operators = new char[0];
            StringBuilder temp = new StringBuilder();
            Operator tempO = null;
            for (char c : chars) {
                if ((c + "").matches("[0-9.~eE]")) temp.append(c);
                else if ((c + "").matches("[" + ALL_CHARS + "]")) {
                    boolean b = false, f = false;
                    for (Operator operator : this.operators)
                        if (operator.equal(c)) {
                            switch (operator.getMode()) {
                                case Operator.UNARY_ON_LEFT:
                                    b = true;
                                    temp = new StringBuilder(String.valueOf(operator.call(getDouble(temp.toString()), 0)));
                                    break;
                                case Operator.UNARY_ON_RIGHT:
                                    b = true;
                                    tempO = operator;
                                    break;
                            }
                            break;
                        }
                    if (b) continue;
                    if (tempO != null) {
                        operands = iiDym(operands, tempO.call(0, getDouble(temp.toString())));
                        tempO = null;
                    } else operands = iiDym(operands, getDouble(temp.toString()));
                    operators = iiDym(operators, c);
                    temp = new StringBuilder();
                }
            }

            //UNARY_ON_RIGHT operator
            operands = tempO != null ? iiDym(operands, tempO.call(0, getDouble(temp.toString()))) :
                    iiDym(operands, getDouble(temp.toString()));

            for (int i = 0; i < this.operators.length; i++)
                for (int j = 0; j < operators.length; j++)
                    if (this.operators[i].equal(operators[j])) {
                        operands = idDYm(operands, this.operators[i].call(operands[j], operands[j + 1]), j + 1);
                        operators = dDYm(operators, j);
                        i = 0;
                    }
            if (operators.length != 0) {
                StringBuilder builder = new StringBuilder();
                for (char c : operators)
                    builder.append(c).append(", ");
                builder.delete(builder.length() - 2, builder.length());
                throw new Exception("Unknown Operator(s): '" + builder.toString() + "'");
            }
            return operands[0];
        }
        */
}
