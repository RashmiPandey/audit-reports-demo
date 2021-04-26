package com.reports.audit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reports.audit.dto.RestResponseDTO;
import com.reports.audit.enums.StatusEnum;
import com.reports.audit.model.AuditReport;
import com.reports.audit.service.AuditReportService;

@RestController
@RequestMapping("/auditreport")
public class AuditReportsController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AuditReportService auditReportService;
	
	@RequestMapping(value="/auditreports",method = RequestMethod.GET)
	public RestResponseDTO getAllReports() {
		try {
			List<AuditReport> reportlist = auditReportService.getAuditReports();

			return new RestResponseDTO(StatusEnum.SUCCESS.toString(), null, reportlist);

		} catch (Exception e) {
			logger.error("AuditReportsController -> getAllReports....", e);
			logger.error("ERROR: Fetching All Reports", e);
			return new RestResponseDTO(StatusEnum.SUCCESS.toString(), null, e.getMessage());
		}

	}
	
	@RequestMapping(value = { "/{audireportid}" }, method = RequestMethod.GET)
	public RestResponseDTO get(@PathVariable Long audireportid) {
		try {
			return new RestResponseDTO(StatusEnum.SUCCESS.toString(), null, auditReportService.getAuditReport(audireportid));
		} catch (Exception e) {
			logger.error("ERROR: Fetching AuditReport: " + audireportid, e);
			return new RestResponseDTO(StatusEnum.FAIL.toString(), e.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/auditreports")
	public RestResponseDTO addAuditReport(@RequestBody AuditReport auditReport) {
		
		try {
			Long reportId = auditReportService.addAuditReport(auditReport);
			return new RestResponseDTO(StatusEnum.SUCCESS.toString(), null, reportId);
			
		} catch (Exception e) {
			logger.error("ERROR: Adding New AuditReport", auditReport);
			logger.error("ERROR: AuditReportController -> addAuditReport....", e);
			return new RestResponseDTO(StatusEnum.FAIL.toString(), e.getMessage());
		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/auditreports/{id}")
	public RestResponseDTO updateAuditReport(@RequestBody AuditReport auditReport, @PathVariable Long id) {
		
		try {
			Long reportId = auditReportService.updateAuditReport(id,auditReport);
			return new RestResponseDTO(StatusEnum.SUCCESS.toString(), null, reportId);
			
		} catch (Exception e) {
			logger.error("ERROR: Updating AuditReport", auditReport);
			logger.error("ERROR: AuditReportController -> updateAuditReport....", e);
			return new RestResponseDTO(StatusEnum.FAIL.toString(), e.getMessage());
		}
		
	}

}
