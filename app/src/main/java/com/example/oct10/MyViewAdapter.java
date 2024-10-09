package com.example.oct10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyViewAdapter extends RecyclerView.Adapter<MyViewAdapter.PersonViewHolder>{
    private Context context;
    private ArrayList<Person> valuesList;

    public MyViewAdapter(ArrayList<Person> valuesList,Context context) {
        this.context = context;
        this.valuesList = valuesList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new PersonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.fName.setText(valuesList.get(position).getFirstName());
        holder.lName.setText(valuesList.get(position).getLastName());
        holder.phone.setText(valuesList.get(position).getPhone());
        Person.Gender g = valuesList.get(position).getGender();
        holder.icon.setImageResource(Person.GenderUtils.setImage(g));
    }

    @Override
    public int getItemCount() {
        return valuesList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView fName,lName,phone;
        ImageView icon;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            fName=itemView.findViewById(R.id.tvFirstName);
            lName=itemView.findViewById(R.id.tvLastName);
            phone=itemView.findViewById(R.id.tvPhone);
            icon=itemView.findViewById(R.id.imgIcon);
        }
    }
}
