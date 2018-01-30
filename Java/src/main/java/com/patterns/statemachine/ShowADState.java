package com.patterns.statemachine;

public class ShowADState extends PlayerState {

	public ShowADState(IPlayer player) {
		super(player);
	}

	@Override
	public void handle(int action) {
		switch (action) {
		case PlayingState.PLAY_OR_PAUSE:
			mPlayer.playVedio();
			mPlayer.setState(new PlayingState(mPlayer));
			break;
		default:
			throw new IllegalArgumentException("ERROE ACTION:" + action + "," + this.toString());
		}
	}
}
