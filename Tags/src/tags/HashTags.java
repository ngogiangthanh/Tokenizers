
package tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HashTags {
    private ArrayList<String> listags;
    private ArrayList<String> lishashtags;
    private String content;

    public HashTags() {
    }

    public HashTags(String content) {
        this.lishashtags = new ArrayList<>();
        this.content = content;
    }
    

    public ArrayList<String> getLishashtags() {
        return lishashtags;
    }

    public void setLishashtags(ArrayList<String> lishashtags) {
        this.lishashtags = lishashtags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void init(){
        listags = Tags.getTokenize(this.content);
    }
    
    public void decrease(Topic topic){
        List<String> elements = topic.getWords();
 
        
        for(String tag: listags){
                for(String element: elements){
                    if(Tags.unAccent(element).equals(Tags.unAccent(tag))){
                      this.lishashtags.add(tag);
                    }
              }
          }
    }
    
    public void increase(Topic topic){
        List<String> elements = topic.getWords();
        if(this.lishashtags == null | this.lishashtags.size() <= 5){
            int size = this.lishashtags.size();
            System.out.println(size);
            System.out.println(topic.getWords().size());
            Random rand = new Random();
            while(size < 6){
                int index = rand.nextInt(topic.getWords().size());
                if(!this.lishashtags.contains(elements.get(index))){
                    this.lishashtags.add(elements.get(index));
                    size++;
                }
            }
        }
    }

    public ArrayList<String> getListags() {
        return listags;
    }

    public void setListags(ArrayList<String> listags) {
        this.listags = listags;
    }
    
}
