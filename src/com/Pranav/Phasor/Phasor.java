package com.Pranav.Phasor;

import com.Pranav.String.StringUtils;

import static com.Pranav.Array.DymArray.*;
import static com.Pranav.Phasor.ValidityHelper.ALL_CHARS;
import static com.preon.Maths.out;

/**
 * Created on 20-04-17 at 12:37 AM
 *
 * @author Pranav Raut
 * @version 1
 */
class Phasor {
    private static final String EXP =
            "Expression is not supported by the given operators or functions or variable " +
                    "(operator or operand(s) may be misplaced)";
    private final Function[] functions;
    private final Variable[] variables;
    private final Operator[] operators;
    private String expression;
    private double result;
    private String lastSolvedEx;

    Phasor(Evaluator evaluator) {
        this.functions = evaluator.getFunctions();
        this.operators = evaluator.getOperators();
        this.variables = evaluator.getVariables();
        expression = evaluator.getExpression();

        solveVar();
    }

    private void solveVar() {
        for (Variable variable : variables) {
            String value = String.valueOf(variable.getVariableValue());
            StringUtils v = new StringUtils(variable.getVariableName());
            if (expression.contains(v.getS())) {
                int t = new StringUtils(expression).getIndexOfFirstString(v.getS());
                expression = (expression.charAt(t - 1) + "").matches("[" + ALL_CHARS + "(]") ?
                        expression.replaceAll(v.getS(), value) : expression.replaceAll(v.getS(), "*" + value);
            }
        }
    }

    private void solveFun() throws Exception {
        for (Function function : functions) {
            String n = function.getName(), s;
            StringUtils utils = new StringUtils(expression);
            while (expression.contains(n)) {
                int sIndex = utils.getIndexOfFirstString(n) + n.length() + 1;
                int eIndex = utils.getParaEndL(sIndex) - 1;
                String[] strings = (s = utils.getTrimString(sIndex, eIndex)).split(",");
                if (strings.length == function.getNumArg()) {
                    double[] doubles = new double[strings.length];
                    for (int i = 0; i < strings.length; i++) doubles[i] = phase(strings[i]);
                    expression = expression.replace(n + "(" + s + ")",
                            String.valueOf(function.call(doubles)));
                } else throw new Exception("Function '" + function.getName() + "' having mismatched arguments");
            }
        }
    }

    double phase() throws Exception {
        solveFun();
        return result = phase(expression);
    }

    private double phase(String expression) throws Exception {
        while (containPara(expression)) {
            String d = String.valueOf(recursivePara(expression)).replace('-', '~');
            expression = expression.replace("(" + lastSolvedEx + ")", d);
        }
        return solve2(expression);
    }


    private double recursivePara(String s) throws Exception {
        return containPara(s) ? recursivePara(getParaString(s)) : solve2(s);
    }

    private boolean containPara(String s) {
        return s.matches(".*[(].*[)].*$");
    }

    private double solve2(String s) throws Exception {
        char[] chars = (lastSolvedEx = s).toCharArray();
        double[] operands = new double[0];
        char[] operators = new char[0];
        StringBuilder sNumber = new StringBuilder();
        Operator o = null;
        for (char c : chars) {
            if ((c + "").matches("[0-9.~eE]")) sNumber.append(c);
            else if ((c + "").matches("[" + ALL_CHARS + "]")) {
                if (c == '-' && (sNumber.toString().isEmpty() || sNumber.toString().matches(".*[eE]"))) {
                    sNumber.append("~");
                    continue;
                }
                boolean b = false;
                for (Operator operator : this.operators)
                    if (operator.equal(c)) {
                        switch (operator.getMode()) {
                            case Operator.UNARY_ON_LEFT:
                                b = true;
                                sNumber = new StringBuilder(String.valueOf(operator.call
                                        (getDouble(sNumber.toString()), 0)));
                                break;
                            case Operator.UNARY_ON_RIGHT:
                                b = true;
                                o = operator;
                                break;
                        }
                        break;
                    }
                if (b) continue;
                if (o != null) {
                    operands = iiDym(operands, o.call(0, getDouble(sNumber.toString())));
                    o = null;
                } else operands = iiDym(operands, getDouble(sNumber.toString()));
                operators = iiDym(operators, c);
                sNumber = new StringBuilder();
            }
        }
        //UNARY_ON_RIGHT operator
        operands = o != null ? iiDym(operands, o.call(0, getDouble(sNumber.toString()))) :
                iiDym(operands, getDouble(sNumber.toString()));
        Operator[] oTemp = charsToOps(operators);
        while (oTemp.length > 0) {
            int i, pTemp = -1, c = 0;
            for (i = 0; i < oTemp.length; i++)
                if (pTemp < oTemp[i].getPrecedence()) {
                    pTemp = oTemp[i].getPrecedence();
                    c = i;
                }
            operands = idDYm(operands, oTemp[c].call(operands[c], operands[c + 1]), c + 1);
            oTemp = dDYm(oTemp, c);
        }
        return operands[0];
    }

    private Operator[] charsToOps(char[] chars) throws Exception {
        Operator[] operators = new Operator[chars.length];
        int i = 0;
        for (char c : chars)
            for (Operator operator : this.operators) {
                if (operator.equal(c))
                    operators[i++] = operator;
            }
        StringBuilder builder = new StringBuilder("");
        for (int i1 = 0; i1 < chars.length; i1++)
            if (operators[i1] == null)
                builder.append(chars[i1]).append(", ");
        if (!builder.toString().isEmpty()) {
            builder.delete(builder.length() - 2, builder.length());
            throw new Exception("Unknown Operator(s): '" + builder.toString() + "'");
        }
        return operators;
    }


    private double getDouble(String s) throws Exception {
        if (s.isEmpty()) throw new Exception(EXP);
        double d;
        try {
            d = Double.parseDouble(s.replace('~', '-'));
        } catch (Exception ignored) {
            throw new Exception(EXP);
        }
        return d;
    }

    public double getResult() {
        return result;
    }

    private String getParaString(String s) {
        StringUtils utils = new StringUtils(s);
        int start = utils.getParaStartL() + 1, end = utils.getIndexOfFirstChar(')') - 1;
        return containPara(s) ? utils.getTrimString(start, end) : utils.getS();
    }
}