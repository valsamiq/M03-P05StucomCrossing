package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author balsamiq
 */
public class StuCrossDAO {
    private Connection connection;
    
    //-------------------------------------------------------------------------- DB Open/Close Conn.
    // DB-Connection:
    public void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/stucomcrossing";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url, user, pass);
    }
    // DB-Disconnection:
    public void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
//   (\_(\
// =( °w° )=
//   )   ( //
//  (__ __)/
// balsamiq