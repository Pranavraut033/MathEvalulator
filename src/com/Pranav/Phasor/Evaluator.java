package com.Pranav.Phasor;


/**
 * Created on 20-04-17 at 12:37 AM
 *
 * @author Pranav Raut
 * @version 1
 */
public class Evaluator {

    private final String expression;
    private double result = 0d;
    private boolean isValidPattern;
    private boolean isDeg = true;
    private int numFun = 0, numOp = 0, numVar = 0;
    private Function[] aFunctions;
    private Operator[] aOperators;
    private Variable[] aVariables;
    private boolean isValidResult;

    public Evaluator(String expression) {
        this(expression, true);
    }

    public Evaluator(String expression, boolean isDeg) {
        this.expression = expression;
        this.isDeg = isDeg;
        aFunctions = new Functions(isDeg).getAllFunctions();
        aOperators = Operators.getAllOperator();
        aVariables = Variables.getAllVariable();
        numOp = aOperators.length;
        numFun = aFunctions.length;
        numVar = aVariables.length;
    }

    /**
     * @return the expression given in constructor {@link #Evaluator(String, boolean)}
     */
    public String getExpression() {
        return expression;
    }

    public double eval() throws Exception {
        check();
        return result = new Phasor(this).phase();
    }

    private boolean check() throws Exception {
        checkAvailability();
        return ValidityHelper.checkValidity(expression);
    }

    Function[] getFunctions() {
        return aFunctions;
    }

    Operator[] getOperators() {
        return aOperators;
    }

    Variable[] getVariables() {
        return aVariables;
    }

    public boolean isValidPattern() {
        try {
            return isValidPattern = check();
        } catch (Exception ignored) {
        }
        return isValidPattern;
    }

    public boolean isValidResult() {
        return isValidResult;
    }

    /**
     * @return weather the parameter in trigonometric functions is  considered as radian(false) or degree(true)
     */
    public boolean isDeg() {
        return isDeg;
    }

    public double getResult() {
        return result;
    }

    /**
     * @param functions add function to be used during evaluation
     */
    public Evaluator addFunction(Function... functions) {
        Function[] temp = new Function[numFun + functions.length];
        System.arraycopy(aFunctions, 0, temp, 0, aFunctions.length);
        for (Function function : functions) temp[numFun++] = function;
        aFunctions = temp;
        return this;
    }

    /**
     * @param operators add Operator to be used during evaluation other than primitive operator
     * @see ValidityHelper
     */
    public Evaluator addOperator(Operator... operators) {
        Operator[] temp = new Operator[numOp + operators.length];
        System.arraycopy(aOperators, 0, temp, 0, aOperators.length);
        for (Operator operator : operators) temp[numOp++] = operator;
        aOperators = temp;
        return this;
    }

    /**
     * @param variables add variable to be used during evaluation
     */

    public Evaluator addVariable(Variable... variables) {
        Variable[] temp = new Variable[numVar + variables.length];
        System.arraycopy(aVariables, 0, temp, 0, aVariables.length);
        for (Variable variable : variables) temp[numVar++] = variable;
        aVariables = temp;
        return this;
    }

    /**
     * @return Number of Functions Used
     */
    public int getNumFun() {
        return numFun;
    }

    /**
     * @return No of Operators Used
     */
    public int getNumOp() {
        return numOp;
    }

    /**
     * @return No of Variables Used
     */
    public int getNumVar() {
        return numVar;
    }

    private void checkAvailability() throws Exception {
        for (Function function : aFunctions)
            for (Variable variable : aVariables)
                if (function.getName().equals(variable.getVariableName()))
                    throw new Exception("Function and Variable have same name : " + variable.getVariableValue());
    }
}
