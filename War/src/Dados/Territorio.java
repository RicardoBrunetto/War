package Dados;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Created by GustavoLuiz on 03/01/2017.
 */
public class Territorio {
    private ImageIcon imagem;
    private String nome;
    private Cor cor;
    private Continente continente;
    private int posX, posY;
    private ArrayList<Aereo> exercitosAereos;
    private ArrayList<Terrestre> exercitosTerrestres;

    public Territorio() {
        exercitosAereos = new ArrayList();
        exercitosTerrestres = new ArrayList();
    }

    public int getTotalExercitosNoTerritorio(){
        return (exercitosAereos.size() + exercitosTerrestres.size());
    }

    public int getTotalExercitosAereos(){ return exercitosAereos.size();}

    public int getTotalExercitosTerrestres(){ return exercitosTerrestres.size();}
    
    public ImageIcon getImagem() {
        return imagem;
    }
    
    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setContinente(Continente cont){
        this.continente=cont;
    }

    public Continente getContinente(){
        return this.continente;
    }

    public void setCor(Cor cor){
        this.cor=cor;
    }

    public Cor getCor(){
        return this.cor;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public ArrayList<Aereo> getExercitosAereos() {
        return exercitosAereos;
    }

    public ArrayList<Terrestre> getExercitosTerrestres() {
        return exercitosTerrestres;
    }
       
    /**
     * Método que adiciona um exército ao contingente do território
     * @param exercito Exército a ser adicionado.
     */
    public void adicionarExercito(Exercito exercito){
        if(exercito instanceof Terrestre){
            exercitosTerrestres.add((Terrestre)exercito);
        }else{
            exercitosAereos.add((Aereo)exercito);
        }
    }
    
    /**
     * Método que remove um exército do contingente do território
     * @param exercito Exército a ser removido.
     */
    public void removerExercito(Exercito exercito){
        if(exercito instanceof Terrestre){
            exercitosTerrestres.remove((Terrestre)exercito);
        }else{
            exercitosAereos.remove((Aereo)exercito);
        }
    }
    
    /**
     * Método que retorna um subconjunto dos exércitos aéreos que está no território que ainda não foram movimentados (remanejados)
     * @return Subconjunto de exércitos aéreos válido para remanejo
     */
    public ArrayList<Aereo> getAereosMovimentaveis(){
        ArrayList<Aereo> total = new ArrayList<>();
        for(Aereo e : exercitosAereos)
            if(!e.isMovimentado())
                total.add(e);
        return total;
    }
    
    /**
     * Método que retorna um subconjunto dos exércitos terrestres que está no território que ainda não foram movimentados (remanejados)
     * @return Subconjunto de exércitos terrestres válido para remanejo
     */
    public ArrayList<Terrestre> getTerrestresMovimentaveis(){
        ArrayList<Terrestre> total = new ArrayList<>();
        for(Terrestre e : exercitosTerrestres)
            if(!e.isMovimentado())
                total.add(e);
        return total;
    }
  
}
