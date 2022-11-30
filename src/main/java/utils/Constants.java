package utils;

public class Constants {
    public final String SCHEMA_NAME = "dam2tm06uf2p1";
    public final String CONNECTION = "jdbc:mysql://localhost:3306/" +
            SCHEMA_NAME +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    public final String USER_CONNECTION = "root";
    public final String PASS_CONNECTION = "root";

    //QUERY's

    public final String QUERY_robarCarta =
            "SELECT ifnull(id, 0) AS id, id_jugador, numero, color" +
                    "FROM carta";

    public final String QUERY_comprobacionUsuario =
            "SELECT count(id) FROM jugador" +
                    " WHERE usuario = ?";

    public final String QUERY_comprobacionPassword =
            "SELECT count(id) FROM jugador" +
                    " WHERE usuario = ? AND password = ?";

    public final String QUERY_ultimaCarta =
            "SELECT carta.id, carta.id_jugador, carta.numero, carta.color, partida.estat" +
                    " FROM partida" +
                    " LEFT JOIN carta ON partida.id_carta = carta.id" +
                    " ORDER BY id DESC" +
                    " LIMIT 1;";
}
