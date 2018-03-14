/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ações;

import Controladores.Principal;
import Dados.Exercito;
import Dados.Jogador;
import Dados.Territorio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author rickh
 */
public class AtaqueAereo extends Action{
          
    @Override
    public void executar() {
        //Jogada da defesa
        
        String str = new String();
        int defesa = getDestino().getExercitosAereos().get(0).combater();        
        int qtdAereos = 0;
        for(Territorio t : getExercitosAtivos().keySet())
            qtdAereos += getExercitosAtivos().get(t).size();
        
        str = "<html><center>A defesa tirou " + defesa + "!<br>";
        
        if(defesa >= qtdAereos){
            //Jogador perdeu pois todos foram todos retirados
            str += "A defesa venceu!</center></html>";
            for(Territorio t : getExercitosAtivos().keySet()){
                for(Exercito e : getExercitosAtivos().get(t)){
                    t.removerExercito(e);
                }
            }
            posBatalha(str);
            return;
        }
        
        ArrayList<Territorio> territoriosEnvolvidos = new ArrayList();
        territoriosEnvolvidos.addAll(getExercitosAtivos().keySet());
        
        //Remover "defesa" exércitos aéreos randomicamente
        Random rnd = new Random();
        for(int i=0; i<defesa; i++){
            int k = rnd.nextInt((territoriosEnvolvidos.size()-1) + 1);            
            Exercito e = getExercitosAtivos().get(territoriosEnvolvidos.get(k)).get(0);
            Territorio t = territoriosEnvolvidos.get(k);
            t.removerExercito(e);
            if(getExercitosAtivos().get(territoriosEnvolvidos.get(k)).isEmpty())
                getExercitosAtivos().remove(territoriosEnvolvidos.get(k));
            str += "Exército removido de " + t.getNome() + "<br>";
        }
                
        qtdAereos = 0;
        for(Territorio t : getExercitosAtivos().keySet())
            qtdAereos += getExercitosAtivos().get(t).size();        
        
        //Atacar com o que restou
        
        int[] resultadosAtaque = new int[qtdAereos]; int i=0;
        for(Territorio t : getExercitosAtivos().keySet()){
            for(Exercito e : getExercitosAtivos().get(t)){
                resultadosAtaque[i] = e.combater();
                i++;
            }
        }
        
        for(i=0; i<resultadosAtaque.length; i++){
            if(getDestino().getTotalExercitosTerrestres() < 4){
                str += "O ataque foi interrompido!";
                break;
            }
            str += "<br>O ataque tirou " + resultadosAtaque[i] + "!<br>";
            if(resultadosAtaque[i] != 0){
                str += getDestino().getNome() + " perdeu ";
                if(getDestino().getTotalExercitosAereos() > 0){
                    getDestino().removerExercito(getDestino().getExercitosAereos().get(0));   
                    str += "1 Exército Aéreo e ";
                }
                int j;
                for(j=0; j<resultadosAtaque[i]; j++){
                    getDestino().removerExercito(getDestino().getExercitosTerrestres().get(0));
                }
                str += resultadosAtaque[i] + " Exércitos Terrestres<br>";
            }
        }
        
        str += "</center></html>";
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
        return "Ataque Aéreo";
    }
}
