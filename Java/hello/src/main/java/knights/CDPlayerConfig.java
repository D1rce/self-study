package knights;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
	
	@Bean
	public CompactDisc sgtPeppers(){
		return new SgtPeppers();
	}
	
	// ��ȡ sgtPeppers ��ʵ������õ�ʵ���� ������
	// �޷�����ʵ�����  sgtPeppers() �� otherCDplayer()
//	@Bean
//	public CDPlayer cdPlayer(){
//		return new CDPlayer(sgtPeppers());
//	}
	
//	@Bean
//	public CDPlayer otherCDPlayer(){
//		return new CDPlayer(sgtPeppers());
//	}
	
	// ��ȡ sgtPeppers ��ʵ��
	// �� 9�������� SgtPeppers ��  
	// ���ַ���spring���Զ�ɨ�� ʵ�ֹ� CompactDisc ���࣬Ȼ��ʵ��
	@Bean
	public CDPlayer cdPlayer(CompactDisc cd){
		return new CDPlayer(cd);
	}
	
}
