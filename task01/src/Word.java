package task01.src;

public class Word implements Comparable<Word> {

    public String word;
    public Integer frequency;

    public Word(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Word word) {
        return this.frequency - word.frequency;
    }
}
