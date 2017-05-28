package pl.mslawin.springmvc.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    @NotEmpty
    @Size(min = 2, max = 15)
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20)
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @NotEmpty
    @Pattern(regexp = "[a-z0-9_\\-.]+@([a-z0-9]+\\.[a-z0-9]+)+", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @OneToMany
    private List<Book> books;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
