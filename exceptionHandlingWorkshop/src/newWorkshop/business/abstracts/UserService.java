package newWorkshop.business.abstracts;

import java.util.ArrayList;

import newWorkshop.business.concretes.BusinessException;
import newWorkshop.entities.concretes.User;

public interface UserService {

	void add(User user) throws BusinessException;
	void update(User user);
	void delete(User user);
	ArrayList <User> getAll();
	
}
