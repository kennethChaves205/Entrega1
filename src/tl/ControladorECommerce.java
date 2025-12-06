package tl;

import bl.*;
import dl.*;

public class ControladorECommerce {

    private DAOProducto daoProducto;
    private DAOUsuario daoUsuario;
    private DAOPedido daoPedido;

    public ControladorECommerce() {
        daoProducto = new DAOProducto();
        daoUsuario = new DAOUsuario();
        daoPedido = new DAOPedido(); // NUEVO DAO
    }

    // ===============================
    // USUARIOS
    // ===============================
    public void registrarUsuario(Usuario u) throws Exception {
        daoUsuario.insertarUsuario(u);
    }

    public void listarUsuarios() throws Exception {
        daoUsuario.listarUsuarios();
    }

    // ===============================
    // PRODUCTOS
    // ===============================
    public void registrarProducto(Producto p) throws Exception {
        daoProducto.insertarProducto(p);
    }

    public void listarProductos() throws Exception {
        daoProducto.listarProductos();
    }

    // ===============================
    // PEDIDOS
    // ===============================
    public Pedido generarPedido(Usuario u, ItemCarrito[] items) throws Exception {
        double idPedido = Math.random() * 99999;

        Pedido p = new Pedido(idPedido, u, items);

        daoPedido.insertarPedido(p, items);

        return p;
    }

    public void listarPedidos() throws Exception {
        daoPedido.listarPedidos();
    }

    public void registrarPedido(Pedido pedido1) {
    }
}