package com.Pranav.Phasor;

import java.nio.charset.IllegalCharsetNameException;

import static com.Pranav.String.StringUtils.getCharCount;

/**
 * Created on 22-04-17 at 14:41
 *
 * @author Pranav
 * @version 1
 */

class ValidityHelper {
    private static String allowedCharacters = "@#$%&_/<>=\\{\\}?';`|\\[\\]";
    private static String primitiveCharacters = "+~*/^!-";
    static final String ALL_CHARS = allowedCharacters + primitiveCharacters;

    /**
     * check weather a name is valid  i.e it only contain alphabets
     *
     * @param name Name to check
     * @param tag  Tag(function, variable...) to use in exception after Invalid.
     * @return Variable name is valid of not (only alphabets allowedCharacters).
     * @throws IllegalCharsetNameException when name is not valid.
     */
    static boolean checkValidity(String name, String tag) {
        if (name.isEmpty())
            throw new IllegalCharsetNameException("Parameter String name is empty");
        if (!(name.matches("[a-zA-z]*$")))
            throw new IllegalCharsetNameException("Invalid" + tag + "\nCannot use: '" + name + "' as a name");
        return true;
    }

    /**
     * check weather a operator character is valid  i.e it only {@link #allowedCharacters}
     *
     * @param operatorChar Character for a operator
     * @throws IllegalCharsetNameException when @param operatorChar is not valid.
     */
    static char checkValidity(char operatorChar) {
        String s = String.valueOf(operatorChar);
        if (s.matches(".*[" + primitiveCharacters + "].*$"))
            throw new IllegalCharsetNameException("Invalid Operator character " + (operatorChar) + " is Reserved for internal use");
        if (!s.matches("[" + allowedCharacters + "]*$"))
            throw new IllegalCharsetNameException("Invalid Operator character" + "\nCannot use '" + operatorChar + "' as a operator");
        return operatorChar;
    }

    /**
     * check weather a operator character is valid  i.e it only {@link #allowedCharacters}
     *
     * @param expression Mathematical expression (4 + 5 * (67-55))
     * @throws IllegalCharsetNameException when @param operatorChar is not valid.
     */
    static boolean checkValidity(String expression) throws Exception {
        if (expression.isEmpty())
            throwExp("Expression is empty");
        String t = primitiveCharacters.replace("-", "");
        boolean b = expression.matches(".*[" + t + "]{2}.*$");
        if (expression.matches(".*[-]{3}.*$")) throwExp("Expression contain multiple '-' operator");
        int start = getCharCount(expression, '('), end = getCharCount(expression, ')');
        if (expression.matches(".*[0-9~][(].*$") || expression.matches(".*[)][0-9~].*$"))
            throwExp("Missing operator after or before Parenthesis \n" + expression);
        if (b) throwExp("Expression have duplicate (Eg. //, ++...) " +
                "or repeated (Eg. /+, -/...) Operator");
        if (start != end) throwExp("Misplaced or Missing Parenthesis found in the String");
        return true;
    }

    private static void throwExp(String s) throws Exception {
        throw new Exception(s);
    }

    public static String getPrimitiveCharacters() {
        return primitiveCharacters;
    }

    public static String getAllowedCharacters() {
        return allowedCharacters;
    }
}
