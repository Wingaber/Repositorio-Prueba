
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

   
    public boolean verificarUser(String username, String password, String role) throws ClassNotFoundException {
        String URL = "jdbc:mysql://localhost:3306/sistemacontable2023";
        
        String consulta = "SELECT COUNT(*) FROM usuario WHERE rol = ? AND username = ? AND pass = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(URL, "root", "");
            PreparedStatement pstmt = conexion.prepareStatement(consulta);
            pstmt.setString(1, role);
            pstmt.setString(2, username);
            pstmt.setString(3, password);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    return rowCount > 0; // Si rowCount es mayor que 0, las credenciales son válidas.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Si algo falla, asumimos que las credenciales no son válidas.
    }
}
