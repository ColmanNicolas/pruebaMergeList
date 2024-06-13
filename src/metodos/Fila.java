package metodos;

public class Fila {

    private Nodo cabeza, ultimo;
    private int tamanio;

    public Fila() {
        this.cabeza = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    private Nodo getCabeza() {
        return cabeza;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    private void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    private Nodo getUltimo() {
        return ultimo;
    }

    private void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    private class Nodo {

        private Integer valor;
        private Nodo siguiente;

        public Integer getValor() {
            return valor;
        }

        public void setValor(Integer valor) {
            this.valor = valor;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        Nodo(Integer valor) {
            this.valor = valor;
            this.siguiente = null;
        }

    }

    public static Fila filaVacia() {
        return new Fila();
    }

    public boolean esFilaVacia() {
        return this.getCabeza() == null;
    }

    public Integer frente() {
        if (this.getCabeza() == null) {
            return null;
        } else {
            return this.getCabeza().getValor();
        }
    }

    public Fila enfila(Integer valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (this.getCabeza() == null) {
            this.setCabeza(nuevoNodo);
        } else {
            this.getUltimo().setSiguiente(nuevoNodo);
        }
        this.setUltimo(nuevoNodo);
        setTamanio(++tamanio);
        return this;
    }

    public Fila defila() {
        if (this.getCabeza() == null) {
            return this;
        } else {
            Nodo nodoSiguiente = this.getCabeza().getSiguiente();
            this.setCabeza(nodoSiguiente);
            if (nodoSiguiente == null) {
                this.setUltimo(null);
            }
        }
        setTamanio(--tamanio);
        return this;
    }

    public void mostrar() {
        Nodo puntero = this.getCabeza();
        System.out.print("\nusuarios: ");
        while (puntero != null) {
            System.out.print(puntero.getValor() + " ");
            puntero = puntero.getSiguiente();
        }
        System.out.println("\n");
    }

    public Fila merge() {
        if (this.getTamanio() == 1) {
            return this;
        } else {
            Fila[] resultado = dividirFila(this);
            Fila filaA = resultado[0];
            Fila filaB = resultado[1];
            return combinarLista(filaA.merge(), filaB.merge());
        }

    }

    private Fila[] dividirFila(Fila unaFila) {
        Fila filaA = Fila.filaVacia();
        Fila filaB = Fila.filaVacia();
        
        
        Nodo puntero = unaFila.getCabeza();
        int mitad = unaFila.getTamanio() / 2;
        int contador = 0;
        
        while (puntero != null) {
            if (contador < mitad) {
                filaA.enfila(puntero.getValor());
            } else {
                filaB.enfila(puntero.getValor());
            }
            puntero = puntero.getSiguiente();
            contador++;
        }
        return new Fila[]{filaA, filaB};
    }

    private Fila combinarLista(Fila filaA, Fila filaB) {
        Fila unaFila = Fila.filaVacia();
        Nodo punteroA = filaA.getCabeza();
        Nodo punteroB = filaB.getCabeza();

        while (punteroA != null && punteroB != null) {
            if (punteroA.getValor() <= punteroB.getValor()) {
                unaFila.enfila(punteroA.getValor());
                punteroA = punteroA.getSiguiente();
            } else {
                unaFila.enfila(punteroB.getValor());
                punteroB = punteroB.getSiguiente();

            }
        }

        while (punteroA != null) {
            unaFila.enfila(punteroA.getValor());
            punteroA = punteroA.getSiguiente();

        }

        while (punteroB != null) {
            unaFila.enfila(punteroB.getValor());
            punteroB = punteroB.getSiguiente();
        }
        return unaFila;
    }

}
