package eng.demo.inv.generic.model;

import java.util.List;

import eng.demo.inv.generic.GenericDto;
import eng.demo.inv.generic.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "car_driver")
public class CarDriver implements GenericEntity<CarDriver> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "CAR")
	private String car;

	public CarDriver() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public List<GenericDto> getModel(CarDriver model) {
		List<GenericDto> genericsList = model.getModel(model);
		return genericsList;
	}

	@Override
	public CarDriver createNewModel(CarDriver model) {
		model.updateModel(model);
		return model;
	}

	@Override
	public void updateModel(CarDriver model) {
		this.firstName = model.firstName;
		this.lastName = model.lastName;
		this.car = model.car;

	}

	@Override
	public Long getId() {

		return this.id;
	}

}
