package com.Pranav.Array;

import com.Pranav.Phasor.Function;
import com.Pranav.Phasor.Operator;

/**
 * Created on 30-04-17 at 19:57
 *
 * @author Pranav
 * @version 1
 */

public class DymArray {

    public static double[] iDym(double[] doubles) {
        double[] temp = new double[doubles.length + 1];
        int i = 0;
        for (double d : doubles)
            temp[i++] = d;
        return temp;
    }

    public static double[] iiDym(double[] doubles, double d) {
        double[] temp = iDym(doubles);
        temp[doubles.length] = d;
        return temp;
    }

    public static double[] dDYm(double[] doubles, int removeId) {
        double[] temp = new double[doubles.length - 1];
        for (int i = 0, j = 0; i < doubles.length; i++) {
            if (i != removeId) {
                temp[j] = doubles[i];
                j++;
            }
        }
        return temp;
    }

    public static char[] iiDym(char[] chars, char c) {
        char[] temp = iDym(chars);
        temp[chars.length] = c;
        return temp;
    }

    public static char[] dDYm(char[] chars, int removeId) {
        char[] temp = new char[chars.length - 1];
        for (int i = 0, j = 0; i < chars.length; i++)
            if (i != removeId) {
                temp[j] = chars[i];
                j++;
            }
        return temp;

    }

    public static Operator[] dDYm(Operator[] operators, int removeId) {
        Operator[] temp = new Operator[operators.length - 1];
        for (int i = 0, j = 0; i < operators.length; i++)
            if (i != removeId) {
                temp[j] = operators[i];
                j++;
            }
        return temp;
    }

    public static Function[] dDYm(Function[] functions, int removeId) {
        Function[] temp = new Function[functions.length - 1];
        for (int i = 0, j = 0; i < functions.length; i++)
            if (i != removeId) {
                temp[j] = functions[i];
                j++;
            }
        return temp;
    }

    public static double[] idDYm(double[] doubles, double d, int i) {
        double[] temp = dDYm(doubles, i);
        temp[i - 1] = d;
        return temp;
    }

    public static char[] iDym(char[] chars) {
        char[] temp = new char[chars.length + 1];
        int i = 0;
        for (char c : chars)
            temp[i++] = c;
        return temp;
    }

}
