/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao.Interfaces;

import java.util.List;

import app.dto.InvoiceDetailDto;

/**
 *
 * @author ESTUDIANTES
 */
public interface InvoiceDetailDao {
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception; // Para crear un nuevo detalle de factura
    public InvoiceDetailDto findById(long id) throws Exception; // Para encontrar un detalle de factura por su ID
    public void deleteInvoiceDetail(long id) throws Exception; // Para eliminar un detalle de factura por su ID
    public List<InvoiceDetailDto> findByInvoiceId(long invoiceId) throws Exception; // Para encontrar detalles por ID de factura
    public List<InvoiceDetailDto> findAll() throws Exception;
}
