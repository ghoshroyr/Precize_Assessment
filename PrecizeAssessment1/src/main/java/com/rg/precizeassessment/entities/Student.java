package com.rg.precizeassessment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student {

	@Id
	private String Name;
	private String Address;
	private String City;
	private String Country;
	private String PinCode;
	private int SATScore;
	private String SATResults;
	public Student() {}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}
	public int getSATScore() {
		return SATScore;
	}
	public void setSATScore(int sATScore) {
		SATScore = sATScore;
	}
	public String getSATResults() {
		return SATResults;
	}
	public void setSATResults(String sATResults) {
		SATResults = sATResults;
	}
}
