package com.example.mealer;

import org.junit.Test;

import static org.junit.Assert.*;

import android.provider.ContactsContract;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests {
    @Test
    public void checkGetEmailField() {
        ClientInfo client = new ClientInfo("emma","emma@gmail.com","emma123");
        assertTrue(client.getEmailAddressField() == "emma@gmail.com");
    }

    @Test
    public void roleValidation(){
        MainActivity activity = new MainActivity();
        DataBaseHelper db = new DataBaseHelper(activity);
        assertTrue(db.getRole("admin","adminpass")== 2);
    }

    @Test
    public void checkUserValidation(){
        MainActivity activity = new MainActivity();
        DataBaseHelper db = new DataBaseHelper(activity);
        assertFalse(db.checkUser(""));
    }

    @Test
    public void checkGetFirstNameField(){
        ClientInfo client = new ClientInfo("emma","emma@gmail.com","emma123");
        assertTrue(client.getFirstnameField() == "emma");
    }

    @Test
    public void checkGetEmailAddressField(){
        ClientInfo client = new ClientInfo("emma","emma@gmail.com","emma123");
        assertTrue(client.getEmailAddressField().equals("emma@gmail.com"));
    }

    @Test
    public void checkGetPasswordField(){
        ClientInfo client = new ClientInfo("emma","emma@gmail.com","emma123");
        assertTrue(client.getPasswordField().equals("emma123"));
    }

    @Test
    public void checkAddCart(){
        MainActivity activity = new MainActivity();
        DataBaseHelper DB = new DataBaseHelper(activity);

        DB.addCart("Pizza");
        assertTrue(DB.getCartItems().getCount() > 0);
    }

    @Test
    public void checkAddMeal(){
        MainActivity activity = new MainActivity();
        DataBaseHelper DB = new DataBaseHelper(activity);

        DB.addMeal("Pizza");
        assertTrue(DB.getMeals().getCount()>0);
    }

    @Test
    public void checkComplaints(){
        MainActivity activity = new MainActivity();
        DataBaseHelper DB = new DataBaseHelper(activity);

        DB.removeAllComplaints();
        assertTrue(DB.getComplaints().getCount() == 0);

    }

    @Test
    public void checkAddComplaint(){
        MainActivity activity = new MainActivity();
        DataBaseHelper DB = new DataBaseHelper(activity);

        DB.addComplaints("Bad", "jim");
        assertTrue(DB.getComplaints().getCount() >0);
    }

    @Test
    public void checkSuspension(){
        MainActivity activity = new MainActivity();
        DataBaseHelper DB = new DataBaseHelper(activity);

        DB.suspendAccount("jim","10");
        assertTrue(DB.isAccountSuspended("jim"));
    }

    @Test
    public void checkSuspensionDuration(){
        MainActivity activity = new MainActivity();
        DataBaseHelper DB = new DataBaseHelper(activity);

        DB.suspendAccount("jim","10");
        assertTrue(DB.getSuspendedAccountDuration("jim") == "10");
    }

}
