package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import utils.Enum;

@Data
@Builder
public class Carta {
    private int id;
    private int id_jugador;
    private Enum.Numero numero;
    private Enum.Color color;
}
