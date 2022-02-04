package newWorkshop;

import newWorkshop.business.concretes.BusinessException;
import newWorkshop.business.concretes.UserManager2;
import newWorkshop.dataAccess.concretes.UserHibernateDao;
import newWorkshop.entities.concretes.User;

public class Main {

	public static void main(String[] args) throws BusinessException {
		
		User user1 = new User(1,"Zümra", "Girgin", "zmrgrgn@gmail.com", "1234576");
		User user2 = new User(2,"Umut", "Taze", "umtz@gmail.com", "121566");
		User user3 = new User(3,"Aaa", "Baa", "ozgurcglk@gmail.com", "112233");
		
		UserManager2 userManager2 = new UserManager2(new UserHibernateDao());
		
		try {
			userManager2.add(user1);
			userManager2.add(user2);
			userManager2.add(user3);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Bilinmeyen bir hata oluþtu");
		}
		
	}

}
