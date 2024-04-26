package eng.demo.inv.dto;

public class InvoiceItemDto {

	private Long id;

	private String name;

	private int stock;

	private String description;

	public InvoiceItemDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvoiceItemDto [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
