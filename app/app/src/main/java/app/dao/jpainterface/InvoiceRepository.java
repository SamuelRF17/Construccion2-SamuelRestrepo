package app.dao.jpainterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
    public List<Invoice> findByPartnerId(long partnerId); // Buscar facturas por ID de socio
    public List<Invoice> findByPersonId(long personId); // Buscar facturas por ID de persona
    public long countByStatus(String status);
}
