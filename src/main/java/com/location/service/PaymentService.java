package com.location.service;

import com.location.entity.PaymentEntity;
import com.location.repository.PaymentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    public PaymentEntity createPayment(PaymentEntity paymentEntity) {
        Instant now = Instant.now();
        paymentEntity.setIsCreatedDate(now);
      //  paymentEntity.setIsDeletedFlag('N');

        return paymentRepo.save(paymentEntity);

    }

    public PaymentEntity updatePayment(PaymentEntity paymentEntity, Integer id) {
        Optional<PaymentEntity> paymentEntityOptional = paymentRepo.findById(id) ;
        log.info("PaymentEntity Optional " + paymentRepo.findById(id));
        PaymentEntity payment = new PaymentEntity();

        if (paymentEntityOptional.isPresent()){
            payment = paymentEntityOptional.get();
            payment.setId(id);
            payment.setPaymenType(paymentEntity.getPaymenType());
            payment.setClassification(paymentEntity.getClassification());
            payment.setIsCreatedDate(paymentEntity.getIsCreatedDate());
            Instant now = Instant.now();
            payment.setIsCreatedDate(now);
        }
       return paymentRepo.save(payment);
    }



    public Optional<PaymentEntity> getPaymentById(int id) throws NullPointerException {
        Optional<PaymentEntity> entity = paymentRepo.findById(id);
        PaymentEntity pEntity = new PaymentEntity();
        return  entity;

      /*  if (entity.isPresent()) {
            entity.get().getIsDeletedFlag();
        }
        if (pEntity.getIsDeletedFlag().equals("N")) {
                return entity;
            }

         else   {
            pEntity.getIsDeletedFlag().equals("Y");
            return null;
        }*/
    }

    /**
     *
     * @return payment
     */
    public List<PaymentEntity> getAllPayments()
    {
        List<PaymentEntity> payment = new ArrayList<PaymentEntity>();
        paymentRepo.findAll().forEach(getAll -> payment.add(getAll));
        return payment;
    }

    public void deleteById(int id) {
        PaymentEntity pEntity = new PaymentEntity();
        Instant now = Instant.now();
        Optional<PaymentEntity> entity = paymentRepo.findById(id);
        if (entity.isPresent()) {
            List<Integer> paymentType = new ArrayList<>();
            // entity.get().setIsDeletedFlag('Y');
             entity.get().setIsCreatedDate(now);
             paymentRepo.save(entity.get());

        }
       // paymentRepo.deleteById(id);
    }

}
