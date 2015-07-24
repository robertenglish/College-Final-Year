/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;
import entities.*;
import java.util.*;

/**
 *
 * @author puser
 */
@Local
public interface ProductBeanLocal {
    
    public int createNewProduct(String name, double price);
    public void removeProduct(int id);
    public Product getProduct(int id);
    public int changeStockLevel(int id, int quantity);
    public List<Product> getAll();
    public Product getByName(String name);
    
}
