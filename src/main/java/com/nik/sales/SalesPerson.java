package com.nik.sales;

public class SalesPerson implements Comparable<SalesPerson> {

	private String name;
	private int sale = 0;

	public SalesPerson(String name, int sale) {
		super();
		this.name = name;
		this.sale = sale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int compareTo(SalesPerson salePerson) {
		if (salePerson == null) {
			return this.sale;
		}else{
			int sale = ((SalesPerson) salePerson).getSale();
			return this.sale - sale;
		}
	}

	@Override
	public String toString() {
		return "SalesPerson [name=" + name + ", sale=" + sale + "]";
	}

}
