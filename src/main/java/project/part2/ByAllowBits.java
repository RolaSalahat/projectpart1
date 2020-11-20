package project.part2;

public class ByAllowBits implements GeneralSpec {

	private boolean allow;

	public ByAllowBits(boolean allow) {
		this.allow = allow;
	}

	public boolean isAllow() {
		return allow;
	}

	public boolean isSpecMatched(FinderApp finderApp, int i) {
		return (finderApp.homesList.get(i).isPets() && isAllow())||(!finderApp.homesList.get(i).isPets() && !isAllow());
	}

}
