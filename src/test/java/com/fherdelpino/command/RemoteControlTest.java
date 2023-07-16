package com.fherdelpino.command;

import com.fherdelpino.designpatterns.command.control.RemoteControl;
import com.fherdelpino.designpatterns.command.vendor.Light;
import com.fherdelpino.designpatterns.command.vendor.Stereo;
import org.junit.jupiter.api.Test;

public class RemoteControlTest {

	@Test
	public void lightOnTest() {
		Light livingRoomLight = new Light("Living Room");

		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setCommand(0, livingRoomLight::on, livingRoomLight::off);

	}

	@Test
	public void stereoOnTest() {
		Stereo livingRoomStereo = new Stereo("Living Room");

		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setCommand(0, () -> {
			livingRoomStereo.on();
			livingRoomStereo.setCd();
			livingRoomStereo.setVolume(11);
		}, livingRoomStereo::off);
	}

}
