package com.snlabs.aarogyatelangana.account.service;

import java.util.Date;

import com.snlabs.aarogyatelangana.account.beans.*;

public interface FormService {
    public ClinicAddress saveClinicDetails(ClinicAddress clinicAddress);

    public Form searchForm(int formId);

    public Form searchFormByDateRange(Date fromDate, Date toDate);

    public SectionA saveSectionA(SectionA section);

    public NonInvasive saveNonInvasiveDetails(NonInvasive nonInvasive);

    public Invasive saveInvasiveDetails(Invasive invasive);

    public Declaration saveDeclarationDetails(Declaration declaration);

    public Patient getPatientDetails(long patientID);

    public SectionA getSectionADetails(long patientID);

    public NonInvasive getNonInvasiveDetails(long patientID);

    public Invasive getInvasiveDetails(long patientID);

	ClinicAddress getClinicDetails(long patientID);

}
