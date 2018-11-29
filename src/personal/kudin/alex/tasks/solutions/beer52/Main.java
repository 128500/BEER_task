package personal.kudin.alex.tasks.solutions.beer52;


import java.util.*;

/**
 * This class here is for testing purposes
 */
public class Main {

    public static void main(String[] args) {

        /**for(int  i = 6; i < 51; i++){
            BFSAlgorithm al = new BFSAlgorithm();
            System.out.println("i = " + i + " " + al.findQuantityOfBeerPacks(i).toString());
        }*/

        BeerInfo one = new BeerInfo("one", 0.5, 13);
        BeerInfo two = new BeerInfo("two", 1, 10);
        BeerInfo three = new BeerInfo("three", 0.5, 12);
        BeerInfo four = new BeerInfo("four", 1, 1);
        Map<String, BeerInfo> map1 = new HashMap<>();
        map1.put("one", one);
        Map<String, BeerInfo> map2 = new HashMap<>();
        map2.put("two", two);
        Map<String, BeerInfo> map3 = new HashMap<>();
        map3.put("three", three);
        Map<String, BeerInfo> map4 = new HashMap<>();
        map4.put("four", four);

        List<Map<String, BeerInfo>> order = new ArrayList<>();
        order.add(map1);
        order.add(map2);
        order.add(map3);
        order.add(map4);


        //order.sort(Comparator.comparingDouble(o -> o.entrySet().iterator().next().getValue().getVolume()));
        //Collections.reverse(order);

        //System.out.println(order);

        BFSAlgorithm al = new BFSAlgorithm();
        List<Map<String, Content>> list = al.divideOrder(order);

        for(Map<String, Content> map : list){
            Map.Entry<String, Content> entry = map.entrySet().iterator().next();

            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }

    }
}


/**  The output for the first fifty numbers(quantity of bottles)
 i = 6 [6]
 i = 7 [8]
 i = 8 [8]
 i = 9 [10]
 i = 10 [10]
 i = 11 [12]
 i = 12 [12]
 i = 13 [8, 6]
 i = 14 [8, 6]
 i = 15 [16]
 i = 16 [16]
 i = 17 [12, 6]
 i = 18 [12, 6]
 i = 19 [12, 8]
 i = 20 [12, 8]
 i = 21 [16, 6]
 i = 22 [16, 6]
 i = 23 [16, 8]
 i = 24 [16, 8]
 i = 25 [25]
 i = 26 [16, 10]
 i = 27 [16, 12]
 i = 28 [16, 12]
 i = 29 [16, 8, 6]
 i = 30 [16, 8, 6]
 i = 31 [25, 6]
 i = 32 [16, 16]
 i = 33 [25, 8]
 i = 34 [16, 12, 6]
 i = 35 [25, 10]
 i = 36 [16, 12, 8]
 i = 37 [25, 12]
 i = 38 [16, 16, 6]
 i = 39 [25, 8, 6]
 i = 40 [16, 16, 8]
 i = 41 [25, 16]
 i = 42 [16, 16, 10]
 i = 43 [25, 12, 6]
 i = 44 [16, 16, 12]
 i = 45 [25, 12, 8]
 i = 46 [16, 16, 8, 6]
 i = 47 [25, 16, 6]
 i = 48 [16, 16, 16]
 i = 49 [25, 16, 8]
 i = 50 [25, 25]
 */