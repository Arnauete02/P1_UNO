package dao;

import model.Carta;
import utils.Constants;
import utils.Enum;

import java.sql.*;
import java.util.*;

public class Database {
    private Connection connection;
    private Constants constants;

    public Database() {
        this.constants = new Constants();
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(constants.CONNECTION, constants.USER_CONNECTION, constants.PASS_CONNECTION);
    }

    public void disconnect() throws SQLException{
        if (connection != null) connection.close();
    }

    public Carta robarCarta() throws SQLException{
        Carta carta;

        try(Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(constants.QUERY_robarCarta)){
                carta = Carta.builder()
                        .id(resultSet.getInt(1))
                        .build();
            }
        }

        Map<Enum.Numero, Enum.Color> numeroColorMap = Enum.random();

        Set<Enum.Numero> numeros = numeroColorMap.keySet();
        for (Enum.Numero numero : numeros){
            carta.setNumero(numero);
        }

        Collection<Enum.Color> colors = numeroColorMap.values();
        for (Enum.Color color : colors){
            carta.setColor(color);
        }

        return carta;
    }

    public boolean comprobacionUsuario(String usuario) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.QUERY_comprobacionUsuario)){
            preparedStatement.setString(1, usuario);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    if (resultSet.getInt(1) != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean comprobacionPassword(String usuario, String password) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(constants.QUERY_comprobacionPassword)){
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    if (resultSet.getInt(1) != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Map<Carta, Integer> ultimaCarta() throws SQLException {
        Carta carta = Carta.builder().build();

        Map<Carta, Integer> map = new HashMap<>();

        try (Statement statement = connection.createStatement()){
            try (ResultSet resultSet = statement.executeQuery(constants.QUERY_ultimaCarta)){
                while (resultSet.next()){
                    carta = Carta.builder()
                            .id(resultSet.getInt(1))
                            .id_jugador(resultSet.getInt(2))
                            .build(); //TODO -> Mirar como hacer para añadir ENUMS

                    map.put(carta, resultSet.getInt(5));
                }
            }
        }

        return map;
    }
}
