package com.Pranav.String;

/**
 * Created on 24-04-17 at 19:33
 *
 * @author Pranav
 * @version 1
 */
public class StringUtils {

    private final char[] chars;
    private final String s;

    public StringUtils(String s) {
        this.s = s;
        chars = s.toCharArray();
    }

    /**
     * get number of given character in a String
     *
     * @param s Source String in character is searched
     * @param c Character to count in given String s
     * @return number of given character c in given String s
     */
    public static int getCharCount(String s, char c) {
        int count = 0;
        char chars[] = s.toCharArray();
        for (char t : chars)
            if (t == c)
                count++;
        return count;
    }

    public String reverseString() {
        return reverseString(s);
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int l = s.length();
        for (int i = 0; i < l / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[l - i - 1];
            chars[l - i - 1] = temp;
        }
        return charArrayToString(chars);
    }

    private static String charArrayToString(char[] chars) {
        StringBuilder builder = new StringBuilder();
        for (char c : chars)
            builder.append(c);
        return builder.toString();
    }

    public int getIndexOfLastChar(char c) {
        return getIndexOfLastChar(c, s);
    }

    public static int getIndexOfLastChar(char c, String source) {
        return source.length() - getIndexOfFirstChar(c, reverseString(source)) - 1;
    }

    public int getIndexOfFirstChar(char c) {
        return getIndexOfFirstChar(c, s);
    }

    public static int getIndexOfFirstChar(char c, String source) {
        int i = 0;
        for (char c1 : source.toCharArray()) {
            if (c1 == c) break;
            i++;
        }
        return i;
    }

    public String getS() {
        return s;
    }

    public String getTrimString(int start, int end) {
        return getTrimString(start, end, chars);
    }

    public static String getTrimString(int start, int end, char[] chars) {
        StringBuilder temp = new StringBuilder();
        for (int i = start; i <= end; i++) temp.append(chars[i]);
        return temp.toString();
    }

    public int getParaStartL() {
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == ')')
                break;
            else if (chars[j] == '(')
                i = j;
        }
        return i;
    }

    public Integer sGetIndexOfFirstChar(String key) {
        return sGetIndexOfFirstChar(s, key);
    }
    
    public static Integer sGetIndexOfFirstChar(String source, String s) {
        char[] key = s.toCharArray(), chars = source.toCharArray();
        int j, i, k;
        for (i = 0; i < chars.length; i++) {
            if (chars[i] == key[0]) {
                for (j = i, k = 0; k < key.length; j++, k++) if (chars[j] != key[k]) break;
                if (k == key.length)
                    return i;
            }
        }
        return null;
    }

    public String insertAfterIndex(String s, int index) {
        return insertAfterIndex(this.s, s, index);
    }

    public static String insertAfterIndex(String source, String s, int index) {
        int l = source.length() + s.length(), src = 0, key = 0;
        char[] chars = new char[l];
        for (int i = 0; i < l; i++)
            chars[i] = i >= index && i < index + s.length()
                    ? s.toCharArray()[src++] : source.toCharArray()[key++];
        return charsToString(chars);
    }

    private static String charsToString(char[] chars) {
        StringBuilder builder = new StringBuilder();
        for (char c : chars)
            builder.append(c);
        return builder.toString();
    }

    public int getParaEndL(int start) {
        int count = 0;
        int i;
        for (i = start; i < s.length(); i++) {
            if (chars[i] == '(') count++;
            if (chars[i] == ')')
                if (count == 0) return i;
                else count--;
        }
        return i;
    }
}
