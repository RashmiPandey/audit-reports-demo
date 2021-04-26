package com.reports.audit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

/**
 * 
 * @author Rashmi
 * @version 1.0
 * 
 * Entity represents image table in DB
 */
@Entity
@Table(name="image")
public class Image extends BaseAuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String url;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "audit_item_id",nullable = false)
	private AuditItem auditItem;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public AuditItem getAuditItem() {
		return auditItem;
	}

	public void setAuditItem(AuditItem auditItem) {
		this.auditItem = auditItem;
	}
	
	
	
}
