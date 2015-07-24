/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.*;
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
public class CommentBean implements CommentBeanLocal {
    @PersistenceContext(unitName = "0746711_11149132_12088447-ejb")
    private EntityManager em;

    @Override
    public List<Comment> getAll(int id) {
        
        // create named query from Customer Entity Class
        Query query = em.createNamedQuery("Comment.findByProductId");
        // set paramter for query
        query.setParameter("productId", id);
        // get results for query
        List<Comment> comments = query.getResultList();

        return comments;
    }

    @Override
    public int createNewComment(int id, String comment) {
        int cid = (Integer) em.createNamedQuery("Comment.getHighestCommentID").getSingleResult();
        // id is current highest, increment to next id
        cid++;
        // create comment object
        Comment c = new Comment(cid);
        
        persist(c);
        
        c.setProductId(id);
        c.setComment(comment);
        
        return cid;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
