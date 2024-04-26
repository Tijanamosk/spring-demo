package eng.demo.inv.generic;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class GenericService<T extends GenericEntity<T>> {

	private final GenericRepository<T> genericRepository;

	public GenericService(GenericRepository<T> genericRepository) {
		this.genericRepository = genericRepository;
	}

	public List<GenericDto> getModel(T model) {
		List<GenericDto> listModel = model.getModel(model);
		return listModel;

	}

	public T get(Long id) {
		return genericRepository.findById(id).orElse(null);
	}

	public T create(T createModel) {
		return genericRepository.save(createModel);
	}

	public T update(T updateModel) {
		T model = get(updateModel.getId());
		model.updateModel(updateModel);
		return genericRepository.save(model);

	}

	public T delete(Long id) {
		T deleteT = get(id);
		genericRepository.deleteById(id);
		return deleteT;
	}

	public Page<T> getPage(Pageable pageable) {
		return genericRepository.findAll(pageable);
	}

}
