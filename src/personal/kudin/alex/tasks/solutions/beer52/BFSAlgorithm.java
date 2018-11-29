package personal.kudin.alex.tasks.solutions.beer52;

import java.util.*;

/**
 * This class represents the algorithm of
 * finding the optimum for
 * bottles spreading (between the beer packs),
 * based on Breadth First Search or BFS for a Graph
 */
public class BFSAlgorithm {

    /*Available packs for beer*/
    private final static int[] PACKS = {25, 16, 12, 10, 8, 6};

    /*A queue for unchecked nodes of the graph*/
    private Queue<PackNode> queue = new ArrayDeque<>();

    /*A list for storing nodes that have no empty cells in the pack (best result)*/
    private List<PackNode> bestZeroCellsLeft = new ArrayList<>();

    /*A list for storing nodes that have one empty cell in the pack (almost best result)*/
    private List<PackNode> bestOneCellLeft = new ArrayList<>();

    /**
     * Divides the given list(order) between the packs.
     * Operates with others methods to obtain the result
     * @param order oa order to process
     * @return list of divided bottles of beer between the packs
     */
    public List<Map<String, Content>> divideOrder(List<Map<String, BeerInfo>> order) {

        double sum = 0;
        /*Find the overall sum of space taking by bottles in the order (assuming that we can put 2 of 0.5 bottles in one cell)*/
        for (Map<String, BeerInfo> elem : order) {
            sum += elem.entrySet().stream().mapToDouble(entry -> entry.getValue().getQuantity() * entry.getValue().getVolume()).sum();
        }

        int cellsSum = (int)Math.ceil(sum);

        /*Gets the best result(there may be more than one)*/
        List<Integer> result = this.findQuantityOfBeerPacks(cellsSum);

        try{
            return this.packBoxes(result, order);
        } catch(Exception e){
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Finds the optimum quantity of packs
     * @param cellsSum overall sum of all bottles in order
     * @return list of packs of available sizes (@see PACKS)
     */
    List<Integer> findQuantityOfBeerPacks(int cellsSum){

        /*If there are less than 7 bottles, return the only suitable pack of 6 cells size*/
        if(cellsSum <= 6) {
            Integer[] result = {6};
            return Arrays.asList(result);
        }

        PackNode current = new PackNode(cellsSum);

        /*Create children nodes for building the graph*/
        do{
            this.createChildNodes(current);
            current = queue.poll();
        } while (!queue.isEmpty());

        /*Pick the best result*/
        if(bestZeroCellsLeft.size() != 0) return this.filterBestResults(bestZeroCellsLeft);
        else if(bestOneCellLeft.size() != 0) return this.filterBestResults(bestOneCellLeft);
        else return Collections.EMPTY_LIST;
    }


    /**
     * Creates child nodes and simultaneously puts
     * them into the queue or into lists of best results
     * @param parent a node from witch we must create new nodes
     */
    private void createChildNodes(PackNode parent){
        int leftBottles = parent.getLeftBottles();
        for(int cells : PACKS){
            int left = leftBottles - cells;
            if (left == 0) {
                bestZeroCellsLeft.add(new PackNode(cells, left, parent));
            }

            if (left == -1) {
                bestOneCellLeft.add(new PackNode(cells, left, parent));
            }

            if(left > 0){
                queue.add(new PackNode(cells, left, parent));
            }
        }
    }

    /**
     * Filters the results. Before that creates
     * lists of results based on a child - parent tree of nodes
     * @param results list of found results
     * @return list of packs of available sizes (@see PACKS)
     */
    private List<Integer> filterBestResults(List<PackNode> results){
        List<ArrayList<Integer>> bests = new ArrayList<>();
        for(PackNode node : results){
            ArrayList<Integer> result = new ArrayList<>();
            PackNode next = node;

            do{
                result.add(next.getCells());
                next = next.getParent();
            } while(next.getCells() != 0);

            result.sort(Collections.reverseOrder());
            bests.add(result);
        }
        bests.sort(Comparator.comparingInt(List::size));
        return bests.get(0);
    }


    /**
     * THIS IS A MESS. THIS METHOD MUST BE REFACTORED (MAYBE MORE THAN ONE TIME)!!!
     * 'Packs' the order into picked beer packs (boxes)
     * @param packs list of picked packs
     * @param order order to be packed
     * @return list of packs with beer bottles in it
     * @throws Exception if there is a lack of cells in picked packs and the beer order cannot be
     *  placed in them. OMG that's a fail.
     */
    List<Map<String, Content>> packBoxes(List<Integer> packs, List<Map<String, BeerInfo>> order) throws Exception{

        /*Sorts the list of order so that the bottles of 0.5 volume will be at the end of the list*/
        order.sort(Comparator.comparingDouble(o -> o.entrySet().iterator().next().getValue().getVolume()));
        Collections.reverse(order);

        List<Map<String, Content>> result = new ArrayList<>();
        Iterator packsIterator = packs.iterator();
        int cells = (int)packsIterator.next();

        double currentPackCells = (double) cells;

        List<BeerInfo> beerChain = createBeerCain(order);

        Content currentContent = new Content();
        Map<String, Content> map = null;
        int counter = 0;
        for(BeerInfo info : beerChain){
            currentPackCells -= info.getVolume();
            counter++;

            if(currentPackCells == 0 || counter == beerChain.size()){
                currentContent.addBottleOfBeer(info);

                map = new HashMap<>();
                map.put("boxPack_" + cells, currentContent);
                result.add(map);

                if(counter != beerChain.size()){
                    currentContent = new Content();
                    if (packsIterator.hasNext())cells = (int) packsIterator.next();
                    currentPackCells = (double) cells;
                }
            }

            else if(currentPackCells > 0){
                currentContent.addBottleOfBeer(info);
            }

            else throw new Exception("The volume of a bottle is more than left in the current pack");
        }

        return result;

    }

    private List<BeerInfo> createBeerCain(List<Map<String, BeerInfo>> order){
        List<BeerInfo> chain = new ArrayList<>();

        for(Map<String, BeerInfo> m : order){
            BeerInfo info = m.entrySet().iterator().next().getValue();

            int quantity = info.getQuantity();
            String name = info.getName();
            double volume = info.getVolume();

            for(int i = 0; i < quantity; i++){
                chain.add(new BeerInfo(name, volume, 1));
            }
        }
        return chain;
    }


    /**
     * Initiates the list of packs according to picked ones,
     * preparing them for filling with bottles
     * @param packs list of picked bottles
     * @return list of prepared packs
     */
    List<Map<String, Content>> initiateListOfPacks(List<Integer> packs){
        List<Map<String, Content>> result = new ArrayList<>();
        for(int cells : packs){
            String packName = "BoxPack_" + cells;
            Map<String, Content> map = new HashMap<>();
            map.put(packName, new Content());
            result.add(map);
        }
        return result;
    }

}
