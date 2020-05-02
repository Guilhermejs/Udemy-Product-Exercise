package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	protected Date manufactureDate;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		super.priceTag();
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName()+ " (used) $ ");
		sb.append(String.format("%.2f", this.getPrice()));
		sb.append(" (Manufacture date: " + sdf.format(this.getManufactureDate()) + ")");
		return sb.toString();
		
	}
}
