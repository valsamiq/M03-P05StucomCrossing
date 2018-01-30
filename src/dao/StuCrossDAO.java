package dao;

import exceptions.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;
import model.Character;
import model.Item;
/**
 * @author balsamiq
 */
public class StuCrossDAO {
    private Connection connection;
    //Insertions
    //--------------------------------------------------------------------------
    public void insertItem(Item i) throws SQLException, MyException{
        if(itemExists(i)){
            throw new MyException("[!] Error: This item already exist [!] |");
        }
        else{
            PreparedStatement ps = connection.prepareStatement("insert into item values(?, ?, ?, ?, ?)");
            ps.setString(1, i.getName());
            ps.setDouble(2, i.getPrice());
            ps.setDouble(3, i.getSalePrice());
            ps.setString(4, i.getStyle());
            ps.setString(5, i.getType());
            ps.executeUpdate();
            ps.close();
        }
    }
    public void insertCharacter(Character c) throws SQLException, MyException{
        if(characterExists(c)){
            throw new MyException("[!] Error: This user already exist [!] |");
        }
        else{
            PreparedStatement ps = connection.prepareStatement("insert into stucomcrossing.character values(?, ?, ?, ?)");
            ps.setString(1, c.getName());
            ps.setString(2, c.getStudy());
            ps.setString(3, c.getPlace());
            ps.setString(4, c.getPreference());
            ps.executeUpdate();
            ps.close();
        }
    }
    
    public void insertUser(User u) throws SQLException, MyException{
        if(userExists(u)){
            throw new MyException("[!]Error: This Char. already exists[!] |");
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
    public boolean Login (String usu, String pass)throws SQLException, MyException{
        boolean bnd=true;
        Statement st = connection.createStatement();
        ResultSet rsUser = st.executeQuery("select * from user where username='" +usu+ "'");
        if(!rsUser.next()){
            bnd = false;
        }
        ResultSet rsPass = st.executeQuery("select * from user where password='" +pass+ "'");
        if(!rsPass.next()){
            bnd=false;
        }
        rsUser.close();
        rsPass.close();
        st.close();
        return bnd;
    }
    //Get user:
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
    //Check if a value already exists.
    private boolean itemExists(Item i) throws SQLException{
        Statement st = connection.createStatement();
        boolean bnd = false;
        ResultSet rs = st.executeQuery("select * from item where name='" + i.getName()+ "'");
        if(rs.next()){
            bnd = true;
        }
        rs.close();
        st.close();
        return bnd;
    }
    private boolean characterExists(Character c) throws SQLException{
        Statement st = connection.createStatement();
        boolean bnd = false;
        ResultSet rs = st.executeQuery("select * from stucomcrossing.character where name='" + c.getName()+ "'");
        if(rs.next()){
            bnd = true;
        }
        rs.close();
        st.close();
        return bnd;
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