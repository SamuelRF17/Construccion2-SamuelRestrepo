package app.dao.Interfaces;

import java.util.List;
import app.dto.InvoiceDetailDto;

/**
 *
 * @author ESTUDIANTES
 */
public interface InvoiceDetailDao {
    // Para crear un nuevo detalle de factura
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;

    // Para encontrar un detalle de factura por su ID
    public InvoiceDetailDto findById(long id) throws Exception;

    // Para eliminar un detalle de factura por su ID
    public void deleteInvoiceDetail(long id) throws Exception;

    // Ajustar para encontrar detalles por objeto Invoice
    public List<InvoiceDetailDto> findByInvoiceId(long invoiceId) throws Exception; // Permanece igual, pero la implementación se ajustará

    // Para encontrar todos los detalles de factura
    public List<InvoiceDetailDto> findAll() throws Exception;
}
