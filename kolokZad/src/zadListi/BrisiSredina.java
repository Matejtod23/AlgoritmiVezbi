package zadListi;

import java.util.Scanner;

/**(1 Термин):
 Дадена еднострано поврзана листа, се бара N пати да се избрише средината. Ако листата е со парен број елементи од 2та средишни елементи се брише
 помалиот, а ако се исти се брише првиот.
 Влез: првата линија број на елементи на листата,вториот ред елементите на листата и во третиот ред број колку пати да се избрише средината

 Sample input:       Sample output:
 5                   1 4 5
 1 2 3 4 5
 2
 */

//  CODE
public class BrisiSredina {
    public static void removeMiddleNode(SLL<Integer> list, int timesDeleted) {
        int sredina;
        if (list.size()%2==0){
            sredina = (list.size() / 2) - 1;
        }else {
            sredina = list.size()/2;
        }
        int count = 0;
        SLLNode<Integer> first = list.getFirst();
        for (int i = 0; i < timesDeleted; i++){
            while (first != null) {
                if (count == sredina)
                    list.delete(first);
                first = first.succ;
                count++;
            }
            first = list.getFirst();
            count = 0;
            if (list.size()%2==0){
                sredina = (list.size() / 2) - 1;
            }else {
                sredina = list.size()/2;
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SLL<Integer> list = new SLL<Integer>();
        int n = input.nextInt();

        for (int i = 0; i < n; ++i)
            list.insertLast(input.nextInt());
        removeMiddleNode(list, input.nextInt());
        input.close();
    }
}
