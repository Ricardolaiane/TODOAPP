package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import controller.ProjectController;
import controller.TaskController;
import model.Project;
import model.Task;
import util.TaskTableModel;

public class backupTelaInicial {

	private JFrame frame;
	ProjectController projectController;
	TaskController taskController;
	JList listProjects = new JList();

	DefaultListModel projectsModel;

	TaskTableModel taskTableModel;

	JPanel panelEmptyList;
	JPanel panelMensagem;
	private JTable jTableTasks;
	JScrollPane scrollPane;
	PainelComMensagem mensagem;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					backupTelaInicial window = new backupTelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();	
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public backupTelaInicial() {
		initialize();
		initDataController();
		initComponentsModel();
		decorateJTableTasks();
		showTableTasks(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frame = new JFrame();
		frame.setMinimumSize(new Dimension(600, 700));
		frame.getContentPane().setMinimumSize(new Dimension(600, 800));
		frame.setBounds(100, 100, 710, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jPanelToobar = new JPanel();
		jPanelToobar.setMinimumSize(new Dimension(600, 800));
		jPanelToobar.setBackground(new Color(46, 139, 87));

		JPanel jPanelProjects = new JPanel();
		jPanelProjects.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanelProjects.setBackground(new Color(255, 255, 255));
		jPanelProjects.setForeground(new Color(255, 255, 255));

		JPanel JPanelTasks = new JPanel();
		JPanelTasks.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		JPanelTasks.setBackground(new Color(255, 255, 255));

		JPanel jPanelProjectList = new JPanel();
		jPanelProjectList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanelProjectList.setBackground(new Color(255, 255, 255));

		panelMensagem = new JPanel();
		panelMensagem.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelMensagem.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(jPanelToobar, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jPanelProjects, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanelProjectList, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelMensagem, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
								.addComponent(JPanelTasks, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(jPanelToobar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(JPanelTasks, GroupLayout.PREFERRED_SIZE, 61, Short.MAX_VALUE)
								.addComponent(jPanelProjects, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelMensagem, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
								.addComponent(jPanelProjectList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				);

		scrollPane = new JScrollPane();
		GroupLayout gl_panelMensagem = new GroupLayout(panelMensagem);
		gl_panelMensagem.setHorizontalGroup(
				gl_panelMensagem.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
				);
		gl_panelMensagem.setVerticalGroup(
				gl_panelMensagem.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
				);

		jTableTasks = new JTable();
		jTableTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jTableTasks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jTableTasks.setFocusable(false);
		jTableTasks.setIntercellSpacing(new java.awt.Dimension(0, 0));
		jTableTasks.setRowHeight(50);
		jTableTasks.setSelectionBackground(new java.awt.Color(204, 255, 204));
		jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jTableTasks.setShowHorizontalLines(false);
		jTableTasks.setShowVerticalLines(false);
		jTableTasks.getTableHeader().setReorderingAllowed(false);

		scrollPane.setViewportView(jTableTasks);
		jTableTasks.setPreferredSize(new Dimension(2700,2700));
		panelMensagem.setLayout(gl_panelMensagem);


		JScrollPane scrollPanelProjects = new JScrollPane();
		scrollPanelProjects.setForeground(Color.WHITE);
		scrollPanelProjects.setBackground(Color.WHITE);
		GroupLayout gl_jPanelProjectList = new GroupLayout(jPanelProjectList);
		gl_jPanelProjectList.setHorizontalGroup(
			gl_jPanelProjectList.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPanelProjects, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
		);
		gl_jPanelProjectList.setVerticalGroup(
			gl_jPanelProjectList.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPanelProjects, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
		);
		listProjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int projectIndex = listProjects.getSelectedIndex();
				Project project = (Project) projectsModel.get(projectIndex);
				loadTasks(project.getId());
			}
		});


		listProjects.setSelectionBackground(new Color(46, 139, 87));
		listProjects.setBackground(new Color(255, 250, 250));
		listProjects.setFont(new Font("Segoe UI", Font.BOLD, 15));
		listProjects.setForeground(new Color(0, 0, 0));
		listProjects.setFixedCellHeight(50);
		listProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPanelProjects.setViewportView(listProjects);
		jPanelProjectList.setLayout(gl_jPanelProjectList);

		JLabel jLabelTaskTitle = new JLabel("Tarefas");
		jLabelTaskTitle.setForeground(new Color(51, 102, 0));
		jLabelTaskTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));

		JLabel jLabelTasksAdd = new JLabel("");
		jLabelTasksAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				CreateTaskScreen createTaskScreen = new CreateTaskScreen();
				int projectIndex = listProjects.getSelectedIndex();
				Project project = (Project) projectsModel.get(projectIndex);
				createTaskScreen.setProject(project);

				createTaskScreen.setVisible(true);
				
				createTaskScreen.addWindowListener(new WindowAdapter() {
					
					@Override
					public void windowClosed(WindowEvent e) {
						int projectIndex = listProjects.getSelectedIndex();
						Project project = (Project) projectsModel.get(projectIndex);
						loadTasks(project.getId());
					}
				});
			}
				
		});
		jLabelTasksAdd.setIcon(new ImageIcon(backupTelaInicial.class.getResource("/Resorces/add.png")));
		GroupLayout gl_JPanelTasks = new GroupLayout(JPanelTasks);
		gl_JPanelTasks.setHorizontalGroup(
				gl_JPanelTasks.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_JPanelTasks.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabelTaskTitle, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
						.addComponent(jLabelTasksAdd)
						.addContainerGap())
				);
		gl_JPanelTasks.setVerticalGroup(
				gl_JPanelTasks.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_JPanelTasks.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_JPanelTasks.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabelTaskTitle)
								.addComponent(jLabelTasksAdd))
						.addGap(19))
				);
		JPanelTasks.setLayout(gl_JPanelTasks);

		JLabel jLabelProjectsTitle = new JLabel("Projetos");
		jLabelProjectsTitle.setForeground(new Color(51, 102, 0));
		jLabelProjectsTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));

		JLabel jLabelProjectsAdd = new JLabel("");
		jLabelProjectsAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen();
				projectDialogScreen.setVisible(true);

				projectDialogScreen.addWindowListener(new WindowAdapter() {
					public void  windowClosed(WindowEvent e) {
						loadProjects();
					}
				});
			}
		});
		jLabelProjectsAdd.setIcon(new ImageIcon(backupTelaInicial.class.getResource("/Resorces/add.png")));
		GroupLayout gl_jPanelProjects = new GroupLayout(jPanelProjects);
		gl_jPanelProjects.setHorizontalGroup(
				gl_jPanelProjects.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jPanelProjects.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabelProjectsTitle, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabelProjectsAdd)
						.addContainerGap())
				);
		gl_jPanelProjects.setVerticalGroup(
				gl_jPanelProjects.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelProjects.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_jPanelProjects.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(jLabelProjectsTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabelProjectsAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				);
		jPanelProjects.setLayout(gl_jPanelProjects);

		JLabel jLabelToobarTitle = new JLabel("To do App");
		jLabelToobarTitle.setIcon(new ImageIcon(backupTelaInicial.class.getResource("/Resorces/tick.png")));
		jLabelToobarTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
		jLabelToobarTitle.setForeground(new Color(255, 255, 255));

		JLabel jLabelToobarSubtitle = new JLabel("Anote tudo, n\u00E3o esque\u00E7a nada!");
		jLabelToobarSubtitle.setForeground(new Color(255, 255, 255));
		jLabelToobarSubtitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanelToobar = new GroupLayout(jPanelToobar);
		gl_jPanelToobar.setHorizontalGroup(
				gl_jPanelToobar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelToobar.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_jPanelToobar.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabelToobarTitle, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
								.addComponent(jLabelToobarSubtitle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
						.addContainerGap())
				);
		gl_jPanelToobar.setVerticalGroup(
				gl_jPanelToobar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelToobar.createSequentialGroup()
						.addComponent(jLabelToobarTitle)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jLabelToobarSubtitle)
						.addContainerGap(55, Short.MAX_VALUE))
				);
		jPanelToobar.setLayout(gl_jPanelToobar);
		frame.getContentPane().setLayout(groupLayout);



	}

	


	public void initDataController() {
		projectController = new ProjectController();
		taskController = new TaskController();
	}

	public void initComponentsModel() {
		projectsModel = new DefaultListModel<Project>();
		loadProjects();

		taskTableModel = new TaskTableModel();
		jTableTasks.setModel(taskTableModel);
		
		
		if(!projectsModel.isEmpty()) {
			listProjects.setSelectedIndex(0);
			int projectIndex = listProjects.getSelectedIndex();
			Project project = (Project) projectsModel.get(0);

			loadTasks(project.getId());
		}


	}

	private void showTableTasks(boolean hasTasks) {
		
		try {
			mensagem = new PainelComMensagem();
			mensagem.setVisible(true);
			
			if(hasTasks) {
				//Existe Tarefas
				if (mensagem.isVisible()) {
					mensagem.setVisible(false);
					panelMensagem.remove(mensagem);
					
				}
				panelMensagem.add(scrollPane);
				
				scrollPane.setVisible(true);
				System.out.println("Mostra tabela");
				scrollPane.setSize(panelMensagem.getWidth(),panelMensagem.getHeight());

			}else {
				//não existe tarefas
				if(scrollPane.isVisible()) {
					scrollPane.setVisible(false);
					panelMensagem.remove(scrollPane);
					
				}
				
				panelMensagem.add(mensagem);
				mensagem.setVisible(true);
			
				System.out.println("Mostra mensagem");
				mensagem.setSize(panelMensagem.getWidth(), panelMensagem.getHeight());
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private void loadTasks(int idProject) {
		List<Task> tasks = taskController.getAll(idProject);
		taskTableModel.setTasks(tasks);
		showTableTasks(!tasks.isEmpty());

	}

	private void decorateJTableTasks() {
		//To style table header
		jTableTasks.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		jTableTasks.getTableHeader().setOpaque(false);
		jTableTasks.getTableHeader().setBackground(new Color(0, 153, 102));
		jTableTasks.getTableHeader().setForeground(new Color(255, 255, 255));
		//Auto sort dos items da jTable
		jTableTasks.setAutoCreateRowSorter(true);

		//Add event 
		jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
				int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());

				//completar essa parte
			}
		});
	}

	private void loadProjects() {
		List<Project> projects = projectController.getAll();

		projectsModel.clear();

		for (int i = 0; i < projects.size(); i++) {
			projectsModel.addElement(projects.get(i));
		}
		listProjects.setModel(projectsModel);
	}
}

