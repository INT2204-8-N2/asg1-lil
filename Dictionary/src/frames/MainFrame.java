package frames;

import database.Dictionary;
import java.util.ArrayList;
import java.util.HashMap;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        currentDic = new Dictionary();
        eToV = new Dictionary("data/E_V.txt");
        vToE = new Dictionary("data/V_E.txt");
        reload();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchBar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        keysList = new javax.swing.JList();
        changeEToV = new javax.swing.JButton();
        changeVToE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        resultArea.setEditable(false);
        jScrollPane1.setViewportView(resultArea);
        resultArea.setContentType("text/html");

        keysList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        keysList.setToolTipText("");
        keysList.setName(""); // NOI18N
        keysList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keysListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(keysList);

        changeEToV.setText("E_V");
        changeEToV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeEToVMouseClicked(evt);
            }
        });

        changeVToE.setText("V_E");
        changeVToE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeVToEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(changeEToV)
                .addGap(18, 18, 18)
                .addComponent(changeVToE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeEToV)
                    .addComponent(changeVToE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keysListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keysListMouseClicked
        String selectedWord = (String) keysList.getSelectedValue();
        searchBar.setText(selectedWord);
        displayWordDefinition(selectedWord);      
    }//GEN-LAST:event_keysListMouseClicked

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        String word = searchBar.getText().trim();
        displayWordDefinition(word);
    }//GEN-LAST:event_searchBarActionPerformed

    private void changeEToVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeEToVMouseClicked
        currentDic = null;
        currentDic = eToV;
        reload();
    }//GEN-LAST:event_changeEToVMouseClicked

    private void changeVToEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeVToEMouseClicked
        currentDic = null;
        currentDic = vToE;
        reload();
    }//GEN-LAST:event_changeVToEMouseClicked
    
    private void displayKeys() {
        keysList.setListData(currentDic.getKeys().toArray());
    }
    
    private void displayWordDefinition(String key) {
        String meaning = hm.get(key);
        resultArea.setText(meaning);
    }
    
    private void reload() {
        searchBar.setText("");
        resultArea.setText("");
        hm = currentDic.getData();
        keys = currentDic.getKeys();
        displayKeys();
    }
    
    private Dictionary currentDic = null;
    private Dictionary eToV = null;
    private Dictionary vToE = null;
    private ArrayList<String> keys = null;
    private HashMap<String, String> hm = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeEToV;
    private javax.swing.JButton changeVToE;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList keysList;
    private javax.swing.JTextPane resultArea;
    private javax.swing.JTextField searchBar;
    // End of variables declaration//GEN-END:variables
}
