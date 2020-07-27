package DoublyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            DLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if(after==last){
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if(before == first){
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        }
        // else throw Exception
        return null;
    }

    public E delete(DLLNode<E> node) {
        if(node==first){
            deleteFirst();
            return node.element;
        }
        if(node==last){
            deleteLast();
            return node.element;
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            while (tmp.succ != null) {
                ret += tmp + "<->";
                tmp = tmp.succ;
            }
            ret += tmp;
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {
        return last;
    }

    public void setFirst(DLLNode<E> node) {
        this.first = node;
    }

    public void setLast(DLLNode<E> node) {
        this.last = node;
    }


}

public class App {

    public static void razigranaList(DLL<Character> lista) {
        while (lista.getFirst().succ != null) {
            DLLNode<Character> dvizi = lista.getFirst().succ;
            while (dvizi != null) {
                DLLNode<Character> d1 = dvizi.pred;
                DLLNode<Character> d2 = dvizi.succ;

                d1.succ = d2;

                if (d2 != null) {
                    d2.pred = d1;
                    dvizi = d2.succ;
                }else{
                    lista.setLast(d1);
                    dvizi = null;
                }
            }
            System.out.println(lista);
            if (lista.getFirst().succ == null) {
                break;
            }

            dvizi = lista.getLast().pred;

            while (dvizi != null) {
                DLLNode<Character> d1 = dvizi.pred;
                DLLNode<Character> d2 = dvizi.succ;

                d2.pred = d1;

                if (d1 != null) {
                    d1.succ = d2;
                    dvizi = d1.pred;
                }else{
                    lista.setFirst(d2);
                    dvizi = null;
                }
            }
            System.out.println(lista);
        }
    }




    public static int palindrome(DLL<Integer> lista){
        DLLNode<Integer> tmp1 = lista.getFirst();
        DLLNode<Integer> tmp2 = lista.getLast();

        while (tmp1 != tmp2) {
            if (!tmp1.element.equals(tmp2.element)) {
                return -1;
            }
            tmp1 = tmp1.succ;
            tmp2 = tmp2.pred;
        }

        return 1;
    }

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        DLLNode<DLL<Integer>> tmpList = list.getFirst();
        DLLNode<Integer> tmpElems = null;

        int suma = 0;
        long proizvod = 1;

        while (tmpList != null) {
            suma = 0;
            tmpElems = tmpList.element.getFirst();

            while (tmpElems != null) {
                suma+=tmpElems.element;
                tmpElems = tmpElems.succ;
            }

            proizvod *= suma;
            tmpList = tmpList.succ;
        }
        return proizvod;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<DLL<Integer>> dll = new DLL<DLL<Integer>>();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            String []niza = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                tmp.insertLast(Integer.parseInt(niza[j]));
            }
            dll.insertLast(tmp);
        }
        
        //razigranaList(dll);
        //System.out.println(palindrome(dll));
        System.out.println(findMagicNumber(dll));
    }
}
