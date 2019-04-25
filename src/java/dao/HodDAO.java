/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.MydbConnection;
import dto.AdminBean;
import dto.CompanyDetailsBean;
import dto.FilterBean;
import dto.HodBean;
import dto.InternshipDetailsBean;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author GAGAN
 */
public class HodDAO {

       public boolean isUserValid(HodBean hod)
    {
        boolean b=false;
        String userid=hod.getUserid();
        String pass=hod.getPass();
        try
        {
            Connection con=MydbConnection.getDbConnection();
            PreparedStatement pst=con.prepareStatement("select * from hod where userid=? and pass=? ");
            pst.setString(1,userid);
            pst.setString(2,pass);
            ResultSet rs=pst.executeQuery();
            
            if(rs.isBeforeFirst())
            {
                b=true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return b;
    }
     public HodBean getHodDetails()
    {
        HodBean hod=new HodBean();
        
        try
        {
            Connection con=MydbConnection.getDbConnection();
            PreparedStatement pst=con.prepareStatement("Select * from hod");
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                hod.setUserid(rs.getString("userid"));
                hod.setHod_name(rs.getString("hod_name"));
                hod.setHod_no(rs.getString("hod_no"));
                hod.setDept(rs.getString("dept"));
                hod.setHod_email(rs.getString("hod_email"));
                hod.setPass(rs.getString("pass"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return hod;
    }
     
     
    public List displayRecord(String userid)
    {
    int i=0;
    String filepath="C:\\Users\\GAGAN\\Documents\\NetBeansProjects\\Internship_Portal\\web\\img\\uploads"; 
    String dept=null;
     List<InternshipDetailsBean>internship_list=new ArrayList<InternshipDetailsBean>();
      try
      {
      Connection con=MydbConnection.getDbConnection();
      PreparedStatement pst1=con.prepareStatement("Select dept from hod where userid=?");
      pst1.setString(1, userid);
      ResultSet rs1=pst1.executeQuery();
      while(rs1.next())
      {
          dept=rs1.getString("dept");
      }
     
      PreparedStatement pst=con.prepareStatement("Select * from internship_details where vstatus=1 and dept=?");
      pst.setString(1,dept);
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {

          InternshipDetailsBean ob=new InternshipDetailsBean();
          ob.setUserid(rs.getString("userid"));
          ob.setYear(rs.getString("year"));
          ob.setSemester(rs.getString("semester"));
          ob.setDept(rs.getString("dept"));
          ob.setComp_name(rs.getString("comp_name"));
          ob.setDuration(rs.getString("duration"));
          ob.setSession(rs.getString("session"));
          ob.setComp_address(rs.getString("comp_address"));
          Blob certificate= rs.getBlob("certificate");
          ob.setImage(certificate);
          ob.setDomain(rs.getString("domain"));
          ob.setSkills(rs.getString("skills"));
          ob.setCont_name(rs.getString("cont_name"));
          ob.setCont_no(rs.getString("cont_no"));
          ob.setCont_email(rs.getString("cont_email"));
          ob.setVstatus(rs.getInt("vstatus"));
          ob.setName(rs.getString("stu_name"));
          internship_list.add(ob);
       
       
        }
      }
        
      catch(Exception e)
      {
          e.printStackTrace();
      }
     
      return internship_list;
}
    
      public int rejectInternshipDetails(String userid,String session)
    {
        int res=0;
      try
      {
      Connection con=MydbConnection.getDbConnection();
      PreparedStatement pst=con.prepareStatement("Delete from internship_details where userid=? and session=?");
      pst.setString(1,userid);
      pst.setString(2,session);
      int count=pst.executeUpdate();
      if(count>0)
      {
          res=1;
      }
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      return res;       
    }
    
    public void sendMail(String recepient,String message,String sub)
    {
        try{
            String host ="smtp.gmail.com" ;
            String user = "universalmean23@gmail.com";
            String pass = "Mean@123";
            String to = recepient;
            String from = "universalmean23@gmail.com";
            String subject = sub;
            String messageText = message;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           
    }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
     public List fetchCompanyDetails()
    {
    
     ArrayList<CompanyDetailsBean>company_list=new ArrayList<CompanyDetailsBean>();
     try
      {
          
           Connection con=MydbConnection.getDbConnection();
           PreparedStatement pst=con.prepareStatement("Select * from comp_details");
           
           ResultSet rs=pst.executeQuery();
           while(rs.next())
           {
             CompanyDetailsBean comp=new CompanyDetailsBean();    
             comp.setComp_id(rs.getInt("comp_id"));
             comp.setComp_name(rs.getString("comp_name"));
             comp.setComp_address(rs.getString("comp_address"));
             comp.setCont_no(rs.getString("cont_no"));
             comp.setDomain(rs.getString("domain"));
             comp.setDuration(rs.getString("duration"));
             comp.setEmail(rs.getString("email"));
             comp.setSkills(rs.getString("skills"));
             comp.setStart_date(rs.getString("start_date"));
             comp.setVacancy(rs.getInt("vacancy"));
             company_list.add(comp);
             
           }
           
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
     return company_list;
 }
     
       public int notificationUpdate(String userid)
    { 
       
      int res=0;
        try
        {
        Connection con = MydbConnection.getDbConnection();  
      PreparedStatement pst=con.prepareStatement("update notification set info=?,"
                                                    + "status=? where userid=? ");
      
      pst.setString(1,"Your Details were Rejected, Please submit again.");
      pst.setInt(2,1);
      pst.setString(3,userid);
      
      int count=pst.executeUpdate();
      
      if(count>0)
      {
          res=1;
          
      }
        
      }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        return res;
    }
    
     public List filterRecords(List intern_list,FilterBean filter)
     {
         intern_list.removeAll(intern_list);
         String year=filter.getYear();
         String domain=filter.getDomain();
         String comp_name=filter.getComp_name();
       System.out.println("domain:"+domain);
       System.out.println("year:"+year);
       System.out.println("comp:"+comp_name);
         try
      {
      Connection con=MydbConnection.getDbConnection();
      if(domain.equals("null") && comp_name.equals("null"))
      {
          System.out.println("1");
      PreparedStatement pst=con.prepareStatement("Select * from internship_details where vstatus=1 and year=?");
      pst.setString(1,year);
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {

          InternshipDetailsBean ob=new InternshipDetailsBean();
          ob.setUserid(rs.getString("userid"));
          ob.setYear(rs.getString("year"));
          ob.setSemester(rs.getString("semester"));
          ob.setComp_name(rs.getString("comp_name"));
          ob.setDuration(rs.getString("duration"));
          ob.setSession(rs.getString("session"));
          ob.setComp_address(rs.getString("comp_address"));
          Blob certificate= rs.getBlob("certificate");
          ob.setImage(certificate);
          ob.setDomain(rs.getString("domain"));
          ob.setSkills(rs.getString("skills"));
          ob.setCont_name(rs.getString("cont_name"));
          ob.setCont_no(rs.getString("cont_no"));
          ob.setCont_email(rs.getString("cont_email"));
          ob.setVstatus(rs.getInt("vstatus"));
          ob.setName(rs.getString("stu_name"));
          intern_list.add(ob);
        }
      }
     
   else if(year.equals("null") && comp_name.equals("null"))
      {
          System.out.println("2");
      PreparedStatement pst=con.prepareStatement("Select * from internship_details where vstatus=1 and domain=?");
      pst.setString(1,domain);
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {

          InternshipDetailsBean ob=new InternshipDetailsBean();
          ob.setUserid(rs.getString("userid"));
          ob.setYear(rs.getString("year"));
          ob.setSemester(rs.getString("semester"));
          ob.setComp_name(rs.getString("comp_name"));
          ob.setDuration(rs.getString("duration"));
          ob.setSession(rs.getString("session"));
          ob.setComp_address(rs.getString("comp_address"));
          Blob certificate= rs.getBlob("certificate");
          ob.setImage(certificate);
          ob.setDomain(rs.getString("domain"));
          ob.setSkills(rs.getString("skills"));
          ob.setCont_name(rs.getString("cont_name"));
          ob.setCont_no(rs.getString("cont_no"));
          ob.setCont_email(rs.getString("cont_email"));
          ob.setVstatus(rs.getInt("vstatus"));
          ob.setName(rs.getString("stu_name"));
          intern_list.add(ob);
        }
      }
   else if(domain.equals("null") && year.equals("null"))
      {
          System.out.println("3");
      PreparedStatement pst=con.prepareStatement("Select * from internship_details where vstatus=1 and comp_name=?");
      pst.setString(1,comp_name);
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {

          InternshipDetailsBean ob=new InternshipDetailsBean();
          ob.setUserid(rs.getString("userid"));
          ob.setYear(rs.getString("year"));
          ob.setSemester(rs.getString("semester"));
          ob.setComp_name(rs.getString("comp_name"));
          ob.setDuration(rs.getString("duration"));
          ob.setSession(rs.getString("session"));
          ob.setComp_address(rs.getString("comp_address"));
          Blob certificate= rs.getBlob("certificate");
          ob.setImage(certificate);
          ob.setDomain(rs.getString("domain"));
          ob.setSkills(rs.getString("skills"));
          ob.setCont_name(rs.getString("cont_name"));
          ob.setCont_no(rs.getString("cont_no"));
          ob.setCont_email(rs.getString("cont_email"));
          ob.setVstatus(rs.getInt("vstatus"));
          ob.setName(rs.getString("stu_name"));
          intern_list.add(ob);
        }
      }
    else if(domain.equals("null"))
      {
      PreparedStatement pst=con.prepareStatement("Select * from internship_details where vstatus=1 and year=? and comp_name=?");
      pst.setString(1,year);
      pst.setString(2,comp_name);
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {

          InternshipDetailsBean ob=new InternshipDetailsBean();
          ob.setUserid(rs.getString("userid"));
          ob.setYear(rs.getString("year"));
          ob.setSemester(rs.getString("semester"));
          ob.setComp_name(rs.getString("comp_name"));
          ob.setDuration(rs.getString("duration"));
          ob.setSession(rs.getString("session"));
          ob.setComp_address(rs.getString("comp_address"));
          Blob certificate= rs.getBlob("certificate");
          ob.setImage(certificate);
          ob.setDomain(rs.getString("domain"));
          ob.setSkills(rs.getString("skills"));
          ob.setCont_name(rs.getString("cont_name"));
          ob.setCont_no(rs.getString("cont_no"));
          ob.setCont_email(rs.getString("cont_email"));
          ob.setVstatus(rs.getInt("vstatus"));
          ob.setName(rs.getString("stu_name"));
          intern_list.add(ob);
        }
      }
    else if(comp_name.equals("null"))
      {
      PreparedStatement pst=con.prepareStatement("Select * from internship_details where vstatus=1 and year=? and domain=?");
      pst.setString(1,year);
      pst.setString(2,domain);
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {

          InternshipDetailsBean ob=new InternshipDetailsBean();
          ob.setUserid(rs.getString("userid"));
          ob.setYear(rs.getString("year"));
          ob.setSemester(rs.getString("semester"));
          ob.setComp_name(rs.getString("comp_name"));
          ob.setDuration(rs.getString("duration"));
          ob.setSession(rs.getString("session"));
          ob.setComp_address(rs.getString("comp_address"));
          Blob certificate= rs.getBlob("certificate");
          ob.setImage(certificate);
          ob.setDomain(rs.getString("domain"));
          ob.setSkills(rs.getString("skills"));
          ob.setCont_name(rs.getString("cont_name"));
          ob.setCont_no(rs.getString("cont_no"));
          ob.setCont_email(rs.getString("cont_email"));
          ob.setVstatus(rs.getInt("vstatus"));
          ob.setName(rs.getString("stu_name"));
          intern_list.add(ob);
        }
      }
    else if(year.equals("null"))
      {
      PreparedStatement pst=con.prepareStatement("Select * from internship_details where vstatus=1 and comp_name=? and domain=?");
      pst.setString(1,comp_name);
      pst.setString(2,domain);
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {

          InternshipDetailsBean ob=new InternshipDetailsBean();
          ob.setUserid(rs.getString("userid"));
          ob.setYear(rs.getString("year"));
          ob.setSemester(rs.getString("semester"));
          ob.setComp_name(rs.getString("comp_name"));
          ob.setDuration(rs.getString("duration"));
          ob.setSession(rs.getString("session"));
          ob.setComp_address(rs.getString("comp_address"));
          Blob certificate= rs.getBlob("certificate");
          ob.setImage(certificate);
          ob.setDomain(rs.getString("domain"));
          ob.setSkills(rs.getString("skills"));
          ob.setCont_name(rs.getString("cont_name"));
          ob.setCont_no(rs.getString("cont_no"));
          ob.setCont_email(rs.getString("cont_email"));
          ob.setVstatus(rs.getInt("vstatus"));
          ob.setName(rs.getString("stu_name"));
          intern_list.add(ob);
        }
      }
     else
    { 
        System.out.println("This");  
      PreparedStatement pst=con.prepareStatement("Select * from internship_details where vstatus=1 and year=? and comp_name=? and domain=?");
      pst.setString(1,year);
      pst.setString(2,comp_name);
      pst.setString(3,domain);
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {

          InternshipDetailsBean ob=new InternshipDetailsBean();
          ob.setUserid(rs.getString("userid"));
          ob.setYear(rs.getString("year"));
          ob.setSemester(rs.getString("semester"));
          ob.setComp_name(rs.getString("comp_name"));
          ob.setDuration(rs.getString("duration"));
          ob.setSession(rs.getString("session"));
          ob.setComp_address(rs.getString("comp_address"));
          Blob certificate= rs.getBlob("certificate");
          ob.setImage(certificate);
          ob.setDomain(rs.getString("domain"));
          ob.setSkills(rs.getString("skills"));
          ob.setCont_name(rs.getString("cont_name"));
          ob.setCont_no(rs.getString("cont_no"));
          ob.setCont_email(rs.getString("cont_email"));
          ob.setVstatus(rs.getInt("vstatus"));
          ob.setName(rs.getString("stu_name"));
          intern_list.add(ob);
        }
    }
      }     
      catch(Exception e)
      {
          e.printStackTrace();
      }
         return intern_list;
     }
}
     
     
     
     

