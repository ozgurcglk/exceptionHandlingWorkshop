package newWorkshop.business.concretes;

import java.util.ArrayList;

import newWorkshop.business.abstracts.UserService;
import newWorkshop.dataAccess.abstracts.UserDao;
import newWorkshop.entities.concretes.User;

public class UserManager2 implements UserService {

	private UserDao userDao;

	public UserManager2() {
		super();
	}

	public UserManager2(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	/* Business methods */

	private boolean eMailCheck(User user) throws BusinessException {
		if (user.getEmail().contains("@") == false) {
			throw new BusinessException("E-mail does not include @ sign");
		} else {
			return true;
		}

	}

	private boolean nameCheck(User user) throws BusinessException {
		if (user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			throw new BusinessException("First name or last name is shorter than 2 characters");
		} else {
			return true;
		}
	}

	private boolean passwordCheck(User user) throws BusinessException {
		if (user.getPassword().length() < 6) {
			throw new BusinessException("Password should contain at least 6 charachters");
		} else {
			return true;
		}
	}

	private boolean usedMail(User user) throws BusinessException {
		for (User users : userDao.getAll()) {
			if (user.getEmail() == users.getEmail()) {
				throw new BusinessException("This e-mail has been used, please try a new e-mail");
			}
		}
		return true;
	}

	private boolean usedId(User user) throws BusinessException {
		for (User users : userDao.getAll()) {
			if (user.getId() == users.getId()) {
				throw new BusinessException("This ID has been used");
			}
		}
		return true;
	}
	
	/* General methods */

	@Override
	public void add(User user) throws BusinessException {
		if(eMailCheck(user) && nameCheck(user) && passwordCheck(user) && usedMail(user) && usedId(user) == true) {
			this.userDao.add(user);
		}else {
			System.out.println("Something unknown went wrong :(");
		}

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<User> getAll() {
		return this.userDao.getAll();
	}

}
