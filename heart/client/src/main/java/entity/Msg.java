package entity;

import java.io.Serializable;

public class Msg implements Serializable{

    private String status;
    private String message;
    private String name;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "[ status:"+status+
                ",message:"+message+"]";
    }
}
