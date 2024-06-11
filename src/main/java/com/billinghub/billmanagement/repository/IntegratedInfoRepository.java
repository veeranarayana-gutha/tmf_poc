package com.billinghub.billmanagement.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.billinghub.billmanagement.model.IntegratedBillInfo;

@Repository
public interface IntegratedInfoRepository extends JpaRepository<IntegratedBillInfo, Long >{
    
}
