package projectPart1;

public class ByAllowBits {

	private boolean allow;

	public ByAllowBits(boolean allow) {
		this.allow = allow;
		// TODO Auto-generated constructor stub
	}

	public boolean isAllow() {
		return allow;
	}

	boolean isSpecMatched(finderApp finderApp, int i) {
		return (finderApp.homesList.get(i).isPets() && isAllow())||(!finderApp.homesList.get(i).isPets() && !isAllow());
	}

}
