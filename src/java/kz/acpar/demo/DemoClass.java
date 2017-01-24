/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.acpar.demo;

import kz.acpar.entity.Userprofile;
import kz.acpar.util.HibernateUtil;
import org.hibernate.Session;



/**
 *
 * @author ABaimaganbetov
 */
public class DemoClass {
    
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        
        
       
            
            Userprofile userProfile = new Userprofile( "Vlad", "Asd", "vlad@mail.ru");
            
            System.out.println(userProfile);
                    	
            session.save(userProfile);
			
            session.getTransaction().commit();
            
            HibernateUtil.shutdown();
        
    
        
        
    }
    
    public static void authoriz(String login,String password,String email){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
               
            Userprofile userProfile = new Userprofile( login, password, email);
            
            System.out.println(userProfile);
                    	
            session.save(userProfile);
			
            session.getTransaction().commit();
            
            HibernateUtil.shutdown();
        
    }
    
}
