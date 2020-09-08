package mrnikita.restapi.repository;

import mrnikita.restapi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contact, Long> {
}
