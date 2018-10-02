package decisionmakingcontrolandroid.diu.com.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MyContacts {
    @SerializedName("contacts")
    @Expose
    private ArrayList<Contact> contacts = null;

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
