package eng.demo.inv.generic.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import eng.demo.inv.generic.GenericDto;
import eng.demo.inv.generic.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "model_user")
public class AppUser implements GenericEntity<AppUser> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Username cannot be null")
	@Column(name = "USERNAME")
	private String username;

	@NotNull(message = "Password cannot be null")
	@Column(name = "PASSWORD")
	@Size(min = 8, max = 15, message = "Password should be min 8 characters")
	private String password;

	@NotNull(message = "Email cannot be null")
	@Column(name = "EMAIL")
	@Email
	private String email;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date date;

	public AppUser() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public AppUser createNewModel(AppUser model) {
		model.updateModel(model);
		return model;
	}

	@Override
	public void updateModel(AppUser model) {
		this.username = model.username;
		this.password = model.password;
		this.email = model.email;
		this.date = model.date;

	}

	@Override
	public List<GenericDto> getModel(AppUser model) {
		List<GenericDto> genericsList = model.getModel(model);

		return genericsList;
	}

}
