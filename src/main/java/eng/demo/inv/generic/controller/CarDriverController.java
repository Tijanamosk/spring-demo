package eng.demo.inv.generic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eng.demo.inv.generic.GenericController;
import eng.demo.inv.generic.GenericDto;
import eng.demo.inv.generic.GenericRepository;
import eng.demo.inv.generic.model.CarDriver;

@RestController
@RequestMapping("/api/cardriver")
@CrossOrigin(origins = "http://localhost:4200")
public class CarDriverController extends GenericController<CarDriver> {

	public CarDriverController(GenericRepository<CarDriver> genericRepository) {
		super(genericRepository);

	}

	@Override
	public List<GenericDto> getModel(CarDriver model) {
		GenericDto firstName = new GenericDto();
		firstName.setType("text");
		firstName.setLabel("firstName");
		firstName.setName("firstName");
		firstName.setValue("");
		HashMap<String, String> firstName1 = new HashMap<>();
		firstName1.put("validator", "required");
		firstName1.put("message", "First Name is required");
		List<HashMap<String, String>> firstNm = new ArrayList<HashMap<String, String>>();
		firstNm.add(firstName1);
		firstName.setValidations(firstNm);

		GenericDto lastName = new GenericDto();
		lastName.setType("text");
		lastName.setLabel("lastName");
		lastName.setName("lastName");
		lastName.setValue("");
		HashMap<String, String> lastName1 = new HashMap<>();
		lastName1.put("validator", "required");
		lastName1.put("message", "Last Name is required");
		List<HashMap<String, String>> lastNm = new ArrayList<HashMap<String, String>>();
		lastNm.add(lastName1);
		lastName.setValidations(lastNm);

		GenericDto car = new GenericDto();
		car.setType("text");
		car.setLabel("car");
		car.setName("car");
		car.setValue("");

		List<GenericDto> carDrivers = new ArrayList<>();
		carDrivers.add(firstName);
		carDrivers.add(lastName);
		carDrivers.add(car);
		return carDrivers;
	}

}
