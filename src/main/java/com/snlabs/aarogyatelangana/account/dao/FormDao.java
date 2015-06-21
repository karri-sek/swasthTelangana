package com.snlabs.aarogyatelangana.account.dao;

import com.snlabs.aarogyatelangana.account.beans.*;

public interface FormDao {
    public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress);

    public boolean update(Form form);

    public boolean updateClinicDetails(ClinicAddress clinicAddress);

    public boolean updateSectionA(SectionA sectionA);

    public boolean updateNonInvasiveDetails(NonInvasive nonInvasive);

    public boolean updateInvasiveDetails(Invasive invasive);

    public Form findByFormId(int formId);

    public boolean delete(Form patient);

    public Form findByFromName(String formName);

    public Form searchFormByDateRange(String fromDate, String toDate);

    public SectionA saveSectionA(SectionA sectionA);

    public NonInvasive saveNonInvasive(NonInvasive nonInvasive);

    public Invasive saveInvasive(Invasive invasive);

    public Declaration saveDeclaration(Declaration declaration);

    public Patient getPatientDetails(int patientID);

    public SectionA getSectionADetails(int patientID);

    public ClinicAddress getClinicDetails(int patientID);

    public NonInvasive getNonInvasiveDetails(int patientID);

    public Invasive getInvasiveDetails(int patientID);
}
