package org.anttix.example.shj.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author olena.viliuzhanina
 *
 */
public interface CustomerRepository  extends CrudRepository<Customer, Long>{
	
	List<Customer> findByLastName(String lastName);

}
