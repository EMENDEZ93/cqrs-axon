package member.backend.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamEntity {

	@Id
	private String id;

	private String name;

	private int membersNumer;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMembersNumer() {
		return membersNumer;
	}

	public void setMembersNumer(int membersNumer) {
		this.membersNumer = membersNumer;
	}

}
