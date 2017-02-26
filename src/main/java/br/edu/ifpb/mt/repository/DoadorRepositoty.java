package br.edu.ifpb.mt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.mt.model.Doador;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Repository
public interface DoadorRepositoty extends JpaRepository<Doador, Long>{

}
