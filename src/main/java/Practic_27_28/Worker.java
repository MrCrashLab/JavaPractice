package Practic_27_28;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Worker {
    @ConsoleOperation
    public void sum(Data data){
        ArrayList<Integer> num = data.getNumbers();
        int sum = num.stream().flatMapToInt(IntStream::of).sum();
        System.out.println(sum);
    }

    @ConsoleOperation
    public void print(Data data){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = data.getWords();
        String delitemetr = data.getDelimeter();
        for(String str:list){
            sb.append(str);
            if(!str.equals(list.get(list.size()-1))){
                sb.append(delitemetr);
            }
        }
        System.out.println(sb.toString());
    }
}
