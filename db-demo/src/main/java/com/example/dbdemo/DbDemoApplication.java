package com.example.dbdemo;

import com.example.dbdemo.entity.StoreInformation;
import com.example.dbdemo.repository.StoreInformationRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbDemoApplication implements CommandLineRunner {
	@Autowired
	StoreInformationRepositiry storeInformationRepositiry;

	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StoreInformation storeInformation=new StoreInformation("Amazon","All types of bags are avilable here","xxxxxxx");
		StoreInformation storeInformation1=new StoreInformation("Flipkart","All types of books are avilable here","yyyyyy");
		StoreInformation storeInformation2=new StoreInformation("Meesho","All fasion items are avilable here","zzzzzz");
		StoreInformation storeInformation3 =new StoreInformation("Myntra","All fasion items are avilable here","aaaaaa");
		storeInformationRepositiry.save(storeInformation);
		storeInformationRepositiry.save(storeInformation1);
		storeInformationRepositiry.save(storeInformation2);
		storeInformationRepositiry.save(storeInformation3);

		storeInformationRepositiry.findByStoreName("Amazon").forEach(val -> System.out.println(val));
		storeInformationRepositiry.findByStoreDetail("All fasion items are avilable here").forEach(val -> System.out.println(val));
		storeInformationRepositiry.findByStorePhoneNumber("yyyyyy").forEach(val -> System.out.println(val));
		storeInformationRepositiry.findById(2).ifPresent(val -> System.out.println(val));

		System.out.println(storeInformationRepositiry.count());

		storeInformationRepositiry.deleteById(4);
		System.out.println(storeInformationRepositiry.count());

		storeInformationRepositiry.findById(4).ifPresent(val -> System.out.println(val));


	}
}
