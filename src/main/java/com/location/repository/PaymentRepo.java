package com.location.repository;

import com.location.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity,Integer> {

    void deleteById(Integer id);
}