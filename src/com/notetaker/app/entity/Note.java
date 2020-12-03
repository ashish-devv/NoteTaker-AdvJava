package com.notetaker.app.entity;

import java.io.Serializable;

public class Note implements Serializable {

	private static final long serialVersionUID = 1L;

	private int nid ;
	private String uname ;
	private String note_heading ;
	private String note_content ;
	
	
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getNote_heading() {
		return note_heading;
	}
	public void setNote_heading(String note_heading) {
		this.note_heading = note_heading;
	}
	public String getNote_content() {
		return note_content;
	}
	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}
	
	@Override
	public String toString() {
		return "Note [nid=" + nid + ", uid=" + uname + ", note_heading=" + note_heading + ", note_content=" + note_content;
	}
	public Note(int nid, String uname, String note_heading, String note_content) {
		super();
		this.nid = nid;
		this.uname = uname;
		this.note_heading = note_heading;
		this.note_content = note_content;
		
	}
	
	public Note() {
		super();
	}
	
	
	
	
	
	
	
}
