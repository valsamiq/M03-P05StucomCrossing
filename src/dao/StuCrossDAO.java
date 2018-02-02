package dao;

import exceptions.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.spec.IvParameterSpec;
import model.User;
import model.Character;
import model.Inventory;
import model.Item;

/**
 * @author balsamiq
 */
public class StuCrossDAO {

    private Connection connection;

    //Insertions
    //--------------------------------------------------------------------------
    public void insertItem(Item i) throws SQLException, MyException {
        if (itemExists(i)) {
            throw new MyException("[!] Error: This item already exist [!] |");
        } else {
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

    public void insertCharacter(Character c) throws SQLException, MyException {
        if (characterExists(c)) {
            throw new MyException("[!] Error: This user already exist [!] |");
        } else {
            PreparedStatement ps = connection.prepareStatement("insert into stucomcrossing.character values(?, ?, ?, ?)");
            ps.setString(1, c.getName());
            ps.setString(2, c.getStudy());
            ps.setString(3, c.getPlace());
            ps.setString(4, c.getPreference());
            ps.executeUpdate();
            ps.close();
        }
    }

    public void insertUser(User u) throws SQLException, MyException {
        if (userExists(u)) {
            throw new MyException("[!]Error: This Char. already exists[!] |");
        } else {
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
//    public void sellItemFromUsers(String itm) throws SQLException{
//        Inventory aux = new Inventory(itm);
//        
//        if (itemExists(aux))
//    }
    public void modifyItemPriceValue(String itm, double value) throws SQLException {
        Item aux = new Item(itm);
        if (itemExists(aux) == true) {
            String update = "update stucomcrossing.item set price=? where name=?";
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setDouble(1, value);
            ps.setString(2, itm);
            ps.executeUpdate();
            ps.close();
        }
    }

    public void modifyLicationCharacter(String usu, String newLocation) throws SQLException {
        Character aux = new Character(usu);
        if (characterExists(aux) == true) {
            String update = "update stucomcrossing.character set place=? where name=?";
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, newLocation);
            ps.setString(2, usu);
            ps.executeUpdate();
            ps.close();
        } else {
            System.out.println("| [!]  Error: Char Not Found on DB   [!] |");
        }
    }

    public void modifyLocationUser(String usu, String newLocation) throws SQLException {
        User aux = new User(usu);
        if (userExists(aux) == true) {
            String update = "update stucomcrossing.user set place=? where username=?";
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, newLocation);
            ps.setString(2, usu);
            ps.executeUpdate();
            ps.close();
        } else {
            System.out.println("| [!]  Error: User Not Found on DB   [!] |");
        }
    }

    public void modifyUserProfile(User user, String usu) throws SQLException, MyException {
//        if(!userExists(user)){
//            throw new MyException("| [!] Error: No User registred [!]|");
//        }
        String upd = "update user set username=? where username=?";
        PreparedStatement ps = connection.prepareStatement(upd);
        ps.setString(1, user.getUsername());
        ps.setString(2, usu);
        ps.executeUpdate();
        ps.close();
        System.out.println("");
    }

    public boolean Login(String usu, String pass) throws SQLException, MyException {
        boolean bnd = true;
        Statement st = connection.createStatement();
        ResultSet rsUser = st.executeQuery("select * from user where username='" + usu + "'");
        if (!rsUser.next()) {
            bnd = false;
        }
        ResultSet rsPass = st.executeQuery("select * from user where password='" + pass + "'");
        if (!rsPass.next()) {
            bnd = false;
        }
        rsUser.close();
        rsPass.close();
        st.close();
        return bnd;
    }
    //Get Char by User Location:

    public List<Character> CharactergetCharByUserLocation(String usu) throws SQLException, MyException{
        List<Character> Characters = new ArrayList<>();
        User aux = getUserByUsername(usu);
        if(!userExists(aux)) {
            throw new MyException("| [!]  Error: User Not Found on DB   [!] |");
        }
        String select = "select * from stucomcrossing.character where place='" + aux.getPlace()+ "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next()){
            Character charList = new Character();
            charList.setName(rs.getString("name"));
            charList.setStudy(rs.getString("study"));
            charList.setPlace(rs.getString("place"));
            charList.setPreference(rs.getString("preference"));
            Characters.add(charList);
        }
        rs.close();
        st.close();
        return Characters;
    }
    //Get Item Price:
    public Item getItemPrice(String itm) throws SQLException, MyException{
        Item aux = new Item(itm);
        if (!itemExists(aux)) {
            throw new MyException("| [!]  Error: Item Not Found on DB   [!] |");
        }
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from stucomcrossing.item where name='" + itm + "'");
        Item i = new Item();
            if(rs.next()){
                i.setName(rs.getString("name"));
                i.setPrice(rs.getDouble("price"));
                i.setSalePrice(rs.getDouble("saleprice"));
            }
        return i;
                
    }
    //Get Char:
    public Character getCharacterByName(String name) throws SQLException, MyException {
        Character aux = new Character(name);
        if (!characterExists(aux)) {
            throw new MyException("| [!]  Error: Char Not Found on DB   [!] |");
        }
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from stucomcrossing.character where name='" + name + "'");
        Character c = new Character();

        if (rs.next()) {
            c.setName(rs.getString("name"));
            c.setStudy(rs.getString("study"));
            c.setPlace(rs.getString("place"));
            c.setPreference(rs.getString("preference"));
        }
        st.close();
        rs.close();
        return c;
    }

    //Get User:
    public User getUserByUsername(String name) throws SQLException, MyException {
        User aux = new User(name);
        if (!userExists(aux)) {
            throw new MyException("| [!]  Error: User Not Found on DB   [!] |");
        }
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from stucomcrossing.user where username='" + name + "'");
        User u = new User();
        if (rs.next()) {
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setStucoins(rs.getInt("stucoins"));
            u.setLevel(rs.getInt("level"));
            u.setPlace(rs.getString("place"));
            u.setPoints(rs.getInt("points"));
        }
        st.close();
        rs.close();
        return u;
    }

    //Check if a value already exists.
    private boolean itemExists(Item i) throws SQLException {
        Statement st = connection.createStatement();
        boolean bnd = false;
        ResultSet rs = st.executeQuery("select * from item where name='" + i.getName() + "'");
        if (rs.next()) {
            bnd = true;
        }
        rs.close();
        st.close();
        return bnd;
    }

    private boolean characterExists(Character c) throws SQLException {
        Statement st = connection.createStatement();
        boolean bnd = false;
        ResultSet rs = st.executeQuery("select * from stucomcrossing.character where name='" + c.getName() + "'");
        if (rs.next()) {
            bnd = true;
        }
        rs.close();
        st.close();
        return bnd;
    }

    private boolean userExists(User u) throws SQLException {
        Statement st = connection.createStatement();
        boolean bnd = false;
        ResultSet rs = st.executeQuery("select * from user where username='" + u.getUsername() + "'");
        if (rs.next()) {
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
