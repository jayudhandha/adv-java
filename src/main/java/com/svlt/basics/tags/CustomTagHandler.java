package com.svlt.basics.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class CustomTagHandler extends TagSupport {

	private int number;
	
	public void setNumber(int number) {
		this.number = number;
	}


	@Override
	public int doStartTag() throws JspException {

		try (JspWriter out = pageContext.getOut()) {
			
//			out.println("<h3>My Customer Tag Created... Number : "+number+"</h3>");
			
			/*
			 	   	*
			 	    **
			 	  * * *
			 	 * * * *
			 */
			
			// if num = 4
			// 10 -> 0 to 9
			for(int i=0 ; i < number ; i++) {
				for(int j=0; j < number - i - 1; j++) {
					out.print("&nbsp");
				}
				for (int k=0; k<=i; k++) {
					out.print("*");
				}
				out.println("<br>");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return super.doStartTag();
	}
	
	
	
}
