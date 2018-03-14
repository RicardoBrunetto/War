package ControleJogo;

import Controladores.Mapa;
import Controladores.Principal;
import Dados.Cor;
import Dados.Exercito;
import Dados.Jogador;
import Dados.Territorio;

import java.util.ArrayList;
import ControleJogo.Turno;
import GUI.PrincipalGUI;

/**
 * Created by rickh on 11/01/2017.
 */
public class Rodada {
    
    private int indice;
    private boolean primeiraVez;

    public Rodada(boolean primeiraVez) {
        this.primeiraVez = primeiraVez;
    }
        
    public void iniciar(){
        indice = 0;
        proximo();
    }
    
    /**
     * Método que chama o turno para o próximo jogador
     */
    public void proximo(){
        if(indice >= Principal.jogadores.size()){            
            Principal.inicioDeRodada();
            return;
        }else{
            Turno turnoAtual = new Turno(Principal.jogadores.get(indice), this, primeiraVez);
            indice++;
            turnoAtual.iniciar();
        }
    }

}
    