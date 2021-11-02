package edu.ntut.project_01.homegym.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="video")
public class Video implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer videoId;
    private String course;
    private String videoName;	//課程名
    @Lob
    private char[] videoInfo;	//課程資訊
    private String category; //課程類別
    private String partOfBody; //不確定會用數字還是字串來設定  //運動部位
    private String videoImage;	//影片圖片
    private String mimeType;   // /dmot/src/main/java/_03_listBooks/service/impl/BookServiceImpl.java
    private Date uploadTime;	//上傳時間
    private Integer price; //Integer or Double 	//課程價格
    private String equipment; //器材
    private String level; //適合的層級
    private Integer pass; //課程是否審核成功
    private	Integer checked; //審核狀態（未審核/已審核）
    private Date checktime;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "video")
    private Set<Member> member = new HashSet<Member>();

    @ManyToOne(cascade =CascadeType.PERSIST)
    @JoinColumn
    Coach coach;

    public Video(Integer videoId, String course, String videoName, char[] videoInfo, String category, String partOfBody, String videoImage, String mimeType, Date uploadTime, Integer price, String equipment, String level, Integer pass, Integer checked, Date checktime, Set<Member> member, Coach coach) {
        this.videoId = videoId;
        this.course = course;
        this.videoName = videoName;
        this.videoInfo = videoInfo;
        this.category = category;
        this.partOfBody = partOfBody;
        this.videoImage = videoImage;
        this.mimeType = mimeType;
        this.uploadTime = uploadTime;
        this.price = price;
        this.equipment = equipment;
        this.level = level;
        this.pass = pass;
        this.checked = checked;
        this.checktime = checktime;
        this.member = member;
        this.coach = coach;
    }

    public Video() {

    }



    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getCourse() {
        return course;
    }

    public void setVideo(String course) {
        this.course = course;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public char[] getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(char[] videoInfo) {
        this.videoInfo = videoInfo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPartOfBody() {
        return partOfBody;
    }

    public void setPartOfBody(String partOfBody) {
        this.partOfBody = partOfBody;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }



    public Set<Member> getMember() {
        return member;
    }



    public void setMember(Set<Member> member) {
        this.member = member;
    }



    public Coach getCoach() {
        return coach;
    }



    public void setCoach(Coach coach) {
        this.coach = coach;
    }






}
