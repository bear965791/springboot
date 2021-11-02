package edu.ntut.project_01.homegym.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="coach")
public class Coach implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coachId;
    private String experience;
    private String certification;
    private String skill;
    private String coachImage;
    private String coachInfo;
    private String account;
    private String pass;
    private	String checked;
    private Timestamp checkTime;
    private Timestamp applyTime;
    private Integer suspension;


    @OneToOne(mappedBy = "coach")
    Member member;

    @OneToMany(mappedBy = "coach", cascade = { CascadeType.PERSIST })
    private Set<Video> course = new HashSet<Video>();

    public Coach(Integer coachId, String experience, String certification, String skill, String coachImage, String coachInfo,
                     String account, String pass, String checked, Timestamp checkTime, Timestamp applyTime, Integer suspension,
                     Member member) {
        super();
        this.coachId = coachId;
        this.experience = experience;
        this.certification = certification;
        this.skill = skill;
        this.coachImage = coachImage;
        this.coachInfo = coachInfo;
        this.account = account;
        this.pass = pass;
        this.checked = checked;
        this.checkTime = checkTime;
        this.applyTime = applyTime;
        this.suspension = suspension;
        this.member = member;
    }


    public Coach() {

    }


    public Integer getCoachId() {
        return coachId;
    }

    public void seId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCoachImage() {
        return coachImage;
    }

    public void setCoachImage(String coachImage) {
        this.coachImage = coachImage;
    }

    public String getCoachInfo() {
        return coachInfo;
    }

    public void setCoachInfo(String coachInfo) {
        this.coachInfo = coachInfo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getSuspension() {
        return suspension;
    }

    public void setSuspension(Integer suspension) {
        this.suspension = suspension;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public Set<Video> getCourse() {
        return course;
    }


    public void setCourse(Set<Video> course) {
        this.course = course;
    }


    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }





}
