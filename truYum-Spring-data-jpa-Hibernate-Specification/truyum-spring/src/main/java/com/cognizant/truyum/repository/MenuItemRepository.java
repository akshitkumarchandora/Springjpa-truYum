package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

	@Query(value="select * from menu_item where me_date_of_launch <=CURRENT_DATE()",nativeQuery = true)
	List<MenuItem> findByActiveItems();
}
