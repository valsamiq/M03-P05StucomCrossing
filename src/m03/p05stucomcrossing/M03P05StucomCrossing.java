package m03.p05stucomcrossing;

import dao.StuCrossDAO;
import exceptions.MyException;
import java.sql.SQLException;
import java.util.List;
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
        User u2 = new User("Carles","pass",0,0,"Clase",0);
        User u3 = new User("Albert","pass",0,0,"Clase",0);
        User u4 = new User("Torquemada","pass",0,0,"Biblioteca",0);
        User u5 = new User("JoanaDeArco","pass",0,0,"Biblioteca",0);
        
        //Characters:
        Character c1 = new Character("Fury","Things","Everywhere","Dont know");
        Character c2 = new Character("Robertus", "DAM", "P2", "Palo");
        Character c3 = new Character("Brutus", "DAM", "P2", "Piedra");
        Character c4 = new Character("Chirigotus", "DAM", "P2", "AceleradorParticulas");
        Character c5 = new Character("Bilis", "DAM", "P2", "Piedra");
        //Items:
        Item i1 = new Item("Palo",59.0,20.0,"Objeto Contundente","Modernista");
        Item i2 = new Item("Piedra",20.0,10.5,"Objeto Contundente","Modernista");
        Item i3 = new Item("AceleradorParticulas",999.0,500.0,"Objeto de bolsillo","Lo peta");
        Item i4 = new Item("Libro",30.0,25.0,"Objeto Contundente","Libro Rojo de Mao");
        Item i5 = new Item("Teclado",30.0,15.0,"Objeto Contundente","Tecnologico");
        
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
            System.out.println("|  Inserting other users...              |");
            newUser(stuCrossDAO, u2);
            newUser(stuCrossDAO, u3);
            newUser(stuCrossDAO, u4);
            newUser(stuCrossDAO, u5);
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
            System.out.println("|  Inserting other characters...         |");
            newCharacter(stuCrossDAO, c2);
            newCharacter(stuCrossDAO, c3);
            newCharacter(stuCrossDAO, c4);
            newCharacter(stuCrossDAO, c5);
            System.out.println("|________________________________________|");
            //------------------------------------------------------------------
            //Insert new Item
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  Registering item :                    |");
            System.out.println("|  --> " + i1.getName()+ "." );
            newItem(stuCrossDAO, i1);
            System.out.println("|  Inserting other Items...              |");
            newItem(stuCrossDAO, i2);
            newItem(stuCrossDAO, i3);
            newItem(stuCrossDAO, i4);
            newItem(stuCrossDAO, i5);
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
            //u1.setUsername(newUsername);
            modifyProfile(stuCrossDAO, u1, usu);
            System.out.println("|  --> " + newUsername + "                        |");
            System.out.println("|________________________________________|");
            
            //------------------------------------------------------------------
            //Modify User's Location
            waitForIt();
            boolean bnd;
            System.out.println(" ________________________________________ ");
            System.out.println("|  Modify Location :                     |");
            System.out.println("|   Movement of...                       |");
            System.out.println("|  [0] --> User       [1] --> Character  |");
            //this means that the same function can be used for both cases. False=0, True=1.
            bnd = true;
            usu = "ViejoFlojo";
            System.out.println("|  User to move:                         |");
            System.out.println("|  --> "+usu);
            String newLocation = "Biblioteca";
            System.out.println("|  New Location:                         |");
            System.out.println("|  --> "+newLocation);
            modifyLocation(stuCrossDAO,bnd,usu,newLocation);
            System.out.println("|________________________________________|");
            waitForIt();
            System.out.println(" ________________________________________");
            System.out.println("|  Checking Movement:                    |");
            System.out.println("|  --> ViejoFlojo                        |");
            searchName(stuCrossDAO, "ViejoFlojo");
            System.out.println("|________________________________________|");
            //------------------------------------------------------------------
            //Modify Character's Location
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  Modify Location :                     |");
            System.out.println("|   Movement of...                       |");
            System.out.println("|  [0] --> User       [1] --> Character  |");
            //this means that the same function can be used for both cases. False=0, True=1.
            bnd = false;
            usu = "Fury";
            System.out.println("|  User to move:                         |");
            System.out.println("|  --> "+usu);
            newLocation = "Clase";
            System.out.println("|  New Location:                         |");
            System.out.println("|  --> "+newLocation);
            modifyLocation(stuCrossDAO,bnd,usu,newLocation);
            System.out.println("|________________________________________|");
            waitForIt();
            System.out.println(" ________________________________________");
            System.out.println("|  Checking Movement:                    |");
            System.out.println("|  --> Fury                              |");
            searchNameC(stuCrossDAO, "Fury");
            System.out.println("|________________________________________|");
            //------------------------------------------------------------------
            //Modify Item's price
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  Modify Item's Price :                 |");
            String itm = "Palo";
            System.out.println("|  Item to change:                       |");
            System.out.println("|  --> "+itm);
            double newValue = 66.6;
            System.out.println("|  New Price:                            |");
            System.out.println("|  --> "+newValue);
            modifyItemPrice(stuCrossDAO,itm,newValue);
            System.out.println("|________________________________________|");
            //------------------------------------------------------------------
            //Verify Location (who is there)
            //Modify Item's price
            waitForIt();
            System.out.println(" ________________________________________ ");
            System.out.println("|  Users on the same Place :             |");
            usu = "ViejoFlojo";
            System.out.println("|  Location to search:                   |");
            System.out.println("|  --> "+usu);
            searchCharByUser(stuCrossDAO,usu);
            System.out.println("|________________________________________|");
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
    public static void modifyItemPrice(StuCrossDAO stuCrossDAO,String itm, double value) throws SQLException{
        stuCrossDAO.modifyItemPriceValue(itm,value);
    }
    public static void modifyLocation(StuCrossDAO stuCrossDAO,boolean bnd, String usu, String newLocation) throws SQLException, MyException{
        if(bnd){
            stuCrossDAO.modifyLocationUser(usu,newLocation);
        }
        else if(!bnd){
            stuCrossDAO.modifyLicationCharacter(usu,newLocation);
        }
        else{
            System.out.println("|  How the hell have you arrived here?   |");
        }
    }
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
    public static void searchCharByUser(StuCrossDAO stuCrossDAO, String usu) throws SQLException{
        try{
        List<Character> charList =stuCrossDAO.CharactergetCharByUserLocation(usu);
        System.out.println("|  Location to search:                   |");
        System.out.println("|  Characters found there:               |");
            for(Character c : charList){
                System.out.println(c);
            }
        }
        catch(MyException ex){
            System.out.println(ex.getMessage());
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
    public static void searchNameC(StuCrossDAO stuCrossDAO, String name) throws SQLException{
        try{
            Character aux = stuCrossDAO.getCharacterByName(name);
            System.out.println("|  Character Details:                    |");
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
