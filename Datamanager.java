package com.example.address_book_application;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Datamanager {

    private SQLiteDatabase db;
    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    private static final String TABLE_N_AND_A =
            "contact";




    public Datamanager(Context context) {
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public Cursor selectAll() {

        Cursor cursor = null;

        try {
            String query = "select * from contact order by name";
            cursor = db.rawQuery(query, null);
            //Log.i ("info", "In Datamanager selectAll try statement");
        } catch (Exception e) {
            Log.i("info", "In DataManager selectAll method");
            Log.i("info", e.getMessage());
        }

        //Log.i("info", "Loaded data " + cursor.getCount());
        return cursor;
    }



    public boolean updateDataManager(String prevName, String name11, String phone11, String email11, String address11,
                                     String facebook11, String city11, String state11, String zip11, String contacttype11) {




        ContentValues contentValues = new ContentValues();


        contentValues.put("name", name11);
        contentValues.put("phone", phone11);
        contentValues.put("email", email11);
        contentValues.put("address", address11);
        contentValues.put("facebook", facebook11);
        contentValues.put("city", city11);
        contentValues.put("state", state11);
        contentValues.put("zip",zip11);
        contentValues.put("contacttype", contacttype11);





        try {

            int updateValue = db.update("contact", contentValues, "name=?", new String[]{String.valueOf(prevName)});

            db.update("contact",contentValues,"name= ?" ,new String[]{prevName});
//            String updateQuery= "update contact set name"

            //db.update("contact", "(address11,name11,phone11)"+ " VALUES ('LAWRANCE STREET','REDDY','911')","WHERE _id=1",null);


            Log.i("Info","Update values is "+ updateValue);
            db.execSQL(String.valueOf(updateValue));
        }
        catch (SQLException e)
        {
            Log.i("Info", "error in update query");
        }

        Log.i("Info",  name11);


        return true;
    }


    public boolean deleteContact(String name22){


//        ContentValues contentValues = new ContentValues();
//
//
//        contentValues.put("name", name22);
//        contentValues.put("phone", phone22);
//        contentValues.put("email", email22);
//        contentValues.put("address", address22);
//        contentValues.put("facebook", facebook22);
//        contentValues.put("city", city22);
//        contentValues.put("state", state22);
//        contentValues.put("zip",zip22);
//        contentValues.put("contacttype", contacttype22);





        try {

            String name3 = name22;

//            String delteQuery = "DELETE FROM contact WHERE name = " + name22;


            String query = "DELETE FROM " + TABLE_N_AND_A +
                    " WHERE " + TABLE_ROW_NAME +
                    " = '" + name22 + "';";

            db.execSQL(query);
            db.close();
            return true;
        }
        catch (Exception e) {


            return false;
        }
    }








//        try{
//            String query = "update
//
//            db.execSQL(query);
//
//
//
//        }
//        catch (SQLException e) {
//            Log.i ("info", "In DataManager update method");
//            Log.i ("info", e.getMessage());
//        }
//        Log.i ("info", "updated  contact " + name);
//    }
//







    public void insert(String name, String phone, String email, String address,
                       String facebook, String city, String state, String zip, String contacttype) {

        try {
            String query = "insert into contact" +
                    "(name, phone, email, address,facebook, city, state, zip, contacttype) values " +
                    "( '" + name + "', '" + phone + "', '" + email + "', '" + address + "','" + facebook + "', '" + city +
                    "', '" + state + "', '" + zip + "', '" + contacttype + "' )";
            db.execSQL(query);
        } catch (SQLException e) {
            Log.i("info", "In DataManager insert method");
            Log.i("info", e.getMessage());
        }
        Log.i("info", "Added new contact " + name);
    }







    private class MySQLiteOpenHelper extends SQLiteOpenHelper {

        /**
         * Constructor os used to initialize the database name, and version number
         *
         * @param context
         */

        public static final String DATABASE_NAME="address_book";
        public static final String COL_1="ID";
        public static final String COL_2="NAME";
        public static final String COL_3="PHONE";
        public static final String COL_4="EMAIL";
        public static final String COL_5="ADDRESS";
        public static final String COL_6="FACEBOOK";
        public static final String COL_7="CITY";
        public static final String COL_8="STATE";
        public static final String COL_9="ZIP";
        public static final String COL_10="CONTACTTYPE";


        public MySQLiteOpenHelper(Context context) {
            super(context, "address_book", null, 2);



        }








        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                String newTable = "create table contact ("
                        + "_id integer primary key autoincrement not null, "
                        + "name text not null, "
                        + "phone text, "
                        + "email text, "
                        + "address text, "
                        + "facebook text, "
                        + "city text, "
                        + "state text, "
                        + "zip text, "
                        + "contacttype)";

                db.execSQL(newTable);
            } catch (SQLException e) {
                Log.i("info", "In DataManager onCreate method");
                Log.i("info", e.getMessage());
            }


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }



    }

//    public boolean updateee(String id111, String name111, String phone111, String email111, String address111,
//                            String facebook111, String city111, String state111, String zip111, String contacttype111){
//
//        //SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put("COL_1",id111);
//        contentValues.put("COL_2", name111);
//        contentValues.put("COL_3", phone111);
//        contentValues.put("COL_4", email111);
//        contentValues.put("COL_5", address111);
//        contentValues.put("COL_6", facebook111);
//        contentValues.put("COL_7", city111);
//        contentValues.put("COL_8", state111);
//        contentValues.put("COL_9",zip111);
//        contentValues.put("COL_10", contacttype111);
//        db.update("contact",contentValues,"id111=?",new String[]{id111});
//
//        return true;
//
//
//
//
//
//
//    }




}


