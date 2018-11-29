package personal.kudin.alex.tasks.solutions.beer52;


/**
 * This class represents a node of the graph,
 * as the task of finding the optimum for
 * bottles spreading (between the beer packs) has many outcomes
 */
class PackNode {

    PackNode(){}
    PackNode(Integer leftBottles){
        this.leftBottles = leftBottles;
    }

    PackNode(Integer cells, Integer leftBottles, PackNode parent){
        this.cells = cells;
        this.leftBottles = leftBottles;
        this.parent = parent;
    }

    /*Quantity of cells for current pack*/
    private int cells;

    /*Quantity of bottles left to get packed*/
    private int leftBottles;

    /* Reference to the parent node */
    private PackNode parent;


    /* Getters and setters*/
    int getCells() {
        return cells;
    }

    int getLeftBottles() {
        return leftBottles;
    }

    PackNode getParent() {
        return parent;
    }
}
