package dl;

import bl.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOProducto {

    public void insertarProducto(Producto p) throws Exception {
        String sql = "INSERT INTO productos(id, nombre, precio) VALUES (?, ?, ?)";

        PreparedStatement ps = Connector.getConnection().prepareStatement(sql);
        ps.setInt(1, p.obtenerId());
        ps.setString(2, p.obtenerNombre());
        ps.setDouble(3, p.obtenerPrecio());
        ps.executeUpdate();
    }

    public void listarProductos() throws Exception {
        String sql = "SELECT * FROM productos";
        ResultSet rs = Connector.getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            System.out.println("[" + rs.getInt("id") + "] "
                    + rs.getString("nombre") + " - $" + rs.getDouble("precio"));
        }
    }
}
