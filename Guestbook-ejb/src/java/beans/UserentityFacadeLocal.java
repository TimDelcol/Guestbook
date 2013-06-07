/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Userentity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matthias
 */
@Local
public interface UserentityFacadeLocal {

	void create(Userentity userentity);

	void edit(Userentity userentity);

	void remove(Userentity userentity);

	Userentity find(Object id);

	List<Userentity> findAll();

	List<Userentity> findRange(int[] range);

	int count();

	void createTestUser();
	
}
