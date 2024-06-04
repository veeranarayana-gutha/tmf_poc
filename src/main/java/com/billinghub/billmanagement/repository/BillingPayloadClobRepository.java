package com.billinghub.billmanagement.repository;

import com.billinghub.billmanagement.dto.BillingPayloadClob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingPayloadClobRepository extends JpaRepository<BillingPayloadClob, Long >{
}
