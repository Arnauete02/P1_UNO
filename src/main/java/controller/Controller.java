package controller;

import dao.Database;
import model.Carta;
import utils.Constants;
import utils.Enum;
import utils.ExcepcionsUno;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class Controller {

    private Database database;
    private ExcepcionsUno excepcionsUno;
    private Scanner scanner;

    public Controller(){
        this.database = new Database();
        this.scanner = new Scanner(System.in);
    }

    public void init() throws  SQLException{
        printPartida();
    }

    public void printPartida() throws SQLException {
        try {
            database.connect();
        } catch (SQLException e) {
            System.out.println(excepcionsUno.ERROR_CONNECTION);
        }

        System.out.println("Introduce tu usuario:");
        String usuario = scanner.nextLine();

        if (database.comprobacionUsuario(usuario)) {
            System.out.println("Introduce tu password:");
            String password = scanner.nextLine();

            if (database.comprobacionPassword(usuario, password)) {
                System.out.println("\n---- PARTIDA INICIADA -----\n");

                Map<Carta, Integer> mapUltimaCarta = database.ultimaCarta();

                Carta ultimaCarta = Carta.builder().build();
                for (Carta carta : mapUltimaCarta.keySet()) {
                    ultimaCarta = carta;
                }
                int estat = 0;
                for (int i : mapUltimaCarta.values()) {
                    estat = i;
                }

                System.out.println("ÚLTIMA CARTA JUGADA -> " + ultimaCarta.toString());

                if (ultimaCarta.getNumero() == null) {

                } else if (ultimaCarta.getNumero() == Enum.Numero.MASDOS) {
                    comprobacionNumeroCarta(Enum.Numero.MASDOS, estat);
                } else if (ultimaCarta.getNumero() == Enum.Numero.MASCUATRO) {
                    comprobacionNumeroCarta(Enum.Numero.MASCUATRO, estat);
                } else if (ultimaCarta.getNumero() == Enum.Numero.SALTO || ultimaCarta.getNumero() == Enum.Numero.CAMBIO) {
                    if (ultimaCarta.getNumero() == Enum.Numero.SALTO) comprobacionNumeroCarta(Enum.Numero.SALTO, estat);
                    if (ultimaCarta.getNumero() == Enum.Numero.CAMBIO) comprobacionNumeroCarta(Enum.Numero.CAMBIO, estat);
                }
            }
        }
    }

    public void comprobacionNumeroCarta(Enum.Numero numero, int estat) {
        if (estat == 0 && numero == Enum.Numero.MASDOS) {

        } else if (estat == 0 && numero == Enum.Numero.MASCUATRO) {

        } else if (estat == 0 && (numero == Enum.Numero.SALTO || numero == Enum.Numero.CAMBIO)) {

        } else {

        }
    }
}
