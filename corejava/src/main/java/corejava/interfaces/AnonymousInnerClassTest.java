package corejava.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This program demonstrates anonymous inner classes.
 *
 * @author Cay Horstmann
 * @version 1.10 2004-02-27
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

    /**
     * A clock that prints the time in regular intervals.
     */
    static  class TalkingClock {
        /**
         * Starts the clock.
         *
         * @param interval the interval between messages (in milliseconds)
         * @param beep     true if the clock should beep
         */
        public void start(int interval, final boolean beep) {
            ActionListener listener = event -> {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep)
                    Toolkit.getDefaultToolkit().beep();
            };
            Timer t = new Timer(interval, listener);
            t.start();
        }
    }
}


