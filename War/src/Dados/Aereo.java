package Dados;

import java.util.Random;

/**
 * Created by rickh on 11/01/2017.
 */
public class Aereo extends Exercito{
    @Override
    public int combater() {
        Random rnd = new Random();
        return rnd.nextInt(3+1);
    }

    @Override
    public String getTipo() {
        return "Aéreo";
    }

}
