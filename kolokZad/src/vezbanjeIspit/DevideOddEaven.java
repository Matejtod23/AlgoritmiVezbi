package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DevideOddEaven {
    public static void main(String[] args) throws IOException{
        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }
        divideOddEven(lista);
    }

    private static void divideOddEven(DLL<Integer> lista) {
        DLLNode<Integer> first = lista.getFirst();
        DLLNode<Integer> last = lista.getLast();
        DLL<Integer> oddList = new DLL<>();
        DLL<Integer> eavenList = new DLL<>();
        while (first.succ != last && first != last){
            if (first.element % 2 == 0 && last.element % 2 == 0){
                if (first == last){
                    eavenList.insertLast(first.element);
                }else {
                    eavenList.insertLast(first.element);
                    eavenList.insertLast(last.element);
                }
            } else if (first.element % 2 == 0 || last.element %2 == 0) {
                if (first.element % 2 == 0){
                    eavenList.insertLast(first.element);
                }else {
                    eavenList.insertLast(last.element);
                }
            }else if (first.element % 2 != 0 && last.element % 2 != 0){
                if (first == last){
                    oddList.insertLast(first.element);
                }else {
                    oddList.insertLast(first.element);
                    oddList.insertLast(last.element);
                }
            } else if (first.element % 2 != 0 || last.element %2 != 0) {
                if (first.element % 2 != 0){
                    oddList.insertLast(first.element);
                }else {
                    oddList.insertLast(last.element);
                }
            }
            first = first.succ;
            last = last.pred;
        }
        System.out.println(oddList + "\n" + eavenList);
    }
}
