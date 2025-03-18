package com.learning.ex_productservice.Repository;

import com.learning.ex_productservice.Model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface prdsvcRepository extends JpaRepository<Product, Integer> {

}
