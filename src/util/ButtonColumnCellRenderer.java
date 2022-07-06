package util;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import view.TelaInicialView2;

public class ButtonColumnCellRenderer extends DefaultTableCellRenderer{
	
	private String buttonType;
	
	public ButtonColumnCellRenderer(String buttonType) {
		this.buttonType = buttonType;
	}
	
	@Override
	 public Component getTableCellRendererComponent(JTable table, Object value,
             boolean isSelected, boolean hasFocus, int row, int column) {
		
		JLabel label;
		label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		label.setHorizontalAlignment(CENTER);
		
		label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/"+ buttonType + ".png")));
		
		return label;
	}

	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}
	
	

}
