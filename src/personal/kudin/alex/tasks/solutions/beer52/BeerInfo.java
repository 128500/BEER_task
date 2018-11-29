package personal.kudin.alex.tasks.solutions.beer52;

/**
 * This class represents a short info
 * about beer
 */
public class BeerInfo {

    BeerInfo(){}

    BeerInfo(String name, double volume, int quantity){
        this.name = name;
        this.volume = volume;
        this.quantity = quantity;
    }

    /*Beer name (name of brand)*/
    private String name;

    /*Volume of a bottle*/
    private double volume;

    /*Quantity of bottles in an order*/
    private int quantity;


    /* Getters */
    String getName() {
        return name;
    }

    double getVolume() {
        return volume;
    }

    int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BeerInfo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", volume=").append(volume);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
