package frames;

import API.TranslatorAPI;
import database.Dictionary;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import com.sun.speech.freetts.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        eToV = new Dictionary("data/E_V.txt");
        vToE = new Dictionary("data/V_E.txt");
        currentDic = eToV;
        speech = new SpeechFrame();
        reload();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchBar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        keysList = new javax.swing.JList();
        changeEToV = new javax.swing.JButton();
        changeVToE = new javax.swing.JButton();
        speaker = new javax.swing.JButton();
        addWord = new javax.swing.JButton();
        removeWord = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        definition = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        speechItem = new javax.swing.JMenuItem();
        updateItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        addItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dreammy Dictionary");
        setIconImages(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        keysList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        keysList.setToolTipText("");
        keysList.setName(""); // NOI18N
        keysList.setAutoscrolls(true);
        jScrollPane2.setViewportView(keysList);

        changeEToV.setText("English - Vietnamese");
        changeEToV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeEToVMouseClicked(evt);
            }
        });

        changeVToE.setText("Vietnamese - English");
        changeVToE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeVToEMouseClicked(evt);
            }
        });

        speaker.setText("Speak");
        speaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speakerActionPerformed(evt);
            }
        });

        addWord.setText("Add");
        addWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addWordMouseClicked(evt);
            }
        });

        removeWord.setText("Remove");
        removeWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeWordMouseClicked(evt);
            }
        });

        modify.setText("Modify");
        modify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyMouseClicked(evt);
            }
        });

        save.setText("Save");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        update.setText("Update");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        definition.setEditable(false);
        definition.setContentType("text/html"); // NOI18N
        jScrollPane3.setViewportView(definition);

        fileMenu.setText("File");

        speechItem.setText("Speech");
        speechItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speechItemActionPerformed(evt);
            }
        });
        fileMenu.add(speechItem);

        updateItem.setText("Update");
        updateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemActionPerformed(evt);
            }
        });
        fileMenu.add(updateItem);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");

        addItem.setText("Add word");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });
        editMenu.add(addItem);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(speaker, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(update)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removeWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changeEToV, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changeVToE, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeEToV)
                    .addComponent(changeVToE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(searchBar)
                                .addComponent(speaker))
                            .addComponent(modify))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(addWord)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeWord)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(update)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        save.setVisible(false);

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

    private void speakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speakerActionPerformed
        if (currentDic == eToV) {
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice(VOICENAME);
            voice.allocate();
            voice.speak(searchBar.getText());
        }
    }//GEN-LAST:event_speakerActionPerformed

    private void addWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addWordMouseClicked
        new AddWordFrame(currentDic).setVisible(true);
        reload();
    }//GEN-LAST:event_addWordMouseClicked

    private void removeWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeWordMouseClicked
        currentDic.removeWord(keysList.getSelectedValue().toString());
        reload();
    }//GEN-LAST:event_removeWordMouseClicked

    private void modifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyMouseClicked
        if (!"".equals(searchBar.getText().trim())) {
            modify.setVisible(false);
            definition.setEditable(true);
            removeWord.setVisible(false);
            addWord.setVisible(false);
            update.setVisible(false);
            save.setVisible(true);
        }
    }//GEN-LAST:event_modifyMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        save.setVisible(false);
        modify.setVisible(true);
        update.setVisible(true);
        addWord.setVisible(true);
        removeWord.setVisible(true);
        String _word = searchBar.getText().trim();
        String _definition = definition.getText().trim();
        currentDic.getData().remove(_word);
        if (!"".equals(_word) && !"".equals(_definition)) {
            currentDic.getData().put(_word, _definition);
        }
        definition.setEditable(false);
    }//GEN-LAST:event_saveMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        eToV.update("data/E_V.txt");
        vToE.update("data/V_E.txt");
        reload();
    }//GEN-LAST:event_updateMouseClicked

    private void speechItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speechItemActionPerformed
        speech.setVisible(true);
    }//GEN-LAST:event_speechItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        dispose();        
        this.setVisible(false);
        voce.SpeechInterface.destroy();
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        new AddWordFrame(currentDic).setVisible(true);
        reload();
    }//GEN-LAST:event_addItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
        voce.SpeechInterface.destroy();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void updateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemActionPerformed
        eToV.update("data/E_V.txt");
        vToE.update("data/V_E.txt");
        reload();
    }//GEN-LAST:event_updateItemActionPerformed
    
    private int binarySearch(ArrayList<String> keys, String str) {
        int l = 0, r = keys.size() - 1; 
        while (l <= r) { 
            int m = l + (r-l)/2; 
            if (keys.get(m).equals(str)) 
                return m; 
            if (keys.get(m).compareTo(str) < 0) 
                l = m + 1; 
            else
                r = m - 1; 
        }
        return -1;
    }
    
    private DefaultListModel<String> displayKeysListModel(String word) {

        DefaultListModel<String> keyModel = new DefaultListModel<>();
        ArrayList<String> _keysList = currentDic.getKeys();

        if (keyModel.isEmpty()) {
            displayKeys();
        }

        int index = binarySearch(_keysList, word);

        if (index != -1) {
            String temp = _keysList.get(index);

            while (temp.startsWith(word)) {
                keyModel.addElement(temp);
                if (index >= _keysList.size()) {
                    break;
                }
                index++;
                temp = _keysList.get(index);
            }
        }
        else {
            String temp = "<Translate online>";
            keyModel.addElement(temp);
        }
        return keyModel;
    }
    
    private void displayKeys() {
        keysList.setListData(currentDic.getKeys().toArray());
    }
    
    private void displayWordDefinition(String key) {
        if (binarySearch(currentDic.getKeys(), key) != -1) {
            String meaning = currentDic.getData().get(key);
            definition.setText(meaning);
        } else {
            String from = null;
            String to = null;
            if (currentDic == eToV) {
                from = "en";
                to = "vi";
            } else if (currentDic == vToE) {
                from = "vi";
                to = "en";
            }
            try {
                String def = TranslatorAPI.translate(from, to, key);
                String _definition = "<html><i>" + key +
                "</i><br/><ul><li><font color='#cc0000'><b>" + def + 
                "</b></font></li></ul><i><b>\nTranslated by GoogleTranslate</i></b></html>";
                definition.setText(_definition);
            } catch (IOException ex) {
                definition.setText("#Internet disconnected");
            } 
        }
    }
                
    
    private void loadListener() {
        searchBar.addKeyListener(new SearchBarListener());
        ListKeysListener listener = new ListKeysListener();
        keysList.addMouseListener(listener);
        keysList.addKeyListener(listener);
    }
    
    private void reload() {
        searchBar.setText("");
        definition.setText("");
        loadListener();
        displayKeys();
    }
    
    private class SearchBarListener implements KeyListener {
            
        @Override
        public void keyPressed(KeyEvent e) {    
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String word = searchBar.getText().trim();
                displayWordDefinition(word);
            }  
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                definition.setText("");
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() != KeyEvent.VK_ENTER) {
                String word = searchBar.getText().trim();
                if (searchBar.getText().trim().isEmpty()) {
                displayKeys();
                } else {
                    keysList.setListData(displayKeysListModel(word).toArray());
                }
            }
        }

    }
    
    private class ListKeysListener implements MouseListener, KeyListener {

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

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                displayWordDefinition(searchBar.getText().trim());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            searchBar.setText(keysList.getSelectedValue().toString());
        }
        
    }
    
    public Dictionary getCurrentDic() {
        return currentDic;
    }
    
    private Dictionary currentDic = null;
    private Dictionary eToV = null;
    private Dictionary vToE = null;
    private SpeechFrame speech = null;
    private static final String VOICENAME = "kevin16";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addItem;
    private javax.swing.JButton addWord;
    private javax.swing.JButton changeEToV;
    private javax.swing.JButton changeVToE;
    private javax.swing.JEditorPane definition;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList keysList;
    private javax.swing.JButton modify;
    private javax.swing.JButton removeWord;
    private javax.swing.JButton save;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton speaker;
    private javax.swing.JMenuItem speechItem;
    private javax.swing.JButton update;
    private javax.swing.JMenuItem updateItem;
    // End of variables declaration//GEN-END:variables
}