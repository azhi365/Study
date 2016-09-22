package v2ch10.buttons2;

import javax.swing.*;

/**
 * @author Cay Horstmann
 * @version 1.00 2007-11-02
 */
public abstract class ButtonFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    protected JPanel panel;
    protected JButton yellowButton;
    protected JButton blueButton;
    protected JButton redButton;

    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        panel = new JPanel();
        add(panel);

        yellowButton = new JButton("Yellow");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        panel.add(yellowButton);
        panel.add(blueButton);
        panel.add(redButton);

        addEventHandlers();
    }

    protected abstract void addEventHandlers();
}
