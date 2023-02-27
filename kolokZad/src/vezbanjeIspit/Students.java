package vezbanjeIspit;

import java.util.Scanner;

public class Students {
    public static void main(String[] args)
    {
        SLL<Student> studenti = new SLL<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++)
        {
            int index = input.nextInt();
            String name = input.next();
            int points = input.nextInt();

            Student s1 = new Student(index,name,points);
            studenti.insertLast(s1);
        }
        removeStudent(studenti);
        System.out.println(studenti.toString());
    }

    private static void removeStudent(SLL<Student> studenti) {
        SLLNode<Student> first = studenti.getFirst();
        SLLNode<Student> toRemove = first;
        while (first != null){
            if (toRemove.element.getPoints() > first.element.getPoints()){
                toRemove = first;
            }
            first = first.succ;
        }
        studenti.delete(toRemove);
    }
}

class Student
{
    private int index;
    private String name;
    private int points;

    public Student(int index, String name, int points) {
        this.index = index;
        this.name = name;
        this.points = points;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }


    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
