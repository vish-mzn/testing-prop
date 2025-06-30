package org.sde.springexpressionproject;

public class InjectedService {
	
	private EnrichObject enrich;
	private ObRequest input;
	
	public EnrichObject getEnrich() {
		return enrich;
	}
	public void setEnrich(EnrichObject enrich) {
		this.enrich = enrich;
	}
	public ObRequest getInput() {
		return input;
	}
	public void setInput(ObRequest input) {
		this.input = input;
	}
	
}
