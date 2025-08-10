package com.mywork.soap_shop.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "")
public class SoapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private Integer soapID;

    @Column(name = "")
    private String soapName;

    @Column(name = "")
    private Double cost;

    @Column(name = "")
    private String mfd;
}