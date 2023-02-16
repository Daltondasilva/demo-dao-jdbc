package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test #1: Seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== Test #2: Seller findByDepartment ===");
		
		Department department = new Department(2, null);
		
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println();
		System.out.println("=== Test #3: Seller findAll ===");
				
		list = sellerDao.findAll();
		
		for (Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println();
		System.out.println("=== Test #4: Seller insert ===");
				
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted: New Id = " + newSeller.getId());
		
		System.out.println();
		System.out.println("=== Test 5: Seller insert ===");
		
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		
		
		System.out.println();
		System.out.println("=== Test 6: Seller delete ===");
		
		System.out.print("Enter id to delete: ");
		int n = sc.nextInt();
		
		sellerDao.deleteById(n);
		System.out.println("Deletion Completed!");
		
		
		sc.close(); 
	}

}
