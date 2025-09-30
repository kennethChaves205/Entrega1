class Pedido {
    private double id;
    private Usuario usuario;
    private ItemCarrito[] items;
    private String estado;

    public Pedido(double idPedido, Usuario user, ItemCarrito[] listaItems) {
        id = idPedido;
        usuario = user;
        items = listaItems;
        estado = "Pendiente";
    }

    public void confirmar(Pago metodoPago) {
        if (metodoPago.procesarPago(calcularMonto())) {
            estado = "Confirmado";
            System.out.println(" Pedido confirmado para " + usuario.obtenerNombre());
        } else {
            estado = "Fallido";
            System.out.println(" El pago ha fallado");
        }
    }

    public double calcularMonto() {
        double total = 0;
        for (double i = 0; i < items.length; i = i + 1) {
            total = total + items[(int)i].calcularSubtotal();
        }
        return total;
    }
}

//Agregación: Contiene un Usuario y un conjunto de ItemCarrito. Los usuarios y los ítems existen fuera del pedido, por lo que no dependen completamente de él.
//Dependencia: Depende de la interfaz Pago para confirmar la compra, ya que necesita un método de pago externo para procesarla.
//Encapsulamiento: Atributos como id, estado y items son privados y se acceden mediante métodos públicos