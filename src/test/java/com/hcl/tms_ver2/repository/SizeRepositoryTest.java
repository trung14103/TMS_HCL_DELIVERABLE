//package com.hcl.tms_ver2.repository;
//
//import com.hcl.tms_ver2.persistent.domain.Size;
//import com.hcl.tms_ver2.persistent.repository.SizeRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Profile;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//@DataJpaTest
//@ExtendWith(SpringExtension.class)
//@TestPropertySource()
//public class SizeRepositoryTest {
//    @Autowired
//    private SizeRepository repository;
//
//    @Test
//    public void testGetSize() {
//        Size size = repository.getOne(1L);
//        Assertions.assertEquals("smt", size.getName());
//    }
//}
