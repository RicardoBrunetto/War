package Controladores;

import ControleJogo.Rodada;
import ControleJogo.TurnoMaquina;
import Dados.Cor;
import Dados.Jogador;
import Dados.Territorio;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import GUI.PrincipalGUI;
import com.bulenkov.darcula.DarculaLaf;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicLookAndFeel;

/**
 * Created by GustavoLuiz on 03/01/2017.
 */
public class Principal {
     
    public static ArrayList<Jogador> jogadores;
    public static Mapa mapa;
    public static PrincipalGUI gui;
    
    public static void main(String[] args) throws Exception {
        mapa = new Mapa();
                
        jogadores = new ArrayList(); //Cria uma lista de jogadores
        jogadores.add(new Jogador(Jogador.HUMANO)); // Cria o jogador humano
        jogadores.add(new Jogador(Jogador.COMPUTADOR)); //Cria o jogador computador
        
        int quantidadeTerritoriosCada = (33/jogadores.size());
        int quantidadeTerrestreInicial = quantidadeTerritoriosCada/2, quantidadeAereosInicial = quantidadeTerritoriosCada/3;
        
        for(Jogador j : jogadores){
            j.adicionarDisponiveisAereos(quantidadeAereosInicial);
            j.adicionarDisponiveisTerrestres(quantidadeTerrestreInicial);
            j.setCor(Cor.getRandomColor(jogadores)); //Seleciona as cores para cada um deles (o método garante a não-repetição)
        }
        //Distriui os territórios entre os jogadores
        mapa.distribuirTerritorios(jogadores);
        //Faz as máquinas distribuirem 
        for(Jogador j : jogadores)
            if(j.getTipo() == Jogador.COMPUTADOR)
                TurnoMaquina.distribuirExecitos(j);
                
        BasicLookAndFeel darcula = new DarculaLaf(); //Apenas para deixar o Layout mais bonito
        UIManager.setLookAndFeel(darcula);
        
       gui = new PrincipalGUI(mapa, jogadores.get(0));
       gui.setVisible(true);

        Rodada rodada = new Rodada(true);
        rodada.iniciar();
    }
    
    public static Jogador getJogadorViaCor(Cor cor){
        for(Jogador j : jogadores)
            if(j.getCor() == cor)
                return j;
        return null;
    }
    
    /**
     * Método chamado quando há o início de uma Rodada.
     * Serve para distribuir a quantidade de 
     */
    public static void inicioDeRodada(){
        System.out.print("\n\nIniciando rodada\n\n");
        Rodada rodada = new Rodada(false);
        rodada.iniciar();
    }
    
    public static void declararVitoria(Jogador jogador){
        gui.declararVitoria(jogador);
    }
}
