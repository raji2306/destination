package com.example.demo.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit,Integer>{

}
