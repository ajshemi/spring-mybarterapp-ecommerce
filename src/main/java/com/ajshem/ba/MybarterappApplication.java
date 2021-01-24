package com.ajshem.ba;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.ajshem.ba.service.BuyerService;
import com.ajshem.ba.service.ProductService;
import com.ajshem.ba.service.SellerService;
import com.ajshem.ba.service.TransactionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;


@SpringBootApplication
public class MybarterappApplication implements CommandLineRunner  {

	@Value("${ba.importfile}")
	private String importFile;


	@Autowired
	private SellerService sellerService;
	
	@Autowired
    private BuyerService buyerService;
	

	@Autowired
    private ProductService productService;
    @Autowired
    private TransactionService transactionService;

	public static void main(String[] args) {
		SpringApplication.run(MybarterappApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
		createSellers();
		createBuyers();
        createProducts(importFile);
        createAllTransactions();
	}
	
	private void createAllTransactions(){
        transactionService.createTransaction("Toothbrush","Buyer1");
        transactionService.createTransaction("Toothpaste","Buyer2");
		transactionService.createTransaction("Shampoo","Buyer3");
		
	}

		
	private void createSellers(){
        sellerService.createSeller("John");
        sellerService.createSeller("Paul");
		sellerService.createSeller("Peter");
		
	}

			
	private void createBuyers(){
        buyerService.createBuyer("Buyer1");
        buyerService.createBuyer("Buyer2");
		buyerService.createBuyer("Buyer3");
		
	}
	

	
	private void createProducts(String fileToImport) throws IOException {
        ProductFromFile.read(fileToImport).forEach(importedProduct ->
            productService.createProduct(
                importedProduct.getName(),
				importedProduct.getSellerName()));
          
	}
	private static class ProductFromFile {
        //fields
		private String name;
		private String sellerName;

        //reader
        static List<ProductFromFile> read(String fileToImport) throws IOException {
            return new ObjectMapper().setVisibility(FIELD, ANY).
                    readValue(new FileInputStream(fileToImport), new TypeReference<List<ProductFromFile>>() {});
        }
        protected ProductFromFile(){}

		
        String getName() { return name; }
        String getSellerName() { return sellerName; }




    }

}
