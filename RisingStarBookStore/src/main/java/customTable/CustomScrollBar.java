package customTable;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

import customEntities.CustomTable;

public class CustomScrollBar extends JScrollBar {

    public CustomScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(new Color(30, 30, 30));
    }
    
}
