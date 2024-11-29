package com.aaron.angularboot.dao;

import com.aaron.angularboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

//Origin = 'protocol' + 'hostname' + 'port'
//Origin = 'http' : '//localhost' : '4200'
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository <Product, Long> {
}
