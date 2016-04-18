package mx.edu.utng.mememtomarco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CESAR on 17/04/2016.
 */
public class ChatRoomMediator extends ArrayAdapter{
    public ChatRoomMediator(Context context, ArrayList<User> users) {
        super(context,0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = (User)getItem(position);
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_layout, parent, false);

        }
        TextView txtUser = (TextView)convertView.findViewById(R.id.txt_user);
        txtUser.setText(user.getName() + ": " + user.getMessage());
        return convertView;
    }
}
