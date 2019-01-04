import sender.ClientSender;
import sender.impl.ClientSenderImpl;

import java.util.concurrent.TimeUnit;

public class ClientHeart extends Thread{
    @Override
    public void run() {
        ClientSender clientSender= ClientSenderImpl.getInstance();
        try{
            while(true){
                clientSender.send();
                synchronized (ClientHeart.class){
                    TimeUnit.MINUTES.sleep(2);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
