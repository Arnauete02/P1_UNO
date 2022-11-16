package model;

import lombok.Data;
import utils.Color;
import utils.Numero;

@Data
public class Carta {
    private int id;
    private int id_jugador;
    private Numero numero;
    private Color color;
}
