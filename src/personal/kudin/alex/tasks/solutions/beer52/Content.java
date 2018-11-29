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

    void addBottleOfBeer(BeerInfo info){
        String name = info.getName();
        for(BeerInfo beerInfo : content){
            if (beerInfo.getName().equals(name)) {
                beerInfo.setQuantity(beerInfo.getQuantity() + 1);
                return;
            }
        }
        content.add(info);
    }

    /*Getters and setters*/
    public List<BeerInfo> getContent() {
        return content;
    }

    public void setContent(List<BeerInfo> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(BeerInfo info : content){
            builder.append(info.toString()).append("\n");
        }

        return builder.toString();
    }
}
