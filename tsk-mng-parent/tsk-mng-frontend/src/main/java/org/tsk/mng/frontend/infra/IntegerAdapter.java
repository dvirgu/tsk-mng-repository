package org.tsk.mng.frontend.infra;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IntegerAdapter extends XmlAdapter<String, Integer> {

	@Override
	public Integer unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return Integer.parseInt(v);
	}

	@Override
	public String marshal(Integer v) throws Exception {
		// TODO Auto-generated method stub
		return v.toString();
	}
	
}
