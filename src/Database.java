import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // URL de connexion MySQL (à adapter si nécessaire)
    private static final String URL = "jdbc:mysql://localhost:3307/cinema";
    private static final String USER = "root";        // ton nom d'utilisateur MySQL
    private static final String PASSWORD = "";        // ton mot de passe MySQL

    // Charger le driver (facultatif avec les versions récentes de JDBC)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Driver JDBC introuvable !");
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer une connexion
    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
