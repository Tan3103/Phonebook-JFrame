package UserMenu;

import Database.PackageData;
import Main.Main;
import MainMenu.LoginMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListMenu extends Container {
    public static JTextArea textArea;
    public MyListMenu(){
        setSize(600, 400);
        setLayout(null);

        JButton listButton = new JButton("LIST");
        listButton.setBounds(100, 50, 400, 30);
        add(listButton);

        textArea = new JTextArea();
        textArea.setBounds(100, 90, 400, 170);
        add(textArea);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(100, 270, 400, 30);
        add(backButton);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST MY PHONE", LoginMenu.user);
                Main.connect(pd);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.myListMenu.setVisible(false);
                Main.frame.userMenu.setVisible(true);
            }
        });
    }
}
