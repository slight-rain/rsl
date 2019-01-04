package server;

import listener.ClientListener;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ServerHeart extends Thread{
    private static ConcurrentHashMap<String,Long> hashMap=new ConcurrentHashMap<String, Long>();
    @Override
    public void run(){
        try {
            ServerSocket serverSocket = new ServerSocket(9096);
            while(true){
                Socket fromClient=serverSocket.accept();
                synchronized(ServerHeart.class) {
                    ClientListener listener = new ClientListener(fromClient,hashMap);
                    new Thread(listener).start();
                }
            }
        }catch(Exception e){

        }
    }
    public static void check(Long duration){
        System.out.println("检测客户端状态...");
        if(!hashMap.isEmpty()){
            for(Map.Entry<String,Long> entry:hashMap.entrySet()){
                if(System.currentTimeMillis()-entry.getValue()> TimeUnit.MINUTES.toMillis(duration)){
                    System.out.println(entry.getKey()+"is unavailable!");
                }
            }
        }
    }
}
