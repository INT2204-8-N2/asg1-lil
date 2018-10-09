package frames;

import database.Dictionary;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class MainFrame extends javax.swing.JFrame {

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
        definition = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        keysList = new javax.swing.JList();
        changeEToV = new javax.swing.JButton();
        changeVToE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        definition.setEditable(false);
        definition.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(definition);
        definition.setContentType("text/html");

        keysList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        keysList.setToolTipText("");
        keysList.setName(""); // NOI18N
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(changeEToV, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeVToE, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeEToV, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(changeVToE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    private DefaultListModel<String> getFilterModel(String filter) {

        DefaultListModel<String> filterModel = new DefaultListModel<>();
        ArrayList<String> _keysList = currentDic.getKeys();

        if (filter.isEmpty()) {
            _keysList.forEach((s) -> {
                filterModel.addElement(s);
            });
            return filterModel;
        }

        int matchedIndex = currentDic.binarySearch(_keysList, filter);

        if (matchedIndex != -1) {
            String matchedKey = _keysList.get(matchedIndex);

            while (matchedKey.startsWith(filter)) {
                filterModel.addElement(matchedKey);
                if (++matchedIndex >= _keysList.size()) {
                    break;
                }
                matchedKey = _keysList.get(matchedIndex);
            }
        }
        return filterModel;
    }
    
    private void displayKeys() {
        keysList.setListData(currentDic.getKeys().toArray());
    }
    
    private void displayWordDefinition(String key) {
        String meaning = currentDic.getData().get(key);
        definition.setText(meaning);
    }
    
    private void loadListener() {
        searchBar.addKeyListener(new SearchBarListener());
        keysList.addMouseListener(new ListKeysListener());
    }
    
    private void reload() {
        searchBar.setText("");
        definition.setText("");
        searchBar.setRequestFocusEnabled(true);
        loadListener();
        displayKeys();
    }
    
    private class SearchBarListener implements KeyListener {
            
        @Override
        public void keyPressed(KeyEvent e) {    
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String word = searchBar.getText();
                displayWordDefinition(word);
            }  
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() != KeyEvent.VK_ENTER) {
                String word = searchBar.getText();
                keysList.setListData(getFilterModel(word).toArray());
            }
        }

    }
    
    private class ListKeysListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            String selectedWord = (String) keysList.getSelectedValue();
            searchBar.setText(selectedWord);
            displayWordDefinition(selectedWord);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
    }
    
    private Dictionary currentDic = null;
    private Dictionary eToV = null;
    private Dictionary vToE = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeEToV;
    private javax.swing.JButton changeVToE;
    private javax.swing.JTextPane definition;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList keysList;
    private javax.swing.JTextField searchBar;
    // End of variables declaration//GEN-END:variables
}