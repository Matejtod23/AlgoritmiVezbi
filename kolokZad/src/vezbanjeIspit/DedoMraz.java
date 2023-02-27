//Помошниците на Дедо Мраз Задача 1 (0 / 0)
//        Помошниците на Дедо Мраз направиле компјутерски систем во кој се чуваа список на сите добри деца и нивната желба за подарок за Нова Година,
//        само што за македонските деца употребиле стара транскрипција на специфичните македонски букви, па така буквата ч ја чуваат како c,
//        буквата ж како z и ш како s. Но, кога треба да проверат дали некое дете било добро, неговото име го добиваат според новата транскрипција
//        каде буквата ч се преставува како ch, буквата ж како zh и ш како sh. Помогнете им на помошниците на Дедо Мраз да проверат дали детете било добро ,
//        и доколку било, кој подарок треба да го добие.
//
//        Влез: Во првата линија е даден број N на деца кои биле добри. Во наредните N линии се дадени името на детете и поклонот кој го сака.
//        Во последниот ред е дадено името на детете кое треба да се провери.
//
//        Излез: Ако даденото дете не било добро (т.е. го нема во списокот на добри деца) да се испечати Nema poklon, а ако било добро да се испечати кој подарок го сакало.
//
//        Име на класа: DedoMrazPomoshnici
//
//        Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.
//
//        Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни структури како низи или сл.
//Пример влез
//5
//JohnDoe dog
//JaneDoe cat
//TomceZarkovski bike
//MartaMartevska sonyplaystation
//EstebanPerez brother
//TomcheZharkovski
//Пример излез
//bike

package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DedoMraz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, String> dobriDeca = new CBHT<String, String>(2*N);// Vie ja odreduvate goleminata na tabelata

        // vo imeDobriDeca se zachuvuvaat iminjata na dobrite deca
        String[] imeDobriDeca = new String[N];
        // tuka se zachuvuvaat soodvetnite adresi na decata
        String[] poklonDobriDeca = new String[N];
        String pom;
        for (int i = 0; i < N; i++) {
            pom = br.readLine();
            String[] del = pom.split(" ");
            imeDobriDeca[i] = del[0];
            poklonDobriDeca[i] = del[1];
        }
        //Помошниците на Дедо Мраз направиле компјутерски систем во кој се чуваа список на сите добри деца и нивната желба за подарок за Нова Година,
//        само што за македонските деца употребиле стара транскрипција на специфичните македонски букви, па така буквата ч ја чуваат како c,
//        буквата ж како z и ш како s. Но, кога треба да проверат дали некое дете било добро, неговото име го добиваат според новата транскрипција
//        каде буквата ч се преставува како ch, буквата ж како zh и ш како sh. Помогнете им на помошниците на Дедо Мраз да проверат дали детете било добро ,
//        и доколку било, кој подарок треба да го добие.
        //tuka se zapishuva imeto na deteto shto treba da se proveri
        String deteZaProverka = br.readLine();
        String tmp = deteZaProverka.toLowerCase();
        if (tmp.contains("ch") || tmp.contains("zh") || tmp.contains("sh")){
            deteZaProverka = deteZaProverka.replace("ch", "c").replace("Ch", "c");
            deteZaProverka = deteZaProverka.replace("zh", "z").replace("Zh", "Z");
            deteZaProverka = deteZaProverka.replace("sh", "s").replace("Sh", "S");
        }


        for(int i = 0; i < N; i++){
            dobriDeca.insert(imeDobriDeca[i], poklonDobriDeca[i]);
        }
        if (dobriDeca.search(deteZaProverka) == null){
            System.out.println("Nema poklon");
        }else {
            System.out.println(dobriDeca.search(deteZaProverka).element.value);
        }
    }
}
