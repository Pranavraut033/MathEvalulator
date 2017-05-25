package com.Pranav.Phasor;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.Pranav.Phasor.Constants.RO;

/**
 * Created on 25-04-17 at 13:02
 *
 * @author Pranav
 * @version 1
 */

public class Result {
    private final boolean isValidNumber;
    @Nullable
    private final Double dResult;
    private final String sResult;
    private boolean b = true;

    public Result(@NotNull String sResult) {
        this.sResult = sResult;
        boolean b;
        Double d;
        try {
            d = Double.parseDouble(sResult);
            b = Double.isFinite(d);
        } catch (Exception ignored) {
            d = null;
            b = false;
        }
        dResult = d;
        isValidNumber = b;
    }

    public Result(double dResult) {
        isValidNumber = Double.isFinite(dResult);
        this.dResult = isValidNumber ? RO.apply(dResult) : dResult;
        sResult = String.valueOf(dResult);
    }

    @Nullable
    public Double getDResult() {
        if (b)
            new Exception("isValidResult() be calle is order ro check the validity").printStackTrace();
        return dResult;
    }

    public String getSResult() {
        return sResult;
    }

    public boolean isValidNumber() {
        b = false;
        return isValidNumber;
    }
}
