/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author puser
 */
@Stateless
public class CustomerBean implements CustomerBeanLocal {
    @PersistenceContext(unitName = "0746711_11149132_12088447-ejb")
    private EntityManager em;

    @Override
    public Customer getCustomer(String username) {
        return (Customer)em.createNamedQuery("Customer.findByName").
                setParameter("name", username).getSingleResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
