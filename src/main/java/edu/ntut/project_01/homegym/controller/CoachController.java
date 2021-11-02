package edu.ntut.project_01.homegym.controller;

import com.sun.mail.iap.Response;
import edu.ntut.project_01.homegym.model.Coach;
import edu.ntut.project_01.homegym.service.CoachService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Base64;


@Controller
public class CoachController {


    private CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/memberAreasApplicationCoach")
    public String showEmptyForm() {

        return "/memberAreasApplicationCoach" ; // 要導入的html
    }

    @GetMapping("/waitForApplyingForCoach")
    @ResponseBody
    public String showWaitForApplyingForCoach() {

        return "/waitForApplyingForCoach" ; // 要導入的html
    }

    @GetMapping("/coachingAreasIntroduction")
    public String showCoachIntroduction() {

        return "/coachingAreasIntroduction" ; // 要導入的html
    }

    @PostMapping("/memberApplyingForCoach")
    public String applyForCoach(@RequestBody Coach coach){
        //存到coachImages
        File imageFolder = new File("src/main/resources/static/coachImages");
        System.out.println(imageFolder);
        if(!imageFolder.exists()){
            imageFolder.mkdirs();
        }
        String coachImagePath = imageSaveToFile(coach.getCoachImage(),imageFolder);

        //存到certification
        File certificationFolder = new File("src/main/resources/static/certification");
        System.out.println(certificationFolder);
        if(!certificationFolder.exists()){
            certificationFolder.mkdirs();
        }

        String certificationPath = imageSaveToFile(coach.getCertification(),certificationFolder);

        coach.setChecked("0");
        coach.setSuspension(0);
        coach.setApplyTime(new Timestamp(System.currentTimeMillis()));
        coach.setCertification(certificationPath);
        coach.setCoachImage(coachImagePath);
        coachService.apply(coach);

        return "/waitForApplyingForCoach";
    }






    //寫進資料夾的方法
    public String imageSaveToFile(String data, File folder) {

        //取名用
        int startIndex = data.indexOf(",")+50;
        int endIndex = startIndex + 6;

        //base64轉byte陣列
        String dataToBase64 = data.substring(data.indexOf(",") + 1);
        byte[] bytes = Base64.getDecoder().decode(dataToBase64);

        String name = data.substring(startIndex, endIndex);
        File file = new File(folder,name+".jpg");

        try {
            OutputStream out = new FileOutputStream(file);
            out.write(bytes);
            System.out.println("讀取完畢");
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println("失敗");
        }
        return file.toString();
    }


}
