package com.fherdelpino.designpatterns.command.control;

import com.fherdelpino.designpatterns.command.commandclass.Command;
import com.fherdelpino.designpatterns.command.commandclass.NoCommand;

public class RemoteControl {

	Command[] onCommands;
	Command[] offCommands;
	private static final int CONTROL_SIZE = 7;

	public RemoteControl() {
		onCommands = new Command[CONTROL_SIZE];
		offCommands = new Command[CONTROL_SIZE];

		Command noCommand = new NoCommand();
		for(int i = 0; i<CONTROL_SIZE; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i< CONTROL_SIZE; i++) {
			sb.append("[slot " + i + "] ");
			sb.append(onCommands[i].getClass().getName() + "  ");
			sb.append(onCommands[i].getClass().getName());
			sb.append("\n");
		}
		return sb.toString();
	}

}
