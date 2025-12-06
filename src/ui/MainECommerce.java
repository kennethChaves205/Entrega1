package ui;

import bl.Usuario;
import bl.Producto;
import bl.Carrito;
import bl.ItemCarrito;
import bl.Pedido;
import bl.Pago;
import bl.PagoPayPal;
import bl.PagoTarjeta;
import tl.ControladorECommerce;


public class MainECommerce {

    public static void main(String[] args) {
        System.out.println("\n========== SISTEMA E-COMMERCE (MVC + DAO) ==========\n");

        try {
            // --------------------------------------------------
            // 1. CONTROLADOR (TL)
            // --------------------------------------------------
            ControladorECommerce controlador = new ControladorECommerce();


            // --------------------------------------------------
            // 2. CREAR USUARIOS (BL)
            // --------------------------------------------------
            Usuario user1 = new Usuario(1, "Kenneth", "ken@esjknd.com");
            Usuario user2 = new Usuario(2, "Fabi", "fabi@exelasn.com");

            controlador.registrarUsuario(user1);
            controlador.registrarUsuario(user2);

            System.out.println("Usuarios registrados en la base de datos:");
            controlador.listarUsuarios();
            System.out.println();


            // --------------------------------------------------
            // 3. CREAR PRODUCTOS (BL)
            // --------------------------------------------------
            Producto p1 = new Producto(101, "Laptop", 1250.0);
            Producto p2 = new Producto(102, "Ebook Java", 13.0);
            Producto p3 = new Producto(103, "Mouse", 30.0);

            controlador.registrarProducto(p1);
            controlador.registrarProducto(p2);
            controlador.registrarProducto(p3);

            System.out.println("Productos registrados:");
            controlador.listarProductos();
            System.out.println();


            // --------------------------------------------------
            // 4. CREAR CARRITO PARA USER 1
            // --------------------------------------------------
            Carrito carrito1 = new Carrito(5);
            carrito1.agregarProducto(p1, 1);
            carrito1.agregarProducto(p2, 2);

            System.out.println("Carrito de " + user1.obtenerNombre() + ":");
            for (ItemCarrito item : carrito1.obtenerItems()) {
                System.out.println("- " + item.obtenerProducto().obtenerNombre() +
                        " x" + item.obtenerCantidad() +
                        " | Subtotal: $" + item.calcularSubtotal());
            }
            System.out.println("Total del carrito: $" + carrito1.calcularTotal());
            System.out.println();


            // --------------------------------------------------
            // 5. GENERAR PEDIDO + CONFIRMAR PAGO
            // --------------------------------------------------
            Pedido pedido1 = controlador.generarPedido(user1, carrito1.obtenerItems());

            Pago metodoPago = new PagoTarjeta("1234-5678-1111-2222");

            pedido1.confirmar(metodoPago);

            // Registrar pedido en DB:
            controlador.registrarPedido(pedido1);

            System.out.println("\nPedido registrado correctamente.\n");


        } catch (Exception ex) {
            System.out.println("ERROR EN LA EJECUCIÓN:");
            ex.printStackTrace();
        }

        System.out.println("========== FIN DEL SISTEMA ==========\n");
    }
}
