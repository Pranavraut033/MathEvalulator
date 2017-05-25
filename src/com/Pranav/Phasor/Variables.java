package com.Pranav.Phasor;

import static com.Pranav.Phasor.Variable.createAlias;

/**
 * Created on 22-04-17 at 22:42
 *
 * @author Pranav
 * @version 1
 */

public class Variables {

    public static final Variable PI = new Variable("PI") {
        @Override
        public double getVariableValue() {
            return Math.PI;
        }
    };

    public static final Variable E = new Variable("E") {
        @Override
        public double getVariableValue() {
            return Math.E;
        }
    };

    public static Variable pi = createAlias(PI, "pi"), e = createAlias(E, "e");

    public static Variable[] getAllVariable() {
        return new Variable[]{
                PI, E, e, pi
        };
    }
}
