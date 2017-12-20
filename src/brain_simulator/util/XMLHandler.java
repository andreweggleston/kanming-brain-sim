package brain_simulator.util;

import brain_simulator.logic.Phrase;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by student on 12/19/17.
 */
public class XMLHandler {
    // TODO: 12/19/17 write this lmao


    private static File xml;

    public static File setFile(File xmlFile){
        xml = xmlFile;
    }

    public static ArrayList<Phrase> interpret(){


        return
    }

    public static Phrase pickRandomPhrase(){
        return interpret().get((int)(Math.random()*interpret().size()));
    }
}
