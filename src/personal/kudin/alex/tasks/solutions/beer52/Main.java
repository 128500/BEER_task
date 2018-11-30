package personal.kudin.alex.tasks.solutions.beer52;


import java.util.*;

/**
 * This class here is for testing purposes
 */
public class Main {

    public static void main(String[] args) {

        BeerInfo one = new BeerInfo("one", 0.5, 13);
        BeerInfo two = new BeerInfo("two", 1, 10);
        BeerInfo three = new BeerInfo("three", 0.5, 12);
        BeerInfo four = new BeerInfo("four", 1, 1);
        BeerInfo five = new BeerInfo("five", 0.5, 32);
        BeerInfo six = new BeerInfo("six", 1, 20);
        Map<String, BeerInfo> map1 = new HashMap<>();
        map1.put("one", one);
        Map<String, BeerInfo> map2 = new HashMap<>();
        map2.put("two", two);
        Map<String, BeerInfo> map3 = new HashMap<>();
        map3.put("three", three);
        Map<String, BeerInfo> map4 = new HashMap<>();
        map4.put("four", four);
        Map<String, BeerInfo> map5 = new HashMap<>();
        map5.put("five", five);
        Map<String, BeerInfo> map6 = new HashMap<>();
        map6.put("six", six);

        List<Map<String, BeerInfo>> order = new ArrayList<>();
        order.add(map1);
        order.add(map2);
        order.add(map3);
        order.add(map4);
        order.add(map5);
        order.add(map6);


        BFSAlgorithm al = new BFSAlgorithm();
        List<Map<String, Content>> list = al.divideOrder(order);

        for(Map<String, Content> map : list){
            Map.Entry<String, Content> entry = map.entrySet().iterator().next();

            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }

        /*for(int  cells = 6; i < 51; i++){
            BFSAlgorithm al = new BFSAlgorithm();
            System.out.println("cells = " + i + " " + al.findQuantityOfBeerPacks(i).toString());
        }*/

    }
}
/* The output of this little test is:
boxPack_25 : BeerInfo{name='six', volume=1.0, quantity=20}
             BeerInfo{name='four', volume=1.0, quantity=1}
             BeerInfo{name='two', volume=1.0, quantity=4}

boxPack_25 : BeerInfo{name='two', volume=1.0, quantity=6}
             BeerInfo{name='five', volume=0.5, quantity=32}
             BeerInfo{name='three', volume=0.5, quantity=6}

boxPack_10 : BeerInfo{name='three', volume=0.5, quantity=6}
             BeerInfo{name='one', volume=0.5, quantity=13}*/


/*  The output for the first fifty numbers(quantity of occupied cells in pack(s))
    testing the 'findQuantityOfBeerPacks' method in BFSAlgorithm
 cells = 6 [6]
 cells = 7 [8]
 cells = 8 [8]
 cells = 9 [10]
 cells = 10 [10]
 cells = 11 [12]
 cells = 12 [12]
 cells = 13 [8, 6]
 cells = 14 [8, 6]
 cells = 15 [16]
 cells = 16 [16]
 cells = 17 [12, 6]
 cells = 18 [12, 6]
 cells = 19 [12, 8]
 cells = 20 [12, 8]
 cells = 21 [16, 6]
 cells = 22 [16, 6]
 cells = 23 [16, 8]
 cells = 24 [16, 8]
 cells = 25 [25]
 cells = 26 [16, 10]
 cells = 27 [16, 12]
 cells = 28 [16, 12]
 cells = 29 [16, 8, 6]
 cells = 30 [16, 8, 6]
 cells = 31 [25, 6]
 cells = 32 [16, 16]
 cells = 33 [25, 8]
 cells = 34 [16, 12, 6]
 cells = 35 [25, 10]
 cells = 36 [16, 12, 8]
 cells = 37 [25, 12]
 cells = 38 [16, 16, 6]
 cells = 39 [25, 8, 6]
 cells = 40 [16, 16, 8]
 cells = 41 [25, 16]
 cells = 42 [16, 16, 10]
 cells = 43 [25, 12, 6]
 cells = 44 [16, 16, 12]
 cells = 45 [25, 12, 8]
 cells = 46 [16, 16, 8, 6]
 cells = 47 [25, 16, 6]
 cells = 48 [16, 16, 16]
 cells = 49 [25, 16, 8]
 cells = 50 [25, 25]
 */