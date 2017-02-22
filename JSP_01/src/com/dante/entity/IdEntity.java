package com.dante.entity;

public abstract class IdEntity {

	/*
	 * DTO类的编写：Date transfer Object（数据传输对象）
	 * 数据传输对象与数据交互对象或数据访问对象之间的差异是一个以
	 * 不具有任何行为除了存储和检索的数据（访问和存取器）。
	 * 所以一般只有成员变量，不含有逻辑代码
	 */
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
