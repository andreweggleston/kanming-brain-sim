package brain_simulator.util;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by student on 12/19/17.
 */
public class FontPicker {
    private static ArrayList<Font> fonts;

    public FontPicker(){

    }

    public static Font getRandomFont(){
        return fonts.get((int)(Math.random()*fonts.size()));
    }
}
