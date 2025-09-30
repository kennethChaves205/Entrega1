class Producto {
    private Integer id;
    private String nombre;
    private double precio;

    public Producto(Integer idProducto, String nombreProducto, double precioProducto) {
        id = idProducto;
        nombre = nombreProducto;
        precio = precioProducto;
    }

    public Integer obtenerId() { return id; }
    public String obtenerNombre() { return nombre; }
    public double obtenerPrecio() { return precio; }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + " | Precio: $" + precio);
    }
}

//Encapsulamiento: Los atributos (id, nombre, precio) son privados y se manipulan a través de métodos públicos.
//Asociación: Producto es utilizado por ItemCarrito, representando la relación entre un producto y la cantidad que se agrega al carrito.