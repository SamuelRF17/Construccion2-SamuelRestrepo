package app.dao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Invoice;
import app.model.InvoiceDetail;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
    // Ajustar el método para buscar por el ID del invoice
    List<InvoiceDetail> findByInvoiceId(Invoice invoiceId); // Cambia a buscar por objeto Invoice
}
