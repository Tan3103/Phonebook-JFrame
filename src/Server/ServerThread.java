package Server;
import Database.DBManager;
import Database.PackageData;
import Class.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try{
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;

            while((packageData = ((PackageData)inputStream.readObject())) != null){
                if(packageData.getOperationType().equals("ADD USER")){
                    User user = packageData.getUser();
                    manager.addUser(user);
                    break;
                }
                else if(packageData.getOperationType().equals("ADD PHONE")){
                    PhoneNumbers phoneNumbers = packageData.getPhoneNumbers();
                    User user = packageData.getUser();
                    manager.addPhone(phoneNumbers, user);
                    break;
                }
                else if(packageData.getOperationType().equals("GET USER")){
                    User user = manager.getUser(packageData.getLogin());
                    PackageData toPercussion = new PackageData(user);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("LIST MY PHONE")){
                    ArrayList<PhoneNumbers> arrayPhone = manager.getMyPhone(packageData.getUser());
                    PackageData toKeyboard = new PackageData();
                    toKeyboard.setPhoneNumbersArrayList(arrayPhone);
                    outputStream.writeObject(toKeyboard);
                    break;
                }
                else if(packageData.getOperationType().equals("LIST PHONE")){
                    ArrayList<PhoneNumbers> arrayPhone = manager.getAllPhone(packageData.getUser());
                    PackageData toKeyboard = new PackageData();
                    toKeyboard.setPhoneNumbersArrayList(arrayPhone);
                    outputStream.writeObject(toKeyboard);
                    break;
                }
                else if(packageData.getOperationType().equals("DELETE PHONE")){
                    int idServer = packageData.getId();
                    manager.deletePhone(idServer);
                    break;
                }
                else if(packageData.getOperationType().equals("FIND NAME")){
                    ArrayList<PhoneNumbers> findName = manager.findName(packageData.getLogin());
                    PackageData pd = new PackageData();
                    pd.setPhoneNumbersArrayList(findName);
                    outputStream.writeObject(pd);
                    break;
                }
                else if(packageData.getOperationType().equals("FIND PHONE")){
                    ArrayList<PhoneNumbers> findName = manager.findPhone(packageData.getLogin());
                    PackageData pd = new PackageData();
                    pd.setPhoneNumbersArrayList(findName);
                    outputStream.writeObject(pd);
                    break;
                }
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
