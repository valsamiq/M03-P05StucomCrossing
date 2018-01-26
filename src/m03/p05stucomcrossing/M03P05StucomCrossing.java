package m03.p05stucomcrossing;

import dao.StuCrossDAO;
import exceptions.MyException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;
import model.Character;

/**
 * @author balsamiq
 */
public class M03P05StucomCrossing {

    public static void main(String[] args) {
        StuCrossDAO stuCrossDAO = new StuCrossDAO();
        title();
        //Something to declare?
        //Users:
        User u1 = new User("ViejoVerde", "88SS", 0, 0, "Perdido", 0);
        //Characters:
        Character c1 = new Character("Fury", "Things","Everywhere","Dont know");
        try{
            stuCrossDAO.connect();
            //------------------------------------------------------------------
            //Insert new User
            System.out.println("|________________________________________|");
            System.out.println(" ________________________________________ ");
            System.out.println("|  Registering user :                    |");
            System.out.println("|  --> " + u1.getUsername()+ "." );
            newUser(stuCrossDAO, u1);
            //------------------------------------------------------------------
            //Serch User by Name
            System.out.println("|________________________________________|");
            System.out.println(" ________________________________________");
            System.out.println("|  Search user by Name:                  |");
            System.out.println("|  --> ViejoVerde                        |");
            searchName(stuCrossDAO, "ViejoVerde");
            //------------------------------------------------------------------
            //Insert new Character
            System.out.println("|________________________________________|");
            System.out.println(" ________________________________________ ");
            System.out.println("|  Registering character :               |");
            System.out.println("|  --> " + c1.getName()+ "." );
            newCharacter(stuCrossDAO, u1);
        }
        catch(SQLException ex){
            System.out.println("| Error while connecting/disconnecting:  |");
            System.out.println("| "+ex.getMessage());
        }
        exit();
    }

    private static boolean mainMenu(String op){
        boolean bnd = true;
        return bnd;
    }

    //Backgroud Resources
    //-------------------------------------------------------------------------- 
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

    //Graphic Resources
    //--------------------------------------------------------------------------
    public static void listOp() {
        System.out.println("|________________________________________|");
        System.out.println("|              Lists Types:              |");
        System.out.println("|   1 - Get a User Friends List          |");
        System.out.println("|   2 - Get Missing Items from a User    |");
        System.out.println("|   3 - Top 10 Users                     |");
        System.out.println("|   4 - Top Friendships from Users       |");
        System.out.println("|   5 - Get Unknown User from other Users|");
        System.out.println("|   0 - Back                             |");
    }

    public static void itemOp() {
        System.out.println("|________________________________________|");
        System.out.println("|              Item Options:             |");
        System.out.println("|   1 - Buy an Item                      |");
        System.out.println("|   2 - Sell an Item                     |");
        System.out.println("|   3 - Give an Item to a User           |");
        System.out.println("|   4 - Check User Registration          |");
        System.out.println("|   5 - User's Inventory List            |");
        System.out.println("|   0 - Back                             |");
    }

    public static void modifyOp() {
        System.out.println("|________________________________________|");
        System.out.println("|            Modify Options:             |");
        System.out.println("|   1 - Modify User's Profile            |");
        System.out.println("|   2 - Modify User's Location           |");
        System.out.println("|   3 - Modify Character's Location      |");
        System.out.println("|   4 - Modify Item's Price              |");
        System.out.println("|   0 - Back                             |");
    }

    public static void registerOp() {
        System.out.println("|________________________________________|");
        System.out.println("|            Registry Options:           |");
        System.out.println("|   1 - Register new User                |");
        System.out.println("|   2 - Register new Character           |");
        System.out.println("|   3 - Register new Item                |");
        System.out.println("|   4 - Check User Registration          |");
        System.out.println("|   0 - Back                             |");
    }

    public static void mainOptions() {
        System.out.println("|________________________________________|");
        System.out.println(" ________________________________________ ");
        System.out.println("|                                        |");
        System.out.println("|           Choose an option:            |");
        System.out.println("|                                        |");
        System.out.println("|   1 - Register Options  -->            |");
        System.out.println("|   2 - Modify Options  -->              |");
        System.out.println("|   3 - Users on specific location       |");
        System.out.println("|   4 - Item Options  -->                |");
        System.out.println("|   5 - Lists  -->                       |");
        System.out.println("|   0 - Exit                             |");
    }

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
