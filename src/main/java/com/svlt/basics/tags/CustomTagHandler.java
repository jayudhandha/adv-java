package com.svlt.basics.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomTagHandler extends TagSupport {

	@Override
	public int doStartTag() throws JspException {

		try (JspWriter out = pageContext.getOut()) {
			
			out.println("<h3>My Customer Tag Created...</h3>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return super.doStartTag();
	}
	
	
	
}
