package SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                if(tmp.succ!=null)
                    ret += tmp + "->";
            }
            ret+=tmp;
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if(first ==node){
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public void setFirst(SLLNode<E> node) {
        this.first=node;
    }
}


public class App {
    public static void reverse(SLL<Integer> list) {
        SLLNode<Integer> tmp1 = list.getFirst();
        SLLNode<Integer> tmp2 = list.getFirst();
        SLLNode<Integer> prev = null;

        while (tmp1 != null) {
            tmp1 = tmp1.succ;
            tmp2.succ = prev;
            prev = tmp2;
            tmp2 = tmp1;
        }
        list.setFirst(prev);

    }
    public static boolean checkPalindrome(SLL<Integer> list) {
        SLLNode<Integer> tmp1 = list.getFirst();
        SLLNode<Integer> tmp2 = list.getFirst();

        SLLNode<Integer> start_second = null;
        SLLNode<Integer> first = list.getFirst();
        while (true) {
            tmp1 = tmp1.succ.succ;
            if (tmp1 == null) {
                start_second = tmp2.succ;
                break;
            }
            if (tmp1.succ == null) {
                start_second = tmp2.succ.succ;
                break;
            }
            tmp2=tmp2.succ;
        }
        tmp2.succ = null;
        list.setFirst(start_second);
        reverse(list);
        tmp1=list.getFirst();

        while (first != null && tmp1 != null) {
            if (!first.element.equals(tmp1.element)) {
                return false;
            }
            first=first.succ;
            tmp1=tmp1.succ;
        }
        return true;

    }


    public static void removeDuplicatesSorted(SLL<Integer> list) {
        SLLNode<Integer> tmp = list.getFirst();

        while (tmp.succ != null) {
            if (tmp.element.equals(tmp.succ.element)) {
                tmp.succ = tmp.succ.succ;
            }else{
                tmp = tmp.succ;
            }
        }
    }

    public static void removeDuplicatesUnsorted(SLL<Integer> list) {
        SLLNode<Integer> tmp1 = list.getFirst();
        SLLNode<Integer> tmp2 = list.getFirst();
        SLLNode<Integer> prev = null;

        while (tmp1 != null) {
            tmp2=tmp1.succ;
            prev=tmp1;
            while (tmp2 != null) {
                if (!tmp1.element.equals(tmp2.element)) {
                    prev=tmp2;
                    tmp2 = tmp2.succ;
                }else{
                    tmp2 = tmp2.succ;
                    prev.succ = tmp2;
                }
            }
            tmp1=tmp1.succ;
        }
    }

    public static void swapNodes(SLL<Integer> list, int x, int y) {
        SLLNode<Integer> X = list.getFirst();
        SLLNode<Integer> Y = list.getFirst();
        SLLNode<Integer> prevX = null;
        SLLNode<Integer> prevY = null;
        while (X != null) {
            if (X.element.equals(x)) {
                break;
            }
            prevX = X;
            X = X.succ;
        }

        while (Y != null) {
            if (Y.element.equals(y)) {
                break;
            }
            prevY = Y;
            Y = Y.succ;
        }



        if (prevX != null)
            prevX.succ = Y;
        else
            list.setFirst(Y);

        if (prevY != null)
            prevY.succ = X;
        else
            list.setFirst(X);

        SLLNode<Integer> tmp = X.succ;
        X.succ = Y.succ;
        Y.succ = tmp;

    }

    public static SLL<Integer> spoiSortirani(SLL<Integer> lista1, SLL<Integer> lista2) {
        SLL<Integer> result = null;
        SLLNode<Integer> d1 = null;
        SLLNode<Integer> d2 = null;

        if (lista1.getFirst().element < lista2.getFirst().element) {
            result = lista1;
            d1 = lista1.getFirst();
            d2 = lista2.getFirst();
        }
        else if (lista1.getFirst().element > lista2.getFirst().element) {
            result = lista2;
            d1 = lista2.getFirst();
            d2 = lista1.getFirst();
        }
        else{
            result = lista1;
            d1 = lista1.getFirst();
            d2 = lista2.getFirst();
        }


        SLLNode<Integer> sled = null;

        while (d2 != null) {
            if (d1.succ != null) {
                if (d1.succ.element > d2.element) {
                    sled = d2.succ;
                    d2.succ = d1.succ;
                    d1.succ = d2;
                    d1 = d2;
                    d2 = sled;
                } else if (d1.succ.element < d2.element) {
                    d1 = d1.succ;
                }else{
                    d1 = d1.succ;
                    d2 = d2.succ;
                }
            }else{
                d1.succ = d2;
            }

        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        SLL<Character> sll = new SLL<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("First List");
        int n = Integer.parseInt(br.readLine());
        String []pomNiza = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sll.insertLast(pomNiza[i].charAt(0));
        }

        System.out.println(sll);

        //System.out.println(checkPalindrome(list));
        //removeDuplicatesSorted(list);
        //removeDuplicatesUnsorted(list);
        //swapNodes(list,12, 13);
        //System.out.println(spoiSortirani(lista1, lista2));
    }
}
