package com.snlabs.aarogyatelangana.account.dao.impl;

import com.snlabs.aarogyatelangana.account.beans.Form;
import com.snlabs.aarogyatelangana.account.beans.Patient;
import com.snlabs.aarogyatelangana.account.beans.User;
import com.snlabs.aarogyatelangana.account.dao.DownloadDao;
import com.snlabs.aarogyatelangana.account.service.impl.CompleteDetailsRowMapper;
import com.snlabs.aarogyatelangana.account.service.impl.FormRowMapper;
import com.snlabs.aarogyatelangana.account.service.impl.PatientRowMapper;
import com.snlabs.aarogyatelangana.account.utils.CustomDate;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class DownloadDaoImpl implements DownloadDao {

    private DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public File downloadExcelForm(HttpServletRequest request,
                                  HttpSession session) {
        String fileId = null;
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM T_FORM WHERE ");
        if (session.getAttribute("formId") != null) {
            fileId = String.valueOf(session.getAttribute("formId"));
            queryBuilder.append("F_FORM_ID = ").append(fileId);
        } else {
            fileId = String.valueOf(session.getAttribute("formId"));
            queryBuilder.append("F_FORM_ID = ").append(fileId);
        }
        String filePath = "/resources/F_" + fileId + ".xls";
        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("");
        System.out.println(" application path: " + appPath);
        String fullPath = appPath + filePath;
        File downloadFile = new File(fullPath);
        try {
            List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(
                    queryBuilder.toString(), new FormRowMapper());
            return prepareExcelSheet(detailsList, fullPath, downloadFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private File prepareExcelSheet(List<User> detailsList, String fullPath,
                                   File downloadFile) {
        try {
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet sheet = workBook.createSheet("Details");
            int rownum = 0;
            Form form = null;
            Patient pe = null;
            // setWorkBookStyles(workBook);
            prepareHeader(sheet.createRow(rownum), workBook);
            Row row = sheet.createRow(++rownum);
            for (User user : detailsList) {
                int colnum = 0;
                Cell cell = null;
                if (user instanceof Patient) {
                    pe = (Patient) user;
                    cell = row.createCell(colnum);
                    cell.setCellValue((String) pe.getPatientName());
                    cell = row.createCell(++colnum);
                }
                if (user instanceof Form) {
                    form = (Form) user;
                    cell = row.createCell(colnum);
                    cell.setCellValue((String) form.getPatientName());
                    cell = row.createCell(++colnum);
                    cell.setCellValue((Integer) form.getAge());
                    cell = row.createCell(++colnum);
                    cell.setCellValue((Integer) form.getNoOfChildren());
                    cell = row.createCell(++colnum);
                    cell.setCellValue((String) form.getPatientAddress());
                    cell = row.createCell(++colnum);
                    cell.setCellValue((String) form.getMedicalDisease());
                    cell = row.createCell(++colnum);
                    cell.setCellValue((String) form.getParentalDiagnosis());
                    cell = row.createCell(++colnum);
                    cell.setCellValue((String) form.getGynecologistDetails());
                }
            }
            FileOutputStream fos = new FileOutputStream(new File(fullPath));
            workBook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return downloadFile;
    }

    @Override
    public File downloadExcelPatient(HttpServletRequest request,
                                     HttpSession session) {
        String fileId = null;
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM T_PATIENT WHERE ");
        if (session.getAttribute("patientId") != null) {
            fileId = (String) session.getAttribute("patientId");
            queryBuilder.append("F_PATIENT_ID = ").append(fileId);
        } else {
            fileId = (String) session.getAttribute("patientName");
            queryBuilder.append("F_PATIENT_NAME = '").append(fileId)
                    .append("'");
        }
        String filePath = "/resources/P_" + fileId + ".xls";
        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("");
        String fullPath = appPath + filePath;
        File downloadFile = new File(fullPath);
        System.out.println("FULL  path: " + fullPath);
        try {
            List<User> detailsList = (List<User>) jdbcTemplate.queryForObject(
                    queryBuilder.toString(), new PatientRowMapper());
            System.out.println("Size " + detailsList.size());
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet sheet = workBook.createSheet("Details");
            int rownum = 0;
            Form form = null;
            Patient pe = null;
            // setWorkBookStyles(workBook);
            prepareHeader(sheet.createRow(rownum), workBook);
            Row row = sheet.createRow(++rownum);
            for (User user : detailsList) {
                int colnum = 0;
                Cell cell = null;
                if (user instanceof Patient) {
                    pe = (Patient) user;
                    cell = row.createCell(colnum);
                    cell.setCellValue((String) pe.getPatientName());
                    cell = row.createCell(++colnum);
                    if (user instanceof Form) {
                        form = (Form) user;
                        cell = row.createCell(colnum);
                        cell.setCellValue((String) form.getPatientName());
                        cell = row.createCell(++colnum);
                        cell.setCellValue((Integer) form.getAge());
                        cell = row.createCell(++colnum);
                        cell.setCellValue((Integer) form.getNoOfChildren());
                        cell = row.createCell(++colnum);
                        cell.setCellValue((String) form.getPatientAddress());
                        cell = row.createCell(++colnum);
                        cell.setCellValue((String) form.getMedicalDisease());
                        cell = row.createCell(++colnum);
                        cell.setCellValue((String) form.getParentalDiagnosis());
                        cell = row.createCell(++colnum);
                        cell.setCellValue((String) form
                                .getGynecologistDetails());
                    }
                }
                FileOutputStream fos = new FileOutputStream(new File(fullPath));
                workBook.write(fos);
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return downloadFile;
    }

    @Override
    public File downloadDetails(int patientID, HttpServletRequest request, HttpSession session) {
        File patientFile = null;
        try {
            CustomDate date = new CustomDate(new SimpleDateFormat("yyyy-MMMM-dd").format(new Date()));
            StringBuilder patientFilePath = new StringBuilder();
            patientFilePath.append("D:\\home\\telangana\\")
                    .append(date.YEAR).append("\\").append(date.MONTH)
                    .append("\\").append(patientID).append(".xls");
            patientFile = new File(patientFilePath.toString());
            Boolean fileCreation = patientFile.getParentFile().exists() ? true : patientFile.getParentFile().mkdirs();
            if (fileCreation) {
                if (patientFile.createNewFile()) {
                    System.out.println("Created File successfully");
                    System.out.print("  path : "+patientFile.getAbsolutePath());
                    System.out.print("  path : "+patientFile.getCanonicalPath());
                    StringBuilder patientDetailsQuery = new StringBuilder();
                    patientDetailsQuery.append("SELECT patient.F_PATIENT_ID, patient.F_PATIENT_NAME,")
                            .append(" patient.F_AGE, patient.F_GENDER, patient.F_AADHAR_NO,")
                            .append(" patient_address.F_CURRENT_ADDRESS, patient_address.F_ADDRESS,")
                            .append(" clinic.F_CLINIC_OWNER_NAME, clinic.F_TYPE, clinic.F_ADDRESS,")
                            .append(" referral.F_REFERRAL_NAME")
                            .append(" FROM T_PATIENT patient, T_PATIENT_ADDRESS patient_address,")
                            .append(" T_REFERRAL_ADDRESS referral,").append(" T_CLINIC_DETAILS clinic")
                            .append(" WHERE patient.F_PATIENT_ID=? AND referral.F_PATIENT_ID=?")
                            .append(" AND clinic.F_PATIENT_ID=? AND patient_address.F_PATIENT_ID=?");
                    Object[] arguments = new Object[]{patientID, patientID, patientID, patientID};
                    HSSFWorkbook workBook = new HSSFWorkbook();
                    HSSFSheet sheet = workBook.createSheet("Details");
                    int rowNum = 0;
                    Row row = sheet.createRow(++rowNum);
                    jdbcTemplate.query(patientDetailsQuery.toString(), arguments, new CompleteDetailsRowMapper(row));
                    FileOutputStream fos = new FileOutputStream(patientFile);
                    workBook.write(fos);
                    fos.close();
                } else {
                    System.out.println("Failed in creation");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientFile;
    }

    private void setWorkBookStyles(HSSFWorkbook wb) {
        try {
            HSSFFont defaultFont = wb.createFont();
            defaultFont.setFontHeightInPoints((short) 10);
            defaultFont.setFontName("Arial");
            // defaultFont.setColor(IndexedColors.BLACK.getIndex());
            defaultFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
            defaultFont.setItalic(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareHeader(Row row, HSSFWorkbook workBook) {
        int colNum = 0;
        CellStyle style = workBook.createCellStyle();
        try {
            row.createCell(colNum).setCellValue("PATIENT NAME");
            row.createCell(++colNum).setCellValue("PATIENT_ID");
            row.createCell(++colNum).setCellValue("AGE");
            row.createCell(++colNum).setCellValue("PATIENT ADDRESS");
            row.createCell(++colNum).setCellValue("MEDICAL DISEASE");
            row.createCell(++colNum).setCellValue("PARENTAL DIAGNOSIS");
            row.createCell(++colNum).setCellValue("GYNA DETAILS");
            row.createCell(++colNum).setCellValue("NO OF CHILDREN");
            row.createCell(++colNum).setCellValue("GURDIAN NAME");
            row.createCell(++colNum).setCellValue("PATIENT ADDRESS");
            row.createCell(++colNum).setCellValue("REFERRAL ADDRESS");
            row.createCell(++colNum).setCellValue("MENUSTRAL PERIOD");
            row.createCell(++colNum).setCellValue("MEDICAL DISEASE");
            row.createCell(++colNum).setCellValue("PARENTAL DIAGNOLYSIS");
            row.createCell(++colNum).setCellValue("GYNECOLOGIST ADDRESS");
            style.setFillBackgroundColor(IndexedColors.DARK_BLUE.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            style.setAlignment(CellStyle.ALIGN_CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
