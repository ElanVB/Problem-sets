import java.util.Date;
public class AppointmentAttacks {

    public static void attack1() {
        Appointment a = new Appointment(new Date(), "Johnny Bravo");
        System.out.println("BEFORE:");
        System.out.println(a); 
        a.setContact("Jiminy Cricket");        
        System.out.println("AFTER:");
        System.out.println(a); 
    }

    public static void attack2() {
        Appointment a = new Appointment(new Date(), "Johnny Bravo");
        System.out.println("BEFORE:");
        System.out.println(a); 
        a.setDate(new Date(0));        
        System.out.println("AFTER:");
        System.out.println(a); 
    }

    public static void attack3() {
        Appointment a = new Appointment(new Date(), "Johnny Bravo");
        System.out.println("BEFORE:");
        System.out.println(a); 
        //a.contact = "Jiminy Cricket";
        System.out.println("AFTER:");
        System.out.println(a); 
    }

    public static void attack4() {
        Appointment a = new Appointment(new Date(), "Johnny Bravo");
        System.out.println("BEFORE:");
        System.out.println(a); 
        //a.date = new Date(0);
        System.out.println("AFTER:");
        System.out.println(a); 
    }

    public static void attack5() {
        Appointment a = new Appointment(new Date(), "Johnny Bravo");
        System.out.println("BEFORE:");
        System.out.println(a); 
        Date d = a.getDate();
        d.setTime(0);
        System.out.println("AFTER:");
        System.out.println(a); 
    }

    public static void attack6() {
        Date d = new Date();
        Appointment a = new Appointment(d, "Johnny Bravo");
        System.out.println("BEFORE:");
        System.out.println(a); 
        d.setTime(0);
        System.out.println("AFTER:");
        System.out.println(a); 
    }
    
    public static void main(String[] args) {
        attack1();
        attack2();
        attack3();
        attack4();
        attack5();
        attack6();
    }
}
