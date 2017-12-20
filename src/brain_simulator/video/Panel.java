package brain_simulator.video;

import brain_simulator.logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by student on 12/19/17.
 */
public class Panel extends JPanel {

    ArrayList<String> phraseList;
    private int level;
    private Game game;

    private Phrase currentPhrase;

    private KeyEvent currentLetter;

    private long time;
    private long startTime;



    public Panel() {
        startTime = System.currentTimeMillis();

        game = new Game();

        currentPhrase = new Phrase(game.getCurrentPhrase());

        Timer timer = new Timer(1000 / 24, e -> {
            time = System.currentTimeMillis()-startTime;
            repaint();
        });

        timer.start();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (level == 1){
                    currentLetter = e;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);


        if (currentPhrase.getLife() > 120){
            game.updatePhrase();
            currentPhrase.resetLife();
        }

        currentPhrase.setPhrase(game.getCurrentPhrase());


        currentPhrase.draw(g2);



        //run logic

//        repaint();
    }


}
