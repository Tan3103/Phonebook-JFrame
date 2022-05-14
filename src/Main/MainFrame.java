package Main;

import MainMenu.*;
import UserMenu.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu mainMenu;
    public static LoginMenu loginMenu;
    public static SignUpMenu signUpMenu;
    public static UserMenu userMenu;
    public static AddMenu addMenu;
    public static DeleteMenu deleteMenu;
    public static FindMenu findMenu;
    public static ListMenu listMenu;
    public static MyListMenu myListMenu;

    public MainFrame() {
        setSize(600, 400);
        setTitle("Phonebook");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        mainMenu = new MainMenu();
        mainMenu.setLocation(0, 0);
        add(mainMenu);

        loginMenu = new LoginMenu();
        loginMenu.setLocation(0, 0);
        loginMenu.setVisible(false);
        add(loginMenu);

        signUpMenu = new SignUpMenu();
        signUpMenu.setLocation(0, 0);
        signUpMenu.setVisible(false);
        add(signUpMenu);

        userMenu = new UserMenu();
        userMenu.setLocation(0, 0);
        userMenu.setVisible(false);
        add(userMenu);

        addMenu = new AddMenu();
        addMenu.setLocation(0, 0);
        addMenu.setVisible(false);
        add(addMenu);

        deleteMenu = new DeleteMenu();
        deleteMenu.setLocation(0, 0);
        deleteMenu.setVisible(false);
        add(deleteMenu);

        findMenu = new FindMenu();
        findMenu.setLocation(0, 0);
        findMenu.setVisible(false);
        add(findMenu);

        listMenu = new ListMenu();
        listMenu.setLocation(0, 0);
        listMenu.setVisible(false);
        add(listMenu);

        myListMenu = new MyListMenu();
        myListMenu.setLocation(0, 0);
        myListMenu.setVisible(false);
        add(myListMenu);
    }
}
