import controller.Controller;
import utils.Enum;
import utils.Enum.Numero;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        (new Controller()).init();
    }
}
