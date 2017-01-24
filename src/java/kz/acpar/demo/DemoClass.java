/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.acpar.demo;

import java.util.List;
import kz.acpar.entity.Userprofile;
import kz.acpar.util.HibernateUtil;
import org.hibernate.Session;



/**
 *
 * @author ABaimaganbetov
 */
public class DemoClass {
    
    //private List<Userprofile> user;
    
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
    
    public static void authoriz2(String login,String password,String email){
        
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        try{
            
            
            List <Userprofile> users = session.createQuery("from Userprofile a where a.login=" + "'"+ login + "'").list();
            
            if (!users.isEmpty()){
                System.out.println("Пользователь зарегистрирован");
            }
            else {
            
            String hash = byteArrayToHexString(DemoClass.computeHash(password));
            
            Userprofile userProfile = new Userprofile( login, hash, email);
            
            System.out.println(userProfile);
                    	
            session.save(userProfile);
			
            session.getTransaction().commit();
            }
            
            HibernateUtil.shutdown();
            
            
      
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    
      public static byte[] computeHash(String x)   
  throws Exception  
  {
     java.security.MessageDigest d =null;
     d = java.security.MessageDigest.getInstance("SHA-1");
     d.reset();
     d.update(x.getBytes());
     return  d.digest();
  }
      
        public static String byteArrayToHexString(byte[] b){
     StringBuffer sb = new StringBuffer(b.length * 2);
     for (int i = 0; i < b.length; i++){
       int v = b[i] & 0xff;
       if (v < 16) {
         sb.append('0');
       }
       sb.append(Integer.toHexString(v));
     }
     return sb.toString().toUpperCase();
  }
    
}
