package edu.ntut.project_01.homegym;

import edu.ntut.project_01.homegym.model.Coach;
import edu.ntut.project_01.homegym.model.Member;
import edu.ntut.project_01.homegym.model.Video;
import edu.ntut.project_01.homegym.repository.VideoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeGymApplicationTests {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Test
    void contextLoads() {
    }

    @Test
    void insertTest() {
        List<Member> mbList = new ArrayList<>();
        Member mb;

        List<Coach> cbList = new ArrayList<>();
        Coach cb;

        List<Video> vbList = new ArrayList<>();
        Video vb;

        String row;
        String[] col;
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        try {

            try (BufferedReader br = new BufferedReader(new FileReader("member.csv"))) {
                int times = 0;
                while ((row = br.readLine()) != null) {
                    if (times != 0) {
                        mb = new Member();
                        col = row.split(",");
                        mb.setPassword(col[1]);
                        mb.setName(col[2]);
                        mb.setEmail(col[3]);
                        mb.setPhone(col[4]);
                        mb.setBirthday(new Date(format.parse(col[6]).getTime()));
                        mb.setRole(col[7]);
                        mb.setCreateTime(new java.sql.Timestamp(System.currentTimeMillis()));

                        mbList.add(mb);
                    }
                    times++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new FileReader("coach.csv"))) {
                int times = 0;
                while ((row = br.readLine()) != null) {
                    if (times != 0) {
                        cb = new Coach();
                        col = row.split(",");
//                        int memberId = Integer.parseInt(col[0]);
//                        Member memberBean = session.get(Member.class, memberId);
//                        cb.setMember(memberBean);
                        cb.setChecked(col[1]);
                        cb.setPass(col[2]);
                        cb.setExperience(col[3]);
                        cb.setSkill(col[5]);
                        cb.setCoachInfo(col[7]);
                        cb.setAccount(col[9]);
                        cb.setApplyTime(new java.sql.Timestamp(System.currentTimeMillis()));
                        cbList.add(cb);
                    }
                    times++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new FileReader("/Users/chin/Desktop/video.csv"))) {
                int times = 0;
                while ((row = br.readLine()) != null) {
                    if (times != 0) {
                        vb = new Video();
                        col = row.split(",");
                        vb.setVideoName(col[1]);
                        vb.setVideoInfo((col[2]).toCharArray());
                        vb.setCategory(col[3]);
                        vb.setPartOfBody(col[4]);
                        try {
                            vb.setUploadTime(format.parse(col[6]));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        vb.setPrice(Integer.parseInt(col[7]));
                        vb.setEquipment(col[8]);
                        vb.setLevel(col[9]);
                        vb.setPass(Integer.parseInt(col[10]));
                        vb.setChecked(Integer.parseInt(col[11]));
                        vbList.add(vb);
                    }
                    times++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }catch (Exception e) {
            System.err.println("新建表格時發生例外: " + e.getMessage());
            e.printStackTrace();
        }
        videoRepository.saveAll(vbList);
        System.out.println("程式結束(Done...!!)");
}

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("homegym_ntut_pj01@outlook.com");
        message.setTo("zhps7239@yahoo.com.tw");
        message.setSubject("主旨：JavaMail測試！！！！");
        message.setText("內容：這是一封測試信件，恭喜您成功發送了唷");

        mailSender.send(message);
    }


    @Test
    public void UTest() {
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid);
        }




}
