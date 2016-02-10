/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans.registration;

import java.util.Map;

import com.snlabs.aarogyatelangana.account.beans.Address;

/**
 * @author nbattula
 *
 */
public class CentreDetails {
	
	private String ownershipType;
	
	//In case type of organization is other than individual ownership
	private String articlesOfAssociation;
	private Map<String, Address> associateDetails;
	private String institutionType;
	

}
