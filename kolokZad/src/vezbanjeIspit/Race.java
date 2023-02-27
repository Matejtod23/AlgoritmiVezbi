package vezbanjeIspit;


import java.util.Scanner;

public class Race {

    //todo: implement function


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int prevWinnersCount = Integer.parseInt(scanner.nextLine());
        int currYearRunnersCount = Integer.parseInt(scanner.nextLine());
        SLL<Athlete> prevWinners = new SLL<Athlete>();
        SLL<Athlete> currYearRunners = new SLL<Athlete>();

        for (int i = 0; i < prevWinnersCount; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            prevWinners.insertLast(new Athlete(Integer.parseInt(parts[0]), Double.parseDouble(parts[1])));
        }

        for (int i = 0; i < currYearRunnersCount; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            currYearRunners.insertLast(new Athlete(Integer.parseInt(parts[0]), Double.parseDouble(parts[1])));
        }

        competition(prevWinners, currYearRunners);
        System.out.println(currYearRunners.toString());
    }

    private static void competition(SLL<Athlete> prevWinners, SLL<Athlete> currYearRunners) {
        SLLNode<Athlete> firstOfPrev = prevWinners.getFirst();
        SLLNode<Athlete> firstOfCurr = currYearRunners.getFirst();
        SLLNode<Athlete> minTime = firstOfPrev;
        while (firstOfPrev != null){
            if (minTime.element.getTime() > firstOfPrev.element.getTime()){
                minTime = firstOfPrev;
            }
            firstOfPrev = firstOfPrev.succ;
        }
        while (firstOfCurr != null){
            if (firstOfCurr.element.getTime() > minTime.element.getTime()){
                currYearRunners.delete(firstOfCurr);
            }
            firstOfCurr = firstOfCurr.succ;
        }
    }
}
class Athlete {
    private int id;
    private double time;

    public Athlete(int id, double time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public double getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
