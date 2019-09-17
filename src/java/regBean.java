import java.io.Serializable;
import java.sql.*;
import java.lang.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import comm.Admin;
import comm.Info;
import comm.Doc;


@ManagedBean(name="regBean")
@SessionScoped

public class regBean implements Serializable {

     private String name;
     private String id;
     private String password;
     private String contact1;
     private String dob;
     public String category="1";

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        
    }
    
    
   
    public String register()
        {
            try 
            {
               
                Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml");
                SessionFactory sf = cfg.buildSessionFactory();
                Session s = sf.openSession();
                Transaction t = s.beginTransaction();
                //int contact1=Integer.parseInt(contact);
                
               // int id1=Integer.parseInt(id);
                
                if (category.equalsIgnoreCase("patient"))
                {
                    Info i= new Info(id,name,password,contact1,dob);
                    s.persist(i);
                    t.commit();
                    return "profile.xhtml";
                }
                else if (category.equalsIgnoreCase("doctor" ))
                {
                    Doc d= new Doc(id,name,password,contact1,dob);
                    s.persist(d);
                      t.commit();
                    return "profiledoc.xhtml";
                }
                else if(category.equalsIgnoreCase("admin"))
                {
                    Admin ad= new Admin(id,name,password,contact1,dob);
                    s.persist(ad);
                      t.commit();
                    return "profileadmin.xhtml";
                }
              
                s.close();
                 
            }
            catch(Throwable ex) 
            {
                ex.printStackTrace();
               System.out.println(ex);
            }
           
      return null;
    } 
}
             
    

