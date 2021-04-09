package org.sg.campus.web.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ApplicationBean {
	private int num;

	public int getNextInt() {
		return num++;
	}
}
