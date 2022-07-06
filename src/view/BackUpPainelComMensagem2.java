package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Font;

public class BackUpPainelComMensagem2 extends JPanel {

	
	public BackUpPainelComMensagem2() {
		setBackground(new Color(255, 255, 255));
		setForeground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BackUpPainelComMensagem2.class.getResource("/resorces/lists.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Nenhuma Tarefa for aqui...");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(46, 139, 87));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("Clique no \"+\" para adicionar uma tarefa\r\n");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(157)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(145))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(184)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(200))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(97))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addGap(16)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(96))
		);
		setLayout(groupLayout);
		
		
		
		
	}
}
