/**
 * 
 */
package com.snlabs.aarogyatelangana.account.beans;

import java.io.Serializable;

/**
 * @author nbattula
 *
 */
public class BirthHealthInfo implements Serializable{

	private static final long serialVersionUID = -1694481988875625019L;

	private long birthId;
	private String operation;
	private String attentionAtDelivery;
	private String deliveryMethod;
	private int birthWeight;
	private int pregnancyDuration;
	
	public long getBirthId() {
		return birthId;
	}
	public void setBirthId(long birthId) {
		this.birthId = birthId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getAttentionAtDelivery() {
		return attentionAtDelivery;
	}
	public void setAttentionAtDelivery(String attentionAtDelivery) {
		this.attentionAtDelivery = attentionAtDelivery;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public int getBirthWeight() {
		return birthWeight;
	}
	public void setBirthWeight(int birthWeight) {
		this.birthWeight = birthWeight;
	}
	public int getPregnancyDuration() {
		return pregnancyDuration;
	}
	public void setPregnancyDuration(int pregnancyDuration) {
		this.pregnancyDuration = pregnancyDuration;
	}
	
}
