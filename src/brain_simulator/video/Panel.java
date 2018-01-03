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

    int phraseLife;
    int pointDrainer;

    int points;


    public Panel() {
        startTime = System.currentTimeMillis();

        game = new Game();

        currentPhrase = new Phrase(game.getCurrentPhrase());


        Timer timer = new Timer(1000 / 24, e -> {
            time = System.currentTimeMillis() - startTime;
            repaint();
        });

        timer.start();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                currentLetter = e;
                game.testLetter(e.getKeyChar());
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

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (pointDrainer % 25 == 0 && points > 10) {
            pointDrainer = 1;
            points--;
        }
        pointDrainer++;

        if (game.getCurrentPhrase().getCharMapAt(game.getCurrentPhrase().toString().length() - 1) == 2) {
            if (currentPhrase.isComplete()) {
                System.out.println("beaned");
                points = points + game.getCurrentPhrase().toString().length() * 2;
                game.updatePhrase();
                currentPhrase.resetLife();
            }
        }

        if (currentPhrase.getLife() > 168) {
            game.updatePhrase();
            currentPhrase.resetLife();
        }

        currentPhrase.setPhrase(game.getCurrentPhrase());

        g2.drawString(Integer.toString(points), 10, 10);


        currentPhrase.draw(g2, getWidth()/2 - currentPhrase.toString().length()*13/2, 350);

    }


}
