package com.fherdelpino.designpatterns.command.commandclass;

import com.fherdelpino.designpatterns.command.vendor.Light;

public class LightOnCommand implements Command {
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();

	}


	public void undo() {
		light.off();

	}

}
