package newWorkshop.dataAccess.concretes;

import java.util.ArrayList;

import newWorkshop.dataAccess.abstracts.UserDao;
import newWorkshop.entities.concretes.User;

public class UserHibernateDao implements UserDao {

	ArrayList<User> users = new ArrayList<User>();

	@Override
	public void add(User entity) {
		
		System.out.println("Successsfully added via Hibernate.");
		users.add(entity);
	}

	@Override
	public void update(User entity) {
		System.out.println("Successfully updated via Hibernate.");

	}

	@Override
	public void delete(User entity) {
		System.out.println("Successfully deleted via Hibernate.");

	}

	@Override
	public ArrayList<User> getAll() {
		
		return this.users;
	}

}
