package ma.test;

import java.util.Date;
import ma.beans.Client;
import ma.beans.Service;
import ma.service.ClientService;
import ma.service.ServiceService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lachgar
 */
public class Test {
    public static void main(String[] args) {
        ClientService cs = new ClientService();
        ServiceService ss = new ServiceService();
        
     Client c = new Client("Kadmir", "saad", new Date(), ss.findById(2));
      cs.create(c);
      Client c1 = new Client("Mokadem", "Meriem", new Date(), ss.findById(2));
      cs.create(c1);
       Client c2 = new Client("Maarouf", "Hind", new Date(), ss.findById(3));
      cs.create(c2);
      Client c3 = new Client("Charabi", "Ahmed", new Date(), ss.findById(3));
     cs.create(c3);
      Client c4 = new Client("Farsi", "Khadija", new Date(), ss.findById(3));
      cs.create(c4);
        
      //  System.out.println(cs.findById(2));
//        cs.delete(cs.findById(2));
//        for(Service s : ss.findAll()){
//            System.out.println("Service :"+s.getNom());
//            for(Client c : cs.findAll()){
//                if(c.getService().getId() == s.getId())
//                    System.out.println("########## " +c.getNom()+" "+c.getPrenom());
//            }
//        }
        
      //  ss.delete(ss.findById(7));
        
       //ss.create(new Service("Finance"));
        ss.create(new Service("comptabilité"));
        ss.create(new Service("Management"));
        
    }
}
