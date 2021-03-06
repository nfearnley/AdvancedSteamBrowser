/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slugsource.steam.serverbrowser;

import com.slugsource.steam.servers.KillingFloorServer;
import com.slugsource.steam.servers.ServerAddress;
import com.slugsource.steam.servers.query.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author Nathan Fearnley
 */
public class BrowserGUI extends javax.swing.JFrame
{

    List<ServerAddress> serverList = new LinkedList<>();
    KillingFloorServer server = null;

    /**
     * Creates new form BrowserGUI
     */
    public BrowserGUI()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        serverTextArea = new javax.swing.JTextArea();
        queryMasterServerButton = new javax.swing.JButton();
        queryServerButton = new javax.swing.JButton();
        copyAddressButton = new javax.swing.JButton();
        refreshServerButton = new javax.swing.JButton();
        refreshServerListButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 300));

        jSplitPane1.setDividerLocation(300);

        addressList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(addressList);

        jSplitPane1.setLeftComponent(jScrollPane1);

        serverTextArea.setColumns(20);
        serverTextArea.setRows(5);
        jScrollPane2.setViewportView(serverTextArea);

        jSplitPane1.setRightComponent(jScrollPane2);

        queryMasterServerButton.setText("Query Master Servers");
        queryMasterServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryMasterServerButtonActionPerformed(evt);
            }
        });

        queryServerButton.setText("Query Server");
        queryServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryServerButtonActionPerformed(evt);
            }
        });

        copyAddressButton.setText("Copy IP:Port");
        copyAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyAddressButtonActionPerformed(evt);
            }
        });

        refreshServerButton.setText("Refresh");
        refreshServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshServerButtonActionPerformed(evt);
            }
        });

        refreshServerListButton.setText("Refresh");
        refreshServerListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshServerListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(queryMasterServerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshServerListButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(copyAddressButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshServerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(queryServerButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryMasterServerButton)
                    .addComponent(queryServerButton)
                    .addComponent(copyAddressButton)
                    .addComponent(refreshServerButton)
                    .addComponent(refreshServerListButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void queryServerButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_queryServerButtonActionPerformed
    {//GEN-HEADEREND:event_queryServerButtonActionPerformed
        int serverIndex = addressList.getSelectedIndex();
        if (serverIndex == -1)
        {
            return;
        }

        ServerAddress serverAddress = serverList.get(serverIndex);
        InetAddress address = serverAddress.getAddress();
        int port = serverAddress.getPort();
        
        server = new KillingFloorServer(address, port);

        SourceServerQuery srcQuery = new SourceServerQuery(address, port, server);
        KillingFloorServerQuery kfServerQuery = new KillingFloorServerQuery(address, server.getKFQueryPort(), server);
        KillingFloorGameQuery kfGameQuery = new KillingFloorGameQuery(address, server.getKFQueryPort(), server);
        KillingFloorPlayerQuery kfPlayerQuery = new KillingFloorPlayerQuery(address, server.getKFQueryPort(), server);
        
        Executor exec = Executors.newFixedThreadPool(4);
        exec.execute(srcQuery);
        exec.execute(kfServerQuery);
        exec.execute(kfGameQuery);
        exec.execute(kfPlayerQuery);
    }//GEN-LAST:event_queryServerButtonActionPerformed

    private void queryMasterServerButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_queryMasterServerButtonActionPerformed
    {//GEN-HEADEREND:event_queryMasterServerButtonActionPerformed

        InetAddress address;
        try
        {
            address = InetAddress.getByName("208.64.200.52");
        } catch (UnknownHostException ex)
        {
            // Should never happen
            return;
        }
        int port = 27011;
                
        serverList = new LinkedList<>();
        
        MasterServerQuery mQuery = new MasterServerQuery(address, port, "\\gamedir\\killingfloor", serverList);

        Executor exec = Executors.newSingleThreadExecutor();
        exec.execute(mQuery);
    }//GEN-LAST:event_queryMasterServerButtonActionPerformed

    private void copyAddressButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_copyAddressButtonActionPerformed
    {//GEN-HEADEREND:event_copyAddressButtonActionPerformed
        if (server != null)
        {
            String selection = server.getServerAddress().getAddress().getHostAddress() + ":" + server.getGamePort();
            StringSelection data = new StringSelection(selection);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(data, data);
        }
    }//GEN-LAST:event_copyAddressButtonActionPerformed

    private void refreshServerListButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_refreshServerListButtonActionPerformed
    {//GEN-HEADEREND:event_refreshServerListButtonActionPerformed
        addressList.setListData(serverList.toArray());
    }//GEN-LAST:event_refreshServerListButtonActionPerformed

    private void refreshServerButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_refreshServerButtonActionPerformed
    {//GEN-HEADEREND:event_refreshServerButtonActionPerformed
        if (server == null)
        {
            return;
        }
        serverTextArea.setText(server.toString());
    }//GEN-LAST:event_refreshServerButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(BrowserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(BrowserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(BrowserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(BrowserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable()
        {

            public void run()
            {
                new BrowserGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList addressList;
    private javax.swing.JButton copyAddressButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton queryMasterServerButton;
    private javax.swing.JButton queryServerButton;
    private javax.swing.JButton refreshServerButton;
    private javax.swing.JButton refreshServerListButton;
    private javax.swing.JTextArea serverTextArea;
    // End of variables declaration//GEN-END:variables
}
