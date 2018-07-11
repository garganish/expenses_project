/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.util.List;
import javax.swing.JOptionPane;
import model.dao.categoryinfoDao;
import model.dao.sub_categoryinfoDao;
import model.to.categoryinfoTo;
import model.to.sub_categoryinfoTo;
import utility.operations;
import utility.validate;

/**
 *
 * @author anishgarg
 */
public class addsubCategory extends javax.swing.JInternalFrame {

    /**
     * Creates new form addsubCategory
     */
    public addsubCategory() {

        initComponents();
        jcbcategoryid.removeAllItems();
        jcbcategoryid.addItem("Choose Any Course");
        List<categoryinfoTo> courses = new categoryinfoDao().getAllRecord();
        if (courses != null && courses.size() > 0) {
            for (categoryinfoTo ct : courses) {
                jcbcategoryid.addItem(ct);
            }
        }
    }

    public addsubCategory(sub_categoryinfoTo record) {

        this();
        if (record != null) {
            jtfsubid.setText(String.valueOf(record.getSubcategoryinfo()));
            jtfsubname.setText(record.getSubcategoryname());
            for (int i = 1; i < jcbcategoryid.getItemCount(); i++) {
                categoryinfoTo element = (categoryinfoTo) jcbcategoryid.getItemAt(i);

                if (record.getCategoryid().equals(element.getCategoryid())) {
                    jcbcategoryid.setSelectedIndex(i);
                    break;
                }
            }

            jtfsubid.setEditable(false);//so that our primary key can't be changed.
            btnsubcategoryinfo.setText("Update SubCategory Details");
            setTitle("Update SubCategory Details");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfsubname = new javax.swing.JTextField();
        btnsubcategoryinfo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtfsubid = new javax.swing.JTextField();
        jcbcategoryid = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Add Sub Category");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Enter the SubCategoryName");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Enter the Category Id");

        jtfsubname.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        btnsubcategoryinfo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnsubcategoryinfo.setText("Add Subcategory");
        btnsubcategoryinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubcategoryinfoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Enter the SubCategoryID");

        jtfsubid.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jcbcategoryid.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jcbcategoryid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbcategoryid, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfsubname, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfsubid, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(btnsubcategoryinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfsubid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfsubname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbcategoryid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnsubcategoryinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsubcategoryinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubcategoryinfoActionPerformed
        // TODO add your handling code here:
        String subid = jtfsubid.getText();
        //categoryid is the variable name of the textfield used.
        String subname = jtfsubname.getText().trim();
        String message = "";
        boolean allvalid = true;
        if (validate.isEmpty(subname)) {
            message = "Plzz fill the subcategoryID";
            allvalid = false;
        }
        if (validate.isEmpty(subname)) {
            message = "Plzz fill the sub_categoryname";
            allvalid = false;
        }
        if (jcbcategoryid.getSelectedIndex() == 0) {
            message = "plzz choose any Category ID";
            allvalid = false;
        }

        if (allvalid) {
            sub_categoryinfoTo records = new sub_categoryinfoTo();
            categoryinfoTo ct = (categoryinfoTo) jcbcategoryid.getSelectedItem();
            records.setSubcategoryname(subname);
            records.setSubcategoryinfo(Integer.parseInt(subid));
            records.setCategoryid(ct.getCategoryid());
            sub_categoryinfoDao actions = new sub_categoryinfoDao();
            if (btnsubcategoryinfo.getText().contains("Add")) {
                if (actions.insertRecord(records)) {
                    message = "Sub Category Details has been saved in the system";
                } else {
                    message = "Insertion Failure" + actions.getErrormessage();
                }
            } else if (btnsubcategoryinfo.getText().contains("Update")) {
                if (actions.updateRecord(records)) {
                    message = "Category Details has been Updated in the system";
                } else {
                    message = "Update Failure" + actions.getErrormessage();
                }
                operations.openInternalFrame(getDesktopPane(), new viewSubCategory());
                dispose();
            } else {
                message = "Invalid Operation Performed";
            }
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnsubcategoryinfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsubcategoryinfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<Object> jcbcategoryid;
    private javax.swing.JTextField jtfsubid;
    private javax.swing.JTextField jtfsubname;
    // End of variables declaration//GEN-END:variables
}
