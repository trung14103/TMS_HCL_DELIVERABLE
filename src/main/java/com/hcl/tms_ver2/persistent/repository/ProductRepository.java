package com.hcl.tms_ver2.persistent.repository;

import com.hcl.tms_ver2.persistent.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
