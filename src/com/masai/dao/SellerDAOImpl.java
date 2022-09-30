package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.Utility.DButility;
import com.masai.bean.Product;
import com.masai.bean.Seller;

public class SellerDAOImpl implements SellerDAO{

	@Override
	public String registerSeller(Seller seller) {
		String message = "Not Inserted..";
	
		
	
		
		try(Connection conn= DButility.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("insert into Seller values(?,?,?,?)");
			
			
			
			ps.setInt(1, seller.getId());
			ps.setString(2, seller.getName());
			ps.setString(3, seller.getEmail());
			ps.setString(4, seller.getPassword());
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Seller Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
	
	
		
		return message;
	
	}

	@Override
	public String ProductList(Product p) {
		String message = "NOT INSERTED..";
//		logic
		try (Connection conn = DButility.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into Product values(?,?,?,?,?,?);");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getPrice());
			ps.setInt(4, p.getQuantity());
			ps.setString(5, p.getCategory());
			ps.setInt(6, p.getSellerId());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Item successfully listed";

		} catch (SQLException e) {
			e.getMessage();

		}

		return message;
	}

	@Override
	public String updateproduct(Product p, int id) {
		String message = "NOT UPDATED..";
//		logic
		try (Connection conn = DButility.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update Product Set P_name = ?,p_price = ?, p_quanitity = 5, P_categort = ?  Where P_Id = ?;");
			ps.setString(1, p.getName());
			ps.setInt(2, p.getPrice());
			ps.setString(3, p.getCategory());
			ps.setInt(5, p.getId());
			

			int x = ps.executeUpdate();// Check this

			if (x > 0)
				message = "Item updated successfully";

		} catch (SQLException e) {
			e.getMessage();

		}

		return message;
	}

	@Override
	public String DeleteProduct(Product p,int id) {
		String message = "Not Deleted";
		
		try (Connection conn = DButility.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("Delete  From Product Where P_Id = ?;");
			ps.setInt(1, p.getId());
			

			int x = ps.executeUpdate();// Check this

			if (x > 0)
				message = "Product Delected successfully";

		} catch (SQLException e) {
			e.getMessage();

		}
		
		
		
		return message;
	}

}
