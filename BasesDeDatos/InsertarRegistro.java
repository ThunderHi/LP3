package Sesion8LP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertarRegistro {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:miBaseDatos.db";
        
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO usuarios(nombre, edad) VALUES(?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Juan");
            pstmt.setInt(2, 25);
            pstmt.executeUpdate();
            System.out.println("Registro insertado exitosamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

