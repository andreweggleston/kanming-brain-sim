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

    public void draw(Graphics2D g2) {
//        g2.setFont(FontPicker.getRandomFont());
        g2.drawString(phrase.toString(), 350, 350);
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
}
