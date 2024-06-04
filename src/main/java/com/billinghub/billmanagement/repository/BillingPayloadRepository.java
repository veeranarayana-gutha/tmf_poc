package com.billinghub.billmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billinghub.billmanagement.dto.BillingPayload;

@Repository
public interface BillingPayloadRepository extends JpaRepository<BillingPayload, Long >{



}