package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.ReportCommitteeWishesCountPercDTO;
import com.sbm.shura.dto.ReportUsersNotSubmitWishesDTO;
import com.sbm.shura.dto.ReportUsersWishesDTO;
import com.sbm.shura.management.ReportsManager;
import com.sbm.shura.service.CommitteeService;
import com.sbm.shura.service.ReportsService;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@RestController
@RequestMapping("/api/report/")
@CrossOrigin("*")
public class ReportsController {
	
	@Resource
	private ReportsManager reportsManager;
	
	@Resource
	private ReportsService reportsService;
	
	@Resource
	private CommitteeService committeeService;
	
	@RequestMapping(value = "/usersWishes", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getUsersWishes() throws ControllerException {
		
		return reportsManager.getReportUsersWishes();
	}
	
	@RequestMapping(value = "/committeeWishesCount", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getCommitteeWishesCount() throws ControllerException {
		
		return reportsManager.getReportCommitteeWishesCount();
	}
	
	@RequestMapping(value = "/usersNotSubmitWishes", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getUsersNotSubmitWishes() throws ControllerException {
		
		return reportsManager.getReportUsersNotSubmitWishes();
	}
	
	@RequestMapping(value = "/usersWishesCommittee", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getUsersWishesCommittee(@RequestParam("committeeId") long committeeId) throws ControllerException {
		
		return reportsManager.getReportUsersWishesCommittee(committeeId);
	}
	
	@RequestMapping(value = "/usersWishesReport", method = RequestMethod.POST, produces = "application/pdf")
	@ResponseBody
	public ResponseDTO usersWishesReport(HttpServletResponse response) throws ControllerException {
		ResponseDTO result = null;
			try {
			List<ReportUsersWishesDTO> searchList = reportsService.getReportUsersWishes();
			Map<String, Object> parameterMap = new HashMap<>();
			
			InputStream reportStream = getClass().getResourceAsStream("/jasperreports/usersWishes.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
			
			JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameterMap, new JRBeanCollectionDataSource(searchList));
			result = exportPdfAndDownload(jasperPrint, "usersWishes.pdf", response);
			}catch(Exception e) {
				throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e);
			}
			return result;
	}
	
	@RequestMapping(value = "/committeeWishesCountReport", method = RequestMethod.POST, produces = "application/pdf")
	@ResponseBody
	public ResponseDTO committeeWishesCountReport(HttpServletResponse response) throws ControllerException {
		ResponseDTO result = null;
		try {
			ReportCommitteeWishesCountPercDTO searchList = reportsService.getReportCommitteeWishesCount();
			Map<String, Object> parameterMap = new HashMap<>();
			
			parameterMap.put("firstWishCountTotal", searchList.getFirstWishCountTotal().toString());
			parameterMap.put("secondWishCountTotal", searchList.getSecondWishCountTotal().toString());
			parameterMap.put("thirdWishCountTotal", searchList.getThirdWishCountTotal().toString());
			parameterMap.put("totalWishCountTotal", searchList.getTotalWishCountTotal().toString());
			parameterMap.put("firstWishCountPerc", String.valueOf(searchList.getFirstWishCountPerc()));
			parameterMap.put("secondWishCountPerc",String.valueOf(searchList.getSecondWishCountPerc()));
			parameterMap.put("thirdWishCountPerc", String.valueOf(searchList.getThirdWishCountPerc()));
			parameterMap.put("totalWishCountPerc", String.valueOf(searchList.getTotalWishCountPerc()));
			
			InputStream reportStream
			  = getClass().getResourceAsStream("/jasperreports/committeeWishesCount.jrxml");
			JasperReport jasperReport
			  = JasperCompileManager.compileReport(reportStream);
			
			JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameterMap, new JRBeanCollectionDataSource(searchList.getReportCommitteeWishesCount()));
			result = exportPdfAndDownload(jasperPrint, "committeeWishesCount.pdf", response);
			}catch(Exception e) {
				throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e);
			}
			return result;
	}
	
	@RequestMapping(value = "/usersNotSubmitWishesReport", method = RequestMethod.POST, produces = "application/pdf")
	@ResponseBody
	public ResponseDTO getUsersNotSubmitWishesReport(HttpServletResponse response) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<ReportUsersNotSubmitWishesDTO> searchList = reportsService.getReportUsersNotSubmitWishes();
			Map<String, Object> parameterMap = new HashMap<>();
			
			InputStream reportStream
			  = getClass().getResourceAsStream("/jasperreports/usersNotSubmitWishes.jrxml");
			JasperReport jasperReport
			  = JasperCompileManager.compileReport(reportStream);
			
			JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameterMap, new JRBeanCollectionDataSource(searchList));
			result = exportPdfAndDownload(jasperPrint, "usersNotSubmitWishes.pdf", response);
			}catch(Exception e) {
				throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e);
			}
			return result;
	}
	
	@RequestMapping(value = "/usersWishesCommitteeReport", method = RequestMethod.POST, produces = "application/pdf")
	@ResponseBody
	public ResponseDTO usersWishesCommitteeReport(@RequestParam("committeeId") long committeeId, HttpServletResponse response) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<ReportUsersWishesDTO> searchList = reportsService.getReportUsersWishesCommittee(committeeId);
			Map<String, Object> parameterMap = new HashMap<>();
			
			String committeeName = "";
			CommitteeDTO committeeDTO = committeeService.findById(committeeId);
			if(committeeDTO != null)
			committeeName = committeeDTO.getNameAr();
			
			parameterMap.put("committee", committeeName);
			
			InputStream reportStream
			  = getClass().getResourceAsStream("/jasperreports/usersWishesCommittee.jrxml");
			JasperReport jasperReport
			  = JasperCompileManager.compileReport(reportStream);
			
			JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameterMap, new JRBeanCollectionDataSource(searchList));
			result = exportPdfAndDownload(jasperPrint, "usersWishesCommittee.pdf", response);
			}catch(Exception e) {
				throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e);
			}
			return result;
	}
	
	@RequestMapping(value = "/usersWishesCommitteeMemberReport", method = RequestMethod.POST, produces = "application/pdf")
	@ResponseBody
	public ResponseDTO usersWishesCommitteeMemberReport(@RequestParam("committeeId") long committeeId, HttpServletResponse response) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<ReportUsersWishesDTO> searchList = reportsService.getReportUsersWishesCommitteeMember(committeeId);
			Map<String, Object> parameterMap = new HashMap<>();
			
			String committeeName = "";
			CommitteeDTO committeeDTO = committeeService.findById(committeeId);
			if(committeeDTO != null)
			committeeName = committeeDTO.getNameAr();
			
			parameterMap.put("committee", committeeName);
			
			InputStream reportStream
			  = getClass().getResourceAsStream("/jasperreports/usersWishesCommitteeMember.jrxml");
			JasperReport jasperReport
			  = JasperCompileManager.compileReport(reportStream);
			
			JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameterMap, new JRBeanCollectionDataSource(searchList));
			result = exportPdfAndDownload(jasperPrint, "usersWishesCommitteeMember.pdf", response);
			}catch(Exception e) {
				throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e);
			}
			return result;
	}
	
	@RequestMapping(value = "/usersCommitteeMemberReport", method = RequestMethod.POST, produces = "application/pdf")
	@ResponseBody
	public ResponseDTO usersCommitteeMemberReport(@RequestParam("committeeId") long committeeId, HttpServletResponse response) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<ReportUsersNotSubmitWishesDTO> searchList = reportsService.getReportUsersCommitteeMember(committeeId);
			Map<String, Object> parameterMap = new HashMap<>();
			
			String committeeName = "";
			CommitteeDTO committeeDTO = committeeService.findById(committeeId);
			if(committeeDTO != null)
			committeeName = committeeDTO.getNameAr();
			
			parameterMap.put("committee", committeeName);
			
			InputStream reportStream
			  = getClass().getResourceAsStream("/jasperreports/usersCommitteeMember.jrxml");
			JasperReport jasperReport
			  = JasperCompileManager.compileReport(reportStream);
			
			JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameterMap, new JRBeanCollectionDataSource(searchList));
			result = exportPdfAndDownload(jasperPrint, "usersCommitteeMember.pdf", response);
			}catch(Exception e) {
				throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e);
			}
			return result;
	}
	
	@RequestMapping(value = "/usersWishesNotTrueReport", method = RequestMethod.POST, produces = "application/pdf")
	@ResponseBody
	public ResponseDTO usersWishesNotTrueReport(HttpServletResponse response) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<ReportUsersWishesDTO> searchList = reportsService.getReportUsersWishesNotTrueReport();
			Map<String, Object> parameterMap = new HashMap<>();
			
			InputStream reportStream
			  = getClass().getResourceAsStream("/jasperreports/usersWishesNotTrue.jrxml");
			JasperReport jasperReport
			  = JasperCompileManager.compileReport(reportStream);
			
			JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport, parameterMap, new JRBeanCollectionDataSource(searchList));
			result = exportPdfAndDownload(jasperPrint, "usersWishesNotTrue.pdf", response);
			}catch(Exception e) {
				throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e);
			}
			return result;
	}
	
	public ResponseDTO exportPdfAndDownload(JasperPrint jasperPrint, String reportName, HttpServletResponse response) throws ControllerException {
		ResponseDTO responseDTO = null;
		try {
		JRPdfExporter exporter = new JRPdfExporter();
		
		File file = new File("C:/Shura Reports");
		if(!file.exists())
			new File("C:/Shura Reports").mkdir();
		
		 exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,"C:/Shura Reports/"+reportName);
         exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
         exporter.exportReport();
		
        File downloadfile = new File("C:/Shura Reports/"+reportName);
        if(!downloadfile.exists())
            throw new ControllerException(ExceptionEnums.INVALID_OPERATION);

        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + downloadfile.getName() +"\""));
        response.setContentType("application/pdf");  
        response.setContentLength((int)downloadfile.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(downloadfile));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
        
        responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully", "Report");
		}catch(Exception e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e);
		}
		return responseDTO;
	}
	
}