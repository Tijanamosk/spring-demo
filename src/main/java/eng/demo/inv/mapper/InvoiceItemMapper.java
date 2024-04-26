package eng.demo.inv.mapper;

import org.mapstruct.Mapper;

import eng.demo.inv.dto.InvoiceItemDto;
import eng.demo.inv.entity.InvoiceItem;

@Mapper(componentModel = "spring")
public interface InvoiceItemMapper {

	InvoiceItemDto toDTO(InvoiceItem invoiceItem);

	InvoiceItem toEntity(InvoiceItemDto invoiceItemDto);

}
