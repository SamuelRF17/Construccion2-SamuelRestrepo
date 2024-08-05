package project.java.app.controller.validator;

public class InvoiceValidator extends CommonsValidator {
    public InvoiceValidator() {
        super();
    }

    public void itemsValid(String items) {
        // validate the invoice
        // super.isValidString("items en factura", items);
    }

    public void amountValid(String amount) {
        // validate the invoice
        // return super.isValidDouble("total en factura", amount);
    }
    
}
