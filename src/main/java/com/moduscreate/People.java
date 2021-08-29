package com.moduscreate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class People extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    public String id;

    @Column
    public String nome;

    @Column
    @Enumerated(EnumType.STRING)
    public PeopleStatus status;

    @Column
    public int idade;

    public static List<People> findByStatus(PeopleStatus peopleStatus) {
        return list("status", peopleStatus);
    }

}
