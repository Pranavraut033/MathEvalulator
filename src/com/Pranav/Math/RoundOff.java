package com.Pranav.Math;

import com.Pranav.Phasor.Constants;

import java.text.DecimalFormat;

/**
 * Created on 20-04-17 at 12:37 AM
 * Get double with certain precision
 *
 * @author Pranav Raut
 * @version 1
 */

public class RoundOff {

    private final double initialNumber;
    private final boolean giveStd;
    private double number = 0d;
    private int decimal;
    private DfString df;
    private int stdPower = Constants.STD_POWER;

    /**
     * @see #RoundOff(double, int, boolean) )
     */
    public RoundOff(int decimal) {
        this(0, decimal);
    }

    /**
     * @see #RoundOff(double, int, boolean) )
     */
    public RoundOff(int decimal, boolean giveStd) {
        this(0, decimal, giveStd);
    }

    /**
     * @see #RoundOff(double, int, boolean) )
     */
    public RoundOff(double number, int decimal) {
        this(number, decimal, true);
    }

    /**
     * final constructor
     *
     * @param number  number to round off can also use {@link #RoundOff(int, boolean)}
     * @param decimal not of decimal place after dot
     * @param giveStd where to give in scientific notation or not
     * @throws IllegalArgumentException if @param decimal is negative
     */
    public RoundOff(double number, int decimal, boolean giveStd) {
        if (decimal < 0) {
            throw new IllegalArgumentException("Given value '(" + decimal + ")' for Argument decimal is negative");
        }
        initialNumber = number;
        this.decimal = decimal;
        this.giveStd = giveStd;
        inti();
    }

    public static double apply(double number, int decimal) {
        return apply(number, getDf(decimal).getDf());
    }

    public static double apply(double number, DecimalFormat df) {
        //TODO: Complete Standard...
        return Double.parseDouble(df.format(number).replace(",", ""));
    }

    public static DfString getDf(int decimal) {
        StringBuilder s = new StringBuilder("#.");
        for (int i = 0; i < decimal; i++) s.append("#");
        return new DfString().setDf(new DecimalFormat(s.toString())).setS(s.toString());
    }

    private void inti() {
        df = getDf(decimal);
    }

    /**
     * @return final number with {@link #decimal} precision
     * @throws IllegalAccessError when {@link #RoundOff(int, boolean)} or {@link #RoundOff(int)}
     *                            constructor was used (without  number declaration)
     */
    public double apply() throws IllegalAccessError{
        if (initialNumber == 0d)
            throw new IllegalAccessError("Number Constructor was not used initial number is always 0");
        return number = apply(initialNumber);
    }

    public double apply(double number) {
        if (giveStd && (number < Math.pow(10, -stdPower) || number > Math.pow(10, stdPower))) {
            String s = df.getS();
            s = s + "E#";
            df = new DfString().setDf(new DecimalFormat()).setS(s);
        }
        return this.number = apply(number, df.getDf());
    }

    public RoundOff setStdPower(int stdPower) {
        this.stdPower = stdPower;
        return this;
    }

    public double getNumber() {
        return number;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
        inti();
    }

}