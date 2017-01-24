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
public class CheckClass {
    
    
    static boolean respon=false;
    
    public static boolean check (String login,String password,String email){
        
        if (CheckLoginPass.checkData(login)){
            respon=true;
        }
        
        return respon;
    }
}
        
     
    

