//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainECommerce {
    public static void main(String[] args) {
        System.out.println("========== SISTEMA E-COMMERCE ==========\n");

        // Crear usuarios
        Usuario user1 = new Usuario(1, "Kenneth", "ken@esjknd.com");
        Usuario user2 = new Usuario(2, "Fabi", "Fabi@exelasn.com");
        System.out.println("Usuarios creados:");
        System.out.println("- " + user1.obtenerNombre() + " | Email: " + user1.obtenerEmail());
        System.out.println("- " + user2.obtenerNombre() + " | Email: " + user2.obtenerEmail() + "\n");

        // Crear productos
        Producto p1 = new Producto(101, "Laptop", 1250.0);
        Producto p2 = new Producto(102, "Ebook Java", 13.0);
        Producto p3 = new Producto(103, "Mouse", 30.0);
        System.out.println("Productos disponibles:");
        p1.mostrarInfo();
        p2.mostrarInfo();
        p3.mostrarInfo();
        System.out.println();

        // Crear carrito para el primer usuario
        Carrito carrito1 = new Carrito(5);
        carrito1.agregarProducto(p1, 1);
        carrito1.agregarProducto(p2, 2);

        System.out.println("Carrito de " + user1.obtenerNombre() + ":");
        for (ItemCarrito item : carrito1.obtenerItems()) {
            System.out.println("- " + item.obtenerProducto().obtenerNombre() +
                    " x" + item.obtenerCantidad() +
                    " | Subtotal: $" + item.calcularSubtotal());
        }
        System.out.println("Total del carrito: $" + carrito1.calcularTotal() + "\n");

        // Crear pedido y confirmar con PayPal
        Pedido pedido1 = new Pedido(5001, user1, carrito1.obtenerItems());
        Pago pago1 = new PagoPayPal("ken@xelasn.com");
        pedido1.confirmar(pago1);
        System.out.println("Pedido de " + user1.obtenerNombre() + " confirmado.\n");

        // Crear carrito para el segundo usuario
        Carrito carrito2 = new Carrito(5);
        carrito2.agregarProducto(p2, 1);
        carrito2.agregarProducto(p3, 2);

        System.out.println("Carrito de " + user2.obtenerNombre() + ":");
        for (ItemCarrito item : carrito2.obtenerItems()) {
            System.out.println("- " + item.obtenerProducto().obtenerNombre() +
                    " x" + item.obtenerCantidad() +
                    " | Subtotal: $" + item.calcularSubtotal());
        }
        System.out.println("Total del carrito: $" + carrito2.calcularTotal() + "\n");

        // Crear pedido y confirmar con tarjeta
        Pedido pedido2 = new Pedido(5002, user2, carrito2.obtenerItems());
        Pago pago2 = new PagoTarjeta("1234-5678-9999-0000");
        pedido2.confirmar(pago2);
        System.out.println("Pedido de " + user2.obtenerNombre() + " confirmado.\n");

        System.out.println("========== FIN DEL SISTEMA E-COMMERCE ==========");
    }
}