package com.websystique.springmvc.model;

public class Advertiser {

	private long id;
	
	private String name;
	
	private String email;
	
	public Advertiser(){
		id=0;
	}
	
	public Advertiser(long id, String name, String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Advertiser))
			return false;
		Advertiser other = (Advertiser) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Advertiser [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	

	
}
