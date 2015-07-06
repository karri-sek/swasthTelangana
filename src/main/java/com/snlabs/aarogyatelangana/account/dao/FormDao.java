package com.snlabs.aarogyatelangana.account.dao;

import com.snlabs.aarogyatelangana.account.beans.*;

public interface FormDao {
    public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress);

    public boolean update(Form form);

    public boolean updateClinicDetails(ClinicAddress clinicAddress);

    public boolean updateSectionA(SectionA sectionA);

    public boolean updateNonInvasiveDetails(NonInvasive nonInvasive);

    public boolean updateInvasiveDetails(Invasive invasive);

    public Form findByFormId(long formId);

    public boolean delete(Form patient);

    public Form findByFromName(String formName);

    public Form searchFormByDateRange(String fromDate, String toDate);

    public SectionA saveSectionA(SectionA sectionA);

    public NonInvasive saveNonInvasive(NonInvasive nonInvasive);

    public Invasive saveInvasive(Invasive invasive);

    public Declaration saveDeclaration(Declaration declaration);

    public Patient getPatientDetails(long patientID);

    public SectionA getSectionADetails(long patientID);

    public ClinicAddress getClinicDetails(long patientID);

    public NonInvasive getNonInvasiveDetails(long patientID);

    public Invasive getInvasiveDetails(long patientID);
}
