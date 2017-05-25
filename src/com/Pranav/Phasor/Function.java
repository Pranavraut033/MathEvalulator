package com.Pranav.Phasor;


/**
 * Created on 20-04-17 at 12:37 AM
 *
 * @author Pranav Raut
 * @version 1
 */
public abstract class Function {

    private final String name;
    private final int numArg;
    private boolean ValidFun;

    /**
     * @param name   Name of the function
     * @param numArg No of arguments
     * @throws IllegalArgumentException when {@link #numArg} is negative
     */
    public Function(String name, int numArg) {
        ValidFun = ValidityHelper.checkValidity(name, "Function name");
        if (ValidFun = numArg < 0)
            throw new IllegalArgumentException("No of argument(" + numArg + ") Cannot be negative");
        this.name = name;
        this.numArg = numArg;
    }

    public abstract double call(double... args);

    public boolean isValidFun() {
        return ValidFun;
    }

    public String getName() {
        return name;
    }

    public int getNumArg() {
        return numArg;
    }

}
