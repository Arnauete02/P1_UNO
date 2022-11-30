package utils;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Enum {
    public enum Color {
        ROJO, AMARILLO, VERDE, AZUL, NEGRO;

        private static Color randomColor(){
            Color[] colors = values();
            return colors[RANDOM.nextInt(colors.length)];
        }
    }
    public enum Numero {
        CERO,UNO,DOS,TRES,CUATRO,CINCO,SEIS,SIETE,OCHO,NUEVE,CAMBIO,MASDOS,SALTO,CAMBIOCOLOR,MASCUATRO;

        private static Numero randomNumero(){
            Numero[] numeros = values();
            return numeros[RANDOM.nextInt(numeros.length)];
        }
    }

    private static final Random RANDOM = new Random();

    public static Map<Numero, Color> random(){
        Color color;
        Map<Numero, Color> numeroColorMap = new HashMap<>();

        Numero numero = Numero.randomNumero();

        if (numero == Numero.CAMBIOCOLOR || numero == Numero.MASCUATRO) color = Color.NEGRO;
        else color = Color.randomColor();

        numeroColorMap.put(numero, color);

        return numeroColorMap;
    }
}
