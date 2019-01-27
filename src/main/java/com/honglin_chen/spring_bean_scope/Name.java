package com.honglin_chen.spring_bean_scope;

/* 定义Name类及其处理客户的first和last名字的getter和setter方法 */
public class Name {
	/* 实例变量声明 */ 
	private String firstName; 
	private String lastName; 
	
	/* 默认构造函数 */ 
	public Name() {
		/* 为bean通过构造器构造Name bean提供服务 */ 
	}
	
	/* Name类的构造函数用于初始化客户的first和last名字 */
	public Name(String firstName, String lastName) {
		this.firstName = firstName; 
		this.lastName = lastName; 
	}
	
	/* firstName的getter函数 */ 
	public String getFirstName() {
		return this.firstName;
	}
	
	/* lastName的getter函数 */ 
	public String getLastName() {
		return this.lastName; 
	}
	
	/* firstName的setter函数 */ 
	public void setFirstName(String firstName) {
		this.firstName = firstName; 
	}
	
	/* lastName的setter函数 */ 
	public void setLastName(String lastName) {
		this.lastName = lastName; 
	}
}
