package main;

public class InputEventArgs extends EventArgs {

	private int index;

	public InputEventArgs(int index) {
		this.index = index;
	}

	public int getIndex() { 
		return this.index;
	}
}
