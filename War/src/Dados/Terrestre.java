package Dados;

import java.util.Random;

/**
 * Created by GustavoLuiz on 05/01/2017.
 */
public class Terrestre extends Exercito {
    @Override
    public int combater() {
        Random rnd = new Random();
        return (rnd.nextInt((6-1)+1) + 1);
    }
    
    @Override
    public String getTipo() {
        return "Terrestre";
    }
}
