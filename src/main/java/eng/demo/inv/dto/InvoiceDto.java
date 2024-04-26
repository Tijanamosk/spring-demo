package eng.demo.inv.dto;

import java.util.List;

public class InvoiceDto {

	private Long id;

	private String customer;

	private double price;

	private int quantity;

	private List<InvoiceItemDto> invoiceItems;

	public InvoiceDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<InvoiceItemDto> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItemDto> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvoiceDto [id=");
		builder.append(id);
		builder.append(", customer=");
		builder.append(customer);
		builder.append(", price=");
		builder.append(price);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", invoiceItems=");
		builder.append(invoiceItems);
		builder.append("]");
		return builder.toString();
	}

}
