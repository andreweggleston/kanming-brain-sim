package brain_simulator.logic;

/**
 * Created by student on 12/19/17.
 */
public class Phrase {

    private boolean isComplete;
    private int length;
    private String phrase;
    private int[] charMap;

    public Phrase(String phrase) {
        this.phrase = phrase;
        charMap = new int[phrase.length()];
    }

    public char charAt(int index) {
        return phrase.charAt(index);
    }

    public void setCharMap(int index, int val) {
        charMap[index] = val;
    }

    public int getCharMapAt(int index) {
        return charMap[index];
    }

    public boolean isComplete() {
        for (int i : charMap) {
            if (i != 2) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return phrase;
    }
}
