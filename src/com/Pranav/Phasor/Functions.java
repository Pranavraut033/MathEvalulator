package com.Pranav.Phasor;

/**
 * Created on 20-04-17 at 12:37 AM
 *
 * @author Pranav Raut
 * @version 1
 */

public class Functions {

    private final boolean isDeg;
    public Function sin = new Function("sin", 1) {
        @Override
        public double call(double... args) {
            return Math.sin(isDeg ? Math.toRadians(args[0]) : args[0]);
        }
    };
    public Function cos = new Function("cos", 1) {
        @Override
        public double call(double... args) {
            return Math.cos(isDeg ? Math.toRadians(args[0]) : args[0]);
        }
    };
    public Function tan = new Function("tan", 1) {
        @Override
        public double call(double... args) {
            return Math.tan(isDeg ? Math.toRadians(args[0]) : args[0]);
        }
    };
    public Function asin = new Function("asin", 1) {
        @Override
        public double call(double... args) {
            double d = Math.asin(args[0]);
            return isDeg ? Math.toDegrees(d) : d;
        }
    };
    public Function acos = new Function("acos", 1) {
        @Override
        public double call(double... args) {
            double d = Math.acos(args[0]);
            return isDeg ? Math.toDegrees(d) : d;
        }
    };
    public Function atan = new Function("atan", 1) {
        @Override
        public double call(double... args) {
            double d = Math.atan(args[0]);
            return isDeg ? Math.toDegrees(d) : d;
        }
    };
    public Function sinh = new Function("sinh", 1) {
        @Override
        public double call(double... args) {
            return Math.sinh(args[0]);
        }
    };
    public Function cosh = new Function("cosh", 1) {
        @Override
        public double call(double... args) {
            return Math.cosh(args[0]);
        }
    };
    public Function tanh = new Function("tanh", 1) {
        @Override
        public double call(double... args) {
            return Math.tanh(args[0]);
        }
    };
    public Function log = new Function("log", 1) {
        @Override
        public double call(double... args) {
            return Math.log10(args[0]);
        }
    };
    public Function ln = new Function("ln", 1) {
        @Override
        public double call(double... args) {
            return Math.log(args[0]);
        }
    };
    public Function sqrt = getPowerFun("sqrt", .5);
    public Function cbrt = getPowerFun("cbrt", Math.pow(3, -1));
    public Function sqr = getPowerFun("sqr", 2);
    public Function cub = getPowerFun("cub", 3);
    public Function pow = getPowerFun("pow", 0);

    public Functions(boolean isDeg) {
        this.isDeg = isDeg;
    }

    private Function getPowerFun(String name, double power) {
        boolean b = name.equals("pow");
        return new Function(name, b ? 2 : 1) {
            @Override
            public double call(double... args) {
                return Math.pow(args[0], b ? args[1] : power);
            }
        };
    }

    Function[] getAllFunctions() {
        return new Function[]{
                sin, cos, tan,
                asin, acos, atan,
                sinh, cosh, tanh,
                log, ln,
                sqrt, cbrt, sqr, cub, pow
        };
    }
}