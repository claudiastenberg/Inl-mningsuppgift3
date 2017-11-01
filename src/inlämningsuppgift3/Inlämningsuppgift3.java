
package inlämningsuppgift3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Inlämningsuppgift3 extends JFrame {
    Bricka pusselBricka = new Bricka();
    JButton shuffle = new JButton("Nytt spel");

    Inlämningsuppgift3() {
        
        
        setTitle("Slide Pussel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(pusselBricka);
        add(shuffle, BorderLayout.SOUTH);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        shuffle.setForeground(Color.BLACK);
        shuffle.setBackground(Color.WHITE);
        shuffle.setFont(new Font("Arial", Font.BOLD, 50));
        shuffle.setOpaque(true);
        
        
        
        shuffle.addActionListener((ActionEvent e) -> { // anonym innerklass
            pusselBricka.Nyttspel();
        }
        );
    }

    public static void main(String[] args) {
        Inlämningsuppgift3 ett = new Inlämningsuppgift3(); 
    }
    
}
