package com.snlabs.aarogyatelangana.account.service.impl;

import com.snlabs.aarogyatelangana.account.beans.*;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompleteDetailsRowMapper implements RowMapper {

	List<User> detailsList = new ArrayList<User>();
    Row sheetRow = null;

    public CompleteDetailsRowMapper(Row row) {
        this.sheetRow = row;
    }

    @Override
	public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		do {
			int colNum = -1;
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_PATIENT_NAME"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getInt("F_PATIENT_ID"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_PATIENT_NAME"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getInt("F_AGE"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_GENDER"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_AADHAR_NO"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_CURRENT_ADDRESS"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_ADDRESS"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_CLINIC_NAME"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_TYPE"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_ADDRESS"));
            sheetRow.createCell(++colNum).setCellValue(resultSet.getString("F_REFERRAL_NAME"));
		} while (resultSet.next());
		return detailsList;
	}
}
