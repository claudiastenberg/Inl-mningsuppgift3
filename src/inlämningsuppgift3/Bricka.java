/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlämningsuppgift3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author claudiastenberg
 */
public class Bricka extends JPanel implements ActionListener {
        public List<JButton> knappar;
    public JButton knapp;
    

    public Bricka() {
        setLayout(new GridLayout(4, 4));

        knappar = new ArrayList<JButton>(16);
        for (int i = 1; i < 16; i++) {
            JButton knapp = new JButton(String.valueOf(i));
            knapp.setHorizontalAlignment(JButton.CENTER);
            knapp.setFont(new Font("Arial", Font.BOLD, 30));
            knapp.setForeground(Color.BLACK);
            knapp.setBackground(Color.WHITE);
            knapp.setOpaque(true);
            knappar.add(knapp);
            knapp.addActionListener(this); // Anropar ActionListner som kommer triggas av knapparna. 

        }
        JButton tomKnapp = new JButton("");
        tomKnapp.addActionListener(this); // Anropar ActionListner som triggas av knapparna. 
        tomKnapp.setFont(new Font("Arial", Font.BOLD, 30));
        tomKnapp.setForeground(Color.BLACK);
        tomKnapp.setBackground(Color.WHITE);
        tomKnapp.setOpaque(true);
        knappar.add(tomKnapp);

        Nyttspel();
    }

    
    /**
     * Metoden Nytt spel gör att knapparna blandas om vid nytt spel. Detta gör
     * vi med hjälp av Collections:shuffel. Metoden revalidate begär att
     * barnkomponenterna placeras om
     */
    public void Nyttspel() {
        Collections.shuffle(knappar);
        for (JButton knapp : knappar) {
            add(knapp);
        }
        revalidate();
    }

    /**
     * Denna actionListner talar om för den tomma rutan att ersätta sitt värde
     * med rutan bredvid. Den talar även om ifall du har vunnit spelet beroende
     * på vart komponenterna befinner sig.
     * @param e nödvändig för att vi ska kunna "flytta" texten i knapparna. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        knapp = (JButton) e.getSource();

        int emptyIndex = 0;
        int currentIndex = 0;
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        
        for (int i = 0; i < knappar.size(); i++) { 
            if (knappar.get(i).getText().equals("")) { // returnerar elementet där inehållet är det samma med ""
                emptyIndex = i; // då blir emptyIndex positionen i ArrayListan i.

            } else if (knappar.get(i).getText().equals(knapp.getText())) {
                currentIndex = i;
                left = currentIndex - 1;
                right = currentIndex + 1; 
                top = currentIndex - 4; 
                bottom = currentIndex + 4;
            
            } else if (knappar.get(3).getText().equals(knapp.getText()) 
                    || knappar.get(7).getText().equals(knapp.getText()) 
                    || knappar.get(11).getText().equals(knapp.getText())) {
                    right = currentIndex - 1;
            
            } else if (knappar.get(4).getText().equals(knapp.getText()) 
                    || knappar.get(8).getText().equals(knapp.getText()) 
                    || knappar.get(12).getText().equals(knapp.getText())) {
                    left = currentIndex + 1;
                    
            }
        }
   
        if (emptyIndex == left || emptyIndex == right || emptyIndex == top
                || emptyIndex == bottom) {
            JButton tomKnapp = knappar.get(emptyIndex);
            tomKnapp.setText(knapp.getText());
            knapp.setText("");
        }
        //Denna sats kollar om man vunnit 
        boolean vunnitNu = false;
        String allaNummer = " ";
        for (JButton b : knappar) {

            allaNummer += b.getText();

        }
        if (allaNummer.trim().equals("123456789101112131415")) {
            JOptionPane.showMessageDialog(null, "Grattis du vann!!");
            vunnitNu = true;
        } else {
            vunnitNu = false;
        }
    }
    
}
