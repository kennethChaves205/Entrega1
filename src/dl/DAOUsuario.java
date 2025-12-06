package dl;

import bl.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOUsuario {

    public void insertarUsuario(Usuario u) throws Exception {
        String sql = "INSERT INTO usuarios(id, nombre, email) VALUES (?, ?, ?)";

        PreparedStatement ps = Connector.getConnection().prepareStatement(sql);
        ps.setDouble(1, u.obtenerId());
        ps.setString(2, u.obtenerNombre());
        ps.setString(3, u.obtenerEmail());
        ps.executeUpdate();
    }

    public void listarUsuarios() throws Exception {
        String sql = "SELECT * FROM usuarios";
        ResultSet rs = Connector.getConnection().prepareStatement(sql).executeQuery();

        while (rs.next()) {
            System.out.println("Usuario: " + rs.getString("nombre") +
                    " | Email: " + rs.getString("email"));
        }
    }
}
