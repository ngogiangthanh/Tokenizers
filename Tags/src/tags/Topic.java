
package tags;

import java.util.ArrayList;
import java.util.List;


public class Topic {
    private String name;
    private List<String> words;

    public Topic() {
    }

    public Topic(String name) {
        this.name = name;
        this.words = new ArrayList();
    }

    public Topic(String name, List words) {
        this.name = name;
        this.words = words;
    }

    public String getName() {
        return name;
    }

    public List getWords() {
        return words;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWords(List words) {
        this.words = words;
    }
    
    public void setWords(String[] words) {
        int length = words.length;
        for(int i = 0; i < length; i++){
        this.words.add(words[i]);
        }
    }
    
    public void addWord(String word)
    {
        this.words.add(word);
    }
}
