/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author puser
 */
@Stateless
public class ProductBean implements ProductBeanLocal {
    @PersistenceContext(unitName = "0746711_11149132_12088447-ejb")
    private EntityManager em;

    @Override
    public int createNewProduct(String name, double price) {
        
        int id = (Integer) em.createNamedQuery("Product.getHighestProductID").getSingleResult();
        // id is current highest, increment to next id
        id++;
        // create product object
        Product p = new Product(id);
        
        // ensure all constraints are fulfilled before making object persistent
        // set discount to none
        p.setQuantity(0);
        
        // set default ZIP code
        p.setPrice(price);

        // make new customer persistent
        persist(p);
        // set name
        p.setName(name);

        // return id of the new product
        return id;
    }

    @Override
    public void removeProduct(int id) {
        
        Product p = new Product(id);

        persist(p);
        
        em.remove(p);
    }

    @Override
    public Product getProduct(int id) {
        
        return (Product) em.createNamedQuery("Product.findById").
                setParameter("id", id).getSingleResult();
    }

    @Override
    public int changeStockLevel(int id, int quantity) {
        Product p = getProduct(id);
        int q = p.getQuantity();
        
        if((q+=quantity) >= 0)
        {
            p.setQuantity(q);
            return q;
        }
        else
        {
            return -1;
        }
    }

    @Override
    public List<Product> getAll() {
        
        return (List<Product>) em.createNamedQuery("Product.findAll").getResultList();
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public Product getByName(String name) {
        
        return (Product) em.createNamedQuery("Product.findById").
                setParameter("name", name).getSingleResult();
        
    }

    public void persist(Object object) {
        em.persist(object);
    }

    

    
}
