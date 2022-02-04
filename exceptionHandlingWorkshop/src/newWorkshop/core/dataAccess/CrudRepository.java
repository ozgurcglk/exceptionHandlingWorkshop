package newWorkshop.core.dataAccess;

import java.util.ArrayList;

import newWorkshop.core.entities.Entity;

public interface CrudRepository <T extends Entity>{
	void add(T entity);
	void update(T entity);
	void delete(T entity);
	ArrayList <T> getAll();
}
