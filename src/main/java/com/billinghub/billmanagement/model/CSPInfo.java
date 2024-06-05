package com.billinghub.billmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class CSPInfo {
	@Id
	private long cspId;
	private String cspName;
	private String customerId;
	private String customer;
	private String custCspBillAcc;
	private String eventType;
	private String status;
	private String createDate;
	@Lob
	private String json;
}
