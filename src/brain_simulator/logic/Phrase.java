package brain_simulator.logic;

/**
 * Created by student on 12/19/17.
 */
public class Phrase {

    private boolean isComplete;
    private int length;
    private String phrase;
    private boolean[] charMap;

    public Phrase(String phrase){
        this.phrase = phrase;
        charMap = new boolean[phrase.length()];
    }

    public char charAt(int index){
        return phrase.charAt(index);
    }

    public void setCharMap(int index, boolean val){
        charMap[index] = val;
    }

    @Override
    public String toString() {
        return phrase;
    }
}
