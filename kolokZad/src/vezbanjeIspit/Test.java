package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        SLL<Integer> list = new SLL<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bf.readLine().split("\\s+");
        for (int i = 0; i < parts.length; i++){
            list.insertLast(Integer.valueOf(parts[i]));
        }
        SLLNode<Integer> first = list.getFirst();
        while (first != null){
            if (first.element == 2){
                SLLNode<Integer> tmp = first.succ;
                first.succ = tmp.succ;
                tmp.succ = null;
            }
            first = first.succ;
        }
    }
}
