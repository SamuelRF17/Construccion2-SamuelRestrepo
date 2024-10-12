/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao.Interfaces;

import java.util.List;

import app.dto.InvoiceDto;

/**
 *
 * @author ESTUDIANTES
 */
public interface InvoiceDao {
    public void createInvoice(InvoiceDto invoiceDto) throws Exception; // Para crear una nueva factura
    public InvoiceDto findById(long id) throws Exception; // Para encontrar una factura por su ID
    public void deleteInvoice(long id) throws Exception; // Para eliminar una factura por su ID
    public List<InvoiceDto> findByPartnerId(long partnerId) throws Exception; // Para encontrar facturas por ID de socio
    public List<InvoiceDto> findByPersonId(long personId) throws Exception; // Para encontrar facturas por ID de persona
    public List<InvoiceDto> findAll() throws Exception; // Para obtener todas las facturas
    public long countByStatus(String status) throws Exception; 
}
