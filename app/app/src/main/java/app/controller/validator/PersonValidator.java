package app.controller.validator;

import org.springframework.stereotype.Component;

@Component
public class PersonValidator extends CommonsValidator {
    public PersonValidator() {
		super();
	}
	public void validName(String name) throws Exception{
		super.isValidString("el nombre de la persona ", name);
	}
	public void validDocument(String document) throws Exception{
		super.isValidString("la cedula de la persona ", document);
	}
	public int validCelPhone(String celPhone) throws Exception{
		return super.isValidInteger("El numero de telefono es ", celPhone);
	}
}
