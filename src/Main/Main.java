package Main;

import Database.PackageData;
import Class.*;
import MainMenu.LoginMenu;
import UserMenu.DeleteMenu;
import UserMenu.FindMenu;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static MainFrame frame;

    public static void connect(PackageData pd){
        try{
            Socket socket = new Socket("127.0.0.1", 4512);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("ADD USER") || pd.getOperationType().equals("ADD PHONE") || pd.getOperationType().equals("DELETE PHONE")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("GET USER")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();

                User user = infoFromServer.getUser();
                LoginMenu.user = user;
            }
            else if(pd.getOperationType().equals("LIST PHONE")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<PhoneNumbers> arrayListFromServer = infoFromServer.getPhoneNumbersArrayList();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).toString() + "\n";
                }
                DeleteMenu.textArea.append(s);
            }
            else if(pd.getOperationType().equals("FIND NAME")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String name = infoFromServer.getLogin();

                FindMenu.textArea.append(name);
            }
            else if(pd.getOperationType().equals("FIND PHONE")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String find = infoFromServer.getLogin();

                FindMenu.textArea.append(find);
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}
