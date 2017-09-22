package hello;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDao extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query("SELECT c FROM Customer c WHERE LOWER(c.lastName) like ?1% OR LOWER(c.firstName) like ?1%")
	Collection<Customer> buscarPorTodo(String buscar);
}