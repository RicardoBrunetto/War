package Dados;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by GustavoLuiz on 03/01/2017.
 */
public abstract class Exercito {
    private boolean movimentado;    
    
    public abstract int combater();

    public abstract String getTipo();
    
    public boolean isMovimentado() {
        return movimentado;
    }

    public void setMovimentado(boolean movimentado) {
        this.movimentado = movimentado;
    }
    
}
