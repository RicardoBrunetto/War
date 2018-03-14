/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleJogo;

import Ações.Action;
import Ações.AtaqueAereo;
import Ações.AtaqueTerrestre;
import Ações.Remanejo;
import Controladores.Mapa;
import Dados.Aereo;
import Dados.Exercito;
import Dados.Jogador;
import Dados.Terrestre;
import Dados.Territorio;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rickh
 */
public class TurnoMaquina {
    private static Random rnd;
    
    /**
     * Método que executa a defesa (seleciona exércitos) da Máquina
     * @param a A ação que está atacando a máquina
     * @param sobAtaque O território da Máquina que está sob ataque
     * @return Um conjunto de exércitos para executar a defesa do território
     */
    public static ArrayList<Exercito> executarDefesa(Action a, Territorio sobAtaque){
        int qtdMax, tipo;
        if(a instanceof AtaqueTerrestre){
            qtdMax = sobAtaque.getTotalExercitosTerrestres(); tipo = 0;
        }else{
            qtdMax = sobAtaque.getTotalExercitosAereos(); tipo = 1;
        }
        if(qtdMax > 3) qtdMax = 3;
        ArrayList<Exercito> defesas = new ArrayList<>();
        for(int i=0; i<qtdMax; i++){
            if(tipo == 0)
                defesas.add(sobAtaque.getExercitosTerrestres().get(i));
            else if (tipo == 1)
                defesas.add(sobAtaque.getExercitosAereos().get(i));
        }
        return defesas;
    }
    
    /**
     * Método que distribui os Exércitos da máquina automaticamente em seus territórios
     * @param maquina O jogador que terá seus exércitos automaticamente distribuídos
     */
    public static void distribuirExecitos(Jogador maquina){
        while(maquina.getTotalExercitosDisponiveis() > 0){
            rnd = new Random();
            int index = rnd.nextInt((maquina.getTotalTerritoriosPossuidos() -1) + 1);
            int quantidadeTerrestre = rnd.nextInt(maquina.getTotalTerrestreDisponiveis()+1), quantidadeAereo = rnd.nextInt(maquina.getTotalAereoDisponiveis() +1);
            for(int i=0; i<quantidadeAereo; i++){
                maquina.adicionarAereoAoTerritorio(maquina.getTerritoriosPossuidos().get(index));
            }
            for(int j=0; j<quantidadeTerrestre; j++){
                maquina.adicionarTerrestreAoTerritorio(maquina.getTerritoriosPossuidos().get(index));
            }
        }
    }
    
    /**
     * Método que seleciona uma Ação randomicamente e a preenche com Origem e Destino válidos.
     * Caso a máquina opte por passar a vez, a ação retornará null.
     * @param maquina Jogador que selecionará a Ação randomicamente
     * @param mapa O mapa, para as verificações de validade de Origem e Destino
     * @param houveRemanejo Booleano que, caso ativado, impedirá que uma ação de Ataque seja escolhida
     * @return A Ação selecionada randomicamente e preenchida
     */
    public static Action selecionarAcao(Jogador maquina, Mapa mapa, boolean houveRemanejo){
        Action action;
        rnd = new Random();
        ArrayList<Territorio> validas = new ArrayList<>();
        do{
            int escolha = rnd.nextInt(10);
            if(escolha % 10 == 5 || escolha % 10 == 6 ||escolha % 10 == 7 || escolha % 10 == 8 || escolha % 10 == 9){
                if(!houveRemanejo)
                    action = new AtaqueTerrestre();
                else
                    action = null;
            }else if(escolha % 10 == 1 || escolha % 10 == 2 || escolha % 10 == 3 || escolha % 10 == 4){
                if(!houveRemanejo)
                    action = new AtaqueAereo();
                else
                    action = null;
            }else{
                action = new Remanejo(true);
            }
            validas = mapa.getOrigensValidas(maquina.getTerritoriosPossuidos(), action);
        }while(validas.isEmpty());
        
        if(action == null) return action;
        
        int escOrigem = rnd.nextInt((validas.size() - 1) +1);
        action.setOrigem(validas.get(escOrigem));
        System.out.print(action.getOrigem().getNome());
        validas = mapa.getFronteirasValidas(action.getOrigem(), action);
        int escDestino = rnd.nextInt((validas.size() - 1) +1);
        action.setDestino(validas.get(escDestino));
        
        action.printar();
        
        int qtdMax;
        if(action instanceof AtaqueTerrestre){
            qtdMax = action.getOrigem().getTotalExercitosTerrestres() - 1;
            System.out.print("\nQtdMax: " + qtdMax);
            if(qtdMax > 3) qtdMax = 3;
            for(int i=0; i<qtdMax; i++){
                System.out.print("\nAdicionando Terrestre");
                action.addExercitoAtivo(action.getOrigem(), action.getOrigem().getExercitosTerrestres().get(i));
            }
        }else if(action instanceof AtaqueAereo){
            qtdMax = action.getOrigem().getTotalExercitosAereos();
            System.out.print("\nQtdMax: " + qtdMax);
            if(qtdMax > 3) qtdMax = 3;
            for(int i=0; i<qtdMax; i++){
                System.out.print("\nAdicionando Aereo");
                action.addExercitoAtivo(action.getOrigem(), action.getOrigem().getExercitosAereos().get(i));
            }
        }else if(action instanceof Remanejo){
            ArrayList<Aereo> aereosMovimentaveis = action.getOrigem().getAereosMovimentaveis();
            System.out.print("\naereosMovimentaveis: " + aereosMovimentaveis.size());
            ArrayList<Terrestre> terrestresMovimentaveis = action.getOrigem().getTerrestresMovimentaveis();
            System.out.print("\nterrestresMovimentaveis: " + terrestresMovimentaveis.size());
            int qtdAereo = aereosMovimentaveis.size() == 0 ? 0 : aereosMovimentaveis.size();
            System.out.print("\nQtdAereo: " + qtdAereo);
            int qtdTerrestre = terrestresMovimentaveis.size() > 1 ? terrestresMovimentaveis.size()-1 : 0; 
            System.out.print("\nQtdTerrestre: " + qtdTerrestre);
            for(int i=0; i<qtdAereo; i++){
                System.out.print("\nAdicionando Aereo");
                action.addExercitoAtivo(action.getOrigem(), aereosMovimentaveis.get(i));
            }
            for(int i=0; i<qtdTerrestre; i++){
                System.out.print("\nAdicionando Aereo");
                action.addExercitoAtivo(action.getOrigem(), terrestresMovimentaveis.get(i));
            }
        }        
        
     /*   if(action.getExercitosAtivos().isEmpty())
            System.out.printf("Enviando vazio de Continentes");
        for(Territorio t : action.getExercitosAtivos().keySet()){
            System.out.printf("\n" + t.getNome());
            for(Exercito e : action.getExercitosAtivos().get(t))
                System.out.printf("\t e");
        }
                
        if(action.getExercitosAtivos().get(action.getOrigem()).isEmpty())
            System.out.printf("Enviando vazio de Exercitos");
              */
        return action;
    }
    
    /**
     * Método que realiza uma movimentação de Exércitos da Origem para o Destino quando a máquina vence um Ataque Terrestre.
     * A quantidade a ser transferida depende da quantidade que sobreviveu ao ataque.
     * @param action A ação de Ataque Terrestre que resultou na vitória.
     */
    public static void moverAposVencer(Action action){
        Remanejo rem = new Remanejo(false);
        int qtdSobrou = rnd.nextInt((action.getExercitosAtivos().get(action.getOrigem()).size() - 1)+1)+1;
        for(int i=0;i<qtdSobrou; i++)
            rem.addExercitoAtivo(action.getOrigem(), action.getExercitosAtivos().get(action.getOrigem()).get(i));
        rem.setOrigem(action.getOrigem());
        rem.setDestino(action.getDestino());
        rem.executar();
    }
    
}