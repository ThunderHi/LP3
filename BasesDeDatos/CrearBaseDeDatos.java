package Sesion8LP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CrearBaseDeDatos {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:miBaseDatos.db";
        
        try (Connection conn = DriverManager.getConnection(url); 
             Statement stmt = conn.createStatement()) {
            
            // Crear tabla
            String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nombre TEXT NOT NULL,"
                    + "edad INTEGER)";
            
            stmt.execute(sql);
            System.out.println("Tabla 'usuarios' creada exitosamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
