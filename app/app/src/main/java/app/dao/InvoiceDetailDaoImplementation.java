package app.dao;

import app.dao.Interfaces.InvoiceDetailDao;
import app.dao.repository.InvoiceDetailRepository;
import app.dto.InvoiceDetailDto;
import app.helpers.Helper;
import app.model.InvoiceDetail;
import app.model.Invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@Getter
@Setter
public class InvoiceDetailDaoImplementation implements InvoiceDetailDao {
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
        InvoiceDetail invoiceDetail = Helper.parse(invoiceDetailDto);
        invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public InvoiceDetailDto findById(long id) throws Exception {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findById(id).orElse(null);
        return Helper.parse(invoiceDetail);
    }

    @Override
    public void deleteInvoiceDetail(long id) throws Exception {
        invoiceDetailRepository.deleteById(id);
    }

    @Override
    public List<InvoiceDetailDto> findByInvoiceId(long invoiceId) throws Exception {
        Invoice invoice = new Invoice(); // Crear una instancia de Invoice
        invoice.setInvoiceId(invoiceId); // Establecer el ID de la factura
        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findByInvoiceId(invoice); // Ajustar la búsqueda
        return invoiceDetails.stream().map(Helper::parse).toList(); // Convertir a DTOs
    }

    @Override
    public List<InvoiceDetailDto> findAll() throws Exception {
        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findAll();
        return Helper.parseInvoiceDetails(invoiceDetails); // Ajustar según el método de conversión
    }
}
