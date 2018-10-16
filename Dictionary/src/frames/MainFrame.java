package frames;

import database.Dictionary;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import com.sun.speech.freetts.*;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        eToV = new Dictionary("data/E_V.txt");
        vToE = new Dictionary("data/V_E.txt");
        currentDic = eToV;
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
        speaker = new javax.swing.JButton();
        speechRecognizer = new javax.swing.JButton();
        addWord = new javax.swing.JButton();
        removeWord = new javax.swing.JButton();

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
        keysList.setAutoscrolls(true);
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

        speaker.setText("Speak");
        speaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speakerActionPerformed(evt);
            }
        });

        speechRecognizer.setText("Speech");
        speechRecognizer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                speechRecognizerMouseClicked(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(changeEToV, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changeVToE, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(speaker, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(speechRecognizer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addWord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeWord))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeEToV)
                    .addComponent(changeVToE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(speaker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(speechRecognizer)
                        .addComponent(addWord)
                        .addComponent(removeWord)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void speakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speakerActionPerformed
        if (currentDic == eToV) {
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice(VOICENAME);
            voice.allocate();
            voice.speak(searchBar.getText());
        }
    }//GEN-LAST:event_speakerActionPerformed

    private void speechRecognizerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_speechRecognizerMouseClicked
        new SpeechFrame().setVisible(true);
    }//GEN-LAST:event_speechRecognizerMouseClicked

    private void addWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addWordMouseClicked
        System.out.println(currentDic.binarySearch(currentDic.getKeys(), "ADDD"));
        reload();
    }//GEN-LAST:event_addWordMouseClicked

    private void removeWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeWordMouseClicked
        currentDic.removeWord(keysList.getSelectedValue().toString());
        reload();
    }//GEN-LAST:event_removeWordMouseClicked
    
    private DefaultListModel<String> displayKeysListModel(String word) {

        DefaultListModel<String> keyModel = new DefaultListModel<>();
        ArrayList<String> _keysList = currentDic.getKeys();

        if (keyModel.isEmpty()) {
            displayKeys();
        }

        int index = currentDic.binarySearch(_keysList, word);

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
        return keyModel;
    }
    
    private void displayKeys() {
        keysList.setListData(currentDic.getKeys().toArray());
    }
    
    private void displayWordDefinition(String key) {
        if (currentDic.binarySearch(currentDic.getKeys(), key) != -1) {
            String meaning = currentDic.getData().get(key);
            definition.setText(meaning);
        } else {
            if (currentDic == eToV) {
                new APISearchFrame("en", "vi", searchBar.getText()).setVisible(true);
            } else {
                new APISearchFrame("vi", "en", searchBar.getText()).setVisible(true);
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
                String word = searchBar.getText();
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
                String word = searchBar.getText();
                keysList.setListData(displayKeysListModel(word).toArray());
                if (searchBar.getText().isEmpty()) {
                displayKeys();
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
                displayWordDefinition(searchBar.getText());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            searchBar.setText(keysList.getSelectedValue().toString());
        }
        
    }
    
    private Dictionary currentDic = null;
    private Dictionary eToV = null;
    private Dictionary vToE = null;
    private static final String VOICENAME = "kevin16";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWord;
    private javax.swing.JButton changeEToV;
    private javax.swing.JButton changeVToE;
    private javax.swing.JTextPane definition;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList keysList;
    private javax.swing.JButton removeWord;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton speaker;
    private javax.swing.JButton speechRecognizer;
    // End of variables declaration//GEN-END:variables
}