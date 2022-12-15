package Util;

import Model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Date;

public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        //Pegando componente da classe pai
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        //Customizando a célula
        label.setHorizontalAlignment(CENTER);

        TaskTableModel taskTableModel = (TaskTableModel) table.getModel();
        Task task = taskTableModel.getTasks().get(row);

        //Condicional para mudar cor do fundo da célula
        if(task.getDeadline().after(new Date())){
            label.setBackground(Color.GREEN);
        }else{
            label.setBackground(Color.RED);
        }
        return label;
    }
}
