package member.backend.application.command;

public class MemberEvent {

	private final String id;
	private final String name;
	private final String idTeam;

	public MemberEvent(String id, String name, String idTeam) {
		super();
		this.id = id;
		this.name = name;
		this.idTeam = idTeam;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIdTeam() {
		return idTeam;
	}

}
