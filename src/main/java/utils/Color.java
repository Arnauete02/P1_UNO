package utils;

import java.util.Random;

public enum Color {
    ROJO, AMARILLO, VERDE, AZUL, NEGRO;

    private static final Random RANDOM = new Random();

    private static Color randomNumero(){
        Color[] colors = values();
        return colors[RANDOM.nextInt(colors.length)];
    }
}
