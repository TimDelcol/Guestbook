/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.MessageEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matthias
 */
@Local
public interface MessageEntityFacadeLocal {

	void create(MessageEntity message);

	void edit(MessageEntity message);

	void remove(MessageEntity message);

	MessageEntity find(Object id);

	List<MessageEntity> findAll();

	List<MessageEntity> findRange(int[] range);

	int count();
	
}
