/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.*;
import javax.ejb.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author reiner.dojen
 */
// define stateful bean
@Stateful(mappedName="cart")
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 30)
public class ShoppingCartBean implements ShoppingCart {

    private HashMap<String, Integer> items = new HashMap<String, Integer>();
    
    @Override
    public void addItem(String id, int quantity) {
        // obtain current number of items in cart
        Integer orderQuantity = items.get(id);
        if (orderQuantity == null) {
            orderQuantity = 0;
        }
        // adjust quantity and put back to cart
        orderQuantity += quantity;
        items.put(id, orderQuantity);
    }

    @Override
    public void removeItem(String id, int quantity) {
        // obtain current number of items in cart
        Integer orderQuantity = items.get(id);
        if (orderQuantity == null) {
            orderQuantity = 0;
        }
        // adjust quantity and put back to cart
        orderQuantity -= quantity;
        if (orderQuantity <= 0) {
            // final quantity less equal 0 - remove from cart
            items.remove(id);
        } else {
            // final quantity > 0 - adjust quantity
            items.put(id, orderQuantity);
        }
        
    }

    @Override
    @Remove
    public String checkout() {
        // dummy checkout method that just returns message for successful 
        // checkout
        String message = "You checked out the following items:\n<br>" + getItemList();
        return message;
    }

    @Override
    @Remove
    public void cancel() {
        // no action required - annotation @Remove indicates
        // that calling this method should remove the EJB which will
        // automatically destroy instance variables
    }

    @Override
    public String getItemList() {
        String message = "";
        Set<String> keys = items.keySet();
        Iterator<String> it = keys.iterator();
        String k;
        while (it.hasNext()) {
            k = it.next();
            message += k + ", quantity: " + items.get(k) + "<form action=ProductPageServlet method=GET><input type=hidden name=id value=" + k + "><input type=submit value=View></form>\n<br>";
        }
        return message;
    }

}
