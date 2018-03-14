package Dados;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by GustavoLuiz on 05/01/2017.
 */

public enum Cor {
    VERMELHO(255,64,64), AZUL(100, 149, 237), AMARELO(255,236,139), VERDE(124,205,124), ROSA(255,105,180), ROXO(224,102,255), NEUTRO(0, 191, 255);
    
    private int red, green, blue;
    
    Cor(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
        
    /**
     * Método que sorteia uma cor para um jogador e garante que ela já não tenha sido utilizada.
     * @param jogadores A lista de jogadores para comparações de cor
     * @return Uma Cor ainda não utilizada
     */
    public static Cor getRandomColor(ArrayList<Jogador> jogadores) {
        Random random = new Random();
        boolean unico;
        Cor cor;
        do{
            unico = true;
            cor = values()[random.nextInt(values().length-1)]; //A seleção vai até o penúltimo elemento pois não deve ser escolhida a cor NEUTRO
            for(Jogador j : jogadores){
                if(j.getCor() == cor){
                    unico = false;
                }
            }
        }while(unico == false);
        return cor; 
    }
    
    /**
     * Método que retorna um objeto do tipo Color gerado pelo RGB da Cor
     * @return Objeto Color gerado pelo RGB da Cor
     */
    public Color getColor(){
        return new Color(red, green, blue);
    }
    
    /**
     * Método que possibilita obter a cor para utilizar na formatação HTML dos textos
     * @return String contendo a Cor em formato RGB
     */
    public String getRGB(){
        return red + "," + green + "," + blue;
    }
}
