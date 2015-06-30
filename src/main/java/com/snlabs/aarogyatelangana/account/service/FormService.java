package com.snlabs.aarogyatelangana.account.service;

import com.snlabs.aarogyatelangana.account.beans.*;

public interface FormService {
    public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress);

    public Form searchForm(int formId);

    public Form searchFormByDateRange(String fromDate, String toDate);

    public SectionA saveSectionA(SectionA section);

    public NonInvasive saveNonInvasiveDetails(NonInvasive nonInvasive);

    public Invasive saveInvasiveDetails(Invasive invasive);

    public Declaration saveDeclarationDetails(Declaration declaration);

    public Patient getPatientDetails(int patientID);

    public SectionA getSectionADetails(int patientID);

    public ClinicAddress getClinicDetails(int patientID);

    public NonInvasive getNonInvasiveDetails(int patientID);

    public Invasive getInvasiveDetails(int patientID);

}
