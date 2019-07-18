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
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		List<Product> products = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + "data: ");
			System.out.println("Common, uded or imported (c/u/i)? ");
			char c = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			if(c == 'i') {
				System.out.println("Customs fee: ");
				double fee = sc.nextDouble();
				Product p = new ImportedProduct(name, price, fee);
				products.add(p);
			} else if (c == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				Product p = new UsedProduct(name, price, date);
				products.add(p);
			} else {
				Product p = new Product(name, price);
				products.add(p);
			}
		}
		
		sc.close();
		
		System.out.println();

		System.out.println("PRICE TAGS: ");
		for(Product c : products) {
			System.out.println(c.priceTag());
		}
	}

}
