/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.acpar.demo;

import java.util.List;
import static kz.acpar.demo.CheckClass.respon;
import kz.acpar.entity.Userprofile;
import kz.acpar.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ABaimaganbetov
 */
public class CheckLoginPass {
    
    
    public static boolean checkData(String login){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
                
        try{
            List <Userprofile> users = session.createQuery("from Userprofile a where a.login=" + "'"+ login + "'").list();
            
            if (!users.isEmpty()){
                System.out.println("Пользователь зарегистрирован");
                
                respon=true;
            
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }finally{
                HibernateUtil.shutdown();
        }
        return respon;
    }
    }
    

