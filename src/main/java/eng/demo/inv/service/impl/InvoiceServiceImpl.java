package eng.demo.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.demo.inv.dto.InvoiceDto;
import eng.demo.inv.entity.Invoice;
import eng.demo.inv.mapper.InvoiceMapper;
import eng.demo.inv.repository.InvoiceRepository;
import eng.demo.inv.service.InvoiceService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

//	@Autowired
//	private ModelMapper modelMapper;

	@Autowired
	private InvoiceMapper invoiceMapper;

	
	@Override
	public InvoiceDto createInvoice(InvoiceDto invoiceDto) throws Exception {

//		Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);
//
//		Invoice savedInvoice = invoiceRepository.save(invoice);
//
//		return modelMapper.map(savedInvoice, InvoiceDto.class);
		
		if(invoiceDto.getInvoiceItems()==null) {
			throw new Exception("Please add invoiceItems to invoice");
		}

		Invoice savedInvoice = invoiceRepository.save(invoiceMapper.toEntity(invoiceDto));

		return invoiceMapper.toDTO(savedInvoice);

	}

	@Override
	public List<InvoiceDto> getInvoiceByInvoiceItemsName(String name) {

		List<Invoice> invoices = invoiceRepository.findByInvoiceItemsName(name);
		return invoiceMapper.toDTOList(invoices);
	}

	@Override
	public List<InvoiceDto> getAllInvoices() {

		List<Invoice> invoices = invoiceRepository.findAll();
		return invoiceMapper.toDTOList(invoices);
	}

	@Override
	public InvoiceDto getInvoiceById(Long id) {

		return invoiceRepository.findById(id).map(invoiceMapper::toDTO).orElse(new InvoiceDto());
	}

	@Override
	public InvoiceDto deleteInvoiceById(Long id) {
	
		Invoice deleteInvoice = invoiceRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Invoice is not exist with given Id : " + id));
		invoiceRepository.deleteById(id);
		return invoiceMapper.toDTO(deleteInvoice);
	}

//	@Override
//	public InvoiceDto convertToDto(ModelMapper modelMapper, Invoice invoice) {
//
//		InvoiceDto invoiceDto = modelMapper.map(invoice, InvoiceDto.class);
//
//		if (invoice.getInvoiceItems() != null && !invoice.getInvoiceItems().isEmpty()) {
//
//			List<InvoiceItemDto> invoiceItemDto = new ArrayList<InvoiceItemDto>();
//
//			for (InvoiceItem inItem : invoice.getInvoiceItems()) {
//				InvoiceItemDto invItemDto = modelMapper.map(inItem, InvoiceItemDto.class);
//
////				InvoiceItemDto inItemDto = new InvoiceItemDto();
////				inItemDto.setDescription(inItem.getDescription());
////				inItemDto.setId(inItem.getId());
////				inItemDto.setName(inItem.getName());
////				inItemDto.setStock(inItem.getStock());
////
//				invoiceItemDto.add(invItemDto);
//			}
//			invoiceDto.setInvoiceItem(invoiceItemDto);
//		}
//
//		return invoiceDto;
//	}

}
