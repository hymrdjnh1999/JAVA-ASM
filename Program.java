
import java.io.IOException;

import Views.Menu;

/**
 * Program
 */
public class Program {

    public static void main(String[] args) throws NullPointerException {
        try {
            Menu.MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}