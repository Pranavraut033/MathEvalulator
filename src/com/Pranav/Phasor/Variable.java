package com.Pranav.Phasor;

/**
 * Created on 22-04-17 at 14:39
 *
 * @author Pranav
 * @version 1
 */

public abstract class Variable {
    private final String variableName;

    public Variable(String variableName) {
        ValidityHelper.checkValidity(variableName, "Variable name");
        this.variableName = variableName;
    }

    /**
     * @return A Constant or A Varying Value
     */
    public abstract double getVariableValue();

    public String getVariableName() {
        return variableName;
    }

    public static Variable createAlias(Variable aliasOf, String variableName) {
        return new Variable(variableName) {
            @Override
            public double getVariableValue() {
                return aliasOf.getVariableValue();
            }
        };
    }
}