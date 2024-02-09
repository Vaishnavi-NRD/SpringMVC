package UserMvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import UserMvc.model.User;

@Repository
public class UserDao {
	/*Autowired-- The dependency will be injected implicitly */
	@Autowired
	private EntityManager manager;
	
	/*Further Persistence Logic is written for performing CRUD operations & Validation*/
	public User saveUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(user);
		transaction.begin();
		transaction.commit();
		return user;
	}

	public User updateUser(User user) {
		User dbUser = manager.find(User.class, user.getId());
		if (dbUser != null) {
			dbUser.setEmail(user.getEmail());
			dbUser.setPhone(user.getPhone());
			dbUser.setName(user.getName());
			dbUser.setPassword(user.getPassword());
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			transaction.commit();
			return user;
		}
		return null;
	}

	public User FindById(int id) {
		return manager.find(User.class, id);
	}

	public User verifyUser(long phone, String password) {
		Query q = manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(String email, String password) {
		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(int id, String password) {
		Query q = manager.createQuery("select u from User u where u.id=?1 and u.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean deleteUser(int id) {
		User user = FindById(id);
		if (user != null) {
			EntityTransaction transaction = manager.getTransaction();
			manager.remove(user);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}
}