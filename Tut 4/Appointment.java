import java.util.Date;

public class Appointment {
    private final Date date;
    private final String contact;

    public Appointment(Date date, String contact) {
        this.date = new Date(date.hashCode());
        this.contact = "" + contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        
    }

    public Date getDate() {
        return new Date(date.hashCode());
    }

    public void setDate(Date date) {
    	
    }

    public String toString() {
        return contact + " - " + date.toString();
    }
}
