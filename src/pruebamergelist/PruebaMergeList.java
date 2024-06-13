package pruebamergelist;

import metodos.Fila;

public class PruebaMergeList {

    public static void main(String[] args) {

        Fila miFila = Fila.filaVacia();
        miFila.enfila(5).enfila(2).enfila(10).enfila(8).enfila(99).enfila(1).enfila(55);
        Fila filaOrdenada = miFila.merge();
        miFila.mostrar();
        System.out.println("*****************************");
        filaOrdenada.mostrar();
        
        
    }

}
