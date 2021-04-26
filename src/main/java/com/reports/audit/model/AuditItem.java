package com.reports.audit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author Rashmi
 * @version 1.0
 * 
 * Entity  represents audit_item table in DB
 */
@Entity
@Table(name="audit_item")
public class AuditItem extends BaseAuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String status;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "report_id",nullable = false)
	private AuditReport auditreport;
	
	@OneToMany(mappedBy = "auditItem",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
    private List<Image> images = new ArrayList<Image>();
	
	@OneToMany(mappedBy = "auditItem",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
    private List<PDC> pdcs = new ArrayList<PDC>();
	
	@OneToMany(mappedBy = "auditItem",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
    private List<ActionItem> actionItems = new ArrayList<ActionItem>();
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AuditReport getAuditreport() {
		return auditreport;
	}

	public void setAuditreport(AuditReport auditreport) {
		this.auditreport = auditreport;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<PDC> getPdcs() {
		return pdcs;
	}

	public void setPdcs(List<PDC> pdcs) {
		this.pdcs = pdcs;
	}

	public List<ActionItem> getActionItems() {
		return actionItems;
	}

	public void setActionItems(List<ActionItem> actionItems) {
		this.actionItems = actionItems;
	}
}
