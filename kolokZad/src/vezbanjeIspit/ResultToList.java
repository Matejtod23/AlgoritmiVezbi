package vezbanjeIspit;

import java.util.Scanner;

import zadListi.sumListi;

class ResultToList {

    public static int getSum(SLL l){
        SLLNode<Integer> first = l.getFirst();
        String sum = "";
        while(first != null){
            sum+=first.element;
            first = first.succ;
        }
        return Integer.parseInt(sum);
    }

    public static SLL addTwoNumbers(SLL l1, SLL l2) {
        SLL res = new SLL();
        int s1 = getSum(l1);
        int s2 = getSum(l2);
        String total = String.valueOf(s1 + s2);
        for(int i = 0; i < total.length(); i++){
            res.insertFirst(total.charAt(i));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        SLL<Integer> list1 = new SLL();
        SLL<Integer> list2 = new SLL();
        for(int i = 0 ; i < n; i++){
            list1.insertLast(s.nextInt());
        }
        
        for(int i = 0 ; i < m; i++){
            list2.insertLast(s.nextInt());
        }

        SLL<Integer> res = addTwoNumbers(list1, list2);
    }
}