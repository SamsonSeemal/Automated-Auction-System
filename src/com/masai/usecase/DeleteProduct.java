package com.masai.usecase;

import java.util.Scanner;

import com.masai.bean.Product;
import com.masai.dao.SellerDAO;
import com.masai.dao.SellerDAOImpl;

public class DeleteProduct {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Product Id");
		int id = sc.nextInt();
		
		SellerDAO s = new SellerDAOImpl();
		
		Product p = new Product();
		p.setId(id);
		
		String result =s.DeleteProduct(p, id);
		System.out.println(result);
	}

}
