package com.hcl.tms_ver2.persistent.repository;

import com.hcl.tms_ver2.persistent.domain.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
}
