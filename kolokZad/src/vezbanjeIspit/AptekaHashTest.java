package vezbanjeIspit;

import java.util.HashMap;
import java.util.Scanner;

class Apteka{
    String name;
    int isPositive;
    int price;
    int quantity;

    public Apteka(String name, int isPositive, int price, int quantity) {
        this.name = name;
        this.isPositive = isPositive;
        this.price = price;
        this.quantity = quantity;
    }

    public String status(){
        if (isPositive == 0){
            return "POZ";
        }else {
            return "NEG";
        }
    }

    public void quantityCheck(int n){
        if (n > quantity){
            System.out.print("Nema dovolno lekovi");
        }else {
            System.out.print("Napravena nacarcka");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "\n");
        sb.append(status() + "\n");
        sb.append(price + "\n");
        sb.append(quantity + "\n");

        return sb.toString();
    }
}

class MedName{
    String name;

    public MedName(String name) {
        this.name = name.toUpperCase();
    }
    @Override
    public int hashCode() {
        //h(w)=(29∗(29∗(29∗0+ASCII(c1))+ASCII(c2))+ASCII(c3))%102780 каде зборот w=c1c2c3c4c5
        return (29 * (29* (29*0 + name.charAt(0)) + name.charAt(1)) + name.charAt(2)) % 102780;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MedName other = (MedName) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}

public class AptekaHashTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<MedName, Apteka> farmacy = new HashMap<>();
        for (int i = 0; i < n; i++){
            String name = input.next();
            int status = input.nextInt();
            int price = input.nextInt();
            int quantity = input.nextInt();
            Apteka med = new Apteka(name, status, price, quantity);
            MedName medName = new MedName(name);
            farmacy.put(medName, med);
        }

        while (true){
            String name = input.next();
            if (name.equals("KRAJ"))
                break;
            int numOrders = input.nextInt();
            MedName medName = new MedName(name);
            if (farmacy.containsKey(medName)){
                System.out.print(farmacy.get(medName));
                farmacy.get(medName).quantityCheck(numOrders);
            }else {
                System.out.println("Nema takov lek");
            }
        }
        input.close();
    }
}
