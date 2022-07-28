package com.location.controller;

import com.location.service.PaymentService;
import com.location.entity.PaymentEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentEntity createPayment(@RequestBody PaymentEntity  paymentEntity){
        log.info("Entered into repayment " +paymentEntity);
      return paymentService.createPayment(paymentEntity);
    }

    @PutMapping("{paymentId}")
    public PaymentEntity updatePayment(@PathVariable(name = "paymentId") Integer id, @RequestBody PaymentEntity paymentEntity){
        return  paymentService.updatePayment(paymentEntity,id);
    }

    @GetMapping("{id}")
    private Optional<PaymentEntity> getPaymentById(@PathVariable("id") int id)
    {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/all")
    private List<PaymentEntity> getAllPayments()
    {
        return paymentService.getAllPayments();
    }
}
