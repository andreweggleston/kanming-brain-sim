package brain_simulator.video;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by student on 12/19/17.
 */
public class Panel extends JPanel {

    ArrayList<String> phraseList;

    public Panel(){


    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        super.paint(g2);

        //run logic

        repaint();
    }



}
