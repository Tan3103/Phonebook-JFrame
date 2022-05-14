package UserMenu;

import Main.Main;
import Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends Container {
    public UserMenu(){
        setSize(600, 400);
        setLayout(null);

        JButton listButton = new JButton("LIST PHONE NUMBER");
        listButton.setBounds(100, 50, 400, 25);
        add(listButton);

        JButton addButton = new JButton("ADD PHONE NUMBER");
        addButton.setBounds(100, 80, 400, 25);
        add(addButton);

        JButton deleteButton = new JButton("DELETE PHONE NUMBER");
        deleteButton.setBounds(100, 110, 400, 25);
        add(deleteButton);

        JButton findButton = new JButton("FIND PHONE NUMBER");
        findButton.setBounds(100, 110, 400, 25);
        add(findButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(100, 275, 400, 25);
        add(backButton);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.listMenu.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.addMenu.setVisible(true);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.deleteMenu.setVisible(true);
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.findMenu.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.mainMenu.setVisible(true);
            }
        });
    }
}
