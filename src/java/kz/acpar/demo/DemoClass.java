/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.acpar.demo;

import kz.acpar.entity.Userprofile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author ABaimaganbetov
 */
public class DemoClass {
    
    public static void main(String[] args) {
        
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Userprofile.class)
                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try{
            
            Userprofile userProfile = new Userprofile(1, "Acpar", "Zac", "Acpar@mail.ru");
            
            System.out.println(userProfile);
        
            session.beginTransaction();
			
            session.save(userProfile);
			
            session.getTransaction().commit();
        
        }finally{
            	factory.close();
                
	}
        
        
        
    }
    
}
