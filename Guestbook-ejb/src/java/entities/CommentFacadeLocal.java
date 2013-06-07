/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Silver Desktop
 */
@Local
public interface CommentFacadeLocal {

    void create(Comment comment);

    void edit(Comment comment);

    void remove(Comment comment);

    Comment find(Object id);

    List<Comment> findAll();

    List<Comment> findRange(int[] range);

    int count();

    void createComment();
    
}
