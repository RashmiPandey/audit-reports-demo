package com.reports.audit.repository;

import org.springframework.data.repository.CrudRepository;

import com.reports.audit.model.AuditReport;

public interface AuditReportRepository extends CrudRepository<AuditReport, Long>{
}
