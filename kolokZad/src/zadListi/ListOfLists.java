package zadListi;
// 1 2 3 4 5 6 7 8 9 10 -> [1, 2, 3..]

import java.util.Scanner;

public class ListOfLists {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        SLL<Integer> list = new SLL<Integer>();

        int n = input.nextInt();

        for (int i = 0; i < n; i++)
            list.insertLast(input.nextInt());
        podlistiEdnakvi(list);
        input.close();
    }

    private static void podlistiEdnakvi(SLL<Integer> list) {
        int golemina=list.size();
        int elem= golemina/10;
        double dodatni = golemina%10;
        int pom = (int) dodatni;
        int counter = 0, dali_prv = 0, dali_posledan = 1;
        SLLNode<Integer> jazol = list.getFirst();
        System.out.print("[");
        while(jazol!=null){
            if (dodatni == 0){
                while (counter < elem && jazol!=null) {
                    if(counter==elem-1){
                        System.out.print(jazol.element);
                        counter++;
                        jazol=jazol.succ;
                    }
                   else {
                        System.out.printf(jazol.element + "->");
                        counter++;
                        jazol = jazol.succ;
                    }
                }
                counter=0;
                if (jazol == null){
                    System.out.println("]");
                    break;
                }
                System.out.printf(", ");
            }
            else{
                while(pom !=0) {
                    while(counter <elem +1 && jazol!=null){
                        if(counter==elem){
                            System.out.print(jazol.element);
                            counter++;
                            jazol=jazol.succ;
                        }
                        else {
                            System.out.printf(jazol.element + "->");
                            counter++;
                            jazol = jazol.succ;
                        }
                    }
                    counter=0;
                    System.out.printf(", ");
                    pom--;
                }
                while (counter < elem && jazol!=null) {
                    if(counter==elem-1){
                        System.out.print(jazol.element);
                        counter++;
                        jazol=jazol.succ;
                    }
                    else {
                        System.out.printf(jazol.element + "->");
                        counter++;
                        jazol = jazol.succ;
                    }
                }
                counter=0;
                if (jazol == null){
                    System.out.print("]");
                    break;
                }
                System.out.printf(", ");
            }
            }
        }
    }

