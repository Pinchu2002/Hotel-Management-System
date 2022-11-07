import java.io.Serializable;
import java.util.ArrayList;

class Room implements Serializable{
    String name;
    String contact;
    String email;
    String gender;
    String aadhar;

    ArrayList<Food> food = new ArrayList<>();

    Room(){
        this.name = "";
    }
    Room(String name, String contact, String email, String gender, String aadhar){
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.gender = gender;
        this.aadhar = aadhar;
    }
}
