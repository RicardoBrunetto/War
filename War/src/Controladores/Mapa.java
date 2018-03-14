package Controladores;

import Ações.*;
import Dados.Aereo;
import Dados.Continente;
import Dados.Cor;
import Dados.Jogador;
import Dados.Terrestre;
import Dados.Territorio;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Created by rickh on 11/01/2017.
 */
public class Mapa {
    
    private static final String VAZIO = "Mar";
    private static final String IMAGEM_VAZIO = "";
    
    private Territorio[][] matriz;
    private static final String[] NOME_TERRITORIOS = {"Alasca", "Vancouver", "Groenlândia", "Inglaterra", "Itália", "Suécia", VAZIO, "Vladvostok",
VAZIO, "Califórnia", "Otawa", VAZIO, "Alemanha", "Moscou", "Omsk", "Sibéria",
VAZIO, "México", "Nova York", "Nigéria", "Egito", "Oriente Médio", "Índia", "China",
"Chile", "Colômbia", VAZIO, "Congo", "Sudão", "Sumatra", "Bornéu", "Japão",
"Argentina", "Brasil", VAZIO, "África Do Sul", "Madagascar", VAZIO, "Austrália", "Nova Guiné"};
    //private static final String[] URL_IMAGENS = {};
            
    public Mapa(){
        //Método adiciona os territórios na matriz. Cada território é inicializado atribuindo-se um nome e continente. Os territórios em posições vazias recebem o nome de "Vazio" e nenhum continente é atribuído à essa posição.
        matriz = new Territorio[5][8];

        for (int i = 0; i <= 4; i++) {
            for (int k = 0; k <= 7; k++) {
                matriz[i][k] = new Territorio();                
                int linearIndex = 8*i+k;
                matriz[i][k].setNome(NOME_TERRITORIOS[linearIndex]);
                matriz[i][k].setPosX(i);
                matriz[i][k].setPosY(k);
                //matriz[i][k].setImagem(new ImageIcon(URL_IMAGENS[linearIndex])); 
                Continente cont = Continente.ASIA;
                if(linearIndex==0 || linearIndex==1 || linearIndex==2 || linearIndex == 9 || linearIndex== 10 || linearIndex==17 || linearIndex==18){
                    cont = Continente.AMERICA_DO_NORTE;
                }else if (linearIndex==3 || linearIndex==4 || linearIndex==5 || linearIndex== 12 || linearIndex==13){
                    cont = Continente.EUROPA;
                }else if (linearIndex==19 || linearIndex==20 || linearIndex==27 || linearIndex==28 || linearIndex==35 || linearIndex==36){
                    cont = Continente.AFRICA;
                }else if (linearIndex==24 || linearIndex==25 || linearIndex == 32 || linearIndex == 33){
                    cont = Continente.AMERICA_DO_SUL;
                }else if (linearIndex == 29 || linearIndex==30 || linearIndex==38 || linearIndex==39){
                    cont = Continente.OCEANIA;
                }else if (linearIndex==6 || linearIndex==8 || linearIndex== 11 || linearIndex==16 || linearIndex==26 || linearIndex==34 || linearIndex==37){
                    cont = null;
                }
                matriz[i][k].setContinente(cont);
                
                if(matriz[i][k].getNome().equals(VAZIO)){
                    matriz[i][k].setCor(Cor.NEUTRO);
                    matriz[i][k].setContinente(null);
                }
            }
        }
    }
    
    /**
     * Método que retorna um território na posição especificada
     * @param posX linha da matriz Mapa
     * @param posY coluna da matriz Mapa
     * @return Território na posição especificada
     */
    public Territorio getTerritorio(int posX, int posY) {
        return matriz[posX][posY];
    }
    
    /**
     * Método que retorna um conjunto de territórios que são válidos para serem escolhidos como Destino de uma determinada ação a partir de uma dada Origem.
     * A implementação deste método respeita as regras do jogo em relação às fronteiras e às condições mínimas para se fazer um Ataque Aéreo, Ataque Terrestre ou Remanejo.
     * Logo, o uso deste método para restringir as opções de Destino fazem com que a ação respeite as regras.
     * @param territorio Origem da ação
     * @param action Ação que se deseja executar
     * @return Territórios válidos para a Ação a partir da Origem
     */
    public ArrayList<Territorio> getFronteirasValidas(Territorio territorio, Action action){
        int posX = territorio.getPosX(), posY = territorio.getPosY();
        ArrayList<Territorio> ans = new ArrayList<>(), sec = new ArrayList();
       
        ans.add(getTerritorio(posX, posY - 1 == -1 ? 7 : (posY-1)));//esquerda
        ans.add(getTerritorio(posX, posY + 1 == 8 ? 0 : (posY+1))); //direita
        if(posX != 0)
            ans.add(getTerritorio(posX-1, posY));
        if(posX != 4)
            ans.add(getTerritorio(posX+1, posY));
        
        for(Territorio t : ans){
            if(action instanceof AtaqueTerrestre){ //Para ataque aéreo, não são válidos: Vazios e territórios próprios
                if(t.getNome().equals(VAZIO) || t.getCor() == territorio.getCor()){
                    sec.add(t);
                }
            }else if(action instanceof Remanejo){ //Para remanejo de exércitos, não são válidos: Vazios e Territórios inimigos
                if(t.getNome().equals(VAZIO) || t.getCor() != territorio.getCor()){
                    sec.add(t);
                }
            }else if(action instanceof AtaqueAereo){ //Para ataque aéreo, não são válidos: Vazios, Territórios próprios, territórios que possuam menos de 1 aéreo ou menos de 4 terrestres
                if(t.getNome().equals(VAZIO) || t.getCor() == territorio.getCor() || t.getTotalExercitosAereos() < 1 || t.getTotalExercitosTerrestres() < 4){
                    sec.add(t);
                }
            }
        }
        ans.removeAll(sec);
        return ans;
    }
    
    /**
     * Método que retorna um subconjunto de territórios válidos para serem escolhidos como Origem de uma determinada ação a partir de um conjunto de territórios possuídos.
     * Este método garante que a escolha da Origem de uma determinada ação obedece as regras e condições básicas para efetuá-la.
     * @param atuais O conjunto de territórios que o jogador possui
     * @param action A ação que se deseja realizar
     * @return Um subconjunto do conjunto de territórios que o jogador possui, cujos territórios são válidos para serem Origem da ação
     */
    public ArrayList<Territorio> getOrigensValidas(ArrayList<Territorio> atuais, Action action){
        ArrayList<Territorio> validos = new ArrayList();
        for(Territorio t : atuais){
            if(action instanceof AtaqueAereo){
                if(t.getTotalExercitosAereos() >= 1){
                    if(getFronteirasValidas(t, action).size() > 0){
                        validos.add(t);   
                    }
                }
            }else if(action instanceof AtaqueTerrestre){
                if(t.getTotalExercitosTerrestres() > 1){
                    if (getFronteirasValidas(t, action).size() > 0) {
                        validos.add(t);
                    }
                }
            }else if(action instanceof Remanejo){
                if(t.getTerrestresMovimentaveis().size() > 1 || !t.getAereosMovimentaveis().isEmpty()){
                     if(getFronteirasValidas(t, action).size() > 0){
                        validos.add(t);   
                    }
                }
            }
        }
        return validos;
    }
    
    /**
     * Método que distribui randomicamente e igualitariamente os territórios disponíveis para os jogadores.
     * @param jogadores O conjunto de jogadores nos quais se deseja distribuir os territórios.
     */
    public void distribuirTerritorios(ArrayList<Jogador> jogadores){
        ArrayList<Territorio> territorios = new ArrayList();
        for(int i=0; i<5; i++){
            for(int k=0; k<8; k++){
                if(!matriz[i][k].getNome().equals(VAZIO)){
                    matriz[i][k].adicionarExercito(new Terrestre());
                    matriz[i][k].adicionarExercito(new Aereo());
                    territorios.add(matriz[i][k]);
                }                 
            }
        }
        int times = jogadores.size(), qtdParaCadaJogador = (int)territorios.size()/jogadores.size();
        
        while(times > 0){
            int p = 0;
            while(p  < qtdParaCadaJogador){
               Random rnd = new Random();
               int k = rnd.nextInt(territorios.size());
               jogadores.get(times-1).adicionarTerritorio(territorios.get(k));
               territorios.remove(k); p++;
            }
            times--;
        }
        if(territorios.size() > 0){
            do{
                Random rnd = new Random();
                int k = rnd.nextInt(jogadores.size());
                jogadores.get(k).adicionarTerritorio(territorios.get(0));   
                territorios.remove(0);
            }while(territorios.size() > 0);
        }
    }
    
    /**
     * Retorna uma lista de territórios nos quais é possível solicitar apoio para um Ataque Aéreo a partir da Origem
     * @param terPossuidos Lista de territórios que o jogador possui
     * @param origem Território de origem do ataque aéreo
     * @return Lista de territórios que não infringem às condições de apoio aéreo
     */
    public ArrayList<Territorio> getAuxilioValido(ArrayList<Territorio> terPossuidos, Territorio origem){
        ArrayList<Territorio> resp = new ArrayList();
        //Obtém os continentes que são adjacentes ao território de origem do ataque
        ArrayList<Continente> contPermitidos = Continente.getContinentesAdjacentes(origem.getContinente());
        
        for(Territorio t : terPossuidos){
            //Adiciona os territórios que são válidos
            if(contPermitidos.contains(t.getContinente()) && t.getTotalExercitosAereos() > 0){
                resp.add(t);
            }
        }       
        return resp;
    }
    
    /**
     * Método que computa se o jogador ainda poderá efetuar algum movimento em sua vez
     * Retorna verdadeiro caso ainda seja possível executar alguma ação e falso do contrário
     * @param possuidos Lita de Territórios que o jogador possui
     * @return Indicador se o jogador ainda pode continuar a vez ou não
     */
    public boolean podeContinuar(ArrayList<Territorio> possuidos){
        if(getOrigensValidas(possuidos, new AtaqueTerrestre()).isEmpty())
            if(getOrigensValidas(possuidos, new AtaqueAereo()).isEmpty())
                if(getOrigensValidas(possuidos, new Remanejo(false)).isEmpty())
                    return false;
        return true;
    }
}
