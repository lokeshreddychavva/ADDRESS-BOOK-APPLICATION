package com.example.address_book_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ListItemHolder> {

    private MainActivity mainActivity;
    private List<Contact> contactList;

    public ContactAdapter(MainActivity mainActivity,List<Contact> contactList){

        this.mainActivity=mainActivity;
        this.contactList=contactList;



    }
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_contacts, parent, false);

        return new ListItemHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ListItemHolder holder, int position) {

        Contact contact = contactList.get(position);
        holder.textViewName.setText(contact.getName());
        holder.textViewType.setText(contact.getContacttype());

    }
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textViewName;
        private TextView textViewType;

        public ListItemHolder (View view) {
            super(view);

            textViewName = view.findViewById(R.id.textViewlistcontact);
            textViewType = view.findViewById(R.id.textViewcontacttype);

            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


            mainActivity.displayContact(getAdapterPosition());





        }





    }



}


