package com.billinghub.billmanagement.repository;

import com.billinghub.billmanagement.dto.BillingPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingPayloadRepository extends JpaRepository<BillingPayload, Long >{


}