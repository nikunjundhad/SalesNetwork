package com.nik.sales;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nik.sales.SalesNetwork;
import com.nik.sales.SalesPerson;

public class SalesNetworkTest {
	
	private SalesPerson sp1;
	private SalesPerson sp2;
	private SalesPerson sp3;
	private SalesPerson sp4;
	private SalesPerson sp5;
	private List<SalesPerson> members;
	private SalesNetwork salesNetwork; 
	
	@Before
	public void setUp(){
		sp1 = new SalesPerson("PersonA", 100);
		sp2 = new SalesPerson("PersonB", 200);
		sp3 = new SalesPerson("PersonC", 500);
		sp4 = new SalesPerson("PersonD", 500);
		sp5 = new SalesPerson("PersonD", 300);
		members = new ArrayList<SalesPerson>();
		members.add(sp1);
		members.add(sp2);
		members.add(sp3);
		members.add(sp4);
		salesNetwork = new SalesNetwork();
		salesNetwork.setMembers(members);
		
	}

	@Test
	public void testNetworkTotalSales() {
		SalesNetwork salesNetwork = new SalesNetwork();
		salesNetwork.setMembers(members);
		
		assertThat("it should return total sale of network members",salesNetwork.getTotalSale(), equalTo(1300));
	}
	
	@Test
	public void testFirstMembersRankInNetwork(){
		assertThat("it should return 1 for first rank", salesNetwork.getMemberRankInNetwork(sp3), equalTo(1));
		assertThat("it should return 1 for first rank", salesNetwork.getMemberRankInNetwork(sp4), equalTo(1));
	}
	
	@Test
	public void testThirdMemberRankInNetwork(){
		assertThat("it should return 3 for second rank because we have two first rank", salesNetwork.getMemberRankInNetwork(sp2), equalTo(3));
	}
	
	@Test
	public void testZeroMemberRankForSalesPersonNotExistInNetwork(){
		assertThat("is should return 0 for member not exist in network ", salesNetwork.getMemberRankInNetwork(sp5), equalTo(0));
	}
	
	@Test
	public void testZeroContributionOfMemberNotExistInNetwork(){
		assertThat("it should return 0.0 for member not part of network", salesNetwork.getMemberContributionIntoNetworkSales(sp5) , equalTo(0.0));
	}
	
	
	@Test
	public void testMemberContributionInNetwork(){
		assertThat("it should return greater than 38.4615 for contribution in network",
					salesNetwork.getMemberContributionIntoNetworkSales(sp4),
					greaterThan(38.4615));
		
		assertThat("it should return greater than 15.38 for contribution in network",
				salesNetwork.getMemberContributionIntoNetworkSales(sp4),
				greaterThan(15.38));
	}
	
	@Test
	public void testTotalSalesContributionTotalOfNetwork(){
		assertThat("total should be eqal to 100 ", 
					salesNetwork.getMemberContributionIntoNetworkSales(sp1) + 
					salesNetwork.getMemberContributionIntoNetworkSales(sp2) +
					salesNetwork.getMemberContributionIntoNetworkSales(sp3) +
					salesNetwork.getMemberContributionIntoNetworkSales(sp4),
					equalTo(100.0));
		
	}
	
	@Test
	public void testMemberRankAndContributionString(){
		assertThat(salesNetwork.getMemberRankAndContriButionString(sp4), 
				equalTo("PersonD :- Rank : 1 and Contribution : 38.46153846153846"));
	}

}
