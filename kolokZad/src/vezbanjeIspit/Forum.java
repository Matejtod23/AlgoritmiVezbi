package vezbanjeIspit;

import java.util.Scanner;

public class Forum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numHealth = Integer.parseInt(scanner.nextLine());
        int numFinance = Integer.parseInt(scanner.nextLine());

        SLL<Discussion> health = new SLL<Discussion>();
        SLL<Discussion> finance = new SLL<Discussion>();

        for (int i = 0; i < numHealth; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            health.insertLast(new Discussion(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < numFinance; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            finance.insertLast(new Discussion(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        forum(health, finance);
        System.out.println(health.toString());
        System.out.println(finance.toString());
    }

    private static void forum(SLL<Discussion> health, SLL<Discussion> finance) {
        SLLNode<Discussion> firstH = health.getFirst();
        SLLNode<Discussion> firstF = finance.getFirst();
        SLLNode<Discussion> toDelete = finance.getFirst();
        while (firstF != null){
            if (toDelete.element.calculateImportance() > firstF.element.calculateImportance())
                toDelete = firstF;
            firstF = firstF.succ;
        }
        finance.delete(toDelete);
        SLLNode<Discussion> toAdd = health.getFirst();
        while (firstH != null){
            if (toAdd.element.calculateImportance() < firstH.element.calculateImportance())
                toAdd = firstH;
            firstH = firstH.succ;
        }
        finance.insertLast(toAdd.element);
    }
}
class Discussion {
    private int id;
    private int popularity;
    private int users;

    public Discussion(int id, int popularity, int users) {
        this.id = id;
        this.popularity = popularity;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int calculateImportance(){
        return popularity * users;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}