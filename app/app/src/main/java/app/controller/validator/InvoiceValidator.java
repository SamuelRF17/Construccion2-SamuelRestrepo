package app.controller.validator;

import org.springframework.stereotype.Component;

@Component
public class InvoiceValidator extends CommonsValidator {
    public InvoiceValidator() {
        super();
    }

    public void itemsValid(String items) {
        // Implementación del método
    }

    public void amountValid(String amount) {
        // Implementación del método
    }
}
