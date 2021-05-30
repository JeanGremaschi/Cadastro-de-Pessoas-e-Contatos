package com.proj.cadastro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Pessoa.class)
    @JoinColumn(name = "id_pessoa", nullable = false)
    @JsonBackReference
    @ToString.Exclude
    private Pessoa pessoa;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contato contato = (Contato) o;

        return id != null && id.equals(contato.id);
    }

    @Override
    public int hashCode() {
        return 391263437;
    }

}