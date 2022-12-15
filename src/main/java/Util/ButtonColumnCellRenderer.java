package Util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

//Customizando as células do Editar e Excluir

public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {

    private String buttonType;

    public ButtonColumnCellRenderer(String buttonType){
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        //Pegando componente da classe pai
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        //Customizando a célula
        label.setHorizontalAlignment(JLabel.CENTER);

        //Mudando o arquivo .png de acordo com a mudança selecionada do buttonType através da pasta resource
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));

        return label;
    }

}
