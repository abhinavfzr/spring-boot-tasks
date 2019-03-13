package com.stackroute.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String restaurent_name;
    String restaurent_img;
    String restaurent_location;

}
