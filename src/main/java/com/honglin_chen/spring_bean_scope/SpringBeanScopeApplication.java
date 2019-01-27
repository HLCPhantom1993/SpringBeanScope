package com.honglin_chen.spring_bean_scope;

import org.springframework.context.support.ClassPathXmlApplicationContext; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBeanScopeApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/* 创建应用文本并载入bean构造文件 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml"); 
		/* 创建Customer1的bean */
		Customer customer1 = (Customer) context.getBean("customer1");
		System.out.println("第一个客户是: " + customer1.toString());
		
		/* 通过Singleton来创建一个新的名字实例 */ 
		Name name = (Name) context.getBean("single"); 
		name.setFirstName("Honglin");
		name.setLastName("Chen");
		
		/* 在Name bean创建新的实例之后我们再创建一个新的客户实例 */
		Customer customer2 = (Customer) context.getBean("customer2"); 
		/* 因为我们定义customer2bean指向Name bean且Name bean被设置为singleton scope
		 * 每次我们对Name bean创建实例时都会得到一个新的单独的实例覆盖掉之前的实例(single
		 * ton模式只允许一个实例存在), 所以customer2实例指向了新的Name bean
		 */
		System.out.println("第二个客户是: " + customer2.toString()); 
		
		/* 通过Prototype创建一个客户实例 */
		Customer customer3 = (Customer) context.getBean("customer3");
		System.out.println("第三个客户是: " + customer3.toString());
		
		/* 通过Prototype模式创建一个新的Name bean实例 */
		Name nameProto = (Name) context.getBean("proto"); 
		/* 通过改变当前nameProto bean的成员变量值来为指向它的客户4 bean设置姓名 */
		nameProto.setFirstName("Whatever");
		nameProto.setLastName("Whatever");
		
		/* 创建客户4bean的实例, 我们设定客户4的指代依赖是nameProto, 我们在创建客
		 * 户4的实例之前已经对nameProto做过重建操作, 因为nameProto的scope被设置
		 * 为Prototype, 因此无论我们建立多少Prototype的实例它们都只有一个原型即在
		 * bean构造时初始化的那个实例 
		 */ 
		Customer customer4 = (Customer) context.getBean("customer4"); 
		System.out.println("第四个客户是: " + customer4.toString()); 
		
		context.close(); 
	}

}

