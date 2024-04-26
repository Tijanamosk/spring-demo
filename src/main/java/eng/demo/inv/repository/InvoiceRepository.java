package eng.demo.inv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import eng.demo.inv.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	

	List<Invoice> findByInvoiceItemsName(@Param("name") String name);
	
	

}
