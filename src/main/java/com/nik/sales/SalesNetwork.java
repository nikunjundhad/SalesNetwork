package com.nik.sales;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalesNetwork {

	private String name;
	private List<SalesPerson> members = new ArrayList<SalesPerson>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SalesPerson> getMembers() {
		return members;
	}
	public void setMembers(List<SalesPerson> members) {
		this.members = members;
	}
	public void addMember(SalesPerson salesPerson){
		members.add(salesPerson);
	}
	
	public void removeMember(SalesPerson salesPerson){
		members.remove(salesPerson);
	}
	
	public int getTotalSale() {
		int totalSale = 0;
		for (SalesPerson salesPerson : members) {
			totalSale += salesPerson.getSale();
		}
		return totalSale;
	}
	
	public int getMemberRankInNetwork(SalesPerson salesPerson){
		int rank= 0;
		if(members.contains(salesPerson)){
			Collections.sort(members, Collections.reverseOrder());
			rank= 1;
			int increment = 0;
			for (SalesPerson currentMember : members) {
				if(currentMember.getName().equals(salesPerson.getName())){
					break;
				}else{
					if(currentMember.getSale() == salesPerson.getSale()){
						increment++;
						continue;
					}
					increment++;
					rank += increment;
					increment = 0;
				}
			}
		}
		return rank;
	}
	
	public double getMemberContributionIntoNetworkSales(SalesPerson salesPerson){
		double contribution = 0.0;
		if(members.contains(salesPerson)){
			contribution = (double)(salesPerson.getSale() * 100) / getTotalSale();
		}
		return contribution;
	}
	
	public String getMemberRankAndContriButionString(SalesPerson salesPerson){
		return salesPerson.getName() + " :- Rank : " + getMemberRankInNetwork(salesPerson) +" and Contribution : " + getMemberContributionIntoNetworkSales(salesPerson); 
	}
	
}
