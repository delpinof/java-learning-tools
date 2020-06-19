package com.fherdelpino.designpatterns.command.commandclass;

import com.fherdelpino.designpatterns.command.vendor.Stereo;

public class StereoOnCommand implements Command {

	private Stereo stereo;

	public StereoOnCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume(11);

	}

}
