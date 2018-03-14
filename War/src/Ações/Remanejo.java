/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ações;

import Controladores.Principal;
import Dados.Aereo;
import Dados.Exercito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rickh
 */
public class Remanejo extends Action {
    boolean marcarMovimentacao;

    public Remanejo(boolean marcarMovimentacao) {
        this.marcarMovimentacao = marcarMovimentacao;
    }
        
    @Override
    public void executar() {
        List<Exercito> ex = getExercitosAtivos().get(getOrigem());
        String str = new String();
        str = "<html><center>";
        for(Exercito e : ex){
            str += "Movido Exército ";
            str+= e.getTipo();
            str+=" de " + getOrigem().getNome() + " para " + getDestino().getNome() + "<br>";
            getDestino().adicionarExercito(e);
            getOrigem().removerExercito(e);
            if(marcarMovimentacao)
                e.setMovimentado(true);
        }
        posBatalha(str);
    }
    
    /**
     * Método chamado após a execução da Ação. Informa a interface gráfica (jogador humano) do ocorrido.
     * @param str String que informará o jogador do ocorrido
     */
    private void posBatalha(String str){
        Principal.gui.setRetornoAction(this, str);
    }
    
    @Override
    public String getTipo() {
        return "Remanejo";
    }
}
