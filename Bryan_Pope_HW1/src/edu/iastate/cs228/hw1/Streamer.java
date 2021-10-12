package edu.iastate.cs228.hw1;

public class Streamer extends TownCell {

	public Streamer(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew) {
		TownCell t;
		this.census(nCensus);
		if(nCensus[RESELLER] > 0) {
			t = new Outage(tNew,this.row,this.col);
			return t;
		}
		else if(nCensus[OUTAGE] > 0) {
			t = new Empty(tNew,this.row,this.col);
			return t;
		}
		t = new Streamer(tNew,this.row,this.col);
		return t;
	}

	

}