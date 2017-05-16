import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/*
 *  htmlCodeThief
 *  Tento program stáhne HTML kód ze zadané URL do textového souboru
 */

/*
 * @author: Martin Bartoš, V2P, SPŠSE a VOŠ
 */
public class MainFrame extends javax.swing.JFrame {
      // Deklarace globálních proměnných
        PrintWriter zapis;
        String zdrojak;
        
    public MainFrame() {
        
        initComponents();
    }
    
    public String kontrolaUrl(String test){
        // Metoda pro kontrolu zadané URL, předpokládá, že alespoň základní
        // URL je zapsána do textFieldu
        String http = "https://";
        String full = "https://www.";
        String temp;
        if(test.startsWith("www")){
              temp = http + test;
              test = temp;
              temp = "";
            } else if(test.startsWith("https://")){
                
            }else{
                temp = full + test;
                test = temp;
                temp = "";
            }
        if(test.charAt(test.length()-1) == '/'){
        
        }else{
            test = test + "/";
        }
        jLabelStav.setText("Zkontrolováno a staženo!");
        return test;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPopisURL = new javax.swing.JLabel();
        jButtonSteal = new javax.swing.JButton();
        jTextFieldURL = new javax.swing.JTextField();
        jLabelPopisStav = new javax.swing.JLabel();
        jButtonZavrit = new javax.swing.JButton();
        jLabelStav = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelPopisURL.setText("URL:");

        jButtonSteal.setText("Stáhni zdroják");
        jButtonSteal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStealActionPerformed(evt);
            }
        });

        jTextFieldURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldURLActionPerformed(evt);
            }
        });

        jLabelPopisStav.setText("Stav:");

        jButtonZavrit.setText("Zavřít");
        jButtonZavrit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZavritActionPerformed(evt);
            }
        });

        jLabelStav.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPopisURL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldURL))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSteal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                        .addComponent(jButtonZavrit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPopisStav)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelStav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPopisURL)
                    .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPopisStav)
                    .addComponent(jLabelStav))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSteal)
                    .addComponent(jButtonZavrit))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldURLActionPerformed
        // Zde zadáme URL
    }//GEN-LAST:event_jTextFieldURLActionPerformed

    private void jButtonStealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStealActionPerformed
        
        // Tlačítko, které zavolá metodu kontrolaURL(), vymění opravenou URL zpět
        // do textFieldu a poté pomocí knnihovny Jsoup (po které jsem dlouho pátral)
        // stáhne HTML kód stránky a zapíše jej do textového souboru "txturl.txt".
        
        try {
                zapis = new PrintWriter("txturl.txt");
                zdrojak = kontrolaUrl(jTextFieldURL.getText());
                jTextFieldURL.setText(zdrojak);
                Element dokument = Jsoup.connect(zdrojak).get();
                String textak = dokument.html();
                zapis.println(textak);
                zapis.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }//GEN-LAST:event_jButtonStealActionPerformed

    private void jButtonZavritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZavritActionPerformed
        // Tlačítko pro ukončení programu
        System.exit(0);
    }//GEN-LAST:event_jButtonZavritActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSteal;
    private javax.swing.JButton jButtonZavrit;
    private javax.swing.JLabel jLabelPopisStav;
    private javax.swing.JLabel jLabelPopisURL;
    private javax.swing.JLabel jLabelStav;
    private javax.swing.JTextField jTextFieldURL;
    // End of variables declaration//GEN-END:variables
}
