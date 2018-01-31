package test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import knights.Knight;
import knights.KnightConfig;

public class KnightMain {

	public static void main(String[] args) {
//		// TODO 自动生成的方法存根
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/knight.xml");
//		Knight knight = context.getBean(Knight.class);
//		knight.embarkOnQuest();
//		context.close();
		
		AnnotationConfigApplicationContext context =  
				new AnnotationConfigApplicationContext(KnightConfig.class);  
		
		Knight knight = context.getBean(Knight.class);
		knight.embarkOnQuest();
		context.close();
				
		
		
		
		
	}

}
