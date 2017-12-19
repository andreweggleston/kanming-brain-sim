package brain_simulator.video;

import brain_simulator.util.FontPicker;

import java.awt.*;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/**
 * Created by student on 12/19/17.
 */
public class Phrase {

    private String phrase;

    private int x, y;

    private double scalex, scaley;

    public Phrase(String p){
        phrase = p;
    }

    public void draw(Graphics2D g2){
        g2.setFont(FontPicker.getRandomFont());
        g2.drawString(phrase, x, y);
        g2.scale(scalex, scaley);
    }

}
