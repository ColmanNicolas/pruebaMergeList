package metodos;

public class Ordenamiento {

    private Fila listaOrganizable;

    public Fila merge(Fila unaFila) {
        if (unaFila.getTamanio() == 1) {
            return unaFila;
        } else {
            Fila[] resultado = dividirFila(unaFila);
            Fila filaA = resultado[0];
            Fila filaB = resultado[1];
            filaA.mostrar();
            System.out.println("**********************************");
            filaB.mostrar();
            return unaFila;
        }

    }

    private Fila[] dividirFila(Fila unaFila) {
        Fila filaA = Fila.filaVacia();
        Fila filaB = Fila.filaVacia();
        int mitad = unaFila.getTamanio() / 2;
        int contador = 0;
        while (unaFila.getTamanio() != 0) {
            if (contador <= mitad) {
                filaA.enfila(unaFila.frente());
            } else {
                filaB.enfila(unaFila.frente());
            }
            unaFila.defila();
            contador++;
        }
        return new Fila[] { filaA, filaB };
    }

}
