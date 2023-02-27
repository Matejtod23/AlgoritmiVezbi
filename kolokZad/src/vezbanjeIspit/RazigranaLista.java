package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RazigranaLista {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        DLL<String> list = new DLL<>();
        String str[] = bf.readLine().split("\\s+");
        for (int i = 0; i < str.length; i++){
            list.insertLast(str[i]);
        }
        deleteTillOneLeft(list);
    }
    public static void deleteTillOneLeft(DLL<String> list){
        while (list.getSize() != 1){
            DLLNode<String> prv = list.getFirst();
            int counter = 1;
            while (prv != null){
                if (counter % 2 == 0){
                    list.delete(prv);
                }
                counter++;
                prv = prv.succ;
            }
            DLLNode<String> posleden = list.getLast();
            counter = 1;
            while (posleden != null){
                if (counter % 2 == 0){
                    list.delete(posleden);
                }
                counter++;
                posleden = posleden.pred;
            }
        }
        System.out.println(list);
    }

}
