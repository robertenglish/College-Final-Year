/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import entities.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author puser
 */
@Stateless
public class AdministratorBean implements AdministratorBeanLocal {
    @PersistenceContext(unitName = "0746711_11149132_12088447-ejb")
    private EntityManager em;

    @Override
    public Administrator getAdministrator(String username)
    {
        return (Administrator)em.createNamedQuery("Administrator.findByName").
                setParameter("name", username).getSingleResult();
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
