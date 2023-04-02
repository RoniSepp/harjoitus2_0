package org.roniseppala.harjoitus2_0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder>{
    private UserStorage storage = UserStorage.getInstance();
    private Context context;
    private ArrayList<User> users = storage.getUsers();


    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        String tempTutkinto = "Suoritetut tutkinnot:\n";
        holder.userName.setText(users.get(position).getFirstNameName() + " " + users.get(position).getLastName());
        holder.userAla.setText((users.get(position).getDegreeProgram()));
        holder.userEmail.setText(users.get(position).getEmail());
        if ((users.get(position).getDI() || users.get(position).getKandi() || users.get(position).getTohtori() || users.get(position).getUima())){
            if (users.get(position).getKandi()){
                tempTutkinto = tempTutkinto + "-Kandidaatin tutkinto\n";
            }
            if (users.get(position).getDI()){
                tempTutkinto = tempTutkinto + "-Diplomi-insinöörin tutkinto\n";
            }
            if (users.get(position).getTohtori()){
                tempTutkinto = tempTutkinto + "-Tekniikan tohtorin tutkinto\n";
            }
            if (users.get(position).getUima()){
                tempTutkinto = tempTutkinto + "-Uimamaisteri\n";
            }
            holder.userTutkinto.setText(tempTutkinto);
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
