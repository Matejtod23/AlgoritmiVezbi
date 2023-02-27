
/**Се организира прв колоквиум по предметот Алгоритми и структури на податоци.
 За таа цел се отвара анкета по предметот на која студентите се пријавуваат.
 Анкетата има дадено 2 избори:

 1)  Полагам во било кој термин
 2)  Испитот ми се преклопува со Математика

 Студентите се поставуваат во термините според редоследите во кои се примени (почнувајќи од првиот). Сите студенти сакаат да полагаат колку е можно порано па затоа дел од студентите мамат и во анкетата наведуваат дека истиот ден полагаат и Математика.
 Асистентите бараат список на студенти кои полагаат Математика и добиваат.
 Потоа се започнува со распределба на студентите во термини: прво во термините се доделуваат  студентите кои се пријавиле дека полагаат и Математика (по редоследот по кој се пријавиле), меѓутоа секој од овие студенти се проверува дали навистина полага и Математика и ако мамел се сместува на крај од списокот на студенти кои избрале дека полагаат било кој термин. Потоа се изминуваат останатите студенти и се доделуваат во термини.

 Влез: Се дава прво капацитетот на студенти по термин (т.е. по колку студенти во еден термин може да полагаат). Следно се дава бројот и списокот на студенти кои истиот ден полагаат и Математика (според редоследот по кој се пријавиле). Потоа се дава бројот и списокот на останатите студенти (според редоследот по кој се пријавиле). На крај се дава број и список на студенти кои навистина полагаат Математика. На излез се печати број на термин, па студентите кои полагаат во тој термин.

 Име на класа (за Јава): Kolokvium

 Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни структури како низи или сл.

 Sample input:
 2
 4
 IlinkaIvanovska
 IgorKulev
 MagdalenaKostoska
 HristinaMihajlovska
 3
 VladimirTrajkovik
 SlobodanKalajdziski
 AnastasMishev
 1
 IlinkaIvanovska

 Sample output:
 1
 IlinkaIvanovska
 VladimirTrajkovik
 2
 SlobodanKalajdziski
 AnastasMishev
 3
 IgorKulev
 MagdalenaKostoska
 4
 HristinaMihajlovska
 */


//CODE
package zad6;

import java.util.Scanner;

public class KolokviumPodreduvanje {

    private static void Kolokvium(ArrayQueue<String> redAPS, ArrayQueue<String> redAPSMatematika,
                                  int brStudentiTermin, int j, String[] imeStudentiMatematika) {
        ArrayQueue<String> prvTermin = new ArrayQueue<>(brStudentiTermin);
        ArrayQueue<String> studLazat = new ArrayQueue<>(10);
        ArrayQueue<String> vtorTermin = new ArrayQueue<>(brStudentiTermin);
        ArrayQueue<String> tretTermin = new ArrayQueue<>(brStudentiTermin);
        ArrayQueue<String> cetvrtTermin = new ArrayQueue<>(brStudentiTermin);
        for (int i = 0; i < imeStudentiMatematika.length; i++) {
                while (!redAPSMatematika.isEmpty()){
                    if (redAPSMatematika.peek().equals(imeStudentiMatematika[i])){
                        if (prvTermin.size() < brStudentiTermin){
                            prvTermin.enqueue(redAPSMatematika.dequeue());
                        }else {
                            vtorTermin.enqueue(redAPSMatematika.dequeue());
                        }
                    }else {
                        studLazat.enqueue(redAPSMatematika.dequeue());
                    }
                }
        }
        while (!redAPS.isEmpty()){
            if (prvTermin.size() < brStudentiTermin){
                prvTermin.enqueue(redAPS.dequeue());
            }else {
                vtorTermin.enqueue(redAPS.dequeue());
            }
        }
        while (!studLazat.isEmpty()){
            if (tretTermin.size() < brStudentiTermin){
                tretTermin.enqueue(studLazat.dequeue());
            }else {
                cetvrtTermin.enqueue(studLazat.dequeue());
            }
        }
        System.out.println(1);
        while (!prvTermin.isEmpty()){
            System.out.println(prvTermin.dequeue());
        }
        System.out.println(2);
        while (!vtorTermin.isEmpty()){
            System.out.println(vtorTermin.dequeue());
        }
        System.out.println(3);
        while (!tretTermin.isEmpty()){
            System.out.println(tretTermin.dequeue());
        }
        System.out.println(4);
        while (!cetvrtTermin.isEmpty()){
            System.out.println(cetvrtTermin.dequeue());
        }
    }

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        ArrayQueue<String> redAPS = new ArrayQueue<String>(50);
        ArrayQueue<String> redAPSMatematika = new ArrayQueue<String>(50);

        int i, j, brStudentiAPS, brStudentiAPSMatematika, brStudentiMatematika;

        int brStudentiTermin = Integer.parseInt(br.nextLine());
        j = brStudentiTermin;
        brStudentiAPSMatematika = Integer.parseInt(br.nextLine());
        String[] imeStudentiAPSMatematika = new String[brStudentiAPSMatematika];

        for (i = 0; i < brStudentiAPSMatematika; i++) {
            String red = br.nextLine();
            String[] pom = red.split(" ");
            imeStudentiAPSMatematika[i] = pom[0];
            redAPSMatematika.enqueue(imeStudentiAPSMatematika[i]);
        }

        brStudentiAPS = Integer.parseInt(br.nextLine());
        String[] imeStudentiAPS = new String[brStudentiAPS];

        for (i = 0; i < brStudentiAPS; i++) {
            String red = br.nextLine();
            String[] pom = red.split(" ");
            imeStudentiAPS[i] = pom[0];
            redAPS.enqueue(imeStudentiAPS[i]);
        }

        brStudentiMatematika = Integer.parseInt(br.nextLine());
        String[] imeStudentiMatematika = new String[brStudentiMatematika];

        for (i = 0; i < brStudentiMatematika; i++) {
            String red = br.nextLine();
            String[] pom = red.split(" ");
            imeStudentiMatematika[i] = pom[0];
        }
        Kolokvium(redAPS, redAPSMatematika, brStudentiTermin, j, imeStudentiMatematika);

        br.close();
}
}
