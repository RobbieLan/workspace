package com.patterns.statemachine;

public abstract class PlayerState {
	public final static int PLAY_OR_PAUSE = 0;
	public final static int STOP = 1;
	public final static int SHOW_AD = 2;
	protected IPlayer mPlayer;

	public PlayerState(IPlayer player) {
		this.mPlayer = player;
	}

	public abstract void handle(int action);

	@Override
	public String toString() {
		return "current state:" + this.getClass().getSimpleName();
	}
}
