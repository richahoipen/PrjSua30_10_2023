package customEntities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.raven.model.SettingModel;

public class CustomTable extends JTable {

    private CustomTableHeader header;
    private CustomTableCell cell;
    private SettingModel settingModel;
    private void setting() {
		settingModel = new SettingModel();
		try {
			settingModel.readFrom();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public CustomTable() {
        header = new CustomTableHeader();
        cell = new CustomTableCell();
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, cell);
        setRowHeight(30);
        setting();
    }

    public void setColumnAlignment(int column, int align) {
        header.setAlignment(column, align);
    }

    public void setCellAlignment(int column, int align) {
        cell.setAlignment(column, align);
    }

    public void setColumnWidth(int column, int width) {
        getColumnModel().getColumn(column).setPreferredWidth(width);
        getColumnModel().getColumn(column).setMinWidth(width);
        getColumnModel().getColumn(column).setMaxWidth(width);
        getColumnModel().getColumn(column).setMinWidth(10);
        getColumnModel().getColumn(column).setMaxWidth(10000);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(30, 30, 30));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));
    }

    private class CustomTableHeader extends DefaultTableCellRenderer {

        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            String phongCach = settingModel.getPhongCach();
            String background = null, foreground = null;
        	if(phongCach.equals("Whitebright"))
    		{
        		background = "FFFFFF";
        		foreground = "C3ACD0";
    		}
        	if(phongCach.equals("Darkmode"))
    		{
        		background = "000000";
        		foreground = "F5F5F5";
    		}
            com.setBackground(new Custom_ColorPicker(background).toColor());
            com.setForeground(new Custom_ColorPicker(foreground).toColor());
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            if (alignment.containsKey(i1)) {
                setHorizontalAlignment(alignment.get(i1));
            } else {
                setHorizontalAlignment(JLabel.LEFT);
            }
            return com;
        }
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        // All cells are uneditable
        return false;
    }
    private class CustomTableCell extends DefaultTableCellRenderer {

        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }
        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column);
            String phongCach = settingModel.getPhongCach();
            String evenBackground = null, oddBackground = null,evenSelectedBackground = null,ovenSelectedBackground = null,foreground = null;
            if(phongCach.equals("Whitebright"))
    		{
        		evenBackground = "F7F7F7";
        		oddBackground = "FFFFFF";
        		evenSelectedBackground = "F8F8FF";
        		ovenSelectedBackground = "F1F1FF";
        		foreground = "696969";
    		}
            if(phongCach.equals("Darkmode"))
    		{
        		evenBackground = "323232";
        		oddBackground = "1E1E1E";
        		evenSelectedBackground = "216799";
        		ovenSelectedBackground = "1D567F";
        		foreground = "FFFFFF";
    		}
            if (!isCellSelected(row, column)) {
                if (row % 2 == 0) {
                    com.setBackground(new Custom_ColorPicker(evenBackground).toColor());
                } else {
                    com.setBackground(new Custom_ColorPicker(oddBackground).toColor());
                }
            } else {
                if (row % 2 == 0) {
                    com.setBackground(new Custom_ColorPicker(evenSelectedBackground).toColor());
                } else {
                    com.setBackground(new Custom_ColorPicker(ovenSelectedBackground).toColor());
                }
            }
            com.setForeground(new Custom_ColorPicker(foreground).toColor());
            setBorder(new EmptyBorder(0, 5, 0, 5));
            if (alignment.containsKey(column)) {
                setHorizontalAlignment(alignment.get(column));
            } else {
                setHorizontalAlignment(JLabel.LEFT);
            }
            return com;
        }
    }
}
