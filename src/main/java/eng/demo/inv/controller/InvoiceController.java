package eng.demo.inv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eng.demo.inv.dto.InvoiceDto;
import eng.demo.inv.service.InvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping
	public InvoiceDto save(@RequestBody InvoiceDto toSave) throws Exception {

		InvoiceDto savedInvoice = invoiceService.createInvoice(toSave);
		return savedInvoice;

	}

	@GetMapping("/{name}")
	public List<InvoiceDto> getInvoiceByInvoiceItemName(@PathVariable String name) {

		return invoiceService.getInvoiceByInvoiceItemsName(name);

//		using Stream forEach method should be void
//		invoices.stream().forEach(i -> System.out.println(i));

//		List<InvoiceDto> invoicesDto = new ArrayList<InvoiceDto>();
//		if (invoices != null) 
//		return invoices.stream().map(i -> invoiceMapper.toDTO(i)).collect(Collectors.toList());

//			for (Invoice invoice : invoices) {
//				invoicesDto.add(invoiceService.convertToDto(modelMapper, invoice));
//			}

//		 return invoicesDto;

	}

	@GetMapping("/all")
	public List<InvoiceDto> getAll() {
		return invoiceService.getAllInvoices();

	}

	@GetMapping("/all/{id}")
	public InvoiceDto getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);

	}

	@DeleteMapping("/{id}")
	public InvoiceDto deleteById(@PathVariable Long id) {
		return invoiceService.deleteInvoiceById(id);

//		Invoice deleteInvoice = invoiceRepository.findById(id)
//				.orElseThrow(() -> new EntityNotFoundException("Invoice is not exist with given Id : " + id));
//		invoiceRepository.delete(deleteInvoice);
//		invoiceRepository.deleteById(id);
//		return invoiceService.convertToDto(modelMapper, deleteInvoice);
//		return invoiceMapper.toDTO(deleteInvoice);

	}

}
