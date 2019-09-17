import java.io.Serializable;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import comm.Admin;
import comm.Info;
import comm.Doc;
import java.util.List;
import org.hibernate.Query;

@ManagedBean(name="myBean")
@SessionScoped
public class myBean implements Serializable
{
    private String id;
    private String pass;
    public String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
   public String log()
   {
      try 
      {
      System.out.println("id "+id);
      System.out.println("passowrd "+pass);
      SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
      Session session=sessionFactory.openSession();
      session.beginTransaction();
      String queryCheck;
      if(category.equalsIgnoreCase("Doctor"))
      {
          queryCheck="from Doc where id=:id and password=:pass";
           //return "profiledoc.xhtml";
      }
      else if(category.equalsIgnoreCase("Admin"))
      {
          queryCheck="from Admin where id=:id and password=:pass";
          //return "profileadmin.xhtml";
      }
      else
      {
          queryCheck="from Info where id=:id and password=:pass";
          //return "profile.xhtml";
      }
      
      Query query=session.createQuery(queryCheck);
      //int id1=Integer.parseInt(id);
      query.setParameter("id",id);
      query.setParameter("pass", pass);
      List list=query.list();
      System.out.println("list size "+list.size());
      if(list.size()==1)
      {
        if(category.equalsIgnoreCase("Doctor"))
        {
          //queryCheck="from Doc where id=:id and password=:pass";
           return "profiledoc.xhtml";
        }
        else if(category.equalsIgnoreCase("Admin"))
        {
         // queryCheck="from Admin where id=:id and password=:pass";
          return "profileadmin.xhtml";
        }
        else
        {
       //   queryCheck="from Info where id=:id and password=:pass";
          return "profile.xhtml";
        }
      }
    } 
         catch (Exception e) 
    {
        System.out.println(e);
    }
    return "";
   }
       
 }

