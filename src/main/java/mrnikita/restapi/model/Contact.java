package mrnikita.restapi.model;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String value;
    private boolean marked;
}
