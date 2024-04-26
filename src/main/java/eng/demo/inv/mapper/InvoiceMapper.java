package eng.demo.inv.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import eng.demo.inv.dto.InvoiceDto;
import eng.demo.inv.entity.Invoice;

@Mapper(componentModel = "spring", uses = { InvoiceItemMapper.class })
public interface InvoiceMapper {

	InvoiceDto toDTO(Invoice invoice);

	Invoice toEntity(InvoiceDto invoiceDto);

	List<InvoiceDto> toDTOList(List<Invoice> invoices);

}
