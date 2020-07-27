package DoublyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Дадена е двојно поврзана листа од двојно поврзани листи. Да се најде сума на секоја од подлистите, а потоа производ на овие суми

Влез: Број N кој кажува колку листи има Број М кој кажува колку елементи има во секоја листа Во следните М линии се податоците 1<=A<=1000за секоја од листите

Излез: Еден број што е производот на сумите од низите. Со седум децимали.

Пример влез: 3 4 1 2 3 4 2 3 4 5 6 7 8 9

Излез: 1400
*/
public class ListaOdListi {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        /*
        Input:
        4
        4
        6 13 16 7
        7 23 9 11
        8 0 8 19
        6 6 9 11

        Output:
        2352000
        */
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
        System.out.println(findMagicNumber(dll));
    }
}
