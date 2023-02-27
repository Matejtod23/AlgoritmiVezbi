package zad8;


public class SLL<E> {
    private SLLNode<E> first;

    public SLL(){
        //kreiranje prazna lista
        this.first = null;
    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public void insertFirst(E o){
        SLLNode ins = new SLLNode<E>(o, null);
        ins.sledbenik = first;
        first = ins;
    }
    public void insertAfter(E o, SLLNode<E> node){
        if(node != null){
            SLLNode<E> ins = new SLLNode<E>(o, node.sledbenik);
            node.sledbenik = ins;
        }else {
            System.out.println("Dadeniot jazol e null");
        }
    }
    public E deleteFirst(){
        if(first != null){
            SLLNode<E> tmp = first;
            first = first.sledbenik;
            return tmp.element;
        }else {
            System.out.println("Listata e prazna");
            return null;
        }
    }
    public E delete(SLLNode<E> node){
        if (first != null){
            SLLNode<E> tmp = first;
            if (first == node){
                return this.deleteFirst();
            }
            while (tmp.sledbenik != node && tmp.sledbenik.sledbenik != null)
                tmp = tmp.sledbenik;
            if (tmp.sledbenik == node){
                tmp.sledbenik = tmp.sledbenik.sledbenik;
                return node.element;
            }else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        }else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public int size(){
        int lastSize = 0;
        SLLNode<E> tmp = first;
        while (tmp != null){
            lastSize++;
            tmp = tmp.sledbenik;
        }
        return lastSize;
    }

    public void insertBefore(E o, SLLNode<E> before){
        if (first != null){
            SLLNode<E> tmp = first;
            if (first.equals(before)){
                this.insertFirst(o);
                return;
            }
            //ako first != before
            while (tmp.sledbenik != before && tmp.sledbenik!=null)
                tmp = tmp.sledbenik;
            if (tmp.sledbenik.equals(before)){
                tmp.sledbenik = new SLLNode<E>(o, before);
            }else {
                System.out.println("Elementot ne postoi vo listata");
            }
        }else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o){
        if(first != null){
            SLLNode<E> tmp = first;
            while (tmp.sledbenik != null)
                tmp = tmp.sledbenik;
            tmp.sledbenik = new SLLNode<>(o, null);//null bidejki na kraj se dodava
        }else {
            insertFirst(o);
        }
    }

    public SLLNode<E> find(E o){
        if (first != null) {
            SLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.sledbenik != null)
                tmp = tmp.sledbenik;
            if (tmp.element.equals(o)) {
                return tmp;
            } else
                System.out.println("Elementot ne postoi");
        }else{
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void merge(SLL<E> in){
        if (first != null){
            SLLNode<E> tmp = first;
            while (tmp.sledbenik != null)
                tmp = tmp.sledbenik;
            tmp.sledbenik = in.getFirst();
        }else {
            first = in.getFirst();
        }
    }

    public void mirror(){
        if (first != null){
            SLLNode<E> tmp = first;
            SLLNode<E> newsledbenik = null;
            SLLNode<E> next;

            while (tmp!= null){
                next = tmp.sledbenik;
                tmp.sledbenik = newsledbenik;
                tmp = next;
            }
            first = newsledbenik;
        }
    }

    @Override
    public String toString() {
        return ""+first;
    }
}
