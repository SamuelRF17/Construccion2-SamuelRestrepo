package app.dao;


import app.dao.Interfaces.InvoiceDao;
import app.dao.jpainterface.InvoiceRepository;
import app.dto.InvoiceDto;
import app.helpers.Helper;
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
public class InvoiceDaoImplementation implements InvoiceDao {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void createInvoice(InvoiceDto invoiceDto) throws Exception {
        Invoice invoice = Helper.parse(invoiceDto);
        invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceDto findById(long id) throws Exception {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        return Helper.parse(invoice);
    }

    @Override
    public void deleteInvoice(long id) throws Exception {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<InvoiceDto> findByPartnerId(long partnerId) throws Exception {
        List<Invoice> invoices = invoiceRepository.findByPartnerId(partnerId);
        return Helper.parseInvoices(invoices);
    }

    @Override
    public List<InvoiceDto> findByPersonId(long personId) throws Exception {
        List<Invoice> invoices = invoiceRepository.findByPersonId(personId);
        return Helper.parseInvoices(invoices);
    }

    @Override
    public List<InvoiceDto> findAll() throws Exception {
        List<Invoice> invoices = invoiceRepository.findAll();
        return Helper.parseInvoices(invoices);
    }

    @Override
    public long countByStatus(String status) throws Exception {
        return invoiceRepository.countByStatus(status);
    }
}
