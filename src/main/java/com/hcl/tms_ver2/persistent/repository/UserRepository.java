package com.hcl.tms_ver2.persistent.repository;

import com.hcl.tms_ver2.persistent.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional(readOnly = true)
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM dbo_user u " +
            "WHERE((:key IS NULL OR UPPER(u.name) LIKE CONCAT('%',UPPER(:key),'%')) " +
            "OR (:key IS NULL OR UPPER(u.name) LIKE CONCAT('%',UPPER(:key),'%')) " +
            "OR (:key IS NULL OR UPPER(u.email) LIKE CONCAT('%',UPPER(:key),'%')) " +
            "OR (:key IS NULL OR UPPER(u.phoneNumber) LIKE CONCAT('%',UPPER(:key),'%')))" +
            "and u.status=1")
    Page<User> getList(Pageable pageable, @Param("key") String key);

    @Transactional(readOnly = true)
    Optional<User> findByName(String username);

    @Query("SELECT u FROM dbo_user u " +
            "WHERE((:key IS NULL OR UPPER(u.name) LIKE CONCAT('%',UPPER(:key),'%')) " +
            "OR (:key IS NULL OR UPPER(u.email) LIKE CONCAT('%',UPPER(:key),'%')) " +
            "OR (:key IS NULL OR UPPER(u.phoneNumber) LIKE CONCAT('%',UPPER(:key),'%')))")
    Page<User> getAll(Pageable pageable, @Param("key") String key);
}
