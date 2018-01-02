package brain_simulator;

import brain_simulator.video.Panel;

import javax.swing.*;

/**
 * Created by student on 12/19/17.
 */
public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame("Kanming's Brain Simulator");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 800, 800);
        Panel panel = new Panel();
        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);

    }
}
