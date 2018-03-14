package Ações;

import Dados.Exercito;
import Dados.Jogador;
import Dados.Territorio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que representa uma Ação que o jogador pode executar em sua vez.
 */
public abstract class Action {    
    /**
     * São definidos os territórios de:
     * Origem: de qual Território deseja-se iniciar a ação.
     * Destino: sobre qual Território deseja-se executar a ação.
     */
    private Territorio origem, destino;
    /**
     * Este Map serve para que uma lista de Exércitos seja associada a um Território.
     * Tal medida é necessária uma vez que um Ataque Aéreo pode ser solicitado com exércitos de vários Territórios.
     * Para o Ataque Terrestre e Remanejo, este Map conterá sempre uma única chave (Território) associada a uma  lista de Exércitos.
     */
    private Map<Territorio, List<Exercito>> exercitosAtivos;

    public Action() {
        exercitosAtivos = new HashMap<>();
    }
    
    public Territorio getOrigem() {
        return origem;
    }

    public void setOrigem(Territorio origem) {
        this.origem = origem;
    }
    
    /**
     * Método que adiciona um exército à lista de Exércitos associados a um determinado Território.
     * @param t Território ao qual o Exército pertence.
     * @param e Exército que se deseja adicionar.
     */
    public void addExercitoAtivo(Territorio t, Exercito e){
        if(exercitosAtivos.get(t) == null){
            ArrayList<Exercito> exercitos = new ArrayList<>();
            exercitos.add(e);
            exercitosAtivos.put(t, exercitos);
        }else{
            exercitosAtivos.get(t).add(e);
        }
        System.out.print("Adicionando Exercito " + e.getTipo() + " ao contingente do " + t.getNome());
    }
    
    /**
     * Método que remove um exército de uma lista de Exércitos associados a um determinado Território.
     * Caso a lista fique vazia após a remoção, a chave (Território) será removida também.
     * @param t Território do qual se deseja remover um Exército.
     */
    public void removeExercitoAtivo(Territorio t){
        if(exercitosAtivos.get(t)!=null){
            exercitosAtivos.get(t).remove(0);
            if(exercitosAtivos.get(t).isEmpty())
                exercitosAtivos.remove(t);
        }
    }
    
    public Map<Territorio, List<Exercito>> getExercitosAtivos() {
        return exercitosAtivos;
    }
        
    public Territorio getDestino() {
        return destino;
    }

    public void setDestino(Territorio destino) {
        this.destino = destino;
    }
    
    /**
     * Método que, de fato, executa a ação após o preenchimento dos dados.
     * Cada ação realiza a execução de uma forma diferente.
     */    
    public abstract void executar();
    /**
     * Método que informa, via texto, o tipo da Ação, dispensando a necessidade de verificar a instância
     * @return Uma String contendo o tipo da Ação
     */
    public abstract String getTipo();
        
    public void printar(){
        String str = new String();
        str = "\n"+ getTipo() +"\nOrigem: " + getOrigem().getNome() + " | Destino: " + getDestino().getNome();
                       
        System.out.print(str);
    }     
}
