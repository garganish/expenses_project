/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Grapess
 */
public class CurrentDatePanel extends javax.swing.JPanel {

    GregorianCalendar gcal;

    public CurrentDatePanel() {
        initComponents();
        gcal = new GregorianCalendar();
        jcbYear.removeAllItems();
        jcbYear.addItem("Year");
        int currentyear = gcal.get(Calendar.YEAR);
        for (int year = currentyear; year >= 1950; year--) {
            jcbYear.addItem(year);
        }
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbYear = new javax.swing.JComboBox();
        jcbMonth = new javax.swing.JComboBox();
        jcbDate = new javax.swing.JComboBox();

        jcbYear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbYearItemStateChanged(evt);
            }
        });

        jcbMonth.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMonthItemStateChanged(evt);
            }
        });

        jcbDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcbDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYearItemStateChanged
        int selected_date = jcbDate.getSelectedIndex();
        int selected_month = jcbMonth.getSelectedIndex();
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        if (jcbYear.getSelectedIndex() > 0) {
            int syear = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int cyear = gcal.get(Calendar.YEAR);
            Months[] monthlist = Months.values();
            int endindex = monthlist.length - 1;
            if (syear == cyear) {
                endindex = gcal.get(Calendar.MONTH);
            }
            for (int index = 0; index <= endindex; index++) {
                jcbMonth.addItem(monthlist[index]);
            }
            if (selected_month < jcbMonth.getItemCount()) {
                jcbMonth.setSelectedIndex(selected_month);
            }
            if (selected_date < jcbDate.getItemCount()) {
                jcbDate.setSelectedIndex(selected_date);
            }
        }
    }//GEN-LAST:event_jcbYearItemStateChanged

    private void jcbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMonthItemStateChanged
        int selected_date = jcbDate.getSelectedIndex();
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0) {
            int syear = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int cyear = gcal.get(Calendar.YEAR);
            Months smonth = (Months) jcbMonth.getSelectedItem();
            int cmonth = gcal.get(Calendar.MONTH);
            int daterange = smonth.getTotalDate();
            if (syear == cyear && smonth.ordinal() == cmonth) {
                daterange = gcal.get(Calendar.DATE);
            } else if (smonth == Months.February) {
                daterange = gcal.isLeapYear(syear) ? 29 : 28;
            }
            for (int date = 1; date <= daterange; date++) {
                jcbDate.addItem(date);
            }
            if (selected_date < jcbDate.getItemCount()) {
                jcbDate.setSelectedIndex(selected_date);
            }
        }
    }//GEN-LAST:event_jcbMonthItemStateChanged

    public Date getSelectedDate() {
        Date datevalue = null;
        try {
            if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0 && jcbDate.getSelectedIndex() > 0) {
                int year = Integer.parseInt(jcbYear.getSelectedItem().toString());
                int month = jcbMonth.getSelectedIndex();
                int date = jcbDate.getSelectedIndex();
                String datestring = year + "-" + month + "-" + date;
                datevalue = Date.valueOf(datestring);
            }
        } catch (Exception ex) {
        }
        return datevalue;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jcbDate;
    private javax.swing.JComboBox jcbMonth;
    private javax.swing.JComboBox jcbYear;
    // End of variables declaration//GEN-END:variables

    public void setDate(Date date) {
        try {
            String[] values = date.toString().split("-");
            int yr = Integer.parseInt(values[0]);
            int mon = Integer.parseInt(values[1]);
            int dt = Integer.parseInt(values[2]);
            for( int i = 1; i < jcbYear.getItemCount(); i++){
                int year = Integer.parseInt(jcbYear.getItemAt(i).toString());
                if(year == yr){
                    jcbYear.setSelectedIndex(i);                    
                    break;
                }
            }
            jcbMonth.setSelectedIndex(mon);
            jcbDate.setSelectedIndex(dt);
        } catch (Exception ex) {
        }
    }
}
