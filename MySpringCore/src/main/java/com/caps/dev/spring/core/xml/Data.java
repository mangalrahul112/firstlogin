package com.caps.dev.spring.core.xml;

import java.util.ArrayList;

public class Data {

	private String sub;
	private ArrayList<String> info;
	private ArrayList<Job> jobs;
	public Data(){}
	public Data(String sub, ArrayList<String> info, ArrayList<Job> jobs) {
		super();
		this.sub = sub;
		this.info = info;
		this.jobs = jobs;
	}
	public ArrayList<Job> getJobs() {
		return jobs;
	}
	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}
	
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public ArrayList<String> getInfo() {
		return info;
	}
	public void setInfo(ArrayList<String> info) {
		this.info = info;
	}
}
