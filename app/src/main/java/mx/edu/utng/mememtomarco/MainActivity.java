package mx.edu.utng.mememtomarco;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private EditText edtUser, edtMsj;
    private Button btnSend, btnGuardar, btnRestaurar;
    private GridView grvUser;
    private ArrayList<User> users;
    private User user;
    private ChatRoomMediator cr;
    private ChatRoomMediator cr2;
    private Originator originator;
    private Carataker carataker;
    private Memento memento;
    private TextView txtrestaurado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        edtUser = (EditText)findViewById(R.id.edt_user);
        edtMsj = (EditText)findViewById(R.id.edt_msj);
        btnSend = (Button)findViewById(R.id.btn_send);
        btnGuardar= (Button)findViewById(R.id.btn_guardar);
        btnRestaurar =(Button)findViewById(R.id.btn_restaurar);
        grvUser = (GridView)findViewById(R.id.grv_users);
        users = new ArrayList<User>();
        user = new User();
        txtrestaurado = (TextView)findViewById(R.id.txt_restaurado);

        btnSend.setOnClickListener((View.OnClickListener) this);
        btnGuardar.setOnClickListener((View.OnClickListener) this);
        btnRestaurar.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.btn_guardar:
                // it was the first button

                Log.d("entra", "guardar");
                //insatnacia de objeto mementos, paso de variables
                originator = new Originator(users);
                //instancia Carataker
                carataker = new Carataker();
                //se le da el estado al objeto
                carataker.setMemento(originator.crearMemento());
                //Log.d("msg", );
                Toast.makeText(getApplicationContext(), "guardado: " + originator.getUsers(),
                        Toast.LENGTH_SHORT).show();


                break;
            case R.id.btn_restaurar:
                // it was the second button

                Log.d("entra 2", "rest");

                originator.setMemento(carataker.getMemento());

                //cr2 = new ChatRoomMediator(MainActivity.this,originator.getUsers());
                //grvUser.setAdapter(cr2);
                txtrestaurado.setText("Equipo restaurado: " + originator.getUsers());

                Toast.makeText(getApplicationContext(), "guardado: " +originator.getUsers() ,
                        Toast.LENGTH_SHORT).show();




                break;
            case R.id.btn_send:
                // it was the second button
                user.setName(edtUser.getText().toString());
                user.setMessage(edtMsj.getText().toString());
                //User userChat = (User)user.chatear();

                users.add((User)user.chatear());
                cr = new ChatRoomMediator(MainActivity.this,users);
                grvUser.setAdapter(cr);
                break;
        }

    }

}
