package Practic_25_26;

public class TestMain {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap();
        MyHashMap<Integer, String> myHashMap2 = new MyHashMap();
        myHashMap.add(1, "Hello");
        myHashMap.add(5, "World");
        myHashMap.add(5, "Who");
        myHashMap.add(129, "Goodbye");
        System.out.println("Get: " + myHashMap.get(1));
        System.out.println("Get: " + myHashMap.get(5));
        System.out.println("Get: " + myHashMap.get(129));
        System.out.println("Delete: " + myHashMap.remove(5));
        System.out.println("Get: " + myHashMap.get(5));

        System.out.println("///ForEach///");
        for (String map : myHashMap) {
            System.out.println(map);
        }

    }
}
