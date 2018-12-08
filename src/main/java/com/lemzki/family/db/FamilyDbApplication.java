package com.lemzki.family.db;



import com.lemzki.family.db.model.Car;
import com.lemzki.family.db.repository.CarRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;



@SpringBootApplication
public class FamilyDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyDbApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository repository) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
				Car car = new Car();
				car.setName(name);
				repository.save(car);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
