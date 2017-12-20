package brain_simulator.util;

import brain_simulator.logic.Phrase;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by student on 12/19/17.
 */
public class XMLHandler {
    // TODO: 12/19/17 write this lmao


    private static File xml;

    public static void setFile(File xmlFile){
        xml = xmlFile;
    }

    public static ArrayList<Phrase> interpret(){

        ArrayList<Phrase> phrases = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(xml);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            br.readLine();
            String line = br.readLine();
            while (!line.contains("phrases")){
                phrases.add(new Phrase(line.trim().substring(8, line.length()-13)));
                line = br.readLine();
            }
            br.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return phrases;
    }

    public static Phrase pickRandomPhrase(){
        return interpret().get((int)(Math.random()*interpret().size()));
    }
}
