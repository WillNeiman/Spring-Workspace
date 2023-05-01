package com.neiman.Example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("boseSpeaker")
public class BoseSpeaker implements Speaker{

	@Override
	public void volumeUp() {
		System.out.println(this.getClass() + "������ �ø���.");		
	}

	@Override
	public void volumeDown() {
		System.out.println(this.getClass() + "������ ������.");		
	}

}
