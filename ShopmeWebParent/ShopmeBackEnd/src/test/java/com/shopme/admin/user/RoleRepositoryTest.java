package com.shopme.admin.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class RoleRepositoryTest {

	@Autowired
	RoleRepository roleRepository;
	
	@Test
	void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin", "Manage everything");
		Role savedRole = roleRepository.save(roleAdmin);
		assertTrue(savedRole.getId()>0);
	}

	@Test
	public void testCreateRestRoles() {
		Role roleSalesPerson = new Role("SalesPerson", "manage product price customer, shipping, orders and sales report");
		Role roleEditor = new Role("Editor", "manage categories, brands, products, articles and menus");
		Role roleShipper = new Role("Shipper", "view products, view orders and update order status");
		Role roleAssistant = new Role("Assistant", "manage questions and reviews");
		roleRepository.saveAll(List.of(roleSalesPerson, roleEditor, roleShipper, roleAssistant));
	}
}
