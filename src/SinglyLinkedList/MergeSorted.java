package SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSorted {
    public static SLL<Integer> merge(SLL<Integer> lista1, SLL<Integer> lista2) {
        /*
        input:
        7
        1 3 5 7 8 9 10
        5
        2 3 6 9 11
        output:
        1 2 3 5 6 7 8 9 10 11
         */
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
        SLL<Integer> sll1 = new SLL();
        SLL<Integer> sll2 = new SLL();

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("List 1");
        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        String []pomNiza = line.split(" ");
        for (int i = 0; i < N; i++) {
            sll1.insertLast(Integer.parseInt(pomNiza[i]));
        }
        System.out.println("List 2");
        int M = Integer.parseInt(br.readLine());

        line = br.readLine();
        String []pomNiza1 = line.split(" ");
        for (int i = 0; i < M; i++) {
            sll2.insertLast(Integer.parseInt(pomNiza1[i]));
        }

        SLL<Integer> result = merge(sll1,sll2);
        System.out.println(result);
    }
}
