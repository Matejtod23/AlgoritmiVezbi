package vezbanjeIspit;

import java.util.Scanner;

public class TasksPrioityToDo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int toDoNum = s.nextInt();
        int inProgressNum = s.nextInt();
        SLL<Task> toDoList = new SLL<>();
        SLL<Task> progress = new SLL<>();
        for(int i=0;i<toDoNum;i++)
        {
            int id = s.nextInt();
            int hours = s.nextInt();
            int priority = s.nextInt();

            Task t1 = new Task(id,hours,priority);
            toDoList.insertLast(t1);
        }
        for(int j=0;j<inProgressNum;j++)
        {
            int id = s.nextInt();
            int hours = s.nextInt();
            int priority = s.nextInt();

            Task t2 = new Task(id,hours,priority);
            progress.insertLast(t2);
        }
        work(toDoList, progress);
        System.out.println(toDoList);
        System.out.println(progress);
    }

    private static void work(SLL<Task> toDoList, SLL<Task> progress) {
        SLLNode<Task> firstToDo = toDoList.getFirst();
        SLLNode<Task> firstProg = progress.getFirst();
        SLLNode<Task> deleteToDo = firstToDo;
        SLLNode<Task> deleteProg = firstProg;
        while (firstToDo != null){
            if (deleteToDo.element.importance() < firstToDo.element.importance())
                deleteToDo = firstToDo;
            firstToDo = firstToDo.succ;
        }
        toDoList.delete(deleteToDo);
        while (firstProg != null){
            if (deleteProg.element.importance() > firstProg.element.importance())
                deleteProg = firstProg;
            firstProg = firstProg.succ;
        }
        progress.delete(deleteProg);
        toDoList.insertLast(deleteProg.element);
        progress.insertFirst(deleteToDo.element);
    }
}

class Task{
    int id;
    int hours;
    int priority;

    public Task(int id, int hours, int priority) {
        this.id = id;
        this.hours = hours;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getHours() {
        return hours;
    }

    public int getPriority() {
        return priority;
    }

    public int importance(){
        return 2 * hours * priority;
    }

    @Override
    public String toString() {
        return id + " ";
    }
}
