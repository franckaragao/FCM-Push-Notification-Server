package br.edu.ifpb.mt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.mt.model.Person;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Repository
public interface PersonRepositoty extends JpaRepository<Person, Long>{
	
	/**
	 * 
	 * @return
	 */
	Optional<Person> findFirstByOrderByName();

}
