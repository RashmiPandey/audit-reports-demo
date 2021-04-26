package com.reports.audit.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reports.audit.model.AuditReport;
import com.reports.audit.repository.AuditReportRepository;

@Service
public class AuditReportService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AuditReportRepository auditReportRepository;

	public List<AuditReport> getAuditReports() {

		List<AuditReport> auditReport = new ArrayList<AuditReport>();
		auditReportRepository.findAll().forEach(auditReport::add);

		return auditReport;
	}

	public AuditReport getAuditReport(Long id) {
		return auditReportRepository.findById(id).orElse(null);
	}

	public Long addAuditReport(AuditReport auditReport) {

		if (auditReport != null)
			auditReportRepository.save(auditReport);

		return auditReport.getId();
	}

	public Long updateAuditReport(Long id,AuditReport auditReport) {

		if (auditReport != null)
			auditReportRepository.save(auditReport);

		return auditReport.getId();
	}

}
