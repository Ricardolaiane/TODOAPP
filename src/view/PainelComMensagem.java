package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PainelComMensagem extends JPanel {

	
	public PainelComMensagem() {
		setBackground(new Color(0, 255, 127));
		setForeground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PainelComMensagem.class.getResource("/Resources/lists.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Nenhuma atividade criada...");
		lblNewLabel_1.setForeground(new Color(46, 139, 87));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("Clique no \"+\" para adicionar uma tarefa");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(159)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
					.addGap(163))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(192)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(192))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addGap(72))
		);
		setLayout(groupLayout);
		
		
		
		
	}
}
