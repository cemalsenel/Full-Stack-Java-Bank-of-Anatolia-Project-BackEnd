package com.bank;

import com.bank.model.Role;
import com.bank.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Optional;

@SpringBootApplication
public class BankofAnatoliaApplication {

	public static void main(String[] args) {SpringApplication.run(BankofAnatoliaApplication.class, args);
	}

	@Component //==> db ye veri girmek için birkez çalıştırılabilir
	class DemoCommandLineRunner implements CommandLineRunner {

		@Autowired
		private RoleRepo roleRepo;

		@Override
		public void run(String... args) throws Exception {
			Optional<Role> admin = roleRepo.findByName("ADMIN");
			Optional<Role> user = roleRepo.findByName("USER");
			if (!admin.isPresent()) {
				Role roleAdmin = new Role();
				roleAdmin.setName("ADMIN");
				roleRepo.save(roleAdmin);
			}
			if (!user.isPresent()) {
				Role roleUser = new Role();
				roleUser.setName("USER");
				roleRepo.save(roleUser);
			}
		}}
}
