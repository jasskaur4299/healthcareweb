
import java.io.Serializable;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import comm.App;
import org.hibernate.Query;
import java.util.List;


@ManagedBean(name="cancelappointmentBean")
@SessionScoped
public class cancelappointmentBean implements Serializable {
    
    private String contact;

    public String getcontact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
  public String cancel()
        {
            try 
            {
                Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml");
                SessionFactory sf = cfg.buildSessionFactory();
                Session s = sf.openSession();
                Transaction t = s.beginTransaction();
                Query q = s.createQuery("delete from App where contact=:contact");
                q.setParameter("contact",contact);
                q.executeUpdate();
                t.commit();
                s.close();
                return "profile.xhtml";
            }   
                catch(Throwable ex) 
            {
                ex.printStackTrace();
                System.out.println("APPOINTMENT  CANCELLED");
                return null;
            }
            
      }
}
