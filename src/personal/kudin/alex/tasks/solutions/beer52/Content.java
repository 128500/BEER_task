package personal.kudin.alex.tasks.solutions.beer52;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the content of beer pack
 */
public class Content {

    private List<BeerInfo> content;

    Content(){
        this.content = new ArrayList<>();
    }

    /*Getters and setters*/
    public List<BeerInfo> getContent() {
        return content;
    }

    public void setContent(List<BeerInfo> content) {
        this.content = content;
    }
}
