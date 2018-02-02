package m03.p05stucomcrossing;

import dao.StuCrossDAO;
import exceptions.MyException;
import java.sql.SQLException;
import model.User;
import model.Character;
import model.Item;

/**
 * @author balsamiq
 */
public class M03P05StucomCrossing {
    
    public static void main(String[] args) throws MyException, InterruptedException {
        
        
        StuCrossDAO stuCrossDAO = new StuCrossDAO();
        title();
        
        
        
        //Something to declare? do it here:
        //Users:
        User u1 = new User("ViejoVerde","88SS",0,0,"Perdido",0);
        //Characters:
        Character c1 = new Character("Fury","Things","Everywhere","Dont know");
        //Items:
        Item i1 = new Item("Palo",59.0,89.9,"Objeto Contundente","Modernista");
        
        try{
            stuCrossDAO.connect();
            //------------------------------------------------------------------
            //Insert new User 
            System.out.println("|________________________________________|");
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  Registering user :                    |");
            System.out.println("|  --> " + u1.getUsername()+ "." );
            newUser(stuCrossDAO, u1);
            System.out.println("|________________________________________|");
            //------------------------------------------------------------------
            //Serch User by Name
            waitForIt();
            System.out.println(" ________________________________________");
            System.out.println("|  Search user by Name:                  |");
            System.out.println("|  --> ViejoVerde                        |");
            searchName(stuCrossDAO, "ViejoVerde");
            System.out.println("|________________________________________|");
            //------------------------------------------------------------------
            //Insert new Character
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  Registering character :               |");
            System.out.println("|  --> " + c1.getName()+ "." );
            newCharacter(stuCrossDAO, c1);
            System.out.println("|________________________________________|");
            //------------------------------------------------------------------
            //Insert new Item
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  Registering item :                    |");
            System.out.println("|  --> " + i1.getName()+ "." );
            newItem(stuCrossDAO, i1);
            System.out.println("|________________________________________|");
            //------------------------------------------------------------------
            //Trying Login -Bad Login-
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  User Login :                          |");
            System.out.println("|  User:                                 |");
            String usu="ViejoRojo";
            System.out.println("|  --> " + usu + "                         |");
            System.out.println("|  Password:                             |");
            String pass="88SS";
            System.out.println("|  --> " + pass + "                              |");
            System.out.println("|                                        |");
            System.out.println("|  Login in...                           |");
            loginFunction(stuCrossDAO, usu, pass);
            System.out.println("|________________________________________|");
            //------------------------------------------------------------------
            //Trying Login -Login String-
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  User Login :                          |");
            System.out.println("|  User:                                 |");
            usu="ViejoVerde";
            System.out.println("|  --> " + usu + "                        |");
            System.out.println("|  Password:                             |");
            pass="88SS";
            System.out.println("|  --> " + pass + "                              |");
            System.out.println("|                                        |");
            System.out.println("|  Login in...                           |");
            loginFunction(stuCrossDAO, usu, pass);
            System.out.println("|________________________________________|");
            
            //------------------------------------------------------------------
            //Modify User's Profile
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  Modify Username :                     |");
            System.out.println("|  User to modify:                       |");
            usu = "ViejoVerde";
            System.out.println("|  --> " + usu + "                        |");
            System.out.println("|  New Username:                         |");
            String newUsername = "ViejoFlojo";
            u1.setUsername(newUsername);
            modifyProfile(stuCrossDAO, u1, usu);
            System.out.println("|  --> " + newUsername + "                        |");
            System.out.println("|________________________________________|");
            
            //------------------------------------------------------------------
            //Modify User's Location
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  Modify Location :                     |");
            System.out.println("|  User to move:                         |");
            System.out.println("|  New Location:                         |");
            
            System.out.println("|________________________________________|");
            waitForIt();
            //------------------------------------------------------------------
            //Modify Character's Location
            
            //------------------------------------------------------------------
            //Modify Item's price
            
            //------------------------------------------------------------------
            //Verify Location (who is there)
            
            //------------------------------------------------------------------
            //Buy item to User
            
            //------------------------------------------------------------------
            //Sell itemo to User
            
            //------------------------------------------------------------------
            //Give Item from User to Character
            
            //------------------------------------------------------------------
            //Check User's Iventory
            
            //------------------------------------------------------------------
            //Check User's Friendships
        }
        catch(SQLException ex){
            System.out.println("| Error while connecting/disconnecting:  |");
            System.out.println("| "+ex.getMessage());
        }
        exit();
    }
    //Backgroud Resources
    //--------------------------------------------------------------------------
    public static void modifyProfile(StuCrossDAO stuCrossDAO, User user, String usu) throws SQLException{
        try {
            stuCrossDAO.modifyUserProfile(user, usu);
        }
        catch(MyException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void loginFunction(StuCrossDAO stuCrossDAO, String usu, String pass) throws SQLException, MyException{
            boolean checkLogin = stuCrossDAO.Login(usu, pass);
            if(checkLogin){
                System.out.println("|    [!]     Login Successfull!    [!]   |");
            }
            else{
                System.out.println("|  [!] Error: Wrong User or Password [!] |");
            }
    }
    public static void searchName(StuCrossDAO stuCrossDAO, String name) throws SQLException{
        try{
            User aux = stuCrossDAO.getUserByUsername(name);
            System.out.println("|  User Details:                         |");
            System.out.println("|  " + aux);
        }
        catch(MyException ex){
            System.out.println(ex.getMessage());
        }
    }
    private static void newItem(StuCrossDAO stuCrossDAO, Item i1) throws SQLException{
        try{
            stuCrossDAO.insertItem(i1);
            System.out.println("|  Item successfully added.              |");
        }
        catch(MyException ex){
            System.out.println("| "+ex.getMessage());
        }
    }
    private static void newCharacter(StuCrossDAO stuCrossDAO, Character c1) throws SQLException{
        try{
            stuCrossDAO.insertCharacter(c1);
            System.out.println("|  Character successfully added.         |");
        }
        catch(MyException ex){
            System.out.println("| "+ex.getMessage());
        }
    }
    private static void newUser(StuCrossDAO stuCrossDAO, User u1) throws SQLException{
        try{
            stuCrossDAO.insertUser(u1);
            System.out.println("|  User successfully added.              |");
        }
        catch (MyException ex){
            System.out.println("| "+ex.getMessage());
        }
    }
    private static void waitForIt() throws InterruptedException{
        int seconds = 1;
        int miliseconds = seconds * 1000;
        Thread.sleep(miliseconds);
    }

    public M03P05StucomCrossing() {
    }

    //Graphic Resources
    //--------------------------------------------------------------------------

    private static void title() {
        System.out.println(" ________________________________________ ");
        System.out.println("|                                        |");
        System.out.println("|           ╔═╗┌┬┐┬ ┬┌─┐┌─┐┌┬┐           |");
        System.out.println("|           ╚═╗ │ │ ││  │ ││││           |");
        System.out.println("|           ╚═╝ ┴ └─┘└─┘└─┘┴ ┴           |");
        System.out.println("|         ╔═╗┬─┐┌─┐┌─┐┌─┐┬┌┐┌┌─┐         |");
        System.out.println("|         ║  ├┬┘│ │└─┐└─┐│││││ ┬         |");
        System.out.println("|         ╚═╝┴└─└─┘└─┘└─┘┴┘└┘└─┘         |");
        System.out.println("|                                        |");
        System.out.println("|       -------- Welcome --------        |");
    }

    private static void exit() {
        System.out.println("|________________________________________|");
        System.out.println(" ________________________________________ ");
        System.out.println("|                                        |");
        System.out.println("|            [!] Apa Ciau! [!]           |");
        System.out.println("|                   _.-;;-._             |");
        System.out.println("|            '-..-'|   ||   |            |");
        System.out.println("|            '-..-'|_.-;;-._|            |");
        System.out.println("|            '-..-'|   ||   |            |");
        System.out.println("|            '-..-'|_.-''-._|            |");
        System.out.println("|________________________________________|");
    }
}
//   (\_(\
// =( °w° )=
//   )   ( //
//  (__ __)/
// balsamiq
