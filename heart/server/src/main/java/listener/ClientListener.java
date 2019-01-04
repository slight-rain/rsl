package listener;

import entity.Msg;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ClientListener implements Runnable{
    Socket fromClient;
    ConcurrentHashMap<String,Long> hashMap;
    public ClientListener(Socket socket,ConcurrentHashMap<String,Long> map){
        fromClient=socket;
        hashMap=map;
    }

    public void run() {
        try {
            ObjectInput input = new ObjectInputStream(fromClient.getInputStream());
            Msg msg=(Msg)input.readObject();
            System.out.println(msg.toString());
            hashMap.put(msg.getName(),System.currentTimeMillis());

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
