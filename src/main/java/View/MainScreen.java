package View;

import Controller.ProjectController;
import Controller.TaskController;
import Model.Project;
import Model.Task;
import Util.ButtonColumnCellRenderer;
import Util.DeadlineColumnCellRenderer;
import Util.TaskTableModel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

public class MainScreen extends javax.swing.JFrame {

    ProjectController projectController;
    TaskController taskController;

    //List onde serão armazenados em um default do Java os dados recebidos da base de dados
    DefaultListModel projectsDefaultListModel;
    TaskTableModel taskTableModel;

    //Métodos que serão executados no momento que a tela aparecer
    public MainScreen() {
        initComponents();

        //Criando os controllers ao criar a tela
        initiDataController();

        //Criando os models que serão utilizados pela tela
        initiComponentsModel();

        //Chamando o método de customização da Table Task
        decorateTableTask();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEmptyList = new javax.swing.JPanel();
        jLabelEmptyListIcon = new javax.swing.JLabel();
        jLabelEmptyTasksTitle = new javax.swing.JLabel();
        jLabelEmptyTasksSubTitle = new javax.swing.JLabel();
        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolBarTitle = new javax.swing.JLabel();
        jLabelToolBarSubtitle = new javax.swing.JLabel();
        jPanelProjects = new javax.swing.JPanel();
        jLabelProjectsTitle = new javax.swing.JLabel();
        jLabelProjectsAdd = new javax.swing.JLabel();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTasksTitle = new javax.swing.JLabel();
        jLabelTasksAdd = new javax.swing.JLabel();
        jPanelProjectList = new javax.swing.JPanel();
        jScrollPaneProjects = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPaneTasks = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();

        jPanelEmptyList.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEmptyListIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/list/xxhdpi-lists.png"))); // NOI18N
        jLabelEmptyListIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelEmptyTasksTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmptyTasksTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelEmptyTasksTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyTasksTitle.setText("Nenhuma tarefa por aqui :D");

        jLabelEmptyTasksSubTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmptyTasksSubTitle.setForeground(new java.awt.Color(204, 204, 204));
        jLabelEmptyTasksSubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyTasksSubTitle.setText("Clique no bot�o \" + \" para adicionar uma nova tarefa");

        javax.swing.GroupLayout jPanelEmptyListLayout = new javax.swing.GroupLayout(jPanelEmptyList);
        jPanelEmptyList.setLayout(jPanelEmptyListLayout);
        jPanelEmptyListLayout.setHorizontalGroup(
                jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelEmptyListIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEmptyTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEmptyTasksSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );
        jPanelEmptyListLayout.setVerticalGroup(
                jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabelEmptyListIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEmptyTasksTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEmptyTasksSubTitle)
                                .addContainerGap(128, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(760, 670));
        setPreferredSize(new java.awt.Dimension(760, 670));
        setSize(new java.awt.Dimension(755, 664));

        jPanelToolBar.setBackground(new java.awt.Color(0, 153, 102));

        jLabelToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelToolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick/tick (3).png"))); // NOI18N
        jLabelToolBarTitle.setText("  Todo App");

        jLabelToolBarSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelToolBarSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarSubtitle.setText("Anote tudo, n�o esque�a nada");

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
                jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelToolBarLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelToolBarSubtitle)
                                        .addComponent(jLabelToolBarTitle))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelToolBarLayout.setVerticalGroup(
                jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelToolBarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelToolBarTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelToolBarSubtitle)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelProjects.setBackground(new java.awt.Color(255, 255, 255));

        jLabelProjectsTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelProjectsTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelProjectsTitle.setText("Projetos");

        jLabelProjectsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add/add (5).png"))); // NOI18N
        jLabelProjectsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
                jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelProjectsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelProjectsTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelProjectsAdd)
                                .addContainerGap())
        );
        jPanelProjectsLayout.setVerticalGroup(
                jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelProjectsTitle)
                                        .addComponent(jLabelProjectsAdd))
                                .addGap(23, 23, 23))
        );

        jPanelTasks.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTasksTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTasksTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelTasksTitle.setText("Tarefas");

        jLabelTasksAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add/add (5).png"))); // NOI18N
        jLabelTasksAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
                jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTasksLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTasksTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTasksAdd)
                                .addContainerGap())
        );
        jPanelTasksLayout.setVerticalGroup(
                jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTasksLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelTasksAdd)
                                        .addComponent(jLabelTasksTitle))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelProjectList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjectList.setMinimumSize(new java.awt.Dimension(282, 348));

        jListProjects.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jListProjects.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjects.setFixedCellHeight(40);
        jListProjects.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectsMouseClicked(evt);
            }
        });
        jScrollPaneProjects.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectListLayout = new javax.swing.GroupLayout(jPanelProjectList);
        jPanelProjectList.setLayout(jPanelProjectListLayout);
        jPanelProjectListLayout.setHorizontalGroup(
                jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelProjectListLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPaneProjects, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanelProjectListLayout.setVerticalGroup(
                jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelProjectListLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPaneProjects)
                                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTableTasks.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTableTasks.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Nome", "Descri��o", "Prazo", "Tarefa Conclu�da"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableTasks.setRowHeight(40);
        jTableTasks.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTasks.setShowGrid(false);
        jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTasksMouseClicked(evt);
            }
        });
        jScrollPaneTasks.setViewportView(jTableTasks);

        jPanel5.add(jScrollPaneTasks, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanelProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // ################ Início de edição manual do código ######################

    private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {
        int projectIndex = jListProjects.getSelectedIndex();
        Project project = (Project) projectsDefaultListModel.get(projectIndex);
        loadTasks(project.getId());
    }

    //Criando método para chamar (criar e instanciar um novo objeto) a janela de cadastro de novo projeto
    private void jLabelProjectsAddMouseClicked(java.awt.event.MouseEvent evt) {
        ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen(this, rootPaneCheckingEnabled);
        projectDialogScreen.setVisible(true);

        //Inserindo um método para executar o método loadProject quando essa for fechada
        projectDialogScreen.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                loadProjects();
            }
        });
    }

    //Criando método para chamar (criar e instanciar um novo objeto) a janela de cadastro de nova tarefa
    private void jLabelTasksAddMouseClicked(java.awt.event.MouseEvent evt) {
        TaskDialogScreen taskDialogScreen = new TaskDialogScreen(this, rootPaneCheckingEnabled);

        //Ao clicar sobre adicionar sobre nova tarefa ele pega o indice do projeto selecionado
        int projectIndex = jListProjects.getSelectedIndex();
        Project project = (Project) projectsDefaultListModel.get(projectIndex);
        taskDialogScreen.setProject(project);

        taskDialogScreen.setVisible(true);

        //Inserindo um método para executar o método loadTasks quando essa for fechada
        taskDialogScreen.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                loadTasks(project.getId());
            }
        });
    }

    //Pegando o ponto onde ocorreu o click na tela, dizendo onde é a linha e coluna
    private void jTableTasksMouseClicked(java.awt.event.MouseEvent evt) {
        int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
        int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());

        Task task = taskTableModel.getTasks().get(rowIndex);

        switch (columnIndex) {
            case 3:
                taskController.update(task); //update no banco de dados
                break;
            case 5:
                taskController.removeById(task.getId()); //remove do banco de dados
                taskTableModel.getTasks().remove(task); //remove a task da tela

                //Após remoção, recarrega a lista de tarefas
                int projectIndex = jListProjects.getSelectedIndex();
                Project project = (Project) projectsDefaultListModel.get(projectIndex);
                loadTasks(project.getId());

                break;
        }
    }

    //Criando um método para customizar o componente Table Tasks
    public void decorateTableTask() {

        //Customizando o header da tabela de tarefas
        jTableTasks.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTableTasks.getTableHeader().setBackground(new Color(0, 153, 102));
        jTableTasks.getTableHeader().setForeground(new Color(255, 255, 255));

        //Criando sort nas colunas da tabela
        jTableTasks.setAutoCreateRowSorter(true);

        //Inserindo a customização da célula deadline
        jTableTasks.getColumnModel().getColumn(2).setCellRenderer(new DeadlineColumnCellRenderer());

        //Inserindo a customização das células de editar e delete
        jTableTasks.getColumnModel().getColumn(4).setCellRenderer(new ButtonColumnCellRenderer("edit/pencil (4)"));
        jTableTasks.getColumnModel().getColumn(5).setCellRenderer(new ButtonColumnCellRenderer("delete/close (4)"));
    }

    public void initiDataController() {
        projectController = new ProjectController();
        taskController = new TaskController();
    }

    //Instanciando uma default lista de projetos
    public void initiComponentsModel() {
        //Carregando os projetos do banco
        projectsDefaultListModel = new DefaultListModel();
        loadProjects();

        //Carregando as tarefas do banco
        taskTableModel = new TaskTableModel();
        jTableTasks.setModel(taskTableModel);
        loadTasks(24);

        //Condição para selecionar o primeiro projeto ao abrir o programa
        if (!projectsDefaultListModel.isEmpty()) {
            jListProjects.setSelectedIndex(0);
            Project project = (Project) projectsDefaultListModel.get(0);
            loadTasks(project.getId());
        }
    }

    //Criando uma lista com os dados recebidos do banco de dados
    public void loadProjects() {
        //Criando uma lista de projetos com o método getAll do controller
        List<Project> projectList = projectController.getAll();

        //Setando a lista default para que esteja limpa para armazenar os dados que serão recebidos abaixo
        projectsDefaultListModel.clear();

        //Recebendo os dados do banco de dados e armazenando na default
        for (int i = 0; i < projectList.size(); i++) {
            Project project = projectList.get(i);
            projectsDefaultListModel.addElement(project);
        }
        jListProjects.setModel(projectsDefaultListModel);
    }

    //Criando uma lista com os dados recebidos do banco de dados e acionando o método showJTableTasks
    public void loadTasks(int idProject) {
        List<Task> tasksList = taskController.getAll(idProject);
        taskTableModel.setTasks(tasksList);

        showJTableTasks(!tasksList.isEmpty());
    }

    //Método para mostrar telas diferentes na tabela de tarefas, caso tenha tarefas carrega uma, se não carrega outra
    private void showJTableTasks(boolean hasTasks) {
        if (hasTasks) {
            //Existem tarefas? Sim, remove a tela de Tarefas Vazias
            if (jPanelEmptyList.isVisible()) {
                jPanelEmptyList.setVisible(false);
                jPanel5.remove(jPanelEmptyList);
            }
            //Adiciona a tela da tabela com as tarefas do projeto
            jPanel5.add(jScrollPaneTasks);
            jScrollPaneTasks.setVisible(true);
            jScrollPaneTasks.setSize(jPanel5.getWidth(), jPanel5.getHeight());

        } else {
            //Existem tarefas? Não, remove a tela de tabela de tarefas
            if (jScrollPaneTasks.isVisible()) {
                jScrollPaneTasks.setVisible(false);
                jPanel5.remove(jScrollPaneTasks);
            }
            //Adiciona a tela de Tarefas Vazias
            jPanel5.add(jPanelEmptyList);
            jPanelEmptyList.setVisible(true);
            jPanelEmptyList.setSize(jPanel5.getWidth(), jPanel5.getHeight());
        }
    }

    // ################ Final da edição manual do código ######################


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelEmptyListIcon;
    private javax.swing.JLabel jLabelEmptyTasksSubTitle;
    private javax.swing.JLabel jLabelEmptyTasksTitle;
    private javax.swing.JLabel jLabelProjectsAdd;
    private javax.swing.JLabel jLabelProjectsTitle;
    private javax.swing.JLabel jLabelTasksAdd;
    private javax.swing.JLabel jLabelTasksTitle;
    private javax.swing.JLabel jLabelToolBarSubtitle;
    private javax.swing.JLabel jLabelToolBarTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelEmptyList;
    private javax.swing.JPanel jPanelProjectList;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPaneProjects;
    private javax.swing.JScrollPane jScrollPaneTasks;
    private javax.swing.JTable jTableTasks;
    // End of variables declaration//GEN-END:variables
}
