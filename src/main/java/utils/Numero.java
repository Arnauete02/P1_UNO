package utils;

import java.util.Random;

public enum Numero {
    CERO,UNO,DOS,TRES,CUATRO,CINCO,SEIS,SIETE,OCHO,NUEVE,CAMBIO,MASDOS,SALTO,CAMBIOCOLOR,MASCUATRO;

    private static final Random RANDOM = new Random();

    private static Numero randomNumero(){
        Numero[] numeros = values();
        return numeros[RANDOM.nextInt(numeros.length)];
    }
}
