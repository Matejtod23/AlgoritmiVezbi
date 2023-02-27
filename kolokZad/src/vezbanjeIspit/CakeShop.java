package vezbanjeIspit;

import java.util.Scanner;

class SpecialSLLNode {
    String name;
    int price;
    SpecialSLLNode succ;

    public SpecialSLLNode(String name, int price, SpecialSLLNode succ) {
        this.name = name;
        this.price = price;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SpecialSLL {
    SpecialSLLNode first;

    public SpecialSLL() {
        this.first = null;
    }

    public void insertFirst(String name, int price) {
        SpecialSLLNode ins = new SpecialSLLNode(name, price, first);
        first = ins;
    }

    public void insertLast(String name, int price) {
        if (first != null) {
            SpecialSLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SpecialSLLNode ins = new SpecialSLLNode(name, price, null);
            tmp.succ = ins;
        } else {
            insertFirst(name, price);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SpecialSLLNode tmp = first;
            ret.append(tmp).append("\n");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append("\n");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }
}

public class CakeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SpecialSLL cakes = new SpecialSLL();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            cakes.insertLast(parts[0], Integer.parseInt(parts[1]));
        }

        removeCakes(cakes);
        System.out.println(cakes.toString());
    }

    private static void removeCakes(SpecialSLL cakes) {
        double average = 0.0;
        SpecialSLLNode first = cakes.first;
        int sum = 0, counter = 0;
        while (first != null){
            sum+=first.price;
            first = first.succ;
            counter++;
        }
        average = (double) sum / counter;
        first = cakes.first;
        while (first.succ != null){
             if (cakes.first.price > average)
                 cakes.first = cakes.first.succ;
//            if (first.succ == null){
//                break;
//            }
            if (first.succ.price > average){
//                SpecialSLLNode tmp = first.succ;
//                first.succ = tmp.succ;
//                tmp.succ = null;
                first.succ = first.succ.succ;
                continue;
            }
            first = first.succ;
        }
    }
}
