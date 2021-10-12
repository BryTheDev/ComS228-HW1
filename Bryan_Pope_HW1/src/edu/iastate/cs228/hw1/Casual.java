package edu.iastate.cs228.hw1;

public class Casual extends TownCell {

	public Casual(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew) {
		TownCell t;
		this.census(nCensus);
		if(nCensus[RESELLER] > 0) {
			t = new Outage(tNew,this.row,this.col);
			return t;
		}
		else if(nCensus[STREAMER] > 0) {
			t = new Streamer(tNew,this.row,this.col);
			return t;
		}
		t = new Casual(tNew,this.row,this.col);
		return t;
	}

	

}
