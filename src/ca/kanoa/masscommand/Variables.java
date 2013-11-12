package ca.kanoa.masscommand;

public class Variables {
	
	String[] vars;
	
	public Variables(String line) {
		vars = line.trim().split("\\s+");
	}
	
	public String getVar(int index) {
		if (index == 0 || index > vars.length) {
			return "0";
		} else {
			return vars[index - 1];
		}
	}
	
	public int getNumberOfVars() {
		return vars.length;
	}
	
}
