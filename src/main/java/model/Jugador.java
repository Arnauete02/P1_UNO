package model;

import lombok.Data;

@Data
public class Jugador {
    private int id;
    private String usuario;
    private String password;
    private String nombre;
    private int partidas;
    private int ganadas;
}
