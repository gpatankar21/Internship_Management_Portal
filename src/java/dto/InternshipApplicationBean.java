/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


import java.sql.Blob;
import javax.servlet.http.Part;

/**
 *
 * @author GAGAN
 */
public class InternshipApplicationBean implements java.io.Serializable{
    
    private String userid;
    private String name;
    private String comp_name;
    private String email;
    private String year;
    private String dept;
    private String sec;
    private String res;
    private Part resume;
    private Blob resume_img;
    
    public InternshipApplicationBean() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getRes() {
        return res;
    }

    public Blob getResume_img() {
        return resume_img;
    }

    public void setResume_img(Blob resume_img) {
        this.resume_img = resume_img;
    }



    public void setRes(String res) {
        this.res = res;
    }

    public Part getResume() {
        return resume;
    }

    public void setResume(Part resume) {
        this.resume = resume;
    }
  
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }
    
    
    
}
