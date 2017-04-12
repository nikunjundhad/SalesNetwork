package com.nik.sales;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.nik.sales.SalesPerson;

@RunWith(JUnit4.class)
public class SalesPersonTest {
	
	private SalesPerson sp1;
	private SalesPerson sp2;
	private SalesPerson sp3;
	private SalesPerson sp4;
	
	@Before
	public void setUp(){
		sp1 = new SalesPerson("PersonA", 100);
		sp2 = new SalesPerson("PersonB", 200);
		sp3 = new SalesPerson("PersonC", 500);
		sp4 = new SalesPerson("PersonD", 500);
	}

	@Test
	public void testSalesPersonConstructorStoreNameAndSalesDetailProperly(){
		assertEquals("should set proper name", "PersonA", sp1.getName());
		assertEquals("should set proper sales value", 100, sp1.getSale());
	}
	
	@Test
	public void testHigherSalesPersonComparisonShouldReturnPositive(){
		assertTrue("should return positive for higher number", sp2.compareTo(sp1) > 0);
	}
	
	@Test
	public void testSalesPersonComparisonWithNullShouldReturnPositive(){
		assertTrue("should return positive for higher number", sp2.compareTo(null) > 0);
	}
	
	@Test
	public void testLowerSalesPersonComparisonShouldReturnNegative(){
		assertTrue("should return positive for higher number", sp2.compareTo(sp3) < 0);
	}
	
	@Test
	public void testEqualSalesPersonComparisonShouldReturnZero(){
		assertTrue("should return positive for higher number", sp4.compareTo(sp3) == 0);
	}
}
