package com.billinghub.billmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billinghub.billmanagement.model.PartnerInfo;

@Repository
public interface PartnerInfoRepository extends JpaRepository<PartnerInfo, Long >{



}