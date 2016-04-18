package mx.edu.utng.mememtomarco;

import java.util.ArrayList;

/**
 * Created by CESAR on 17/04/2016.
 */
public class Originator {

    private ArrayList<User> users ;

    public Originator() {

    }

    public Originator(
            ArrayList<User> users) {
        this.users = users;
    }

    public Memento crearMemento(){
        return new Memento(users);
    }

    public void setMemento(Memento m){
        this.users = m.getUsers();
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
