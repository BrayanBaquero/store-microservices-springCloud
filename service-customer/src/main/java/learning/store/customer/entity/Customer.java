package learning.store.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "tbl_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El numero de documento no puede estar vacio")
    @Size(min = 8,max = 8,message = "El tamaño del numero de documento es 8")
    @Column(name = "number_id")
    private String numberID;

    @NotEmpty(message = "El nombre no puede estar vacio")
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotEmpty(message = "El apellido no puede estar vacio")
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @NotEmpty(message = "El email no puede estar vacio")
    @Email(message = "No es una direccion de correo valida")
    @Column(unique = true,nullable = true)
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;

    @NotNull(message = "La region no puede estar vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Region region;

    private String state;
}
