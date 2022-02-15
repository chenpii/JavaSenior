package com.ch.team.service;

/**
 * @author chenpi
 * @Description 表示员工的状态。枚举类:只有有限个对象。
 * @date 2021年2月12日
 */
//public class Status {
//	private final String NAME;
//
//	public Status(String name) {
//		super();
//		this.NAME = name;
//	}
//
//	public static final Status FREE = new Status("FREE");
//	public static final Status BUSY = new Status("BUSY");
//	public static final Status VOCATION = new Status("VOCATION");
//
//	public String getNAME() {
//		return NAME;
//	}
//
//	@Override
//	public String toString() {
//		return NAME;
//	}
//}
public enum Status {
    FREE, BUSY, VOCATION;

}