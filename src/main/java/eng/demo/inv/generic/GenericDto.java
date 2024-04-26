package eng.demo.inv.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties({ "id" })
public class GenericDto implements GenericEntity<GenericDto> {

	public String type;

	public String name;

	public String label;

	public String value;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public List<HashMap<String, String>> validations;
	
	@Override
	public List<GenericDto> getModel(GenericDto model) {
		List<GenericDto> genericsList=new ArrayList<>();
		genericsList.add(model);
		return genericsList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<HashMap<String, String>> getValidations() {
		return validations;
	}

	public void setValidations(List<HashMap<String, String>> validations) {
		this.validations = validations;
	}

	@Override
	public GenericDto createNewModel(GenericDto model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateModel(GenericDto model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	



}
