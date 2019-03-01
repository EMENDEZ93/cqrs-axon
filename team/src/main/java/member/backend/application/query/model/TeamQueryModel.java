package member.backend.application.query.model;

public class TeamQueryModel {

	private String team;
	private int members;

	public TeamQueryModel(String team, int members) {
		this.team = team;
		this.members = members;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

}
