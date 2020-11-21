package Practic_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LocalJsonItemsStore implements ItemsStore {
    private Gson gson = new Gson();
    private String path = "src/main/java/Practic_21_22";
    private File file = new File(path + "/data.json");

    public LocalJsonItemsStore() {
        try (PrintWriter writer = new PrintWriter(file)) {
            file.createNewFile();
            writer.write("[\n]");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Override
    public List<Item> getAllItem() {
        ArrayList<Item> itemList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String line;
        Type collectionType = new TypeToken<Collection<Item>>() {
        }.getType();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            line = reader.readLine();
            while (line != null) {
                sb.append(line + "\n");
                line = reader.readLine();
            }
            itemList = gson.fromJson(sb.toString(), collectionType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item getItem(int id) {
        List<Item> itemList;
        itemList = getAllItem();
        for (Item tmp : itemList) {
            if (tmp.getId() == id) {
                return tmp;
            }
        }
        return null;
    }

    @Override
    public boolean addItem(Item item) {
        StringBuilder sb = new StringBuilder();
        String line;
        if (!checkId(item.getId())) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                line = reader.readLine();
                while (!line.equals("]") && line != null) {
                    sb.append(line);
                    if (line.endsWith("}"))
                        sb.append(",");
                    sb.append("\n");
                    line = reader.readLine();

                }
                sb.append(gson.toJson(item));
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.write(sb.toString() + "\n]");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean editItem(int id, Item item) {
        if(checkId(id)&&item.getId()==id){
            deleteItem(id);
            addItem(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        StringBuilder sb = new StringBuilder();
        int index = getAllItem().size();
        int count = 0;
        String line;
        Item item;
        if (checkId(id)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                line = reader.readLine();
                sb.append("[\n");
                while (line != null) {
                    if (isJSONValid(line) || line.endsWith("},")) {
                        item = gson.fromJson(line.substring(line.indexOf("{"), line.indexOf("}") + 1), Item.class);
                        if (item.getId() != id) {
                            sb.append(line.substring(line.indexOf("{"), line.indexOf("}") + 1));
                            if(count<index-2){
                                sb.append(",");
                            }
                            sb.append("\n");
                            count++;
                        }
                    }
                    line = reader.readLine();
                }
                sb.append("]");
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.write(sb.toString());
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
            return true;
        }
        return false;
    }

    private boolean checkId(int id) {
        if (getItem(id) != null) {
            return true;
        }
        return false;
    }

    public boolean isJSONValid(String jsonInString) {
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }
}
