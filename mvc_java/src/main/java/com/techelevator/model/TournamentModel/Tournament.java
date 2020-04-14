package com.techelevator.model.TournamentModel;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Tournament {

	private String id ="";
	private String name="";
	private String organizerId="";
	private String organizerName="";
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String location="";
	private String game="";
	private String type="";
	private String description="";
	private String taggedDesc="";
	private String format="";
	private String rules="";
	
	//get and set
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Tournament [id=" + id + ", name=" + name + ", organizerId=" + organizerId + ", organizerName="
				+ organizerName + ", date=" + date + ", location=" + location + ", game=" + game + ", type=" + type
				+ ", description=" + description + ", taggedDesc=" + taggedDesc + ", format=" + format + ", rules="
				+ rules + ", prizes=" + prizes + ", getId()=" + getId() + ", hashCode()=" + hashCode() + ", getName()="
				+ getName() + ", getOrganizerId()=" + getOrganizerId() + ", getOrganizerName()=" + getOrganizerName()
				+ ", getDate()=" + getDate() + ", getLocation()=" + getLocation() + ", getGame()=" + getGame()
				+ ", getType()=" + getType() + ", getDescription()=" + getDescription() + ", getTaggedDesc()="
				+ getTaggedDesc() + ", getFormat()=" + getFormat() + ", getRules()=" + getRules() + ", getPrizes()="
				+ getPrizes() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	
//	@Override 
//	public String toString() {
//		return this.getName() + ", "+ this.getId() + ", " + this.getGame() + ", " + this.getDescription();
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organizerId == null) ? 0 : organizerId.hashCode());
		result = prime * result + ((organizerName == null) ? 0 : organizerName.hashCode());
		result = prime * result + ((prizes == null) ? 0 : prizes.hashCode());
		result = prime * result + ((rules == null) ? 0 : rules.hashCode());
		result = prime * result + ((taggedDesc == null) ? 0 : taggedDesc.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tournament other = (Tournament) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organizerId == null) {
			if (other.organizerId != null)
				return false;
		} else if (!organizerId.equals(other.organizerId))
			return false;
		if (organizerName == null) {
			if (other.organizerName != null)
				return false;
		} else if (!organizerName.equals(other.organizerName))
			return false;
		if (prizes == null) {
			if (other.prizes != null)
				return false;
		} else if (!prizes.equals(other.prizes))
			return false;
		if (rules == null) {
			if (other.rules != null)
				return false;
		} else if (!rules.equals(other.rules))
			return false;
		if (taggedDesc == null) {
			if (other.taggedDesc != null)
				return false;
		} else if (!taggedDesc.equals(other.taggedDesc))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
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
	public String getOrganizerId() {
		return organizerId;
	}
	public void setOrganizerId(String organizerId) {
		this.organizerId = organizerId;
	}
	public String getOrganizerName() {
		return organizerName;
	}
	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaggedDesc() {
		return taggedDesc;
	}
	public void setTaggedDesc(String taggedDesc) {
		this.taggedDesc = taggedDesc;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public String getPrizes() {
		return prizes;
	}
	public void setPrizes(String prizes) {
		this.prizes = prizes;
	}
	private String prizes;
	
	
}
