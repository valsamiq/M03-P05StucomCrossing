package m03.p05stucomcrossing;

import dao.StuCrossDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * @author balsamiq
 */
public class M03P05StucomCrossing {

    public static void main(String[] args) {
        StuCrossDAO stuCrossDAO = new StuCrossDAO();
        
        System.out.println("Trying connection with the db");
        try {
            stuCrossDAO.connect();
            System.out.println("Connection Estabished");
        } catch (SQLException ex) {
            System.out.println("Error al conectar / desconectar: " + ex.getMessage());
        }
    }
    
    private static boolean mainMenu(String op){
        boolean bnd = true;
        return bnd;
    }

    //Backgroud Resources
    //-------------------------------------------------------------------------- 
    private static String pedStr(String mensaje) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String text = "";
        boolean bnd = true;
        do {
            System.out.print(mensaje);
            try {
                text = teclado.readLine();
                if (text.equals("")) {
                    System.out.println("| [!]         Valor en Blanco        [!] |");
                } else {
                    bnd = false;
                }
            } catch (IOException ex) {
                System.out.println("| [!]    Error de entrada y salida   [!] |");
            }
        } while (bnd);
        return text;
    }

    private static int pedInt(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op = 0;
        boolean bnd = true;
        do {
            try {
                System.out.print(mensaje);
                op = Integer.parseInt(br.readLine());
                bnd = false;
            } catch (IOException ex) {
                System.out.println("| [!]    Error de entrada y salida   [!] |");
            } catch (NumberFormatException ex) { //error de format solicitat
                System.out.println("| [!]     Numero ENTERO requerido    [!] |");
            }
        } while (bnd == true);
        return op;
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
