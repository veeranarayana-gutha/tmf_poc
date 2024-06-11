package com.billinghub.billmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billinghub.billmanagement.model.BillingHubPayloadInfo;

@Repository
public interface BillingHubRepository extends JpaRepository<BillingHubPayloadInfo, Long> {
    
}
