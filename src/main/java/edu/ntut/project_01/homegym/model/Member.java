package edu.ntut.project_01.homegym.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="member")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer memberId;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Date birthday;
    private Integer status;
    private String code;
    private String role;
    private Timestamp createTime;
    @Lob
    private byte[]  memberImage;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "member_courses", catalog = "homegym",
            joinColumns = {
                    @JoinColumn(name = "MEMBER_ID", nullable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "COURSE_ID", nullable = false)
    })
    private Set<Video> video = new HashSet<Video>();

    @OneToOne(cascade =CascadeType.PERSIST)
    @JoinColumn
    Coach coach;



    public Member(Integer memberId, String password, String name, String email, String phone, Date birthday,
                      Integer status, String code, String role, Timestamp createTime, byte[] memberImage, Set<Video> video,
                      Coach coach) {
        super();
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.status = status;
        this.code = code;
        this.role = role;
        this.createTime = createTime;
        this.memberImage = memberImage;
        this.video = video;
        this.coach = coach;
    }



    public Member() {

    }



    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public byte[] getMemberImage() {
        return memberImage;
    }

    public void setMemberImage(byte[] memberImage) {
        this.memberImage = memberImage;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }



    public Set<Video> getVideo() {
        return video;
    }



    public void setVideo(Set<Video> video) {
        this.video = video;
    }





}
