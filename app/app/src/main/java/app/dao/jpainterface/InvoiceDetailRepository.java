package app.dao.jpainterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long>{
    public List<InvoiceDetail> findByInvoiceId(long invoiceId);
}
