/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Mapa;
import Ações.*;
import Controladores.Principal;
import ControleJogo.Rodada;
import ControleJogo.Turno;

import ControleJogo.TurnoMaquina;
import Dados.Aereo;
import Dados.Continente;
import Dados.Exercito;
import Dados.Jogador;
import Dados.Territorio;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rickh
 */
public class PrincipalGUI extends javax.swing.JFrame {

    private static Mapa mapa;
    private static Jogador humano;
    private static Rodada rodada;
    private static Action action;
    private static Territorio suporteAereo;
    private static boolean distribuicao_Andamento = false;
    private static ArrayList<Territorio> validos;
    
    /**
     * A variável estado_jogada é responsável por coodernar o estagio do turno do jogador
     * 0 indica que o Jogador está selecionando território de Origem
     * 1 indica que o Jogador está selecionando os exércitos
     * 2 indica que o Jogador está selecionando território de Destino
     * 3 indica que o Jogador está selecionando apoio Aéreo
     * 4 indica que o ataque deve inciar
     * 5 indica que o Jogador terminou de selecionar apoio Aéreo
     */
    private static int estado_jogada = -1;
    private static boolean movimentacao = false;
    private static Turno em_defesa;
    
    /**Construtor da classe PrincipalGUI que inicializa a interface gráfica
     * @param mapa Referencia o mapa atual do jogo
     * @param humano Referencia o jogador que irá interagir com a interface gráfica
     */
    public PrincipalGUI(Mapa mapa, Jogador humano) {
        this.mapa = mapa;
        this.humano = humano;
        initComponents();
        start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLateral = new javax.swing.JPanel();
        nomeTerritorio = new javax.swing.JLabel();
        containerImagemTerritorio = new javax.swing.JPanel();
        imagemTerritorio = new javax.swing.JLabel();
        continenteTerritorio = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        corTerritorio = new javax.swing.JLabel();
        exercitosTotalTerritorio = new javax.swing.JLabel();
        painelExercitosTerritorio = new javax.swing.JSplitPane();
        exercitosTerrestresTerritorio = new javax.swing.JLabel();
        exercitosAereosTerritorio = new javax.swing.JLabel();
        painelVisaoGeral = new javax.swing.JPanel();
        listaContinentes = new javax.swing.JScrollPane();
        listaQtdContinentes = new javax.swing.JList<>();
        jogadorCor = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        lblExercitosAereosAlocados = new javax.swing.JLabel();
        lblExercitosTerrestresAlocados = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();
        painelTurno = new javax.swing.JPanel();
        btnAtaqueTerrestre = new javax.swing.JButton();
        btnAtaqueAereo = new javax.swing.JButton();
        btnRemanejo = new javax.swing.JButton();
        painelAdicionarExercitos = new javax.swing.JPanel();
        painelBotoesExercito = new javax.swing.JSplitPane();
        btnAddTerrestre = new javax.swing.JButton();
        btnAddAereo = new javax.swing.JButton();
        lblExercitosTerrestresDisponiveis = new javax.swing.JLabel();
        lblExercitosAereosDisponiveis = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        painelAction = new javax.swing.JPanel();
        painelOrigemAction = new javax.swing.JPanel();
        lblNomeOrigem = new javax.swing.JLabel();
        scrollOrigem = new javax.swing.JScrollPane();
        listExercitosOrigem = new javax.swing.JList<>();
        lblActionName = new javax.swing.JLabel();
        painelDestinoAction = new javax.swing.JPanel();
        lblNomeDestino = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listExercitosDestino = new javax.swing.JList<>();
        vezes = new javax.swing.JLabel();
        painelActionAddExercitos = new javax.swing.JPanel();
        spnActionAddExercitos = new javax.swing.JSpinner();
        lblActionAddExercitos = new javax.swing.JLabel();
        btnFinishedAction = new javax.swing.JButton();
        btnApoioAereo = new javax.swing.JButton();
        painelMove = new javax.swing.JPanel();
        lblMoveAereo = new javax.swing.JLabel();
        spnMoveAereos = new javax.swing.JSpinner();
        lblMoveTerrestre = new javax.swing.JLabel();
        spnMoveTerrestres = new javax.swing.JSpinner();
        btnCancel = new javax.swing.JButton();
        painelMoverDepoisDeVencer = new javax.swing.JPanel();
        lblMoveTerrestre2 = new javax.swing.JLabel();
        btnMoveOk = new javax.swing.JButton();
        spnMoveOk = new javax.swing.JSpinner();
        btnPassarVez = new javax.swing.JButton();
        painelMapa = new javax.swing.JPanel();
        containerMapaTerritorio = new javax.swing.JScrollPane();
        mapaTerritorio = new javax.swing.JTable();
        lblVez = new javax.swing.JLabel();
        lblComando = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("GUI/Bundle"); // NOI18N
        setTitle(bundle.getString("PrincipalGUI.title")); // NOI18N
        setResizable(false);

        painelLateral.setPreferredSize(new java.awt.Dimension(300, 0));

        nomeTerritorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeTerritorio.setText(bundle.getString("PrincipalGUI.nomeTerritorio.text")); // NOI18N

        containerImagemTerritorio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        imagemTerritorio.setText(bundle.getString("PrincipalGUI.imagemTerritorio.text")); // NOI18N

        javax.swing.GroupLayout containerImagemTerritorioLayout = new javax.swing.GroupLayout(containerImagemTerritorio);
        containerImagemTerritorio.setLayout(containerImagemTerritorioLayout);
        containerImagemTerritorioLayout.setHorizontalGroup(
            containerImagemTerritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagemTerritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        containerImagemTerritorioLayout.setVerticalGroup(
            containerImagemTerritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagemTerritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );

        continenteTerritorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        continenteTerritorio.setText(bundle.getString("PrincipalGUI.continenteTerritorio.text")); // NOI18N

        corTerritorio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        corTerritorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        corTerritorio.setText(bundle.getString("PrincipalGUI.corTerritorio.text")); // NOI18N
        corTerritorio.setToolTipText(bundle.getString("PrincipalGUI.corTerritorio.toolTipText")); // NOI18N

        exercitosTotalTerritorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exercitosTotalTerritorio.setText(bundle.getString("PrincipalGUI.exercitosTotalTerritorio.text")); // NOI18N

        painelExercitosTerritorio.setDividerLocation(145);
        painelExercitosTerritorio.setResizeWeight(0.5);
        painelExercitosTerritorio.setEnabled(false);

        exercitosTerrestresTerritorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exercitosTerrestresTerritorio.setText(bundle.getString("PrincipalGUI.exercitosTerrestresTerritorio.text")); // NOI18N
        painelExercitosTerritorio.setLeftComponent(exercitosTerrestresTerritorio);

        exercitosAereosTerritorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exercitosAereosTerritorio.setText(bundle.getString("PrincipalGUI.exercitosAereosTerritorio.text")); // NOI18N
        painelExercitosTerritorio.setRightComponent(exercitosAereosTerritorio);

        listaContinentes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        listaContinentes.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listaQtdContinentes.setEnabled(false);
        listaContinentes.setViewportView(listaQtdContinentes);

        jogadorCor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jogadorCor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jogadorCor.setText(bundle.getString("PrincipalGUI.jogadorCor.text")); // NOI18N

        lblDesc.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesc.setText(bundle.getString("PrincipalGUI.lblDesc.text")); // NOI18N

        lblExercitosAereosAlocados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExercitosAereosAlocados.setText(bundle.getString("PrincipalGUI.lblExercitosAereosAlocados.text")); // NOI18N

        lblExercitosTerrestresAlocados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExercitosTerrestresAlocados.setText(bundle.getString("PrincipalGUI.lblExercitosTerrestresAlocados.text")); // NOI18N

        javax.swing.GroupLayout painelVisaoGeralLayout = new javax.swing.GroupLayout(painelVisaoGeral);
        painelVisaoGeral.setLayout(painelVisaoGeralLayout);
        painelVisaoGeralLayout.setHorizontalGroup(
            painelVisaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelVisaoGeralLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jogadorCor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(painelVisaoGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelVisaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblExercitosAereosAlocados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblExercitosTerrestresAlocados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(painelVisaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelVisaoGeralLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(painelVisaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listaContinentes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addComponent(lblDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(16, 16, 16)))
        );
        painelVisaoGeralLayout.setVerticalGroup(
            painelVisaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelVisaoGeralLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jogadorCor)
                .addGap(29, 29, 29)
                .addComponent(lblExercitosTerrestresAlocados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblExercitosAereosAlocados)
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(painelVisaoGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelVisaoGeralLayout.createSequentialGroup()
                    .addContainerGap(109, Short.MAX_VALUE)
                    .addComponent(listaContinentes, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblDesc)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout painelLateralLayout = new javax.swing.GroupLayout(painelLateral);
        painelLateral.setLayout(painelLateralLayout);
        painelLateralLayout.setHorizontalGroup(
            painelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLateralLayout.createSequentialGroup()
                .addGroup(painelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeTerritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addComponent(continenteTerritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLateralLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(containerImagemTerritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(corTerritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exercitosTotalTerritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLateralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(painelExercitosTerritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelVisaoGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelLateralLayout.setVerticalGroup(
            painelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLateralLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(nomeTerritorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(containerImagemTerritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(continenteTerritorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corTerritorio)
                .addGap(18, 18, 18)
                .addComponent(exercitosTotalTerritorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelExercitosTerritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelVisaoGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelPrincipal.setPreferredSize(new java.awt.Dimension(845, 200));

        btnAtaqueTerrestre.setText(bundle.getString("PrincipalGUI.btnAtaqueTerrestre.text")); // NOI18N
        btnAtaqueTerrestre.setPreferredSize(new java.awt.Dimension(135, 32));
        btnAtaqueTerrestre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtaqueTerrestreMouseClicked(evt);
            }
        });

        btnAtaqueAereo.setText(bundle.getString("PrincipalGUI.btnAtaqueAereo.text")); // NOI18N
        btnAtaqueAereo.setPreferredSize(new java.awt.Dimension(135, 32));
        btnAtaqueAereo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtaqueAereoMouseClicked(evt);
            }
        });

        btnRemanejo.setText(bundle.getString("PrincipalGUI.btnRemanejo.text")); // NOI18N
        btnRemanejo.setPreferredSize(new java.awt.Dimension(135, 32));
        btnRemanejo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemanejoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelTurnoLayout = new javax.swing.GroupLayout(painelTurno);
        painelTurno.setLayout(painelTurnoLayout);
        painelTurnoLayout.setHorizontalGroup(
            painelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTurnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtaqueTerrestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtaqueAereo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemanejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelTurnoLayout.setVerticalGroup(
            painelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTurnoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtaqueTerrestre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelTurnoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(painelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemanejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtaqueAereo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        painelBotoesExercito.setBorder(null);
        painelBotoesExercito.setDividerLocation(140);
        painelBotoesExercito.setDividerSize(0);

        btnAddTerrestre.setText(bundle.getString("PrincipalGUI.btnAddTerrestre.text")); // NOI18N
        btnAddTerrestre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddTerrestreMouseClicked(evt);
            }
        });
        painelBotoesExercito.setLeftComponent(btnAddTerrestre);

        btnAddAereo.setText(bundle.getString("PrincipalGUI.btnAddAereo.text")); // NOI18N
        btnAddAereo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAereoActionPerformed(evt);
            }
        });
        painelBotoesExercito.setRightComponent(btnAddAereo);

        lblExercitosTerrestresDisponiveis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExercitosTerrestresDisponiveis.setText(bundle.getString("PrincipalGUI.lblExercitosTerrestresDisponiveis.text")); // NOI18N

        lblExercitosAereosDisponiveis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExercitosAereosDisponiveis.setText(bundle.getString("PrincipalGUI.lblExercitosAereosDisponiveis.text")); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(bundle.getString("PrincipalGUI.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout painelAdicionarExercitosLayout = new javax.swing.GroupLayout(painelAdicionarExercitos);
        painelAdicionarExercitos.setLayout(painelAdicionarExercitosLayout);
        painelAdicionarExercitosLayout.setHorizontalGroup(
            painelAdicionarExercitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAdicionarExercitosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAdicionarExercitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelBotoesExercito)
                    .addGroup(painelAdicionarExercitosLayout.createSequentialGroup()
                        .addComponent(lblExercitosTerrestresDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblExercitosAereosDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelAdicionarExercitosLayout.setVerticalGroup(
            painelAdicionarExercitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAdicionarExercitosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoesExercito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAdicionarExercitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExercitosTerrestresDisponiveis)
                    .addComponent(lblExercitosAereosDisponiveis))
                .addGap(38, 38, 38))
        );

        painelAction.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNomeOrigem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeOrigem.setText(bundle.getString("PrincipalGUI.lblNomeOrigem.text")); // NOI18N

        scrollOrigem.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollOrigem.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listExercitosOrigem.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollOrigem.setViewportView(listExercitosOrigem);

        javax.swing.GroupLayout painelOrigemActionLayout = new javax.swing.GroupLayout(painelOrigemAction);
        painelOrigemAction.setLayout(painelOrigemActionLayout);
        painelOrigemActionLayout.setHorizontalGroup(
            painelOrigemActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOrigemActionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelOrigemActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollOrigem)
                    .addComponent(lblNomeOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelOrigemActionLayout.setVerticalGroup(
            painelOrigemActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOrigemActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeOrigem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblActionName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblActionName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActionName.setText(bundle.getString("PrincipalGUI.lblActionName.text")); // NOI18N

        lblNomeDestino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeDestino.setText(bundle.getString("PrincipalGUI.lblNomeDestino.text")); // NOI18N

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        listExercitosDestino.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listExercitosDestino);

        javax.swing.GroupLayout painelDestinoActionLayout = new javax.swing.GroupLayout(painelDestinoAction);
        painelDestinoAction.setLayout(painelDestinoActionLayout);
        painelDestinoActionLayout.setHorizontalGroup(
            painelDestinoActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDestinoActionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDestinoActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(lblNomeDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelDestinoActionLayout.setVerticalGroup(
            painelDestinoActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDestinoActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeDestino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        vezes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        vezes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vezes.setText(bundle.getString("PrincipalGUI.vezes.text")); // NOI18N

        spnActionAddExercitos.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        spnActionAddExercitos.setToolTipText(bundle.getString("PrincipalGUI.spnActionAddExercitos.toolTipText")); // NOI18N

        lblActionAddExercitos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblActionAddExercitos.setText(bundle.getString("PrincipalGUI.lblActionAddExercitos.text")); // NOI18N

        javax.swing.GroupLayout painelActionAddExercitosLayout = new javax.swing.GroupLayout(painelActionAddExercitos);
        painelActionAddExercitos.setLayout(painelActionAddExercitosLayout);
        painelActionAddExercitosLayout.setHorizontalGroup(
            painelActionAddExercitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
            .addGroup(painelActionAddExercitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelActionAddExercitosLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblActionAddExercitos)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(spnActionAddExercitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        painelActionAddExercitosLayout.setVerticalGroup(
            painelActionAddExercitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
            .addGroup(painelActionAddExercitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelActionAddExercitosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(painelActionAddExercitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnActionAddExercitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblActionAddExercitos))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnFinishedAction.setText(bundle.getString("PrincipalGUI.btnFinishedAction.text")); // NOI18N
        btnFinishedAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinishedActionMouseClicked(evt);
            }
        });

        btnApoioAereo.setText(bundle.getString("PrincipalGUI.btnApoioAereo.text")); // NOI18N
        btnApoioAereo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApoioAereoMouseClicked(evt);
            }
        });

        lblMoveAereo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMoveAereo.setText(bundle.getString("PrincipalGUI.lblMoveAereo.text")); // NOI18N

        spnMoveAereos.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        spnMoveAereos.setToolTipText(bundle.getString("PrincipalGUI.spnMoveAereos.toolTipText")); // NOI18N

        lblMoveTerrestre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMoveTerrestre.setText(bundle.getString("PrincipalGUI.lblMoveTerrestre.text")); // NOI18N

        spnMoveTerrestres.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        spnMoveTerrestres.setToolTipText(bundle.getString("PrincipalGUI.spnMoveTerrestres.toolTipText")); // NOI18N

        javax.swing.GroupLayout painelMoveLayout = new javax.swing.GroupLayout(painelMove);
        painelMove.setLayout(painelMoveLayout);
        painelMoveLayout.setHorizontalGroup(
            painelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMoveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelMoveLayout.createSequentialGroup()
                        .addComponent(lblMoveTerrestre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnMoveTerrestres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelMoveLayout.createSequentialGroup()
                        .addComponent(lblMoveAereo)
                        .addGap(34, 34, 34)
                        .addComponent(spnMoveAereos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        painelMoveLayout.setVerticalGroup(
            painelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMoveLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnMoveTerrestres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMoveTerrestre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMoveAereo)
                    .addComponent(spnMoveAereos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout painelActionLayout = new javax.swing.GroupLayout(painelAction);
        painelAction.setLayout(painelActionLayout);
        painelActionLayout.setHorizontalGroup(
            painelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActionName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelActionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelActionLayout.createSequentialGroup()
                        .addComponent(painelMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnApoioAereo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFinishedAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(painelActionLayout.createSequentialGroup()
                        .addComponent(painelActionAddExercitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(painelActionLayout.createSequentialGroup()
                .addComponent(painelOrigemAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vezes, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(painelDestinoAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        painelActionLayout.setVerticalGroup(
            painelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelActionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblActionName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelDestinoAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelOrigemAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelActionLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(vezes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelActionLayout.createSequentialGroup()
                        .addComponent(btnApoioAereo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinishedAction))
                    .addComponent(painelMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelActionAddExercitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnCancel.setText(bundle.getString("PrincipalGUI.btnCancel.text")); // NOI18N
        btnCancel.setActionCommand(bundle.getString("PrincipalGUI.btnCancel.actionCommand")); // NOI18N
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        lblMoveTerrestre2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMoveTerrestre2.setText(bundle.getString("PrincipalGUI.lblMoveTerrestre2.text")); // NOI18N

        btnMoveOk.setText(bundle.getString("PrincipalGUI.btnMoveOk.text")); // NOI18N
        btnMoveOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMoveOkMouseClicked(evt);
            }
        });

        spnMoveOk.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        spnMoveOk.setToolTipText(bundle.getString("PrincipalGUI.spnMoveOk.toolTipText")); // NOI18N

        javax.swing.GroupLayout painelMoverDepoisDeVencerLayout = new javax.swing.GroupLayout(painelMoverDepoisDeVencer);
        painelMoverDepoisDeVencer.setLayout(painelMoverDepoisDeVencerLayout);
        painelMoverDepoisDeVencerLayout.setHorizontalGroup(
            painelMoverDepoisDeVencerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMoverDepoisDeVencerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMoveTerrestre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnMoveOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMoveOk)
                .addContainerGap())
        );
        painelMoverDepoisDeVencerLayout.setVerticalGroup(
            painelMoverDepoisDeVencerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMoverDepoisDeVencerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMoverDepoisDeVencerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnMoveOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMoveTerrestre2)
                    .addComponent(btnMoveOk))
                .addContainerGap())
        );

        btnPassarVez.setText(bundle.getString("PrincipalGUI.btnPassarVez.text")); // NOI18N
        btnPassarVez.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPassarVezMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelAdicionarExercitos, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPassarVez))
                    .addComponent(painelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelMoverDepoisDeVencer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(painelAdicionarExercitos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(painelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPassarVez))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(painelMoverDepoisDeVencer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        containerMapaTerritorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        containerMapaTerritorio.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        containerMapaTerritorio.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mapaTerritorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mapaTerritorio.setToolTipText(bundle.getString("PrincipalGUI.mapaTerritorio.toolTipText")); // NOI18N
        mapaTerritorio.setAutoscrolls(false);
        mapaTerritorio.setPreferredSize(new java.awt.Dimension(718, 516));
        mapaTerritorio.setRowSelectionAllowed(false);
        mapaTerritorio.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mapaTerritorio.getTableHeader().setResizingAllowed(false);
        mapaTerritorio.getTableHeader().setReorderingAllowed(false);
        mapaTerritorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapaTerritorioMouseClicked(evt);
            }
        });
        containerMapaTerritorio.setViewportView(mapaTerritorio);

        javax.swing.GroupLayout painelMapaLayout = new javax.swing.GroupLayout(painelMapa);
        painelMapa.setLayout(painelMapaLayout);
        painelMapaLayout.setHorizontalGroup(
            painelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMapaLayout.createSequentialGroup()
                .addComponent(containerMapaTerritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelMapaLayout.setVerticalGroup(
            painelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMapaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(containerMapaTerritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
        );

        lblVez.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblVez.setForeground(new java.awt.Color(255, 0, 0));
        lblVez.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVez.setText(bundle.getString("PrincipalGUI.lblVez.text")); // NOI18N

        lblComando.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblComando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComando.setText(bundle.getString("PrincipalGUI.lblComando.text")); // NOI18N
        lblComando.setToolTipText(bundle.getString("PrincipalGUI.lblComando.toolTipText")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblComando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(painelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVez)
                        .addGap(11, 11, 11)
                        .addComponent(lblComando)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(painelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //O que acontece quando clica em uma célula da tabela (um território)
    private void mapaTerritorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapaTerritorioMouseClicked
        int row = mapaTerritorio.rowAtPoint(evt.getPoint());
        int col = mapaTerritorio.columnAtPoint(evt.getPoint());
        Territorio territorio = mapa.getTerritorio(row,col);
        showDetalhes(territorio);
        //Caso a distribuição esteja em andamento
        if(distribuicao_Andamento){
           if(territorio.getCor() == humano.getCor()){
                painelAdicionarExercitos.setVisible(true);
                lblExercitosAereosDisponiveis.setText(humano.getTotalAereoDisponiveis() + " disponíveis");
                lblExercitosTerrestresDisponiveis.setText(humano.getTotalTerrestreDisponiveis() + " disponíveis");
            }else{
                painelAdicionarExercitos.setVisible(false);
            }
        }else{
            if(!validos.contains(territorio))
                return;
            //Caso a ação esteja em andamento
            if(evt.getClickCount() == 2){
                if(estado_jogada == 0){
                    action.setOrigem(territorio);
                    painelActionAddExercitos.setVisible(true);
                    instanciarAcaoGUI(territorio);
                }else if(estado_jogada == 2){
                    action.setDestino(territorio);
                    painelDestinoAction.setVisible(true);
                    if(!(action instanceof Remanejo))
                        vezDaMaquina();
                    else{
                        btnFinishedAction.setText("Movimentar Exércitos!");
                        listExercitosDestino.setModel(new DefaultListModel());
                        estado_jogada = 4;
                    }
                    lblNomeDestino.setText(territorio.getNome());
                }else if(estado_jogada == 3){
                    //Obtém a quantidade de exércitos aéreos do território
                    suporteAereo = territorio;
                    int upperBound = territorio.getTotalExercitosAereos();
                    if(upperBound > 3) upperBound = 3;
                    //Desconta os exércitos já selecionados
                    upperBound = upperBound + listExercitosOrigem.getModel().getSize() > 3 ? 3 - listExercitosOrigem.getModel().getSize() : upperBound;
                    //Verificar tamanho upperBound
                    SpinnerModel sm = new SpinnerNumberModel(1, 1, upperBound, 1);
                    spnActionAddExercitos.setModel(sm);
                }
            }
        }
    }//GEN-LAST:event_mapaTerritorioMouseClicked
    //O que acontece quando se seleciona um Ataque Terrestre
    private void btnAtaqueTerrestreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtaqueTerrestreMouseClicked
        action = new AtaqueTerrestre();
        selecionarOrigem();
    }//GEN-LAST:event_btnAtaqueTerrestreMouseClicked
    //O que acontece quando se seleciona um Ataque Aéreo
    private void btnAtaqueAereoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtaqueAereoMouseClicked
        action = new AtaqueAereo();
        selecionarOrigem();
    }//GEN-LAST:event_btnAtaqueAereoMouseClicked
    //O que acontece quando se seleciona um Remanejo
    private void btnRemanejoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemanejoMouseClicked
        action = new Remanejo(true);
        selecionarOrigem();
        movimentacao = true;
        btnPassarVez.setVisible(true);
    }//GEN-LAST:event_btnRemanejoMouseClicked
    //Método que adiciona um exército Aereo ao Territorio selecionado
    private void btnAddAereoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAereoActionPerformed
        int row = mapaTerritorio.getSelectedRow(), col = mapaTerritorio.getSelectedColumn();
        humano.adicionarAereoAoTerritorio(mapa.getTerritorio(row, col));
        lblExercitosAereosDisponiveis.setText(humano.getTotalAereoDisponiveis() + " disponíveis");
        showDetalhes(mapa.getTerritorio(row, col));
        atualizarDados();
        verificarFimDistribuicaoExercitos();
    }//GEN-LAST:event_btnAddAereoActionPerformed
    //Método que adiciona um exército Terrestre ao Territorio selecionado
    private void btnAddTerrestreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTerrestreMouseClicked
        int row = mapaTerritorio.getSelectedRow(), col = mapaTerritorio.getSelectedColumn();
        humano.adicionarTerrestreAoTerritorio(mapa.getTerritorio(row, col));
        lblExercitosTerrestresDisponiveis.setText(humano.getTotalTerrestreDisponiveis() + " disponíveis");
        showDetalhes(mapa.getTerritorio(row, col));
        atualizarDados();
        verificarFimDistribuicaoExercitos();
    }//GEN-LAST:event_btnAddTerrestreMouseClicked
          
    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        zerarTurno(!movimentacao);
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnApoioAereoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApoioAereoMouseClicked
        if(estado_jogada!=3){
            lblComando.setText("<html><center>Selecione um território válido para chamar Apoio Aéreo!</center></html>");
            btnApoioAereo.setText("Adicionar");
            //Destaca no mapa as opções válidas para apoio aéreo
            destacarTerritorios(mapa.getAuxilioValido(humano.getTerritoriosPossuidos(), action.getOrigem()));
            estado_jogada = 3;
        }else{
            DefaultListModel model = (DefaultListModel)listExercitosOrigem.getModel();
            for(int i=0; i<(int)spnActionAddExercitos.getValue(); i++){
                action.addExercitoAtivo(suporteAereo, suporteAereo.getExercitosAereos().get(i));
                model.addElement("Aéreo - " + suporteAereo.getNome());
            }
            if(model.getSize() < 3){
                btnApoioAereo.setText("Solicitar Apoio Aereo");
            }else{
                btnApoioAereo.setVisible(false);
            }
            listExercitosOrigem.setModel(model);
            estado_jogada = 5;
        }
    }//GEN-LAST:event_btnApoioAereoMouseClicked

    private void btnFinishedActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishedActionMouseClicked
        if(em_defesa != null){
            estado_jogada = -1;
            action.executar();
        }
        if(estado_jogada == 1){//Selecionar exércitos
            if(action instanceof AtaqueTerrestre){
                DefaultListModel model = (DefaultListModel)listExercitosOrigem.getModel();
                for(int i=0; i<(int)spnActionAddExercitos.getValue(); i++){
                    action.addExercitoAtivo(action.getOrigem(), action.getOrigem().getExercitosTerrestres().get(i));
                    model.addElement("Terrestre - " + action.getOrigem().getNome());
                }
                listExercitosOrigem.setModel(model);
                selecionarDestino();
            }else if(action instanceof AtaqueAereo){
                DefaultListModel model = (DefaultListModel)listExercitosOrigem.getModel();
                for(int i=0; i<(int)spnActionAddExercitos.getValue(); i++){
                    action.addExercitoAtivo(action.getOrigem(), action.getOrigem().getExercitosAereos().get(i));
                    model.addElement("Aéreo - " + action.getOrigem().getNome());
                }
                listExercitosOrigem.setModel(model);
                //Pode adicionar mais exércitos aéreos
                if((int)spnActionAddExercitos.getValue() < 3){
                    btnApoioAereo.setVisible(true);
                }else{
                    selecionarDestino();
                }
                estado_jogada = 5;
            }else if(action instanceof Remanejo){
                DefaultListModel model = (DefaultListModel)listExercitosOrigem.getModel();
                for(int i=0; i<(int)spnMoveTerrestres.getValue(); i++){
                    action.addExercitoAtivo(action.getOrigem(), action.getOrigem().getTerrestresMovimentaveis().get(i));
                    model.addElement("Terrestre - " + action.getOrigem().getNome());
                }
                for(int i=0; i<(int)spnMoveAereos.getValue(); i++){
                    action.addExercitoAtivo(action.getOrigem(), action.getOrigem().getAereosMovimentaveis().get(i));
                    model.addElement("Aéreo - " + action.getOrigem().getNome());
                }
                scrollOrigem.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
                listExercitosOrigem.setModel(model);
                selecionarDestino();
            }
        }else if(estado_jogada == 4){
            estado_jogada = -1;
            action.executar();
        }else if(estado_jogada == 5){ //Jogador estava selecionando apoio aereo
            selecionarDestino();
        }
    }//GEN-LAST:event_btnFinishedActionMouseClicked

    private void btnMoveOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoveOkMouseClicked
        System.out.print("\n" + action.getOrigem().getNome() + "|" + action.getDestino().getNome());
        for(int i=0; i<(int)spnMoveOk.getValue(); i++){
            action.addExercitoAtivo(action.getOrigem(), action.getOrigem().getExercitosTerrestres().get(i));
        }
        action.executar();
        zerarTurno(true);        
    }//GEN-LAST:event_btnMoveOkMouseClicked

    private void btnPassarVezMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPassarVezMouseClicked
        passarAVez();
    }//GEN-LAST:event_btnPassarVezMouseClicked
     
    //INICIALIZAÇÃO E ATUALIZAÇÃO DA GUI
           
    /**
     * Procedimento que inicializa o mapa na interface gráfica
     */ 
    private void start(){        
        mapaTerritorio.setRowHeight((containerMapaTerritorio.getHeight() - mapaTerritorio.getTableHeader().getHeight())/5);
        painelAdicionarExercitos.setVisible(false);
        atualizarMapa();
        atualizarDados();
    }
    
    /**
     * Procedimento que os dados no Painel Lateral
     */ 
    public void atualizarDados(){    
        //Autualiza o painel da relação dos continentes
        DefaultListModel<String> model = new DefaultListModel();
        for(Continente c : humano.getQtdTerritoriosCadaContinente().keySet()){
            model.addElement(c.getNome() + " : " + humano.getQtdTerritoriosCadaContinente().get(c) + " de " + c.getQuantidadeTerritorios() + " territórios");
        }
        model.addElement("TOTAL: " + humano.getTotalTerritoriosPossuidos() + " territórios");
        listaQtdContinentes.setModel(model);
        //Atualizar quantidade de exércitos espalhados no mapa
        int[] total = humano.getTotalExercitosNosTerritorios();
        lblExercitosTerrestresAlocados.setText(total[0] + " Exércitos Terrestres espalhados pelo Mapa");
        lblExercitosAereosAlocados.setText(total[1] + " Exércitos Aéreos espalhados pelo Mapa");
    }
    
    /**
     * Procedimento que atualiza a tabela de mapa
     */ 
    public void atualizarMapa(){
        DefaultTableCellRenderer dctr = new BoardTableCellRenderer();
        mapaTerritorio.setDefaultRenderer(String.class, dctr);
    }
    
    /**
     * Procedimento que mostra os detalhes de um território no Painel Lateral
     * @param territorio Território cujos detalhes devem ser exibidos
     */ 
    public void showDetalhes(Territorio territorio){
       nomeTerritorio.setText(territorio.getNome());
       //imagemTerritorio.setIcon(territorio.getImagem());
       continenteTerritorio.setText(territorio.getContinente() == null ? "-" : territorio.getContinente().getNome());
       exercitosTotalTerritorio.setText("Exércitos : " + territorio.getTotalExercitosNoTerritorio());
       exercitosTerrestresTerritorio.setText("Terrestres : " + territorio.getTotalExercitosTerrestres());
       exercitosAereosTerritorio.setText("Aéreos : " + territorio.getTotalExercitosAereos());
       corTerritorio.setText("<html><font color=\"rgb(" + territorio.getCor().getRGB() + ")\">" + territorio.getCor().toString() + "</font></html>");
    }
    
    //TURNO
    
    /**
     * Método que ativa o turno do jogador humano
     * @param habilitar Habilita ou desabilita o turno (mostra ou esconde o painel de opções)
     */
    public void ativarTurno(boolean habilitar){
        if(habilitar){
            painelTurno.setVisible(true);
            lblVez.setText("É A SUA VEZ!");
            lblComando.setText("Selecione o que deseja fazer:");
            atualizarMapa();
        }else{
            painelTurno.setVisible(false);
            lblComando.setText("Você passou a vez!");            
        }       
    }
    
    /**
     * Método que permite que o jogador selecione a Origem da ação
     */
    private void selecionarOrigem(){        
        ativarTurno(false);
        btnCancel.setVisible(true);
        if(action instanceof AtaqueTerrestre)
            lblComando.setText("<html><center>Você pretende realizar um ATAQUE TERRESTRE!<br>Selecione (duplo-clique) um território válido como ORIGEM do ataque!</center></html>");
        else if(action instanceof AtaqueAereo)
            lblComando.setText("<html><center>Você pretende realizar um ATAQUE AEREO!<br>Selecione (duplo-clique) um território válido como ORIGEM do ataque!</center></html>");
        else
            lblComando.setText("<html><center>Você pretende realizar um REMANEJO!<br>Selecione (duplo-clique) um território válido como ORIGEM da movimentação!</center></html>");
        validos = mapa.getOrigensValidas(humano.getTerritoriosPossuidos(), action);
        destacarTerritorios(validos);
        estado_jogada = 0;
    }  
    
    /**
     * Método que mostra o painel de ação para o Jogador
     * @param origem Origem da Ação
     */    
    private void instanciarAcaoGUI(Territorio origem){
        painelOrigemAction.setVisible(true);
        int upperBound = 0;
        SpinnerModel sm;
        vezes.setVisible(true);
        vezes.setText("X");
        lblActionName.setText(action.getTipo());
        if(action instanceof AtaqueAereo){
            upperBound = origem.getTotalExercitosAereos();
        }else if(action instanceof AtaqueTerrestre){
            
            upperBound = origem.getTotalExercitosTerrestres() - 1;
        }else{
            //Adicionar opção para selecionar os 2 tipos de exército
            painelMove.setVisible(true);
            int upAereo = origem.getAereosMovimentaveis().size();
            int upTerrestre = origem.getTerrestresMovimentaveis().size() - 1;
            sm = new SpinnerNumberModel(0, 0, upAereo, 1);
            spnMoveAereos.setModel(sm);
            sm = new SpinnerNumberModel(0, 0, upTerrestre, 1);
            spnMoveTerrestres.setModel(sm);            
            vezes.setText("->");
            painelActionAddExercitos.setVisible(false);
        }
        if(!(action instanceof Remanejo)){
            if(upperBound > 3) upperBound = 3;
            sm = new SpinnerNumberModel(1, 1, upperBound, 1);
            spnActionAddExercitos.setModel(sm);
            painelActionAddExercitos.setVisible(true);
        }
        painelAction.setVisible(true);
        lblNomeOrigem.setText(origem.getNome());   
        listExercitosOrigem.setModel(new DefaultListModel());
        //A partir de agora o jogador deve escolher os exércitos
        estado_jogada = 1;
    }
    
    /**
     * Método que permite que o jogador selecione o Destino da ação
     */
    private void selecionarDestino(){
        validos = mapa.getFronteirasValidas(action.getOrigem(), action);
        destacarTerritorios(validos);
        btnApoioAereo.setVisible(false);
        lblComando.setText("Selecione (duplo-clique) um território válido como DESTINO!");
        estado_jogada = 2;
    }
    
    /**
     * Método invocado para que a máquina se Defenda de uma ação
     */ 
    private void vezDaMaquina(){   
        DefaultListModel model = new DefaultListModel();
        ArrayList<Exercito> ex = TurnoMaquina.executarDefesa(action, action.getDestino());
        if(action instanceof AtaqueTerrestre)
            ((AtaqueTerrestre) action).setQuantidadeDefesa(ex.size());            
        
        for(Exercito e : ex){
            model.addElement(e.getTipo() + " - " + action.getDestino().getNome());
        }
        listExercitosDestino.setModel(model);
        estado_jogada = 4;
        btnFinishedAction.setText("Iniciar Ataque!");
    }
    
    /**
     * Método que coloca os elementos de interface gráfica e as variáveis em seu estado padrão
     * @param continuar 
     */
    private void zerarTurno(boolean continuar){
        estado_jogada = -1;
        action = null;
        painelMove.setVisible(false);
        painelAction.setVisible(false);
        painelMoverDepoisDeVencer.setVisible(false);
        btnCancel.setVisible(false);
        painelActionAddExercitos.setVisible(false);
        painelDestinoAction.setVisible(false);
        btnApoioAereo.setText("Solicitar Apoio Aereo");
        btnFinishedAction.setText("Ok!");
        listExercitosOrigem.setModel(new DefaultListModel());
        listExercitosDestino.setModel(new DefaultListModel());
        scrollOrigem.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
        lblActionAddExercitos.setText("Com quantos exércitos você deseja atacar?");
        if(continuar){            
            btnPassarVez.setVisible(false);
            btnAtaqueTerrestre.setVisible(true);
            btnAtaqueAereo.setVisible(true);
        }else{
            //A última ação foi um Remanejo, logo não se pode mais fazer ataques
            btnAtaqueTerrestre.setVisible(false);
            btnAtaqueAereo.setVisible(false);
        }
        ativarTurno(true);
    }
    
    //INICIO DE RODADA
    
    /**
     * Método que inicia uma rodada
     * @param rodada Rodada que está sendo iniciada
     */
    public void iniciarRodada(Rodada rodada){
        this.rodada = rodada;
        em_defesa = null;
        jogadorCor.setText("<html>Você é o jogador <font color=\"rgb(" + humano.getCor().getRGB() + "\">" + humano.getCor() + "</font></html>");
        distribuicao_Andamento = true;
        //Desativar as opções de seleção de ação        
        btnApoioAereo.setVisible(false);
        painelActionAddExercitos.setVisible(false);
        vezes.setVisible(false);
        painelMove.setVisible(false);
        painelOrigemAction.setVisible(false);
        painelDestinoAction.setVisible(false);
        verificarFimDistribuicaoExercitos();
        movimentacao = false;
        zerarTurno(!movimentacao);
        ativarTurno(false);
        //Desativar o turno
        destacarTerritorios(humano.getTerritoriosPossuidos());
        painelAction.setVisible(false);
        lblVez.setText("Distribuição de Terrotórios em Andamento!");
        lblComando.setText("Adicione exércitos aos seus territórios! Clique sobre eles!");
        lblActionAddExercitos.setText("Com quantos exércitos você deseja atacar?");
    }
    
    /**
     * Método que verifica se a distribuição dos exércitos do jogador já terminou
     */
    private void verificarFimDistribuicaoExercitos(){
        if(humano.getTotalExercitosDisponiveis() == 0){
            distribuicao_Andamento = false;
            painelAdicionarExercitos.setVisible(false);
            ativarTurno(true);
        }
    }
    
    /**
     * Método que informa ao jogador o resultado da execução de uma ação.
     * @param acao Ação ocorrida
     * @param str Resultado da Ação ocorrida
     */
    public void setRetornoAction(Action acao, String str){
        if(Principal.getJogadorViaCor(acao.getOrigem().getCor()) == humano){
            zerarTurno(!movimentacao);
        }
        atualizarDados();
        atualizarMapa();
        if(movimentacao){
            lblComando.setText("Você realizou um Remanejo e não pode mais realizar ataques!");
        }
        infoBox(acao, str);
        if(Principal.getJogadorViaCor(acao.getOrigem().getCor()) != humano){
            if(em_defesa != null)
                em_defesa.proximaAction();
        }
    }
    
    /**
     * Método que passa a vez do jogador para a Máquina
     */
    private void passarAVez(){
        ativarTurno(false);
        btnPassarVez.setVisible(false);
        lblComando.setText("Você passou a vez!");
        atualizarMapa();
        atualizarDados();
        movimentacao = false;
        rodada.proximo();
    }
    
    /**
     * Método que permite que o jogador mova os exércitos do território de origem para o território conquistado após o Ataque Terrestre.
     * Não considera os exércitos movidos como inválidos para remanejo posterior
     * @param qtd Quantidade de exércitos que podem ser transferidos (usados no último ataque)
     * @param acao Ação do Ataque Terrestree
     */
    public void possibilitarMover(int qtd, Action acao){
        btnCancel.setVisible(false);
        painelMoverDepoisDeVencer.setVisible(true);
        painelTurno.setVisible(false);
        action = new Remanejo(false);
        action.setDestino(acao.getDestino());
        action.setOrigem(acao.getOrigem());
        int qtdMovimentaveis = acao.getOrigem().getTerrestresMovimentaveis().size();
        int upperBound = qtd > qtdMovimentaveis-1 ? qtdMovimentaveis-1 : qtd;
        SpinnerModel sm = new SpinnerNumberModel(1, 1, upperBound, 1);
        spnMoveOk.setModel(sm);
    }
   
    //Classes internas para renderização de tabelas/listas
    
    //Renderizador Padrão do Mapa
    private class BoardTableCellRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            Component c = super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, col);
            setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            Territorio t = mapa.getTerritorio(row, col);
            String continente = t.getContinente() == null ? "-" : t.getContinente().getNome();
            String str = "<html><center><font color=\"black\">" + t.getNome() + "<br>[" + continente + "]<br>" + t.getTotalExercitosTerrestres() +" | "+ t.getTotalExercitosAereos() +"</font></center></html>";
            table.getModel().setValueAt(str, row, col);
            c.setBackground(t.getCor().getColor());
            return c;
        }
     }
    //Renderizador para Selecionar um Territorio no Mapa
    private class SelecionarTerritorioCellRenderer extends DefaultTableCellRenderer {
        ArrayList<Territorio> territorios;
        public SelecionarTerritorioCellRenderer(ArrayList<Territorio> territorios) {
            this.territorios = territorios;
        }
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            Component c = super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, col);
            setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            
            Territorio t = mapa.getTerritorio(row, col);
            if(territorios.contains(t)){
                c.setEnabled(true);
                c.setBackground(t.getCor().getColor());
            }else{
                int red = t.getCor().getRed(), green =  t.getCor().getGreen(), blue = t.getCor().getBlue();
                red = red + 50 > 255 ? red : red+50; green = green + 50 > 255 ? green : green+50; blue = blue + 50 > 255 ? blue : blue+50;
                Color color = new Color(red, green, blue);
                c.setBackground(color);
                c.setEnabled(false);
            }
            String continente = t.getContinente() == null ? "-" : t.getContinente().getNome();
            String str = "<html><center><font color=\"black\">" + t.getNome() + "<br>[" + continente + "]<br>" + t.getTotalExercitosTerrestres() +" | "+ t.getTotalExercitosAereos() +"</font></center></html>";
            table.getModel().setValueAt(str, row, col);
            return c;
        }
     }
    
    /**
     * Método estático para criar diálogos com base em uma ação.
     * Serve para que a ação envie uma resposta ao jogador.
     * @param acao Ação que foi executada
     * @param infoMessage Resultado da ação
     */ 
    public static void infoBox(Action acao, String infoMessage){
        JOptionPane.showMessageDialog(null, infoMessage, "Resultado do " + acao.getTipo(), JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Método que proporciona que o jogador execute a defesa quando a máquina acatacá-lo
     * @param action Ação que está atacando o jogador
     * @param turno Turno da máquina que está atacando o jogador para que haja resposta
     */ 
    public void defenderDe(Action action, Turno turno){
        btnCancel.setVisible(false);
        em_defesa = turno;
        lblVez.setText("A VEZ É DO SEU ADVERSÁRIO");
        if(action instanceof Remanejo){
            action.executar();
            lblComando.setText("O adversário está remanejando seus exércitos!");
        }else{
            lblActionName.setText(action.getTipo());
            painelOrigemAction.setVisible(true);
            vezes.setVisible(true);
            vezes.setText("X");
            painelAction.setVisible(true);
            painelActionAddExercitos.setVisible(true);
            //Mostra a origem do ataque
            lblNomeOrigem.setText(action.getOrigem().getNome());   
            //Monta a lista dos exércitos envolvidos
            DefaultListModel model = new DefaultListModel();
            for(Territorio t : action.getExercitosAtivos().keySet()){
                for(Exercito e : action.getExercitosAtivos().get(t))
                    model.addElement(action.getOrigem().getNome() + " - " + e.getTipo()); 
            }
            //Mostra para o jogador que ele está sendo atacado
            listExercitosOrigem.setModel(model);
            lblNomeOrigem.setText(action.getOrigem().getNome());
            painelDestinoAction.setVisible(true);
            lblNomeDestino.setText(action.getDestino().getNome());
            lblComando.setText(action.getDestino().getNome() + " está sendo atacado por " + action.getOrigem().getNome());
            lblActionAddExercitos.setText("Faça sua Defesa!");
            //Define a quantidade Maxima de exércitos que podem ser defendidos
            int upperBound;
            if(action instanceof AtaqueTerrestre)
                upperBound = action.getDestino().getTotalExercitosTerrestres();
            else
                upperBound = action.getDestino().getTotalExercitosAereos();
            if(upperBound > 3) upperBound = 3;

            model = new DefaultListModel();
            for(int i=0; i<upperBound; i++){
                if(action instanceof AtaqueAereo){
                    model.addElement("Aéreo - " + action.getDestino().getNome());
                }else{
                    ((AtaqueTerrestre)action).setQuantidadeDefesa(upperBound);
                    model.addElement("Terrestre - " + action.getDestino().getNome());
                }
            }                    
            listExercitosDestino.setModel(model);

            //Muda o foco para os dois Territorios apenas
            ArrayList<Territorio> envolvidos = new ArrayList<>();
            envolvidos.add(action.getOrigem()); envolvidos.add(action.getDestino());
            destacarTerritorios(envolvidos);
            this.action = action;
        }
    }
    
    /**
     * Método que declara a vitória de algum jogador destacando seus territórios
     * @param vencedor Jogador que venceu o jogo
     */
    public void declararVitoria(Jogador vencedor){
        lblVez.setText("<html><font color=\"rgb("+ vencedor.getCor().getRGB() + ")\">O jogador " + vencedor.getCor() + " venceu a partida!</font></html>");
        painelPrincipal.setVisible(false);
        destacarTerritorios(vencedor.getTerritoriosPossuidos());
    }
    
    /**
     * Método que destaca um conjunto específico de territórios no mapa
     * @param destacados Conjunto de territórios que devem ser destacados
     */
    private void destacarTerritorios(ArrayList<Territorio> destacados){
        DefaultTableCellRenderer dctr = new SelecionarTerritorioCellRenderer(destacados);
        mapaTerritorio.setDefaultRenderer(String.class, dctr);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAereo;
    private javax.swing.JButton btnAddTerrestre;
    private javax.swing.JButton btnApoioAereo;
    private javax.swing.JButton btnAtaqueAereo;
    private javax.swing.JButton btnAtaqueTerrestre;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFinishedAction;
    private javax.swing.JButton btnMoveOk;
    private javax.swing.JButton btnPassarVez;
    private javax.swing.JButton btnRemanejo;
    private javax.swing.JPanel containerImagemTerritorio;
    private javax.swing.JScrollPane containerMapaTerritorio;
    private javax.swing.JLabel continenteTerritorio;
    private javax.swing.JLabel corTerritorio;
    private javax.swing.JLabel exercitosAereosTerritorio;
    private javax.swing.JLabel exercitosTerrestresTerritorio;
    private javax.swing.JLabel exercitosTotalTerritorio;
    private javax.swing.JLabel imagemTerritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jogadorCor;
    private javax.swing.JLabel lblActionAddExercitos;
    private javax.swing.JLabel lblActionName;
    private javax.swing.JLabel lblComando;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblExercitosAereosAlocados;
    private javax.swing.JLabel lblExercitosAereosDisponiveis;
    private javax.swing.JLabel lblExercitosTerrestresAlocados;
    private javax.swing.JLabel lblExercitosTerrestresDisponiveis;
    private javax.swing.JLabel lblMoveAereo;
    private javax.swing.JLabel lblMoveTerrestre;
    private javax.swing.JLabel lblMoveTerrestre2;
    private javax.swing.JLabel lblNomeDestino;
    private javax.swing.JLabel lblNomeOrigem;
    private javax.swing.JLabel lblVez;
    private javax.swing.JList<String> listExercitosDestino;
    private javax.swing.JList<String> listExercitosOrigem;
    private javax.swing.JScrollPane listaContinentes;
    private javax.swing.JList<String> listaQtdContinentes;
    private javax.swing.JTable mapaTerritorio;
    private javax.swing.JLabel nomeTerritorio;
    private javax.swing.JPanel painelAction;
    private javax.swing.JPanel painelActionAddExercitos;
    private javax.swing.JPanel painelAdicionarExercitos;
    private javax.swing.JSplitPane painelBotoesExercito;
    private javax.swing.JPanel painelDestinoAction;
    private javax.swing.JSplitPane painelExercitosTerritorio;
    private javax.swing.JPanel painelLateral;
    private javax.swing.JPanel painelMapa;
    private javax.swing.JPanel painelMove;
    private javax.swing.JPanel painelMoverDepoisDeVencer;
    private javax.swing.JPanel painelOrigemAction;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTurno;
    private javax.swing.JPanel painelVisaoGeral;
    private javax.swing.JScrollPane scrollOrigem;
    private javax.swing.JSpinner spnActionAddExercitos;
    private javax.swing.JSpinner spnMoveAereos;
    private javax.swing.JSpinner spnMoveOk;
    private javax.swing.JSpinner spnMoveTerrestres;
    private javax.swing.JLabel vezes;
    // End of variables declaration//GEN-END:variables
}