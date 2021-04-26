package com.reports.audit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author Rashmi
 * @version 1.0
 * 
 * Entity represents audit_reports table in DB
 */

@Entity
@Table(name = "audit_reports")
public class AuditReport {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Column(unique = true)
    private String name;

	@NotNull
    @Size(max = 250)
    private String version;
	
	@NotNull
    private String status;
	
	@OneToMany(mappedBy = "auditreport",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
    private List<AuditItem> auditItems = new ArrayList<AuditItem>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AuditItem> getAuditItems() {
		return auditItems;
	}

	public void setAuditItems(List<AuditItem> auditItems) {
		this.auditItems = auditItems;
	}
	
	
}
