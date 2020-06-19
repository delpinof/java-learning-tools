package test.designpatterns.command;

import com.fherdelpino.designpatterns.command.commandclass.GarageDoorOpenCommand;
import com.fherdelpino.designpatterns.command.commandclass.LightOnCommand;
import com.fherdelpino.designpatterns.command.control.SimpleRemoteControl;
import com.fherdelpino.designpatterns.command.vendor.GarageDoor;
import com.fherdelpino.designpatterns.command.vendor.Light;

public class SimpleRemoteControlTest {

	public void testLightOnAndGarageOpen() {
		Light light = new Light();
		GarageDoor garageDoor = new GarageDoor();

		LightOnCommand lightOn = new LightOnCommand(light);
		GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);

		SimpleRemoteControl remote = new SimpleRemoteControl();
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
	}

}
