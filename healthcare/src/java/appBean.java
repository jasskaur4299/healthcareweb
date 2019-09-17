
import java.io.Serializable;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import comm.App;

@ManagedBean(name="appBean")
@SessionScoped
public class appBean implements Serializable {
    
    private String name;
     private String contact;
     private String age;
     private String symptom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

   
     
     public String app()
        {
            try 
            {
            
                Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml");
                SessionFactory sf = cfg.buildSessionFactory();
                Session s = sf.openSession();
                Transaction t = s.beginTransaction();
                 App a= new App (contact,name,age,symptom);
                    s.persist(a);
                    t.commit();
                   return "profile.xhtml";
            }   
                catch(Throwable ex) 
            {
                ex.printStackTrace();
                System.out.println("APPOINTMENT FIXED");
                return null;
            }
             
         
    }
}
