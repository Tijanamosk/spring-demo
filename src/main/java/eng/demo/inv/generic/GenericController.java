package eng.demo.inv.generic;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

public abstract class GenericController<T extends GenericEntity<T>> {

	private final GenericService<T> genericService;

	public GenericController(GenericRepository<T> genericRepository) {
		this.genericService = new GenericService<T>(genericRepository) {
		};
	}

	@GetMapping("")
	@Validated
	public List<GenericDto> getModel(T model) {

		return genericService.getModel(model);
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> getOneById(@PathVariable Long id) {
		return ResponseEntity.ok(genericService.get(id));
	}

	@PostMapping("")
	public T save(@Valid @RequestBody T createModel) {
		return genericService.create(createModel);
	}

	@PutMapping("")
	public T update(@Valid @RequestBody T updateModel) {
		return genericService.update(updateModel);
	}

	@DeleteMapping("/{id}")
	public T deleteById(@PathVariable Long id) {
		return genericService.delete(id);
	}

}
