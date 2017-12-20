package brain_simulator.logic;

import brain_simulator.util.XMLHandler;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by student on 12/19/17.
 */
public class Game {
    private Phrase currentPhrase;
    private int phrasesCompleted;

    private int currentIndex;

    private ArrayList<Phrase> phrases;

    public Game(){
        XMLHandler.setFile(new File("res" + File.separator + "phrases.xml"));
        updatePhrase();
    }

    public void updatePhrase(){
        Phrase temp = XMLHandler.pickRandomPhrase();
        if (temp == currentPhrase) updatePhrase();
        else currentPhrase = temp;
    }

    public boolean testLetter(char c){
        if(currentPhrase.charAt(currentIndex)==c){
            currentPhrase.setCharMap(currentIndex, true);
            return true;
        } else {
            currentPhrase.setCharMap(currentIndex, false);
        }
        return false;
    }

    public Phrase getCurrentPhrase(){
        return currentPhrase;
    }


}
