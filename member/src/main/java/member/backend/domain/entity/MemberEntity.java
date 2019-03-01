package member.backend.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MemberEntity {

	@Id
	private String id;

	private String name;

	private String idTeam;

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

	public String getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(String idTeam) {
		this.idTeam = idTeam;
	}

}
