package com.billinghub.billmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class CSPInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
	private String cspId;
	private String cspName;
	private String creditAmount;
	private String status;
	private String createDate;
	@Lob
	private String json;
}