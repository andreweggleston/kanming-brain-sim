package brain_simulator.video;

import brain_simulator.util.FontPicker;

import java.awt.*;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/**
 * Created by student on 12/19/17.
 */
public class Phrase {

    private brain_simulator.logic.Phrase phrase;

    private int x, y;

    private double scalex, scaley;

    private int life;

    public Phrase(brain_simulator.logic.Phrase p) {
        phrase = p;
        life = 0;

    }

    public void draw(Graphics2D g2, int x, int y) {
//        g2.setFont(FontPicker.getRandomFont());
        for (int i = 0; i < phrase.toString().length(); i++) {

            if (String.valueOf(phrase.toString().charAt(i)).equals(" ")) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
                if (phrase.getCharMapAt(i) == 2) {
                    g2.setColor(new Color(54, 172, 63)); //this is green
                    g2.fillRect(x + (i * 10), y-12, 8, 13);
                } else if (phrase.getCharMapAt(i) == 1) {
                    g2.setColor(new Color(172, 21, 25)); //this is red
                    g2.fillRect(x + (i * 10), y-12, 8, 15);
                }
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            } else if (phrase.getCharMapAt(i) == 2) {
                g2.setColor(new Color(54, 172, 63));
                g2.drawString(String.valueOf(phrase.toString().charAt(i)), x + (i * 10), y);
            } else if (phrase.getCharMapAt(i) == 1) {
                g2.setColor(new Color(172, 21, 25));
                g2.drawString(String.valueOf(phrase.toString().charAt(i)), x + (i * 10), y);
            } else {
                g2.setColor(new Color(0, 0, 0));
                g2.drawString(String.valueOf(phrase.toString().charAt(i)), x + (i * 10), y);
            }
        }
        g2.scale(scalex, scaley);
        life++;

    }

    public void setPhrase(brain_simulator.logic.Phrase phrase) {
        this.phrase = phrase;
    }

    public int getLife() {
        return life;
    }

    public void resetLife() {
        life = 0;
    }

    public boolean isComplete() {
        return phrase.isComplete();
    }

    @Override
    public String toString() {
        return phrase.toString();
    }
}
