class ItemCarrito {
    private Producto producto;
    private Integer cantidad;

    public ItemCarrito(Producto prod, Integer cant) {
        producto = prod;
        cantidad = cant;
    }

    public double calcularSubtotal() {
        return producto.obtenerPrecio() * cantidad;
    }

    public Producto obtenerProducto() { return producto; }
    public Integer obtenerCantidad() { return cantidad; }
}
//Composición: Cada ItemCarrito contiene un Producto y la cantidad seleccionada. Si el Carrito que lo contiene se elimina, el ItemCarrito también deja de existir.
//Encapsulamiento: Los atributos son privados y se accede a ellos mediante métodos públicos.
