package org.walnuts.study.corejava.v1ch02;

/**
 * This program displays a greeting from the authors.
 *
 * @author Cay Horstmann
 * @version 1.20 2004-02-28
 */
public class R1Welcome {
    public static void main(String[] args) {

        String[] greeting = new String[3];

        greeting[0] = "e1 to Core Java";
        greeting[1] = "by Cay Horstmann";
        greeting[2] = "and Gary Cornell";

        for (String g : greeting)
            System.out.println(g);
    }
}