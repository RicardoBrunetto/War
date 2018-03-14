package ControleJogo;

import Ações.Action;
import Ações.Remanejo;
import Controladores.Mapa;
import Controladores.Principal;
import static Controladores.Principal.jogadores;
import Dados.Jogador;
import Dados.Territorio;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static Dados.Jogador.HUMANO;
import GUI.PrincipalGUI;

/**
 * Created by rickh on 24/01/2017.
 */
public class Turno {
    Jogador jogadorAtual; Rodada atual; boolean primeiraVez; public static boolean movimentacao; private static int qtdMov;
    
    public Turno(Jogador jogadorAtual, Rodada atual, boolean primeiraVez) {
        this.jogadorAtual = jogadorAtual;
        this.atual = atual;
        this.primeiraVez = primeiraVez;
        System.out.print("\nÉ a vez do Jogador " + jogadorAtual.getCor());
    }
    
    public void iniciar(){
        movimentacao = false;
        qtdMov = 0;
        jogadorAtual.zerarMovimentacoes();
        if(!primeiraVez){
            int qtdTerritorios = jogadorAtual.getTotalTerritoriosPossuidos();
            jogadorAtual.adicionarDisponiveisTerrestres(qtdTerritorios/2);
            jogadorAtual.adicionarDisponiveisAereos(qtdTerritorios/3);
        }
        if(jogadorAtual.getTipo() == HUMANO){
           Principal.gui.iniciarRodada(atual);
        }else{ // Jogada da Máquina
            TurnoMaquina.distribuirExecitos(jogadorAtual);
            proximaAction();
        }
    }
    
    /**
     * Método que chama a próxima ação a ser executada, não permitindo mais que 5 ações seguidas da CPU ou Ataques após Remanejamentos
     */
    public void proximaAction(){
        System.out.print("\nChamando próxima ação: " + movimentacao);
        qtdMov++;
        if(qtdMov > 5){
            fim();   
            return;
        }
        Action action = null;
        action = TurnoMaquina.selecionarAcao(jogadorAtual, Principal.mapa, movimentacao);
        if(action instanceof Remanejo){
            movimentacao = true;
            Principal.gui.defenderDe(action, this);
        }else if(action != null){
            Principal.gui.defenderDe(action, this);
        }else{
            fim();
        }
    }    
    
    public void fim(){
        atual.proximo();
    }
}