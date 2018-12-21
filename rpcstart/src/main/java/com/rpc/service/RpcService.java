package com.rpc.service;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

public class RpcService implements Runnable {
    private Socket client;
    private Map<String, Object> service;
    public RpcService(Socket client,Map<String, Object> service){
        super();
        this.client=client;
        this.service=service;
    }

    public void run() {
        try {
            InputStream in = client.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            OutputStream out= client.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(out);
        }catch(Exception e){

        }
    }
}
