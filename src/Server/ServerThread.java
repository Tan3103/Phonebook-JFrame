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
                if(packageData.getOperationType().equals("ADD")){
                    User visitor = packageData.getVisitor();
                    manager.addVisitor(visitor);
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
