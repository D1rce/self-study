package knights;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
	
	@Bean
	public CompactDisc sgtPeppers(){
		return new SgtPeppers();
	}
	
	// 获取 sgtPeppers 的实例，获得的实例是 单例的
	// 无法声明实例多个  sgtPeppers() 如 otherCDplayer()
//	@Bean
//	public CDPlayer cdPlayer(){
//		return new CDPlayer(sgtPeppers());
//	}
	
//	@Bean
//	public CDPlayer otherCDPlayer(){
//		return new CDPlayer(sgtPeppers());
//	}
	
	// 获取 sgtPeppers 的实例
	// 因 9行配置了 SgtPeppers 类  
	// 这种方法spring会自动扫描 实现过 CompactDisc 的类，然后实例
	@Bean
	public CDPlayer cdPlayer(CompactDisc cd){
		return new CDPlayer(cd);
	}
	
}
