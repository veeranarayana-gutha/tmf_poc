package com.billinghub.billmanagement.repository;

import com.billinghub.billmanagement.dto.CspInfo;
import com.billinghub.billmanagement.dto.PartnerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerInfoRepository extends JpaRepository<PartnerInfo,Long> {
}
