package com.ch.team.domain;

/**
 * 
 * @author chenpi
 * @Description 架构师类
 *
 */
public class Architect extends Designer {
	private int stock;// 股票

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return super.getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t"
				+ getEquipment().getDescription();
	}

	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t架构师\t" + super.getBonus() + "\t" + stock;
	}
}
