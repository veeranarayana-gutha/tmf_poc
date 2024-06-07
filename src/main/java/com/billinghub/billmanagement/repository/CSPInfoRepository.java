package com.billinghub.billmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billinghub.billmanagement.model.CSPInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface CSPInfoRepository extends JpaRepository<CSPInfo, Long>{

}
