package com.neiman.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{

	@Autowired
	@Qualifier("boseSpeaker")
	Speaker speaker;
	
//	@Autowired
//	public SamsungTV(@Qualifier("boseSpeaker") Speaker speaker) {
//		this.speaker = speaker;
//	}

	@Override
	public void turnOn() {
		System.out.println(this.getClass() + "���� on");
		
	}

	@Override
	public void turnOff() {
		System.out.println(this.getClass() + "���� off");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	

}
