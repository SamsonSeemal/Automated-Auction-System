package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.SellerDAO;
import com.masai.bean.Product;
import com.masai.dao.SellerDAOImpl;

public class UpdateProduct {
	 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id no. of item you want to update");
		int id = sc.nextInt();
		
		System.out.println("Enter the name of Item");
		String name = sc.next();
		
		System.out.println("Enter the price of item");
		int price = sc.nextInt();
		
		
		System.out.println("Enter the category of Item");
		String category = sc.next();
		
		SellerDAO s = new SellerDAOImpl();
		
		
		
		//make the objec and pass the data
		Product p  = new Product();
		p.setName(name);
		p.setPrice(price);
		p.setCategory(category);
		
		
		
		String result = s.updateproduct(p, id);
		System.out.println(result);
	}

}
