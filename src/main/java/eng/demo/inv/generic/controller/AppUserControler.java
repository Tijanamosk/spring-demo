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
import eng.demo.inv.generic.model.AppUser;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserControler extends GenericController<AppUser> {

	public AppUserControler(GenericRepository<AppUser> genericRepository) {
		super(genericRepository);

	}

	@Override
	public List<GenericDto> getModel(AppUser model) {
		GenericDto userName = new GenericDto();
		userName.setType("text");
		userName.setLabel("Username");
		userName.setName("username");
		userName.setValue("");
		HashMap<String, String> userName1 = new HashMap<>();
		userName1.put("validator", "required");
		userName1.put("message", "User Name is required");
		List<HashMap<String, String>> userNm = new ArrayList<HashMap<String, String>>();
		userNm.add(userName1);
		userName.setValidations(userNm);

		GenericDto password = new GenericDto();
		password.setType("password");
		password.setLabel("Password");
		password.setName("password");
		password.setValue("");
		HashMap<String, String> password1 = new HashMap<>();
		password1.put("validator", "required");
		password1.put("message", "Password is required, min 8 characters");
		List<HashMap<String, String>> passwordNm = new ArrayList<HashMap<String, String>>();
		passwordNm.add(password1);
		password.setValidations(passwordNm);

		GenericDto email = new GenericDto();
		email.setType("email");
		email.setLabel("Email");
		email.setName("email");
		email.setValue("");
		HashMap<String, String> emaill = new HashMap<>();
		emaill.put("validator", "required");
		emaill.put("message", "Email is required");
		List<HashMap<String, String>> emailNm = new ArrayList<HashMap<String, String>>();
		emailNm.add(emaill);
		email.setValidations(emailNm);

		GenericDto date = new GenericDto();
		date.setType("date");
		date.setLabel("Date");
		date.setName("date");
		date.setValue("");

		List<GenericDto> appUsers = new ArrayList<>();
		appUsers.add(userName);
		appUsers.add(password);
		appUsers.add(email);
		appUsers.add(date);
		return appUsers;
	}

}
