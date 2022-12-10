package com.example.mealer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class  DataBaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
    public static final String TABLE_NAME = "complaints";
    //public static final String TABLE_NAME_CART = "cart";
    public static final String TABLE_NAME_SUSPENDED_ACCOUNTS= "suspended_accounts";
    public static final String CARTMEAL = "cartmeal";
    //public ContentValues menu = new ContentValues();
    public ContentValues offeredMeals = new ContentValues();
    //Content values that creates a cart
    public ContentValues cart = new ContentValues();
    public final String CART_TABLE = "CART_TABLE";
    public ArrayList<String> mcart = new ArrayList<>();





    public DataBaseHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT , flag INTEGER DEFAULT 0)");

        String complaints = ("create Table complaints(id INTEGER PRIMARY KEY AUTOINCREMENT, complaint TEXT,  cook_username TEXT)");
        MyDB.execSQL(complaints);

        MyDB.execSQL("create Table suspended_accounts(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, duration TEXT)");

        MyDB.execSQL("create Table meals(meal TEXT primary key)");

        MyDB.execSQL("create Table offeredMeals(meal TEXT primary key)");

        String crt = ("create Table CART_TABLE(meal TEXT primary key)");
        MyDB.execSQL(crt);


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public boolean isAccountSuspended(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from " + TABLE_NAME_SUSPENDED_ACCOUNTS+" where username = ?", new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public String getSuspendedAccountDuration(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from " + TABLE_NAME_SUSPENDED_ACCOUNTS+" where username = ?", new String[]{username});
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("duration");
            String duration = cursor.getString(columnIndex);
            return duration;
        }
        else {
            return "0";
        }
    }

    public boolean suspendAccount(String username, String duration) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("duration", duration);
        long result = MyDB.insert(TABLE_NAME_SUSPENDED_ACCOUNTS, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean activeAllAccount() {
        SQLiteDatabase MyDB = this.getWritableDatabase();

        //return MyDB.delete(TABLE_NAME_SUSPENDED_ACCOUNTS, "username" + "=" + username, null) > 0;
        return MyDB.delete(TABLE_NAME_SUSPENDED_ACCOUNTS,null,null)>0;
    }


    public boolean removeAllComplaints() {
        SQLiteDatabase MyDB = this.getWritableDatabase();

        //return MyDB.delete(TABLE_NAME_SUSPENDED_ACCOUNTS, "username" + "=" + username, null) > 0;
        return MyDB.delete(TABLE_NAME,null,null)>0;
    }


    public Cursor getComplaints() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor res = MyDB.rawQuery("select * from " + TABLE_NAME,null);

        return res;
    }

    public Boolean insertData(String username, String password, int flag) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("flag",flag);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

    public Boolean addComplaintsPrevious(String complaint1, String complaint2, String complaint3, String complaint4, String complaint5){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("complaint1", complaint1);
        contentValues.put("complaint2", complaint2);
        contentValues.put("complaint3", complaint3);
        contentValues.put("complaint4", complaint4);
        contentValues.put("complaint5", complaint5);
        long result = MyDB.insert("complaints",null,contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean addComplaints(String complaint,String cook_username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("complaint", complaint);
        contentValues.put("cook_username", cook_username);
        long result = MyDB.insert("complaints",null,contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean checkUser(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if(cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean checkInfo(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public int getRole(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        //String flag = "";
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?",new String[]{username, password});
        //Log.d("MYTAG",flag);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("flag");
        int flagValue = cursor.getInt(columnIndex);
        //Log.d("MYTAG",flagValue+"Value");
        return flagValue;
    }

    public Boolean addMeal(String meal){
        if(checkMealExist(meal)) {
            return true;
        }
        SQLiteDatabase MyDB = this.getWritableDatabase();
        //menu.put("meal", meal);
        ContentValues menu1 = new ContentValues();
        menu1.put("meal",meal);
        long result = MyDB.insert("meals",null,menu1);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean addCart(String meal){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        cart.put(CARTMEAL, meal);
        mcart.add(meal);
        mcart.add("pending");
        long result = MyDB.insert(CART_TABLE,null,cart);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
    // Getter method to retrieve the purchase status of the meal
    public String getStatus(String key){

        int i = mcart.indexOf(key);
        String s = mcart.get(i + 1);
        return s;
    }
    public void setStatus (String meal, String status){

        int i = mcart.indexOf(meal);
        mcart.set(i+1, status);

    }



    public Cursor getCartItems() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor res = MyDB.rawQuery("select * from cart",null);
        return res;
    }



    public Boolean checkMealExist(String meal) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from meals where meal = ?", new String[]{meal});
        if(cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean deleteMeal(String meal){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        //menu.remove("meal");
        long result = MyDB.delete("meals","meal=?",  new String[]{meal});
        if(result < 1){
            return false;
        }else{
            return true;
        }
    }

    // this method allows the user to offer a meal from their menu
    public Boolean offerMeal (String meal){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Boolean isMealExistInMenu = checkMealExist(meal);
        if (isMealExistInMenu){
            if(checkOfferMealExist(meal)){
                return true;
            }
            ContentValues offerMeal = new ContentValues();
            offerMeal.put("meal",meal);
            long result = MyDB.insert("offeredMeals",null,offerMeal);
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }
        else{
            return false;
        }
    }


    public Boolean checkOfferMealExist(String meal) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from offeredMeals where meal = ?", new String[]{meal});
        if(cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }

    // this method allows the user to remove a meal from their menu
    public Boolean removeMeal(String meal) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        //menu.remove("meal");
        long result = MyDB.delete("offeredMeals","meal=?",  new String[]{meal});
        if(result < 1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getMeals() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor res = MyDB.rawQuery("Select * from meals", null);

        return res;
    }




}



















    /*public static final String LOGIN_INFO = "LOGIN_INFO";
    public static final String EMAIL_ADDRESS = "EMAIL_ADDRESS";
    public static final String PASSWORD = "PASSWORD";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "loginInfo.db", null, 1);
    }

    //this is called when a database will be created... There should be code here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + LOGIN_INFO + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + EMAIL_ADDRESS + " TEXT, " + PASSWORD + " TEXT)";
        db.execSQL(createTableStatement);

    }
    // this is called if the database version number changes.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne (ClientInfo clientInfo) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(EMAIL_ADDRESS, clientInfo.getEmailAddressField());
        cv.put(PASSWORD, clientInfo.getPasswordField());
        // we need something like cv.put (isCook) Bool

        long insert = db.insert(LOGIN_INFO, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
}
    }*/

