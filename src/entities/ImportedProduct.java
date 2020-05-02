package entities;

public class ImportedProduct extends Product {
	
	protected Double customsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return this.getCustomsFee() + this.getPrice();
	}
	
	@Override
	public String priceTag() {
		super.priceTag();
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName() + " $ ");
		sb.append(String.format("%.2f", this.totalPrice()));
		sb.append(" (Customs fee: $ " + String.format("%.2f",this.getCustomsFee()) + ")");
		return sb.toString();
	}

}
