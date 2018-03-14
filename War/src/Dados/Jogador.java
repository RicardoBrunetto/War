package Dados;

import Controladores.Principal;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by rickh on 11/01/2017.
 */
public class Jogador {

    public static final int HUMANO = 0, COMPUTADOR = 1;

    private ArrayList<Territorio> territoriosPossuidos; //Lista com os territórios que o Jogador possui (estão com a cor dele)
    private ArrayList<Terrestre> terrestresDisponiveis; //Lista com os exércitos terrestres que ele possui disponívieis
    private ArrayList<Aereo> aereosDisponiveis; //Lista com os exércitos aereos que ele possui disponívieis
    private Map<Continente, Integer> qtdTerritoriosCadaContinente;  
    private Cor cor; // Define a cor do jogador
    private int tipo; // Define se o jgoador é Humano ou Computador

    public Jogador(int tipo){
        qtdTerritoriosCadaContinente = new EnumMap<Continente, Integer>(Continente.class);
        qtdTerritoriosCadaContinente.put(Continente.AFRICA, 0);
        qtdTerritoriosCadaContinente.put(Continente.AMERICA_DO_NORTE, 0);
        qtdTerritoriosCadaContinente.put(Continente.AMERICA_DO_SUL, 0);
        qtdTerritoriosCadaContinente.put(Continente.ASIA, 0);
        qtdTerritoriosCadaContinente.put(Continente.OCEANIA, 0);
        qtdTerritoriosCadaContinente.put(Continente.EUROPA, 0);
        
        territoriosPossuidos = new ArrayList();
        terrestresDisponiveis = new ArrayList();
        aereosDisponiveis = new ArrayList();
        this.tipo = tipo;
    }
    
    public void adicionarTerritorio(Territorio territorio){
        territoriosPossuidos.add(territorio);
        territorio.setCor(cor);
        qtdTerritoriosCadaContinente.put(territorio.getContinente(), (qtdTerritoriosCadaContinente.get(territorio.getContinente()) + 1));
    }
    
    public void removerTerritorio(Territorio territorio){
        territoriosPossuidos.remove(territorio);
        qtdTerritoriosCadaContinente.put(territorio.getContinente(), (qtdTerritoriosCadaContinente.get(territorio.getContinente()) - 1));
    }
    
    /**
     * Método que calcula quantos exércitos há, no total, em todos os territórios do jogador
     * @return Um vetor de inteiro com duas posições, onde a primeira posição refere-se à quantidade de exércitos terrestres totais, e a segunda refere-se à quantidade de exércitos aéreos totais.
     */
    public int[] getTotalExercitosNosTerritorios(){
        int aereos = 0, terrestres = 0, totais[] = new int[2];

        for(Territorio k : territoriosPossuidos){
            aereos += k.getTotalExercitosAereos();
            terrestres += k.getTotalExercitosTerrestres();
        }

        totais[0] = terrestres; totais[1] = aereos;
        return totais;
    }

    public ArrayList<Territorio> getTerritoriosPossuidos() {
        return territoriosPossuidos;
    }

    public int getTotalExercitosDisponiveis(){
        return getTotalAereoDisponiveis() + getTotalTerrestreDisponiveis();
    }

    public int getTotalAereoDisponiveis(){
        return aereosDisponiveis.size();
    }

    public int getTotalTerrestreDisponiveis(){
        return terrestresDisponiveis.size();
    }

    public int getTotalTerritoriosPossuidos(){return territoriosPossuidos.size();}

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public Map<Continente, Integer> getQtdTerritoriosCadaContinente() {
        return qtdTerritoriosCadaContinente;
    }
    
    /**
     * Método que adiciona um exército terrestre ao contingente de um território específico
     * @param territorio O território que deve receber o exército.
     */
    public void adicionarTerrestreAoTerritorio(Territorio territorio){
        if(terrestresDisponiveis.size() > 0){
            territorio.adicionarExercito(terrestresDisponiveis.get(0));
            terrestresDisponiveis.remove(0);
        }
            
    }
    
    /**
     * Método que adiciona um exército aéreo ao contingente de um território específico
     * @param territorio O território que deve receber o exército.
     */
    public void adicionarAereoAoTerritorio(Territorio territorio){
        if(aereosDisponiveis.size() > 0){
            territorio.adicionarExercito(aereosDisponiveis.get(0));
            aereosDisponiveis.remove(0);
        }
    }
    
    /**
     * Método que adiciona uma quantidade específica de exércitos aéreos ao contingente disponível do jogador
     * @param quantidade Quantidade de exércitos aéreos que deve ser adicionada como disponível
     */
    public void adicionarDisponiveisAereos(int quantidade){
        for(int i=0; i<quantidade; i++)
            aereosDisponiveis.add(new Aereo());
    }
    
    /**
     * Método que adiciona uma quantidade específica de exércitos terrestres ao contingente disponível do jogador
     * @param quantidade Quantidade de exércitos terrestres que deve ser adicionada como disponível
     */
    public void adicionarDisponiveisTerrestres(int quantidade){
        for(int i=0; i<quantidade; i++)
            terrestresDisponiveis.add(new Terrestre());
    }
    
    /**
     * Método que transforma todos os exércitos do jogador em não-movimentados, permitindo que eles sejam válidos para remanejo.
     */
    public void zerarMovimentacoes(){
        for(Territorio t : territoriosPossuidos){
            for(Exercito e : t.getExercitosAereos())
                e.setMovimentado(false);
            for(Exercito e : t.getExercitosTerrestres())
                e.setMovimentado(false);
        }
    }
    
    /**
     * Método que verifica se o jogador venceu.
     */
    public void verificarVitoria(){
        int quantidadeContinentesConquistados = 0;
        for(Continente c : qtdTerritoriosCadaContinente.keySet()){
            if(c.getQuantidadeTerritorios() == qtdTerritoriosCadaContinente.get(c)){
                quantidadeContinentesConquistados++;
            }
        }
        if(quantidadeContinentesConquistados >= 2){
            Principal.declararVitoria(this);
        }
    }
}
