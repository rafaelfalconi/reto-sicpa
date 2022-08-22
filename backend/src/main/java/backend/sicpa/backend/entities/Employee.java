package backend.sicpa.backend.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "status")
    private boolean status;

    private int age;

    private String email, position, surname, name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && status == employee.status && age == employee.age && Objects.equals(createdBy, employee.createdBy) && Objects.equals(createdDate, employee.createdDate) && Objects.equals(modifiedBy, employee.modifiedBy) && Objects.equals(modifiedDate, employee.modifiedDate) && Objects.equals(email, employee.email) && Objects.equals(position, employee.position) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdBy, createdDate, modifiedBy, modifiedDate, status, age, email, position, surname);
    }
}
