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

    public Game() {
        XMLHandler.setFile(new File("res" + File.separator + "phrases.xml"));
        updatePhrase();
    }

    public void updatePhrase() {
        Phrase temp = XMLHandler.pickRandomPhrase();
        if (temp == currentPhrase) updatePhrase();
        else currentPhrase = temp;
        currentIndex = 0;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public boolean testLetter(char c) {

        if ((int) c == 8) { //backspace
            if (currentIndex != 0) //dont go outside range here either
                currentIndex--; //undo the previous currentIndex++ so we're in the range of the phrase
            currentPhrase.setCharMap(currentIndex, 0);
            debug();
            return false;
        }


        if (currentPhrase.charAt(currentIndex) == c) {
            currentPhrase.setCharMap(currentIndex, 2); //correct
            currentIndex++;
            debug();
            return true;
        } else {
            currentPhrase.setCharMap(currentIndex, 1); //incorrect
            currentIndex++;
            debug();
        }
        return false;
    }

    public Phrase getCurrentPhrase() {
        return currentPhrase;
    }

    public void debug() {
        for (int i = 0; i < currentPhrase.toString().length(); i++) {
            System.out.print(currentPhrase.charAt(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < currentPhrase.toString().length(); i++) {
            System.out.print(currentPhrase.getCharMapAt(i) + " ");
        }
        System.out.println();

    }


}
