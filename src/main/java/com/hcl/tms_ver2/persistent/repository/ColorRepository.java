package com.hcl.tms_ver2.persistent.repository;

import com.hcl.tms_ver2.persistent.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
