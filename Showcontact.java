package com.example.address_book_application;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.address_book_application.Datamanager.*;

import java.util.ArrayList;

public class Showcontact extends DialogFragment {

    private TextView showname;
    private TextView showphone;
    private TextView showemail;
    private TextView showaddress;
    private TextView showfacebook;
    private TextView showcity;
    private TextView showstate;
    private TextView showzip;
    private TextView showcontacttype;
    private Button buttonmainmenu;
    private Button buttonupdate;
    private Button buttondelete;

    SQLiteOpenHelper mydb;


    private  String prevName="";

    private String prevName22="";
    private String delname="";

    private Contact contact;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater infalter = getActivity().getLayoutInflater();

        View dialogView = infalter.inflate(R.layout.view_contact, null);

        showname=dialogView.findViewById(R.id.viewnameid);
        showphone=dialogView.findViewById(R.id.viewphoneid);
        showemail=dialogView.findViewById(R.id.viewemailid);
        showaddress=dialogView.findViewById(R.id.viewaddressid);
        showfacebook=dialogView.findViewById(R.id.viewfacebookid);
        showcity=dialogView.findViewById(R.id.viewcityid);
        showstate=dialogView.findViewById(R.id.viewstateid);
        showzip=dialogView.findViewById(R.id.viewzipid);
        showcontacttype=dialogView.findViewById(R.id.viewcontactType);
        buttonmainmenu=dialogView.findViewById(R.id.viewmainmenu);
        buttonupdate=dialogView.findViewById(R.id.updatebutton);
        buttondelete=dialogView.findViewById(R.id.deletebutton);
        //buttonupdate=findViewById(R.id.updatebutton);



        showname.setText(contact.getName());
        prevName=contact.getName();
        prevName22=contact.getName();




        showphone.setText(contact.getPhone());
        showemail.setText(contact.getEmail());
        showaddress.setText(contact.getAddress());
        showfacebook.setText(contact.getFacebook());
        showcity.setText(contact.getCity());
        showstate.setText(contact.getState());
        showzip.setText(contact.getZip());
        showcontacttype.setText(contact.getContacttype());

        buttonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callUpdate();
            }
        });




        builder.setView(dialogView).setMessage("");

        buttonmainmenu.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dismiss();


            }
        });




//        buttonupdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String showname1=showname.getText().toString();
//                String showphone1=showphone.getText().toString();
//                String showemail1=showemail.getText().toString();
//                String showaddress1=showaddress.getText().toString();
//                String showfacebook1=showfacebook.getText().toString();
//                String showcity1=showcity.getText().toString();
//                String showstate1=showstate.getText().toString();
//                String showzip1=showzip.getText().toString();
//                String showcontacttype1=showcontacttype.getText().toString();
//
//                Contact contact3=new Contact(showname1,showphone1,showemail1,showaddress1,showfacebook1,showcity1,showstate1,showzip1,showcontacttype1);
//                MainActivity activity2=(MainActivity) getActivity();
//                activity2.updateContactmain(contact3);
//
//            }
//        });

        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callDelete();

            }
        });

//        public void onDeleteClick(View view)
//        {
//         callDelete();
//        }

        System.out.println("OnCreate");

        return builder.create();




    }

//    public void onDeleteClick(View n)
//    {
//        callDelete();
//    }

    public void callUpdate()
    {
        Intent addupdateIntent = new Intent(this.getActivity(),Updatecontact.class);

        addupdateIntent.putExtra("value1",contact.getName());
        addupdateIntent.putExtra("value2",contact.getPhone());
        addupdateIntent.putExtra("value3",contact.getEmail());
        addupdateIntent.putExtra("value4",contact.getAddress());
        addupdateIntent.putExtra("value5",contact.getFacebook());
        addupdateIntent.putExtra("value6",contact.getCity());
        addupdateIntent.putExtra("value7",contact.getState());
        addupdateIntent.putExtra("value8",contact.getZip());
        addupdateIntent.putExtra("value9",contact.getContacttype());
        addupdateIntent.putExtra("value10",prevName);
        startActivity(addupdateIntent);
    }

    public void callDelete(){


        Intent adddeleteIntent = new Intent(this.getActivity(),MainActivity.class);

                showname.getText();
                showphone.getText();
                showemail.getText();
                showaddress.getText();
                showfacebook.getText();
                showcity.getText();
                showstate.getText();
                showzip.getText();
                showcontacttype.getText();


                Datamanager d2 = new Datamanager(this.getContext());

                boolean a2=d2.deleteContact(prevName22);
                Log.i("Info",String.valueOf(a2));
                if (a2 == true){

                    Log.i("Info","deleted");
                }
                else{
                    Log.i("Info","not deleted");
                }

                startActivity(adddeleteIntent);

    }


    public void sendSelectedContacttolist (Contact contact) {


        this.contact = contact;
    }

    public void sendSelectedContact(Contact contact) {


        this.contact = contact;
    }
}
