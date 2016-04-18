package mx.edu.utng.mememtomarco;

/**
 * Created by CESAR on 17/04/2016.
 */
public class User implements Mediator{

    private String name;
    private String message;

    public User(){
        name = "";
        message = "";
    }

    public User (String name, String message){
        this.name = name;
        this.message = message;
    }

    @Override
    public Mediator chatear() {
        User chat = new User();
        chat.setName(name);
        chat.setMessage(message);
        return chat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }
}
