package DoublyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DLLVojska {
    public static DLL<Integer> vojska(DLL<Integer> lista, int a, int b, int c, int d) {
        /*
        Input:
        10
        1 2 3 4 5 6 7 8 9 10
        1 5
        6 10

        Output:
        6 7 8 9 10 1 2 3 4 5
        */
        DLLNode<Integer> A = null;
        DLLNode<Integer> B = null;
        DLLNode<Integer> C = null;
        DLLNode<Integer> D = null;

        DLLNode<Integer> dvizi = lista.getFirst();

        while (dvizi != null) {
            if (dvizi.element.equals(a)) {
                A = dvizi;
            }
            if (dvizi.element.equals(b)) {
                B = dvizi;
            }
            if (dvizi.element.equals(c)) {
                C = dvizi;
            }
            if (dvizi.element.equals(d)) {
                D = dvizi;
            }

            dvizi = dvizi.succ;
        }

        DLLNode<Integer> pomA = A.pred;
        DLLNode<Integer> pomB = B.succ;
        DLLNode<Integer> pomC = C.pred;
        DLLNode<Integer> pomD = D.succ;

        B.succ = D.succ;
        if (pomD != null) {
            pomD.pred = B;
        }else{
            lista.setLast(B);
        }



        if (pomB != C) {
            pomB.pred = D;
            D.succ = pomB;
        }

        if (pomC != B) {
            pomC.succ = A;
            A.pred = pomC;
            D.succ = pomB;
            pomB.pred = D;
        }else{
            D.succ = A;
            A.pred = D;
        }
        C.pred = pomA;
        if (pomA != null) {
            pomA.succ = C;
        }else{
            lista.setFirst(C);
        }

        return lista;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=0, b=0, c=0, d=0;

        DLL<Integer> dll = new DLL<>();
        int n = Integer.parseInt(br.readLine());

        String []niza = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            dll.insertLast(Integer.parseInt(niza[i]));
        }

        String interval1 = br.readLine();
        String[] i1 = interval1.split(" ");

        String interval2 = br.readLine();
        String[] i2 = interval2.split(" ");

        a = Integer.parseInt(i1[0]);
        b = Integer.parseInt(i1[1]);
        c = Integer.parseInt(i2[0]);
        d = Integer.parseInt(i2[1]);

        DLL<Integer> result = vojska(dll, a, b, c, d);

        System.out.println(result);
    }
}
