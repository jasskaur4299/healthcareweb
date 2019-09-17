package comm;
// Generated Jul 20, 2019 3:30:31 PM by Hibernate Tools 4.3.1

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





public class Doc  implements java.io.Serializable {


     private String id;
     private String name;
     private String password;
     private String contact;
     private String dob;

    public Doc() {
    }

    public Doc(String id, String name, String password, String contact, String dob) {
       this.id = id;
       this.name = name;
       this.password = password;
       this.contact = contact;
       this.dob = dob;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getDob() {
        return this.dob;
    }
    
    public void setDob(String dob) {
        this.dob = dob;
    }

   

      public String data()
    {
                Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml");
                SessionFactory sf = cfg.buildSessionFactory();
                Session s = sf.openSession();
                Transaction t = s.beginTransaction();
                Query query = s.createQuery("FROM Doc");
                List result=query.list();
                Iterator it=result.iterator();
                while(it.hasNext())//for(Iterator itr=result.iterator();itr.hasNext();)
                {
                
                    Doc d=(Doc)it.next();
                    
                    System.out.println("name is "+d.getName());
                    d.name= name; 
                    d.id=id;
                    d.password=password;
                    d.contact=contact;
                    d.dob=dob;
                    
                  return "docdetails.xhtml";
                }
               
           return "";      
    } 
      
    

   

   

    




}


