package com.example.address_book_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import  com.example.address_book_application.Datamanager.*;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contact> listofcontacts;
    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;


    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private Datamanager datamanager;

    private Button btnviewUpdate;
    private EditText updateid1;






    @Override
    protected void onCreate(Bundle savedInstanceState) {


        btnviewUpdate=(Button)findViewById(R.id.updatebutton);









        super.onCreate(savedInstanceState);

        listofcontacts=new ArrayList<Contact>();
        datamanager=new Datamanager(this);



        preferences=getSharedPreferences("Address book App",MODE_PRIVATE);
        editor=preferences.edit();



        String user=preferences.getString("user","");

        if(user.equals("")){
            user="Lokesh";
            editor.putString("user",user);
            editor.commit();


        }

        setContentView(R.layout.activity_main);
        this.setTitle(""+"Address book App");


        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fabAddContact = findViewById(R.id.fabAddContact);
        fabAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Addcontact dialog = new Addcontact();
                dialog.show(getSupportFragmentManager(), "");
            }
        });


        recyclerView = findViewById(R.id.recyclerView);
        contactAdapter = new ContactAdapter(this, listofcontacts);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(contactAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();

    }




    public void loadData () {
        Cursor cursor = datamanager.selectAll();
        int contactCount = cursor.getCount();

        listofcontacts.clear();

        Log.i("info", "Number of contact " + contactCount);
        if (contactCount > 0) {


            while (cursor.moveToNext()) {
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                String email = cursor.getString(3);
                String address = cursor.getString(4);
                String facebook = cursor.getString(5);
                String city = cursor.getString(6);
                String state = cursor.getString(7);
                String zip = cursor.getString(8);
                String contactType = cursor.getString(9);

                Contact contact = new Contact(name, phone, email, address, facebook, city, state, zip, contactType);

                listofcontacts.add(contact);
            }



        }
        contactAdapter.notifyDataSetChanged();
    }





    public void createNewContact (Contact contact) {
        String name = contact.getName();
        String phone = contact.getPhone();
        String email = contact.getEmail();
        String address = contact.getAddress();
        String facebook=contact.getFacebook();
        String city = contact.getCity();
        String state = contact.getState();
        String zip = contact.getZip();
        String contactType = contact.getContacttype();

        datamanager.insert(name, phone, email, address,facebook, city, state, zip, contactType);
        loadData();





    }







//    public void updateContactmain(Contact contact){
//
//
//        final String name = contact.getName();
//        final String phone = contact.getPhone();
//        final String email = contact.getEmail();
//        final String address = contact.getAddress();
//        final String facebook=contact.getFacebook();
//        final String city = contact.getCity();
//        final String state = contact.getState();
//        final String zip = contact.getZip();
//        final String contacttype = contact.getContacttype();

//        //final boolean isUpdated;
//        btnviewUpdate.setOnClickListener(
//
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                       boolean isUpdated=datamanager.updateContactDatamanager(name,phone,email,address,facebook,city,state,zip,contacttype);
//
//
//                    }
//                }
//        );


//    }








    public void displayContact(int contactToShow) {
        Showcontact dialog = new Showcontact();

        //dialog.OncreateDialog(null);
        dialog.sendSelectedContacttolist(listofcontacts.get(contactToShow));
        dialog.show(getSupportFragmentManager(), "");
    }





    public void updateContactmain(Contact contact3) {

//        String name = contact3.getName();
//        String phone = contact3.getPhone();
//        String email = contact3.getEmail();
//        String address = contact3.getAddress();
//        String facebook=contact3.getFacebook();
//        String city = contact3.getCity();
//        String state = contact3.getState();
//        String zip = contact3.getZip();
//        String contactType = contact3.getContacttype();
//
//        datamanager.updateDataManager(name, phone, email, address,facebook, city, state, zip, contactType);
//        loadData();


    }

//    public  void deleteContactmain(Contact contact){
//
//
//
//        String name = contact.getName();
//        String phone = contact.getPhone();
//        String email = contact.getEmail();
//        String address = contact.getAddress();
//        String facebook=contact.getFacebook();
//        String city = contact.getCity();
//        String state = contact.getState();
//        String zip = contact.getZip();
//        String contactType = contact.getContacttype();
//
//
//
//        datamanager.deleteContact(name);
//
//
//
//    }
//






}
