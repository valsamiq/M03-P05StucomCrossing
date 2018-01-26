package dao;

import exceptions.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;

/**
 * @author balsamiq
 */
public class StuCrossDAO {
    private Connection connection;
    //Insertions
    //--------------------------------------------------------------------------
//    public void insertCharacter(Character c) throws SQLException, MyException{
//        if(userExists(c)){
//            throw new MyException("| [!]Error: This user alrready exist [!] |");
//        }
//        else{
//            PreparedStatement ps = connection.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?)");
//            ps.setString(1, u.getUsername());
//            ps.setString(2, u.getPassword());
//            ps.setInt(3, u.getStucoins());
//            ps.setInt(4, u.getLevel());
//            ps.setString(5, u.getPlace());
//            ps.setInt(6, u.getPoints());
//            ps.executeUpdate();
//            ps.close();
//        }
//    }
    public void insertUser(User u) throws SQLException, MyException{
        if(userExists(u)){
            throw new MyException("| [!]Error: This user alrready exist [!] |");
        }
        else{
            PreparedStatement ps = connection.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?)");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getStucoins());
            ps.setInt(4, u.getLevel());
            ps.setString(5, u.getPlace());
            ps.setInt(6, u.getPoints());
            ps.executeUpdate();
            ps.close();
        }
    }
    //Aux. functions
    //--------------------------------------------------------------------------
    public User getUserByUsername(String name)throws SQLException, MyException{
        User aux = new User(name);
        if(!userExists(aux)){
            throw new MyException("| [!]  Error: User Not Found on DB   [!] |");
        }
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from user where username='"+ name +"'");
        User u = new User();
        return u;
    }
    
    private boolean userExists(User u ) throws SQLException{
        Statement st = connection.createStatement();
        boolean bnd = false;
        ResultSet rs = st.executeQuery("select * from user where username='" + u.getUsername()+ "'");
        if(rs.next()){
            bnd = true;
        }
        rs.close();
        st.close();
        return bnd;
    }
    
    //DB Open/Close Conn.
    //--------------------------------------------------------------------------
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