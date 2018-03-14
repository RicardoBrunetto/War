package Dados;

import java.util.ArrayList;

/**
 * Created by GustavoLuiz on 03/01/2017.
 */
public enum Continente {
    AFRICA("África", 6), AMERICA_DO_NORTE("América do Norte", 7), AMERICA_DO_SUL("América do Sul", 4), ASIA("Ásia", 7), EUROPA("Europa", 5), OCEANIA("Oceania", 4);

    private final String nome;
    private final int quantidadeTerritorios;
    
    Continente(String nome, int quantidadeTerritorios){
        this.nome = nome;
        this.quantidadeTerritorios = quantidadeTerritorios;
    }

    public String getNome(){
        return this.nome;
    }

    public int getQuantidadeTerritorios() {
        return quantidadeTerritorios;
    }
    
    public static ArrayList<Continente> getContinentesAdjacentes(Continente continente){
        ArrayList<Continente> ans = new ArrayList<>();
        ans.add(continente);
        if(continente == AFRICA){
            ans.add(AMERICA_DO_NORTE);
            ans.add(ASIA);
            ans.add(EUROPA);
            ans.add(OCEANIA);
        }else if(continente == AMERICA_DO_NORTE){
            ans.add(AMERICA_DO_SUL);
            ans.add(ASIA);
            ans.add(EUROPA);
            ans.add(AFRICA);
        }else if(continente == AMERICA_DO_SUL){
            ans.add(AMERICA_DO_NORTE);
            ans.add(ASIA);
            ans.add(OCEANIA);
        }else if(continente == ASIA){
            ans.add(AMERICA_DO_NORTE);
            ans.add(AMERICA_DO_SUL);
            ans.add(AFRICA);
            ans.add(EUROPA);
            ans.add(OCEANIA);
        }else if(continente == EUROPA){
            ans.add(AMERICA_DO_NORTE);
            ans.add(ASIA);
            ans.add(AFRICA);
        }else if(continente == OCEANIA){
            ans.add(AMERICA_DO_SUL);
            ans.add(ASIA);
            ans.add(AFRICA);
        }
        return ans;
    }    
    
}
