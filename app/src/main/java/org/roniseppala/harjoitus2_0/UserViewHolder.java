package org.roniseppala.harjoitus2_0;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{
    TextView userName, userAla, userEmail,userTutkinto;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.txtDisplayUserName);
        userAla = itemView.findViewById(R.id.txtDisplayAla);
        userEmail = itemView.findViewById(R.id.txtDisplayEmail);
        userTutkinto = itemView.findViewById(R.id.tvTutkinnot);
    }


}
