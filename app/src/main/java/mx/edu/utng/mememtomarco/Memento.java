package mx.edu.utng.mememtomarco;

import java.util.ArrayList;

/**
 * Created by CESAR on 17/04/2016.
 */
public class Memento {

    public Memento() {

    }

    private ArrayList<User> users;

    public Memento (
            ArrayList<User> users){
        this.users = users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
