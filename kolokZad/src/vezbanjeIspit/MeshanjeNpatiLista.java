package vezbanjeIspit;

import java.util.Scanner;

public class MeshanjeNpatiLista {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int borjMesanja = input.nextInt();
        DLL<Integer> list = new DLL();
        for(int i = 0 ; i < n; i++){
            list.insertLast(input.nextInt());
        }
        transform(list, borjMesanja);
        System.out.println(list);
    }

    public static void transform(DLL list, int m){
        if(m == 0)
            return;
        DLLNode<Integer> first = list.getFirst();    
        DLLNode<Integer> last = list.getLast();
        int sum = 0;
        while(first != null){
            if(sum > last.element){
                list.delete(last);
                list.insertBefore(last.element, first.pred);
                break;
            }
            sum+=first.element;
            first = first.succ;
        }    
        transform(list, m-1);
    }
}
