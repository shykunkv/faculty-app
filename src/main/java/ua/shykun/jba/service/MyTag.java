package ua.shykun.jba.service;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import ua.shykun.jba.entity.Pair;

import java.io.*;
import java.util.List;

public class MyTag extends SimpleTagSupport {
   //StringWriter object
   StringWriter sw = new StringWriter();

   private ScheduleService data;
   private List<Pair> pairs;
   
   
   
   public List<Pair> getPairs() {
	return pairs;
}


public void setPairs(List<Pair> pairs) {
	this.pairs = pairs;
}


public ScheduleService getData() {
	return data;
}


   public void setData(ScheduleService data) {
	   this.data = data;
   }


public void doTag() throws JspException, IOException
   {
		
		
		for (int i = 0; i < pairs.size(); i++) {
			Pair currP = pairs.get(i);
			if (currP.getHours() > 1) {
				int k = currP.getHours();
				currP.setHours(1);
				while (k > 1) {
					pairs.add(currP);
					k--;
				}
			}
		}
	
		Pair[] pairsArray = new Pair[pairs.size()];
		for (int i = 0; i < pairs.size(); i++) {
			pairsArray[i] = pairs.get(i);
		}
	
	
	   JspWriter out = getJspContext().getOut(); 
	   data.setAmOfDays(5);
	   data.setAmOfLesPerDay(3);
	   data.setPairs(pairsArray);
	   data.createBestSchedule();
	   Pair[][]	sched = data.getSchedule();
       if (pairs.size() == 0 || data == null || sched == null) {
    	   out.println("ERROR");
       } else {
    	   
    	   int currGroup = 0;
    	   while (currGroup < sched.length) {
    		   out.println("<h3>Group" + currGroup + "</h3>");
    		   out.println("<table class = \"table table-bordered table-hover\">");
    		   out.println("<thead>");
    		   		out.println("<tr>");
    		   			out.println("<th style = \"width:10%\">Pair</th>");
    		   			out.println("<th style = \"width:16%\">Monday</th>");
    		   			out.println("<th style = \"width:16%\">Tuesday</th>");
    		   			out.println("<th style = \"width:16%\">Wednesday</th>");
    		   			out.println("<th style = \"width:16%\">Thursday</th>");
    		   			out.println("<th style = \"width:16%\">Friday</th>");
    		   		out.println("<tr>");
    		   out.println("</thead>");
    		   out.println("<tbody>");
    		   		for (int i = 0; i < 3; i++) {
    		   			out.println("<tr>");
	   						out.println("<td>"+i+"</td>");
    		   				for (int j = 0; j < 5; j++) {
    		   					if (sched[currGroup][i + j*3] == null) {
    		   						out.println("<td>---</td>");
    		   					} else {
    		   							out.println("<td>"
    		   								+sched[currGroup][i + j*3].getGroupName()+"_"
    		   								+sched[currGroup][i + j*3].getLessonName()+"_"
    		   								+sched[currGroup][i + j*3].getTeacherName()+
    		   							"</td>");
    		   					}
    		   				}
    		   				
    		   			out.println("</tr>");
    		   			
    		   		}
    		   out.println("</tbody>");
    		   out.println("</table>");
    		   currGroup++;
    	   }
       }
   }
}