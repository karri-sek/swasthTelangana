package com.snlabs.aarogyatelangana.account.service.impl;

import java.util.Date;

import com.snlabs.aarogyatelangana.account.beans.*;
import com.snlabs.aarogyatelangana.account.dao.FormDao;
import com.snlabs.aarogyatelangana.account.service.FormService;
import com.snlabs.aarogyatelangana.account.service.PatientService;

public class FormServiceImpl implements FormService {

    FormDao formDao;

    PatientService patientService;

    @Override
    public Patient getPatientDetails(long patientID) {
        try {
            return formDao.getPatientDetails(patientID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress) {
        try {
            if (clinicAddress.getPatientID() > 0 && "UPDATE".equals(clinicAddress.getOperation())) {
            	formDao.updateClinicDetails(clinicAddress);
                return clinicAddress;
            } else {
                return formDao.saveClinicDetails(clinicAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClinicAddress getClinicDetails(long patientID) {
        return formDao.getClinicDetails(patientID);
    }

    public FormDao getFormDao() {
        return formDao;
    }

    public void setFormDao(FormDao formDao) {
        this.formDao = formDao;
    }

    @Override
    public Form searchForm(int formId) {
        return formDao.findByFormId(formId);
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public Form searchFormByDateRange(Date fromDate, Date toDate) {
        return formDao.searchFormByDateRange(fromDate, toDate);
    }

    @Override
    public SectionA saveSectionA(SectionA section) {
        if (section.getPatientID() > 0 && "UPDATE".equals(section.getOperation())) {
        	formDao.updateSectionA(section);
            return section;
        } else {
            return formDao.saveSectionA(section);
        }
    }

    @Override
    public NonInvasive saveNonInvasiveDetails(NonInvasive nonInvasive) {
        if (nonInvasive.getPatientID() > 0 && "UPDATE".equals(nonInvasive.getOperation())) {
        	formDao.updateNonInvasiveDetails(nonInvasive);
            return nonInvasive;
        } else {
            return formDao.saveNonInvasive(nonInvasive);
        }
    }

    @Override
    public Invasive saveInvasiveDetails(Invasive invasive) {
        if (invasive.getPatientID() > 0 && "UPDATE".equals(invasive.getOperation())) {
        	formDao.updateInvasiveDetails(invasive);
            return invasive;
        } else {
            return formDao.saveInvasive(invasive);
        }
    }

    @Override
    public Declaration saveDeclarationDetails(Declaration declaration) {
        return formDao.saveDeclaration(declaration);
    }

    @Override
    public SectionA getSectionADetails(long patientID) {
        return formDao.getSectionADetails(patientID);
    }

    @Override
    public NonInvasive getNonInvasiveDetails(long patientID) {
        return formDao.getNonInvasiveDetails(patientID);
    }

    @Override
    public Invasive getInvasiveDetails(long patientID) {
        return formDao.getInvasiveDetails(patientID);
    }

}
