import java.io.Serializable;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import comm.Doc;
import java.util.Iterator;
import org.hibernate.Query;
import java.util.List;
import org.hibernate.SQLQuery;


@ManagedBean(name="docdetailsBean")
@SessionScoped
public class docdetailsBean  implements Serializable {
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
            
               
               
   public String show()
        {
            try 
            {
                Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml");
                SessionFactory sf = cfg.buildSessionFactory();
                Session s = sf.openSession();
                Transaction t = s.beginTransaction();
               
                
                Query q = s.createQuery("from Doc where id=:id");
                q.setParameter("id",id);
               
                
               
               q.executeUpdate();
                t.commit();
                s.close();
              return "docdetails.xhtml";
            }   
                catch(Throwable ex) 
            {
                ex.printStackTrace();
                System.out.println("details viewed");
                return null;
            }
            
      }
}
