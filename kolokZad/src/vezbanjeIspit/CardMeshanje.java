package vezbanjeIspit;

import java.util.Scanner;

public class CardMeshanje {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        SLL<SpecialCard> prvDel = new SLL<>();
        SLL<SpecialCard> vtorDel = new SLL<>();

        for(int i=0;i<6;i++)
        {
            int id = input.nextInt();
            int rank = input.nextInt();
            SpecialCard c1 = new SpecialCard(id,rank);
            prvDel.insertLast(c1);
        }
        for(int j=0;j<6;j++)
        {
            int id = input.nextInt();
            int rank = input.nextInt();
            SpecialCard c2 = new SpecialCard(id,rank);
            vtorDel.insertLast(c2);
        }
        tarotCards(prvDel,vtorDel);
        System.out.println(prvDel.toString());
        System.out.println(vtorDel.toString());
    }

    public static SLLNode<SpecialCard> getPretposledna(SLL<SpecialCard> lista){
        SLLNode<SpecialCard> first = lista.getFirst();
        while (first != null){
            if (first.succ.succ == null){
                return first;
            }
            first = first.succ;
        }
        return first;
    }

    private static void tarotCards(SLL<SpecialCard> prvDel, SLL<SpecialCard> vtorDel) {
        SLLNode<SpecialCard> firstPrv = prvDel.getFirst();
        SLLNode<SpecialCard> firstVtor = vtorDel.getFirst();
        prvDel.delete(firstPrv);
        vtorDel.insertLast(firstPrv.element);
        vtorDel.delete(firstVtor);
        prvDel.insertLast(firstVtor.element);
        SLLNode<SpecialCard> zaSredina = getPretposledna(prvDel);
        prvDel.delete(zaSredina);
        firstVtor = vtorDel.getFirst();
        int n = (int) Math.ceil((double) vtorDel.size()/2);
        for (int i = 1; i < n; i++){
            firstVtor = firstVtor.succ;
        }
        vtorDel.insertAfter(zaSredina.element, firstVtor);
    }
}

class SpecialCard
{
    private int id;
    private int rank;

    public SpecialCard(int id, int rank)
    {
        this.id=id;
        this.rank=rank;
    }

    public int getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
