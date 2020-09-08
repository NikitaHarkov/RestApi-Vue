package mrnikita.restapi.controllers;

import mrnikita.restapi.model.Contact;
import mrnikita.restapi.repository.ContractRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContractRepository repository;

    @Autowired
    public ContactController(ContractRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Contact save(@RequestBody Contact contact) {
        contact.setMarked(false);
        return repository.save(contact);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable("id") Contact contactFromDb, @RequestBody Contact contact) {
        BeanUtils.copyProperties(contact, contactFromDb, "id");
        return repository.save(contactFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Contact contact) {
        repository.delete(contact);
    }
}
