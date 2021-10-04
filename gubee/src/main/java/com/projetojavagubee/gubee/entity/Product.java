package com.projetojavagubee.gubee.entity;

import com.projetojavagubee.gubee.enums.Tecnologias;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String desc;

    @Column
    private String mercado;

    private Tecnologias tecnologias;
}
