package jsonpretty;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Genaro Coronel
 */
public class Gui extends javax.swing.JFrame {

    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
        subInit();
    }

    private void subInit() {
        jScrollPane1.setSize(500, 700);
        textAreaInput.setSize(500, 700);
        scrollPaneArbol.setVisible(false);
        scrollPaneTextArea.hide();
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaInput = new javax.swing.JTextArea();
        scrollPaneTextArea = new javax.swing.JScrollPane();
        textAreaOut = new javax.swing.JTextArea();
        scrollPaneArbol = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();
        treeSelected = new javax.swing.JCheckBox();
        prettySelected = new javax.swing.JCheckBox();
        convertir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        textAreaInput.setBackground(new java.awt.Color(51, 51, 51));
        textAreaInput.setColumns(20);
        textAreaInput.setForeground(new java.awt.Color(204, 255, 204));
        textAreaInput.setRows(5);
        jScrollPane1.setViewportView(textAreaInput);

        textAreaOut.setBackground(new java.awt.Color(51, 51, 51));
        textAreaOut.setColumns(20);
        textAreaOut.setForeground(new java.awt.Color(204, 255, 204));
        textAreaOut.setRows(5);
        scrollPaneTextArea.setViewportView(textAreaOut);

        scrollPaneArbol.setMinimumSize(new java.awt.Dimension(0, 0));
        scrollPaneArbol.setPreferredSize(new java.awt.Dimension(100, 100));

        arbol.setBackground(new java.awt.Color(51, 51, 51));
        scrollPaneArbol.setViewportView(arbol);

        treeSelected.setText("Tree");
        treeSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeSelectedActionPerformed(evt);
            }
        });

        prettySelected.setText("Pretty");
        prettySelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prettySelectedActionPerformed(evt);
            }
        });

        convertir.setText("Visualizar");
        convertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(convertir, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(prettySelected)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(treeSelected)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(scrollPaneTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(scrollPaneArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(scrollPaneTextArea)
                    .addComponent(scrollPaneArbol, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prettySelected)
                    .addComponent(treeSelected))
                .addGap(18, 18, 18)
                .addComponent(convertir)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void convertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertirActionPerformed
        try {
            String inputJson = textAreaInput.getText();
            String outputJson = jsonTools.toPrettyFormat(inputJson);
            DefaultMutableTreeNode model = jsonTools.getModel(inputJson);
            textAreaOut.setText(outputJson);
            arbol.setModel(new DefaultTreeModel(model));
            MyTreeCellRenderer renderer = new MyTreeCellRenderer();
            arbol.setCellRenderer(renderer);
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_convertirActionPerformed

    private void prettySelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prettySelectedActionPerformed
        // TODO add your handling code here:
        if (prettySelected.isSelected()) {
            scrollPaneTextArea.setVisible(true);
        } else {
            scrollPaneTextArea.setVisible(false);
        }
        this.pack();
    }//GEN-LAST:event_prettySelectedActionPerformed

    private void treeSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treeSelectedActionPerformed
        if (treeSelected.isSelected()) {
            scrollPaneArbol.setVisible(true);

        } else {
            scrollPaneArbol.setVisible(false);
        }
        this.pack();
    }//GEN-LAST:event_treeSelectedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    //if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
                    //javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbol;
    private javax.swing.JButton convertir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox prettySelected;
    private javax.swing.JScrollPane scrollPaneArbol;
    private javax.swing.JScrollPane scrollPaneTextArea;
    private javax.swing.JTextArea textAreaInput;
    private javax.swing.JTextArea textAreaOut;
    private javax.swing.JCheckBox treeSelected;
    // End of variables declaration//GEN-END:variables
}
