/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Administrator;
import javax.ejb.Local;

/**
 *
 * @author puser
 */
@Local
public interface AdministratorBeanLocal {
    
    public Administrator getAdministrator(String username);
    
}
