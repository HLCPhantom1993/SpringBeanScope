package com.honglin_chen.spring_bean_scope;
import com.honglin_chen.spring_bean_scope.Name;

/* 为客户类创建实例bean */ 
public class Customer {
	/* 客户类实例变量以便获取和设置客户名字 */ 
	private Name name; 
	
	/* 定义客户的名字的getter函数 */
	public Name getName() {
		return name; 
	}
	
	/* 定义客户的名字的setter函数 */
	public void setName(Name name) {
		this.name = name; 
	}
	
	/* 重载toString函数输出客户的姓名 */ 
	@Override 
	public String toString() {
		return "客户: " + this.getName().getFirstName() + " " 
				+ this.getName().getLastName(); 
	}
}
