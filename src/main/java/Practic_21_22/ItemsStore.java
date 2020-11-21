package Practic_21_22;

import java.util.List;

public interface ItemsStore {
    List<Item> getAllItem();
    Item getItem(int id);
    boolean addItem(Item item);
    boolean editItem(int id, Item item);
    boolean deleteItem(int id);
}
