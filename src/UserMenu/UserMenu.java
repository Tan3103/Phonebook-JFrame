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

        JButton listButton = new JButton("List all phone number");
        listButton.setFont(new Font("Verdana", Font.BOLD, 12));
        listButton.setBounds(100, 50, 400, 30);
        add(listButton);

        JButton myListButton = new JButton("List my phone number");
        myListButton.setFont(new Font("Verdana", Font.BOLD, 12));
        myListButton.setBounds(100, 90, 400, 30);
        add(myListButton);

        JButton addButton = new JButton("Add phone number");
        addButton.setFont(new Font("Verdana", Font.BOLD, 12));
        addButton.setBounds(100, 130, 400, 30);
        add(addButton);

        JButton deleteButton = new JButton("Delete phone number");
        deleteButton.setFont(new Font("Verdana", Font.BOLD, 12));
        deleteButton.setBounds(100, 170, 400, 30);
        add(deleteButton);

        JButton findButton = new JButton("Find phone number");
        findButton.setFont(new Font("Verdana", Font.BOLD, 12));
        findButton.setBounds(100, 210, 400, 30);
        add(findButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Verdana", Font.BOLD, 12));
        backButton.setBounds(100, 250, 400, 30);
        add(backButton);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.listMenu.setVisible(true);
            }
        });

        myListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.myListMenu.setVisible(true);
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
