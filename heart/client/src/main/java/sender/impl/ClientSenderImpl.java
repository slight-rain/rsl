package sender.impl;

import entity.Msg;
import sender.ClientSender;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSenderImpl implements ClientSender {
    private ClientSenderImpl(){
    }
    private static ClientSenderImpl instance=null;
    public static ClientSenderImpl getInstance(){
        if(instance==null){
            synchronized (ClientSenderImpl.class) {
                instance = new ClientSenderImpl();
            }
        }
        return instance;
    }
    private Socket client=null;
    public void send() {
        try {
            client = new Socket(InetAddress.getLocalHost(),9096);
            ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
            Msg msg=new Msg();
            msg.setMessage("hello");
            msg.setStatus("normal");
            msg.setName("Janny");
            oos.writeObject(msg);
            oos.flush();
            System.out.println("已发送");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
