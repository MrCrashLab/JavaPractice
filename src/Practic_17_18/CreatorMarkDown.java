package Practic_17_18;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class CreatorMarkDown {
    private final String mainPath;
    private final File file;
    private final File mdFile;
    private final HashMap<Integer, String> hashMap = new HashMap<>();
    private final ArrayList<Integer> keys = new ArrayList<>();
    private final Stack<File> files = new Stack<>();
    private final StringBuilder sb = new StringBuilder();
    private String nowPath = "default";

    public CreatorMarkDown(String basePath){
        this.mainPath = basePath + "/Practic_17_18";
        file = new File(basePath);
        mdFile = new File("G:/Java code/JavaPractice" + "/" + "README.md");
        createRootList();

        try {
            mdFile.createNewFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }

    }

    public void createMD() {
        files.add(file);
        for (Integer key : keys) {
            files.add(new File(file.getAbsolutePath() + "/" + hashMap.get(key)));
            while (files.size() > 1) {
                File currentFile = files.pop();
                if (currentFile.getAbsolutePath().endsWith(".java")) {
                    readWriteMD(currentFile);
                }

                if (!currentFile.isFile()) {
                    for (int j = 0; j < currentFile.list().length; j++) {
                        files.add(new File(currentFile.getAbsolutePath() + "/" + currentFile.list()[j]));
                    }
                }
            }
        }
    }

    private void readWriteMD(File currentFile) {
        try (PrintWriter writer = new PrintWriter(mdFile);
             BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
            if (!currentFile.getParentFile().getAbsolutePath().equals(nowPath)) {
                sb.append("#Практическая " + currentFile.getParentFile().getAbsolutePath().split("[_\\\\]")[5]);
                if (currentFile.getParentFile().getAbsolutePath().split("[_\\\\]").length > 6)
                    sb.append("-" + currentFile.getParentFile().getAbsolutePath().split("[_\\\\]")[6]);
                sb.append("\n");
                nowPath = currentFile.getParentFile().getAbsolutePath();
            }

            sb.append("###Класс " + currentFile.getName());
            sb.append("\n" + "````java" + "\n");
            String line = reader.readLine();
            while (line != null) {
                sb.append(line + "\n");
                line = reader.readLine();
            }
            sb.append("````\n");
            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void createRootList() {
        for (int i = 0; i < file.list().length; i++) {
            if (file.list()[i].split("_").length > 1) {
                hashMap.put(Integer.valueOf(file.list()[i].split("_")[1]), file.list()[i]);
                keys.add(Integer.valueOf(file.list()[i].split("_")[1]));
            }
        }
        Collections.sort(keys);
    }
}
