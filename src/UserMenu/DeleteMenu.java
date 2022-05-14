package UserMenu;

import Database.PackageData;
import Main.Main;
import MainMenu.LoginMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMenu extends Container {
    public static JTextArea textArea;
    public DeleteMenu(){
        setSize(600, 400);
        setLayout(null);

        JButton listUserButton = new JButton("LIST");
        listUserButton.setBounds(50, 50, 400, 25);
        add(listUserButton);

        textArea = new JTextArea();
        textArea.setBounds(50, 80, 400, 200);
        add(textArea);

        JButton deleteProductButton = new JButton("Delete");
        deleteProductButton.setBounds(50, 330, 195, 30);
        add(deleteProductButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 330, 195, 30);
        add(backButton);

        JLabel label = new JLabel("Enter the number of the item you want to delete");
        label.setBounds(75, 300, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 300, 80, 25);
        add(numberField);

        listUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                PackageData pd = new PackageData("LIST PHONE", LoginMenu.user);
                Main.connect(pd);
            }
        });

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("DELETE PHONE", Integer.parseInt(numberField.getText()));
                Main.connect(pd);

                numberField.setText(null);
                textArea.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.deleteMenu.setVisible(false);
                Main.frame.userMenu.setVisible(true);
            }
        });
    }
}
