package com.fherdelpino.designpatterns.command.commandclass;

import com.fherdelpino.designpatterns.command.vendor.GarageDoor;

public class GarageDoorOpenCommand implements Command {

	GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.up();

	}

	public void undo() {
		garageDoor.down();

	}

}
