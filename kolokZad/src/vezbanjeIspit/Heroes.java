package vezbanjeIspit;

import java.util.Scanner;

class Card{
    int id;
    int power;
    int numAttacks;

    public Card(int id, int power, int numAttacks) {
        this.id = id;
        this.power = power;
        this.numAttacks = numAttacks;
    }

    public int getId() {
        return id;
    }

    public int getPower() {
        return power;
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public int cardPower(){
        return power * numAttacks;
    }

    @Override
    public String toString() {
        return id + "";
    }
}

public class Heroes {


    public static void startHeroesGame(SLL<Card> firstFriendCards, SLL<Card> secondFriendCards) {
        SLLNode<Card> jazol1 = firstFriendCards.getFirst();
        SLLNode<Card> jazol2 = secondFriendCards.getFirst();
        SLLNode<Card> cardToDelete = jazol1;
        int maxCard = jazol1.element.cardPower();
        while (jazol1 != null){
            if (jazol1.element.cardPower() > maxCard){
                maxCard = jazol1.element.cardPower();
                cardToDelete = jazol1;
            }
            jazol1 = jazol1.succ;
        }
        firstFriendCards.delete(cardToDelete);
        int i = 0;
        while (jazol2 != null){
            if (i == 2){
                secondFriendCards.insertAfter(cardToDelete.element, jazol2);
            }
            i++;
            jazol2 = jazol2.succ;
        }
    }


        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<Card> firstFriendCards = new SLL<Card>();
        SLL<Card> secondFriendCards = new SLL<Card>();

        for (int i = 0; i < 6; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            firstFriendCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < 6; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            secondFriendCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        startHeroesGame(firstFriendCards, secondFriendCards);
        System.out.println(firstFriendCards.toString());
        System.out.println(secondFriendCards.toString());
    }
}
