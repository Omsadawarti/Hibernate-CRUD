package org.nlt.view;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.model.Users;

public interface ParentInterface 
{
    public static Session ses=getDatabaseSession();
    public static List<Users> userList=getUserList();
    
    public String title="Person CRUD";
    public LoginFrame loginFrame=new LoginFrame();
    public SignupFrame signupFrame=new SignupFrame();
    
    
    public StateFrame stateFrame=new StateFrame();
    public CityFrame cityFrame=new CityFrame();  
    public ReceiptFrame receiptFrame=new ReceiptFrame();
    
    
    public PersonFrame personFrame=new PersonFrame();
    public Users loginUserObject=new Users();//right now blank
    
    
    public static Session getDatabaseSession()
    {
        
        System.out.println("Session created");
          SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session ses = sf.openSession();
            List<Object> ob;
            return ses;
            
    }
    
   
    
    
    public static List<Users> getUserList()
    {
        System.out.println("GET USER LIST");
        ses.beginTransaction();
        Query query = ses.createQuery("from Users where status=1");
        List<Users> userList=query.list();
        ses.getTransaction().commit();
        return userList;     
    }
}
