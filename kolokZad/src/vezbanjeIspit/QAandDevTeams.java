package vezbanjeIspit;

import java.util.Scanner;

public class QAandDevTeams {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int devTeamNum = s.nextInt(), qaTeamNum = s.nextInt();
        SLL<Client> devTeam = new SLL<>();
        SLL<Client> qaTeam = new SLL<>();
        for (int i = 0; i < devTeamNum; i++){
            Client c = new Client(s.nextInt(), s.nextInt());
            devTeam.insertLast(c);
        }
        for (int i = 0; i < qaTeamNum; i++){
            Client c = new Client(s.nextInt(), s.nextInt());
            qaTeam.insertLast(c);
        }
        expandTeams(devTeam, qaTeam);
    }

    public static void expandTeams(SLL<Client> dTeam, SLL<Client> qTeam){
        SLLNode<Client> smallest = null;
        SLLNode<Client> firstQ = qTeam.getFirst();
        SLLNode<Client> firstD = dTeam.getFirst();
        int min = firstQ.element.vozrast;
        smallest = firstQ;
        while (firstQ != null){
            if (min > firstQ.element.vozrast){
                min = firstQ.element.vozrast;
                smallest = firstQ;
            }
            firstQ = firstQ.succ;
        }
        qTeam.delete(smallest);
        int n = (int) Math.ceil((double)dTeam.size() / 2);
        for (int i = 0; i < n; i++){
            firstD = firstD.succ;
        }
        dTeam.insertBefore(smallest.element, firstD);
        System.out.println(dTeam.StringToPring());
        System.out.println(qTeam.StringToPring());
    }
}

class Client{
    int id;
    int vozrast;

    public Client(int id, int vozrast) {
        this.id = id;
        this.vozrast = vozrast;
    }

    @Override
    public String toString() {
        return id + " ";
    }
}
