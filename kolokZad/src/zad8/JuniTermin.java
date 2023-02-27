package zad8;
/**(2 термин): Дадена е еднострано поврзана листа од цели броеви. Треба да се изврши бришење на тој начин што прво се остава еден па се брише следниот, па се оставаат два, па се брише следниот, па три итн. се додека е возможно бришење.
 Ако листата е празна на излез да се испечати Prazna lista.
 Влез: број на елементи во листата, самата листа
 Излез: листа со избришани јазли
 Не смее да се користат помошни структури како низи и сл. и не смее да се менуваат вредностите на јазлите.
 Пример:
 Влез: 								Излез:
 7									1 9 5 3 0
 1 6 9 5 6 3 0
 */

import java.util.Scanner;

public class JuniTermin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLL<Integer> list = new SLL<Integer>();
        int n = input.nextInt();

        for (int i = 0; i < n; ++i) {
            list.insertLast(input.nextInt());
        }

        if (n > 0) {
            removeNode(list);
            System.out.println(list.toString());
        } else {
            System.out.println("Prazna lista");
        }
        input.close();
    }

    private static void removeNode(SLL<Integer> list) {
        int count = 1, flag = 1;
        SLLNode first = list.getFirst();
        while (first!=null){
            if (count == 1){
                first = first.sledbenik;
            }
            if (flag == 1){
                list.delete(first);
                flag = 0;
            }
            count++;
            int tmp = count + 1;
            while (tmp!= 0){
                if (first == null)
                    break;
                first = first.sledbenik;
                flag = 1;
                tmp--;
            }
        }
    }


}

