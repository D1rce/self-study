package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import knights.CDPlayer;
import knights.CDPlayerConfig;

public class CDplayMain {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		AnnotationConfigApplicationContext context =  
				new AnnotationConfigApplicationContext(CDPlayerConfig.class);  
		
		CDPlayer cdPlayer = context.getBean(CDPlayer.class);
		cdPlayer.paly();
		context.close();
		
	}

}
