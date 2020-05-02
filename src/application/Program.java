package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("--Product #" + i + " data--");
			System.out.print("Common, used or imported (c/u/i): ");
			char r = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Price: ");
			double priceProduct = sc.nextDouble();
			if (r == 'u' || r == 'U') {
				System.out.print("Manufactue date (dd/mm/yyyy): ");
				sc.nextLine();
				String dateManufacture = sc.nextLine();
				products.add(new UsedProduct(nameProduct, priceProduct, sdf.parse(dateManufacture) ));
			}
			else if(r == 'i' || r == 'I') {
				System.out.print("Customs fee: ");
				double feeProduct = sc.nextDouble();
				sc.nextLine();
				products.add(new ImportedProduct(nameProduct, priceProduct, feeProduct));
			}
			
			else {
				products.add(new Product(nameProduct, priceProduct));
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		
		
		
		
		
		sc.close();

	}

}
