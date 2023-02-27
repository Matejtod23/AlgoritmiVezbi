package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Person{
    String surname;
    String isPositive;

    public Person(String surname, String isPositive) {
        this.surname = surname;
        this.isPositive = isPositive;
    }

    public boolean isPositiveF(){
        if (isPositive.equals("позитивен")){
            return true;
        }else {
            return false;
        }
    }
}

public class Corona {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        CBHT<String, Array<Person>> pozitivniByOpstina = new CBHT<>(n*2);
        CBHT<String, Array<Person>> negativniByOpstina = new CBHT<>(n*2);
        for (int i = 0; i < n; i++){
            String[] parts = bf.readLine().split("\\s+");
            Person p = new Person(parts[1], parts[2]);
            if (parts[2].equals("позитивен")){
                if (pozitivniByOpstina.search(parts[0]) == null){
                    pozitivniByOpstina.insert(parts[0], new Array<>(n));
                    pozitivniByOpstina.search(parts[0]).element.value.insertLast(p);
                }else {
                    pozitivniByOpstina.search(parts[0]).element.value.insertLast(p);
                }
            }else {
                if (negativniByOpstina.search(parts[0]) == null){
                    negativniByOpstina.insert(parts[0], new Array<>(n));
                    negativniByOpstina.search(parts[0]).element.value.insertLast(p);
                }else {
                    negativniByOpstina.search(parts[0]).element.value.insertLast(p);
                }
            }
        }
        String opstina = bf.readLine();
        int brPoz = pozitivniByOpstina.search(opstina).element.value
                .getSize();
        int total = brPoz + negativniByOpstina.search(opstina).element.value.getSize();
        System.out.println(brPoz/(float)total);
    }
}
