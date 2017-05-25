package com.Pranav.Math;

import java.text.DecimalFormat;

/**
 * Created on 21-04-17 at 09:13 PM
 *
 * @author Pranav Raut
 * @version 1
 */
class DfString {

    private DecimalFormat df;
    private String s;

    DecimalFormat getDf() {
        return df;
    }

    DfString setDf(DecimalFormat df) {
        this.df = df;
        return this;
    }

    String getS() {
        return s;
    }

    DfString setS(String s) {
        this.s = s;
        return this;
    }

}
