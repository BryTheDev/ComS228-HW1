package edu.iastate.cs228.hw1;

public class Reseller extends TownCell {

	public Reseller(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew) {
		TownCell t;
		this.census(nCensus);
		if(nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3) {
			t = new Empty(tNew,this.row,this.col);
			return t;
		}
		t = new Reseller(tNew,this.row,this.col);
		return t;
	}

	

}