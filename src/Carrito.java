class Carrito {
    private ItemCarrito[] items;
    private double contador;

    public Carrito(double capacidad) {
        items = new ItemCarrito[(int)capacidad];
        contador = 0;
    }

    public void agregarProducto(Producto prod, double cant) {
        if (contador < items.length) {
            items[(int)contador] = new ItemCarrito(prod, (int) cant);
            contador = contador + 1;
        } else {
            System.out.println("Carrito lleno, no se puede agregar más productos.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (double i = 0; i < contador; i = i + 1) {
            total = total + items[(int)i].calcularSubtotal();
        }
        return total;
    }

    public ItemCarrito[] obtenerItems() {
        ItemCarrito[] copia = new ItemCarrito[(int)contador];
        for (double i = 0; i < contador; i = i + 1) {
            copia[(int)i] = items[(int)i];
        }
        return copia;
    }
}

interface Pago {
    boolean procesarPago(double monto);
}

//Composición: Contiene múltiples ItemCarrito. Los ítems dependen del carrito y se eliminan si este se elimina.
//Encapsulamiento: Los atributos y la lógica interna del carrito están protegidos, con métodos públicos para agregar productos y calcular el total.
//Asociación: Un Usuario usa un Carrito para seleccionar productos antes de generar un pedido.