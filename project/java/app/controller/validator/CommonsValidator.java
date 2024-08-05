package project.java.app.controller.validator;

public abstract class CommonsValidator {
    public void isValidString(String element, String value) throws Exception {
		if (value.equals("")) {
			throw new Exception(element + " no puede ser un valor vacio");
		}
	}
    
}
