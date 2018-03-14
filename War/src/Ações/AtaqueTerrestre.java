/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ações;

import Controladores.Principal;
import ControleJogo.TurnoMaquina;
import Dados.Exercito;
import Dados.Jogador;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rickh
 */
public class AtaqueTerrestre extends Action{
    int quantidadeDefesa;
    
    @Override
    public void executar() {
        String str = new String();
        str = "<html><center>";
        //Computa os dados da defesa
        int[] JogadaDadosDefesa = new int[3];
        for(int i =0; i<quantidadeDefesa; i++){
            JogadaDadosDefesa[i] = getDestino().getExercitosTerrestres().get(i).combater();
            System.out.print("Defesa : " + JogadaDadosDefesa[i]);
        }
        //Computa os dados do ataque
        List<Exercito> exe = getExercitosAtivos().get(getOrigem());
        int quantidadeEnviadaAoAtaque = exe.size();
        int[] JogadaDadosAtaque = new int[3];
        for(int i = 0; i < exe.size(); i++){
            JogadaDadosAtaque[i] = exe.get(i).combater();
            System.out.print("Ataque : " + JogadaDadosAtaque[i]);
        }
        //Ordena ambos os conjuntos de dados em ordem Ascendente
        Arrays.sort(JogadaDadosDefesa);
        Arrays.sort(JogadaDadosAtaque);

        //Percorre até 3 posições
        for(int i=2; i>=0; i--){
            //Se uma das posições for zero, significa que não houve sorteio
            if(JogadaDadosAtaque[i]==0 || JogadaDadosDefesa[i]==0){
                break;
            }
            str += "O Ataque tirou " + JogadaDadosAtaque[i] + " e a Defesa tirou " + JogadaDadosDefesa[i] + "<br>";
            //Caso o ataque vença
            if(JogadaDadosAtaque[i]>JogadaDadosDefesa[i]){
                getDestino().removerExercito(getDestino().getExercitosTerrestres().get(0));
                str += getDestino().getNome() + " perdeu 1 Exército Terrestre <br>";
            }else{//Caso a defesa vença
                getOrigem().removerExercito(getOrigem().getExercitosTerrestres().get(0));
                str += getOrigem().getNome() + " perdeu 1 Exército Terrestre <br>";
            } 
        }
        boolean vitoria = false;
        if(getDestino().getTotalExercitosTerrestres()==0){
            vitoria = true;
            //Mudar a posse do território
            Jogador vencedor = Principal.getJogadorViaCor(getOrigem().getCor()), perdedor = Principal.getJogadorViaCor(getDestino().getCor());
            vencedor.adicionarTerritorio(getDestino());
            perdedor.removerTerritorio(getDestino());
            str += "<font color=\"red\">O Ataque venceu!</font>";
        }else{
            str += "<font color=\"red\">A Defesa conteve o Ataque!</font>";
        }
        str += "</center></html>";
        posBatalha(str, quantidadeEnviadaAoAtaque, vitoria);
    }

    public void setQuantidadeDefesa(int quantidadeDefesa) {
        this.quantidadeDefesa = quantidadeDefesa;
    }
    
    /**
     * Método chamado após a execução da Ação. Informa a interface gráfica (jogador humano) do ocorrido.
     * @param str String que informará o jogador do ocorrido
     * @param qtdPermitidaMover Quantidade de exércitos que será permitida para movimentação posterior caso haja vitória
     * @param vitoria Booleano que indica se houve vitória (conquista de território) no ataque
     */
    private void posBatalha(String str, int qtdPermitidaMover, boolean vitoria){
        Principal.gui.setRetornoAction(this, str);
        if(vitoria){
            Jogador vencedor = Principal.getJogadorViaCor(getOrigem().getCor());
            if(vencedor.getTipo() == Jogador.HUMANO)
                Principal.gui.possibilitarMover(qtdPermitidaMover, this);
            else
                TurnoMaquina.moverAposVencer(this);
            vencedor.verificarVitoria();
        }                   
    }
    
    @Override
    public String getTipo() {
        return "Ataque Terrestre";
    }
}
