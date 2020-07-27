package DoublyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RazigranaLista {
    /*
    Input:
    a b c d e f g h i j
    Prvo brisenje od pocetok: a c e g i
    Vtoro brisenje: a e i
    Treto brisenje: a i
    Cetvrto brisenje: i -> tuka e krajot, ostana samo eden jazol
    */
    public static void brisi(DLL<Character> lista) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DLL<Character> lista = new DLL();
        String line = br.readLine();
        String[] pomNiza = line.split(" ");
        for (int i = 0; i < pomNiza.length; i++) {
            lista.insertLast(pomNiza[i].charAt(0));
        }

        brisi(lista);
    }
}
