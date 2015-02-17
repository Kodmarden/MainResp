package kodmarden.kodmarden_contactlist;

/**
 * Created by magnus on 2/5/15.
 */
public class Contact {

    private String displayName;
    private String phoneNumber;
    private String email;

    public Contact(String displayName,String phoneNumber,String email)
    {
        this.displayName=displayName;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
    public Contact(String displayName,String phoneNumber)
    {
        this(displayName,phoneNumber,null);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString()
    {
        return this.displayName+/*"\t "+this.email+*/"\t "+this.phoneNumber;
    }


}
