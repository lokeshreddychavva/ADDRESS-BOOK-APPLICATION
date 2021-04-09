package com.example.address_book_application;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Addcontact extends DialogFragment {

    private EditText addname;
    private EditText addphone;
    private EditText addemail;
    private EditText addaddress;
    private EditText addfacebook;
    private EditText addcity;
    private EditText addstate;
    private EditText addzip;
    private RadioButton addfamily;
    private RadioButton addfriend;
    private RadioButton addbusiness;
    private Button addsave;
    private Button addclear;
    private Button addmainmenu;








    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.add_contact, null);





        addname=dialogView.findViewById(R.id.addNameid);
        addphone=dialogView.findViewById(R.id.addPhoneid);
        addemail=dialogView.findViewById(R.id.addEmailid);
        addaddress=dialogView.findViewById(R.id.addAddressid);
        addfacebook=dialogView.findViewById(R.id.addfacebookprofilelink);
        addcity=dialogView.findViewById(R.id.addCItyid);
        addstate=dialogView.findViewById(R.id.addStateid);
        addzip=dialogView.findViewById(R.id.addZipid);
        addfamily=dialogView.findViewById(R.id.addradioButtonfamily);
        addfriend=dialogView.findViewById(R.id.addradioButtonfriend);
        addbusiness=dialogView.findViewById(R.id.addradioButtonbusiness);
        addsave=dialogView.findViewById(R.id.buttonsave);
        addclear=dialogView.findViewById(R.id.buttonclear);
        addmainmenu=dialogView.findViewById(R.id.addbuttonbacktomainmenu);


        builder.setView(dialogView).setMessage(" ");


        addmainmenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dismiss();

            }
        });

        addclear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                addname.setText("");
                addphone.setText("");
                addemail.setText("");
                addaddress.setText("");
                addfacebook.setText("");
                addcity.setText("");
                addstate.setText("");
                addzip.setText("");
                addfamily.setChecked(true);





            }
        });

        addsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String addname2=addname.getText().toString();
                String addphone2=addphone.getText().toString();
                String addemail2=addemail.getText().toString();
                String addaddress2=addaddress.getText().toString();
                String addfacebook2=addfacebook.getText().toString();
                String addcity2=addcity.getText().toString();
                String addstate2=addstate.getText().toString();
                String addzip2=addzip.getText().toString();

                String typeOfcontact="";

                if(addbusiness.isChecked()){

                    typeOfcontact="business";

                }
                else if (addfamily.isChecked()){
                    typeOfcontact="family";
                }

                else {
                    typeOfcontact="friend";
                }

                Contact contact2=new Contact(addname2,addphone2,addemail2,addaddress2,addfacebook2,addcity2,addstate2,addzip2,typeOfcontact);

                MainActivity activity1=(MainActivity) getActivity();
                activity1.createNewContact(contact2);
                dismiss();


            }


        });

        return builder.create();
    }

}
