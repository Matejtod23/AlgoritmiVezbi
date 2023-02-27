package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OgledalniBroevi {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> list = new DLL<>();
        String parts[] = bf.readLine().split(" ");
        for (int i = 0; i < parts.length; i++){
            list.insertLast(Integer.valueOf(parts[i]));
        }
        mirorlist(list);
    }

    public static void mirorlist(DLL<Integer> list){
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();
        int n = list.getSize()/2;
        for (int i = 0; i < n; i++){
            list.insertAfter(last.element, first);
            list.delete(last);
            first = first.succ.succ;
            last = last.pred;
        }
        System.out.println(list);
    }
}
