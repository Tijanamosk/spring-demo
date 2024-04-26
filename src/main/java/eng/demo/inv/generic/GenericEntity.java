package eng.demo.inv.generic;

import java.util.List;

public interface GenericEntity<T> {

	List<GenericDto> getModel(T model);

	T createNewModel(T model);

	void updateModel(T model);

	Long getId();

}
