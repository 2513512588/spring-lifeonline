package com.lifeonline.servicelive;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifeonline.servicelive.mapper.ClassifyMapper;
import com.lifeonline.servicelive.model.*;
import com.lifeonline.servicelive.service.ClassifyService;
import com.lifeonline.servicelive.service.DiaryService;
import com.lifeonline.servicelive.service.PhotoService;
import com.lifeonline.servicelive.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;


import java.net.URISyntaxException;



@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringApplicationTest {


    private final HttpClient client = HttpClients.createDefault();

    HttpGet httpGet = null;

    {
        URIBuilder builder = null;
        try {
            builder = new URIBuilder("https://tieba.baidu.com/f/index/feedlist");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        assert builder != null;
        builder.setParameter("is_new","1");
        builder.setParameter("tag_id","like");
        builder.setParameter("limit","20");
        builder.setParameter("offset","1");
        builder.setParameter("last_tid","0");
        builder.setParameter("_", String.valueOf(System.currentTimeMillis()));
        try {
            httpGet = new HttpGet(builder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        assert httpGet != null;
        httpGet.addHeader("cookie","BAIDUID=F8503278023E3ED102662636B4B88FDF:FG=1; BIDUPSID=F8503278023E3ED102662636B4B88FDF; PSTM=1598951901; TIEBAUID=628f5f1091499dda44750ec8; TIEBA_USERTYPE=8cff9d75a3bbabf11413510c; bdshare_firstime=1600232351134; BDUSS=DNKTmYyRWxKZC1LdFZTQWcxOUNrUy1LMnJEdTZnSmNqWVRKZm55OTRFUkZFTDVmRVFBQUFBJCQAAAAAAAAAAAEAAACiaBXOV2FraW5n2Lxob3VycwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEWDll9Fg5Zfe; BDUSS_BFESS=DNKTmYyRWxKZC1LdFZTQWcxOUNrUy1LMnJEdTZnSmNqWVRKZm55OTRFUkZFTDVmRVFBQUFBJCQAAAAAAAAAAAEAAACiaBXOV2FraW5n2Lxob3VycwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEWDll9Fg5Zfe; STOKEN=74274edb95a4271b106c8cb3b304928bd945aeea656d437c3ae20c5df8ad0894; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; yjs_js_security_passport=b0c5d1d97836db3c25409b27ced00bd97c9ede21_1605682589_js; H_PS_PSSID=32815_1431_33044_33124_33058_31254_33099_33100_32962; delPer=0; PSINO=3; BA_HECTOR=8k0l2081ag8584a18g1fracd20q; BAIDUID_BFESS=F8503278023E3ED102662636B4B88FDF:FG=1; st_key_id=17; Hm_lvt_98b9d8c2fd6608d564bf2ac2ae642948=1603941017,1605056259,1605710245,1605710261; Hm_lpvt_98b9d8c2fd6608d564bf2ac2ae642948=1605710261; st_data=55d22251ac881f449ddf1fe7c5cb3a9f06c09b3ff8a1d50d60bbe987013c9ce4d1b81a8e4e90ad3b6887305b488246d3c0e9a2323bf60355bfb141603e09f7250f9ee9f2d4f18e6f590b9e5e1ed75e5a9d054935586fc51b808059178c370cd258d659fdb3abfb0181b486ecdd6b3d553262373e2fccb63f1f29df37646275cd1f24bea4d62f9b8578f8bcd8d886bdde; st_sign=e6e72721");
        httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        httpGet.addHeader("Host","tieba.baidu.com");
        httpGet.addHeader("Referer","https://tieba.baidu.com/");
    }

    @Autowired
    private UserService userService;
    @Autowired
    private DiaryService diaryService;
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private PhotoService photoService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /*
    * todo 数据库pwd长度改成60
    * todo all_classify_related->related_type 添加unsigned
    * todo oss_photo-> url 长度改成100
    * */
    @Test
    public void loadData() throws Exception {
        HttpResponse response = client.execute(httpGet);
        client.execute(httpGet);
        JsonNode json = new ObjectMapper().readTree(EntityUtils.toString(response.getEntity()));
        Document document = Jsoup.parse(StringEscapeUtils.unescapeJava(String.valueOf(json.get("data").get("html"))));
        Elements diarys = document.select(".j_feed_li:not(.home-place-item)");
        for (Element diaryEl :diarys){
            String diaryId = diaryEl.select("div.thread-name-wraper>a").attr("href").replace("/p/","");
            String classifyName = diaryEl.select(".n_name").text();
            String diaryTitle = diaryEl.select(".title").text();
            String diaryContent = diaryEl.select(".n_txt").text();
            String username = diaryEl.select(".post_author").text();
            QueryWrapper<User> wrapper =  new QueryWrapper<User>();
            wrapper.eq("username",username);
            User user = userService.getOne(wrapper);
            if (user == null){
                user = new User();
                user.setUsername(username);
                user.setNickname(username);
                user.setPassword(passwordEncoder.encode("123"));
                userService.save(user);
            }
            log.debug("user = {}" , user.getId());
            log.debug("帖子id = {}",diaryId);
            log.debug("贴吧 = {}",classifyName);
            log.debug("标题 = {}",diaryTitle);
            log.debug("内容 = {}",diaryContent);

            Diary diary = new Diary();
            diary.setTitle(diaryTitle);
            diary.setDetail(diaryContent);
            diary.setUserId(user.getId());
//            diary.setCreateTime(new SimpleDateFormat().parse(diaryEl.select(".time").text()));
            diaryService.save(diary);

            QueryWrapper<Classify> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("subject",classifyName);
            Classify classify = classifyService.getOne(wrapper1);
            if (classify == null){
                classify = new Classify();
                classify.setSubject(classifyName);
                classifyService.save(classify);
            }

            ClassifyRelated classifyRelated = new ClassifyRelated();
            classifyRelated.setClassifyId(classify.getId());
            classifyRelated.setRelatedId(diary.getId());
            classifyService.insertDiaryClassify(classifyRelated);

            Elements pics = diaryEl.select(".n_img>li>img");

            for (Element image : pics){
                String imageCode = image.attr("original");
                if (!StringUtils.isEmpty(imageCode)){
                    Photo photo = new Photo();
                    photo.setUrl(image.attr("original"));
                    photo.setRelatedId(diary.getId());
                    photoService.insert(photo);
                }
            }

        }
    }

    @Autowired
    private ClassifyMapper classifyMapper;

    @Test
    public void testInsertDiaryClassify(){
        ClassifyRelated classifyRelated = new ClassifyRelated();
        classifyRelated.setClassifyId(222222222L);
        classifyRelated.setRelatedId(11111333L);
        classifyMapper.insertDiaryClassify(classifyRelated);
    }

//    @Test
//    public void testEmojiConverter(){
//        EmojiConverter emojiConverter = EmojiConverter.getInstance();
//        String str = emojiConverter.toHtml("\\xF0\\x9F\\xA4\\xA3");
//        log.debug("str = {}", str);
//    }



}
