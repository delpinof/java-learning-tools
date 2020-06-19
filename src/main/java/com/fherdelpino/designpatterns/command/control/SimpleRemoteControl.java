package com.fherdelpino.designpatterns.command.control;

import com.fherdelpino.designpatterns.command.commandclass.Command;

public class SimpleRemoteControl {

	Command slot;

	public SimpleRemoteControl() {

	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}

}
