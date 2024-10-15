package app.dao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByPartnerId_Id(long partnerId);
    List<Invoice> findByPersonId_Id(long personId);

    // Ajustar el método para aceptar Boolean
    long countByStatus(Boolean status);
}
