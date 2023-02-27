package vezbanjeIspit;

import java.util.Scanner;

public class ListaOdListi {

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        DLLNode<DLL<Integer>> podlista = list.getFirst();
         int currSum = 0;
        int proizvod = 1;
        while (podlista != null){
            DLLNode<Integer> posleden = podlista.element.getLast();
            DLLNode<Integer> prv = podlista.element.getFirst();
            int counter = 0;
            while (counter != podlista.element.getSize()/2){
                currSum += prv.element + posleden.element;
                prv = prv.succ;
                posleden = posleden.pred;
                counter++;
            }
            proizvod *= currSum;
            currSum = 0;
            podlista = podlista.succ;
        }
        return proizvod;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }

}
