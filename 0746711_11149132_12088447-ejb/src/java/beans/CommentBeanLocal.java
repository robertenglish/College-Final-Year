/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.*;
import java.util.*;
import javax.ejb.Local;

/**
 *
 * @author puser
 */
@Local
public interface CommentBeanLocal {
    
    public List<Comment> getAll(int id);
    public int createNewComment(int id, String comment);
    
}
