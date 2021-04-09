package com.example.address_book_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.address_book_application.Datamanager.*;

public class Updatecontact extends AppCompatActivity {


    private EditText nameupdate;
    private EditText phoneupdate;

    private EditText emailupdate;
    private EditText addressupdate;
    private EditText facebookupdate;
    private EditText cityupdate;
    private EditText stateupdate;
    private EditText zipupdate;
    private EditText updatecontacttype;

    private Button buttonok;
    private String prevName="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        buttonok=findViewById(R.id.okbutton);

        Bundle bundle = getIntent().getExtras();

        nameupdate = findViewById(R.id.updatenameid);
        String a1 = bundle.getString("value1");
        nameupdate.setText(a1);

        phoneupdate = findViewById(R.id.updatephoneid);
        String a2 = bundle.getString("value2");
        phoneupdate.setText(a2);

        emailupdate = findViewById(R.id.updateemailid);
        String a3 = bundle.getString("value3");
        emailupdate.setText(a3);

        addressupdate = findViewById(R.id.updateaddressid);
        String a4 = bundle.getString("value4");
        addressupdate.setText(a4);

        facebookupdate = findViewById(R.id.updatefacebookid);
        String a5 = bundle.getString("value5");
        facebookupdate.setText(a5);

        cityupdate = findViewById(R.id.updatecityid);
        String a6 = bundle.getString("value6");
        cityupdate.setText(a6);

        stateupdate = findViewById(R.id.updatestateid);
        String a7 = bundle.getString("value7");
        stateupdate.setText(a7);

        zipupdate = findViewById(R.id.updatezipid);
        String a8 = bundle.getString("value8");
        zipupdate.setText(a8);

        updatecontacttype = findViewById(R.id.updatecontactType);
        String a9 = bundle.getString("value9");
        updatecontacttype.setText(a9);

        prevName =bundle.getString("value10");


    }

    public void onUpdateOkClick(View n){

        String updatename2=nameupdate.getText().toString();
        String updatephone2=phoneupdate.getText().toString();
        String updateemail2=emailupdate.getText().toString();
        String updateaddress2=addressupdate.getText().toString();
        String updatefacebook2=facebookupdate.getText().toString();
        String updatecity2=cityupdate.getText().toString();
        String updatestate2=stateupdate.getText().toString();
        String updatezip2=zipupdate.getText().toString();
        String updatecontacttype2=updatecontacttype.getText().toString();



        Datamanager d1= new Datamanager(Updatecontact.this);

        boolean a1= d1.updateDataManager(prevName,updatename2,updatephone2,updateemail2,updateaddress2,updatefacebook2,updatecity2,updatestate2,updatezip2,updatecontacttype2);

        Log.i("Info","Boolean value is "+ a1);

        if(a1= true)
        {
            Intent addmainIntent = new Intent(Updatecontact.this,MainActivity.class);

            startActivity(addmainIntent);

            Toast.makeText(Updatecontact.this,"Contat is updated",Toast.LENGTH_SHORT).show();

        }
        else
        {


        }


    }


}
