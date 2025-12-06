package dl;

import bl.Pedido;
import bl.ItemCarrito;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOPedido {

    public void insertarPedido(Pedido p, ItemCarrito[] items) throws Exception {
        String sql = "INSERT INTO pedidos(id, usuario_id, estado) VALUES (?, ?, ?)";

        PreparedStatement ps = Connector.getConnection().prepareStatement(sql);
        ps.setDouble(1, p.obtenerId());
        ps.setDouble(2, p.obtenerUsuario().obtenerId());
        ps.setString(3, p.obtenerEstado());
        ps.executeUpdate();
    }

    public void insertarItems(Pedido p) throws Exception {
        for (ItemCarrito item : p.obtenerItems()) {
            String sql = "INSERT INTO items(pedido_id, producto_id, cantidad) VALUES (?, ?, ?)";

            PreparedStatement ps = Connector.getConnection().prepareStatement(sql);
            ps.setDouble(1, p.obtenerId());
            ps.setInt(2, item.obtenerProducto().obtenerId());
            ps.setInt(3, item.obtenerCantidad());
            ps.executeUpdate();
        }
    }

    public void listarPedidos() throws Exception {
        String sql = "SELECT * FROM pedidos";
        ResultSet rs = Connector.getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            System.out.println("Pedido ID: " + rs.getDouble("id") +
                    " | Usuario: " + rs.getDouble("usuario_id") +
                    " | Estado: " + rs.getString("estado"));
        }
    }
}
