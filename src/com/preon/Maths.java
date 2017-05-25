package com.preon;

import com.Pranav.Phasor.Evaluator;
import com.Pranav.Phasor.Operator;
import com.Pranav.Phasor.Variable;

import javax.swing.*;
import java.awt.*;

/**
 * tests
 *
 * @author Pranav
 */
public class Maths {

    private static TextComponent area = new TextArea();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Evaluator evaluator = new Evaluator("sin(30)^2+cos(30)^2");
        System.out.println(evaluator.eval());
    }


    public static void out(Object o){
        System.out.println(o);
    }

    private static void printD(String s) {
        JFrame jFrame = new JFrame("Dialog");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        area.setText(s);
        jFrame.getContentPane().add(area, BorderLayout.CENTER);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}
