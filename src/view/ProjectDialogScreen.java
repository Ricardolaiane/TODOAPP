package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.ProjectController;
import model.Project;

public class ProjectDialogScreen extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JLabel lblProjectAdd;
	
	ProjectController controller;

	public static void main(String[] args) {
		try {
			ProjectDialogScreen dialog = new ProjectDialogScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProjectDialogScreen() {
		
		controller =  new ProjectController();
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		setBounds(100, 100, 358, 400);
		
		JPanel panelTitleProjects = new JPanel();
		panelTitleProjects.setBackground(new Color(46, 139, 87));
		
		JPanel panelProjects = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelProjects, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelTitleProjects, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTitleProjects, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelProjects, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
		);
		
		JLabel lblName = new JLabel("Nome");
		lblName.setForeground(new Color(46, 139, 87));
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNome.setColumns(10);
		textFieldNome.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblDescription = new JLabel("Descri\u00E7\u00E3o");
		lblDescription.setForeground(new Color(46, 139, 87));
		lblDescription.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textAreaDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_panelProjects = new GroupLayout(panelProjects);
		gl_panelProjects.setHorizontalGroup(
			gl_panelProjects.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelProjects.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelProjects.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
						.addComponent(textAreaDescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
						.addComponent(lblName, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelProjects.setVerticalGroup(
			gl_panelProjects.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProjects.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaDescription, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panelProjects.setLayout(gl_panelProjects);
		
		JLabel lblToobarProject = new JLabel("Projeto");
		lblToobarProject.setHorizontalAlignment(SwingConstants.LEFT);
		lblToobarProject.setForeground(Color.WHITE);
		lblToobarProject.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		lblProjectAdd = new JLabel("");
		lblProjectAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					if(!textFieldNome.getText().equals("")) {
						Project project = new Project();
						project.setName(textFieldNome.getText());
						project.setDescription(textAreaDescription.getText());
					
						controller.save(project);
						dispose();
					}else {
						JOptionPane.showMessageDialog(lblToobarProject, "O projeto não foi salvo"
								+ ", pois o campo nome está vazio");
					}
				
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(lblToobarProject, e2.getMessage());
				}
			
			
			}
			
		});
		
		
		
		lblProjectAdd.setIcon(new ImageIcon(ProjectDialogScreen.class.getResource("/Resources/check.png")));
		GroupLayout gl_panelTitleProjects = new GroupLayout(panelTitleProjects);
		gl_panelTitleProjects.setHorizontalGroup(
			gl_panelTitleProjects.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelTitleProjects.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblToobarProject, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblProjectAdd)
					.addContainerGap())
		);
		gl_panelTitleProjects.setVerticalGroup(
			gl_panelTitleProjects.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelTitleProjects.createSequentialGroup()
					.addGroup(gl_panelTitleProjects.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblToobarProject, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblProjectAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panelTitleProjects.setLayout(gl_panelTitleProjects);
		getContentPane().setLayout(groupLayout);
	}
}
