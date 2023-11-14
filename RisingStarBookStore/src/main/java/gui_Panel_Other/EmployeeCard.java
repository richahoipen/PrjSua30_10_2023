package gui_Panel_Other;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

import customEntities.Custom_ImageIcon;
import dataBase_BUS.NhanVien_BUS;
import swing.Button;
import swing.ImageAvatar;
import swing.PanelTransparent;

public class EmployeeCard extends PanelTransparent {
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel lbRole;
    private JLabel lbl_UserName;
    private ImageAvatar pic;
    private NhanVien_BUS sqlNhanVien_BUS=new NhanVien_BUS();

	// End of variables declaration//GEN-END:variables
    public EmployeeCard(String maNV) {
       
    	initComponents(maNV);
        setTransparent(0.5f);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(String maNV) {

        pic = new swing.ImageAvatar();
        lbl_UserName = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        //jSeparator1 = new javax.swing.JSeparator();


        pic.setIcon(new Custom_ImageIcon("src/main/images/view_image/Employee.png")); // NOI18N

        lbl_UserName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbl_UserName.setForeground(new java.awt.Color(127, 127, 127));
        lbl_UserName.setText(maNV);

        lbRole.setForeground(new java.awt.Color(127, 127, 127));
        lbRole.setText(sqlNhanVien_BUS.getTenNV(maNV));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                //.addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_UserName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRole, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_UserName)
                        .addComponent(lbRole))
                    .addComponent(pic)
                    )
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
}
