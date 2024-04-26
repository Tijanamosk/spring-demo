package eng.demo.inv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eng.demo.inv.entity.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

}
