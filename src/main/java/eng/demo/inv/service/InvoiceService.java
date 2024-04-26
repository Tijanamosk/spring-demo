package eng.demo.inv.service;

import java.util.List;

import eng.demo.inv.dto.InvoiceDto;

public interface InvoiceService {
	
//	InvoiceDto convertToDto(ModelMapper modelMapper, Invoice invoice);
	
	InvoiceDto createInvoice(InvoiceDto invoiceDto) throws Exception;
	
	List<InvoiceDto> getInvoiceByInvoiceItemsName (String name);
	
	List<InvoiceDto> getAllInvoices();
	
	InvoiceDto getInvoiceById(Long id);
	
	InvoiceDto deleteInvoiceById(Long id);
	

}
