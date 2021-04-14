package org.sg.campus.web.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ApplicationBean {
	private Integer num;

	public Integer getNextInt() {
		if (num == null) {
			return null;
		}
		return num = new Integer(num.intValue() + 1);
	}
}
