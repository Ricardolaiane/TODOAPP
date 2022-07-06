package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.TaskController;
import model.Project;
import model.Task;

public class CreateTaskScreen extends JFrame {

	private JPanel contentPane;
//	private JTextField textFieldNameActivity;
//	private JFormattedTextField formattedTextField;
	TaskController taskController;
	Project project;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTaskScreen frame = new CreateTaskScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateTaskScreen() {
		
		taskController = new TaskController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelTask = new JPanel();
		panelTask.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panelTask, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelTask, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
					.addGap(0))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 139, 87));
		
		JPanel panelFormulario = new JPanel();
		panelFormulario.setBackground(Color.WHITE);
		GroupLayout gl_panelTask = new GroupLayout(panelTask);
		gl_panelTask.setHorizontalGroup(
			gl_panelTask.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
				.addComponent(panelFormulario, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
		);
		gl_panelTask.setVerticalGroup(
			gl_panelTask.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTask.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelFormulario, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setForeground(new Color(46, 139, 87));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JTextField textFieldNameActivity = new JTextField();
		textFieldNameActivity.setToolTipText("Informe o nome da atividade");
		textFieldNameActivity.setSelectionColor(new Color(0, 255, 0));
		textFieldNameActivity.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldNameActivity.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textFieldNameActivity.setColumns(10);
		
		JLabel lblDescription = new JLabel("Descrição");
		lblDescription.setForeground(new Color(46, 139, 87));
		lblDescription.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textAreaDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNotas = new JLabel("Notas");
		lblNotas.setForeground(new Color(46, 139, 87));
		lblNotas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JTextArea textAreaNotas = new JTextArea();
		textAreaNotas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textAreaNotas.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_6 = new JLabel("Prazo");
		lblNewLabel_6.setForeground(new Color(46, 139, 87));
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBorder(new LineBorder(Color.BLACK));
		formattedTextField.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
		formattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
		GroupLayout gl_panelFormulario = new GroupLayout(panelFormulario);
		gl_panelFormulario.setHorizontalGroup(
			gl_panelFormulario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFormulario.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelFormulario.createParallelGroup(Alignment.LEADING)
						.addComponent(textAreaNotas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(textAreaDescription, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(textFieldNameActivity, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(lblNewLabel_6)
						.addComponent(lblDescription, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(lblNotas, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(formattedTextField, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelFormulario.setVerticalGroup(
			gl_panelFormulario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFormulario.createSequentialGroup()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNameActivity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6)
					.addGap(4)
					.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaDescription, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNotas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaNotas, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addGap(22))
		);
		panelFormulario.setLayout(gl_panelFormulario);
		
		JLabel lblNewLabel = new JLabel("Tarefas");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					if(!textFieldNameActivity.getName().isEmpty() && !formattedTextField.getText().isEmpty()) {
						Task task = new Task();
						task.setidProject(project.getId());
						System.out.println("setor o id");
						task.setName(textFieldNameActivity.getText());
						System.out.println("setor o nome");
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date deadline;
						deadline = dateFormat.parse(formattedTextField.getText());
						System.out.println("converteu a data");
						
						task.setDeadline(deadline);
						task.setDescription(textAreaDescription.getText());
						task.setNotes(textAreaNotas.getText());
						task.setCompleted(false);

						
						taskController.save(task);

						JOptionPane.showMessageDialog(lblNewLabel_1, "Tarefa salva com sucesso");
						dispose();
					}else {
						JOptionPane.showMessageDialog(lblNewLabel_1, "A tarefa não foi salva, pois existem campos obrigatórios"
								+ " a serem preenchidos!");
					}
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(lblNewLabel_1, e2.getMessage());
				}
			}
		});
		
		
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(CreateTaskScreen.class.getResource("/Resources/check.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		panelTask.setLayout(gl_panelTask);
		contentPane.setLayout(gl_contentPane);
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
