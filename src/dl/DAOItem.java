package dl;

import bl.ItemCarrito;
import java.sql.PreparedStatement;

public class DAOItem {

    public void insertarItem(double idPedido, ItemCarrito item) throws Exception {

        String sql = "INSERT INTO items(pedido_id, producto_id, cantidad) VALUES (?, ?, ?)";

        PreparedStatement ps = Connector.getConnection().prepareStatement(sql);

        ps.setDouble(1, idPedido);
        ps.setInt(2, item.obtenerProducto().obtenerId());
        ps.setInt(3, item.obtenerCantidad());

        ps.executeUpdate();
    }
}
