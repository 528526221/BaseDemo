package com.xulc.basedemo;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.xulc.basedemo.app.BitMapHelper;
import com.xulc.basedemo.app.DBHelper;
import com.xulc.basedemo.app.HttpHelper;
import com.xulc.basedemo.app.HttpListener;
import com.xulc.basedemo.base.BaseActivity;
import com.xulc.basedemo.model.User;
import com.xulc.basedemo.response.LoginResponse;
import com.xulc.basedemo.util.ResponseUtil;
import com.xulc.basedemo.util.ToastUtil;



import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxParams;


import java.util.List;


public class MainActivity extends BaseActivity implements HttpListener {

    @ViewInject(id = R.id.tvText)
    TextView tvText;
    @ViewInject(id = R.id.btnTest,click = "clickTest")
    Button btnTest;
    @ViewInject(id = R.id.img)
    ImageView img;
    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void findView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void underCreate() {
//        params.put("profile_picture", new File("/mnt/sdcard/pic.jpg")); // 上传文件
//        params.put("profile_picture2", inputStream); // 上传数据流
//        params.put("profile_picture3", new ByteArrayInputStream(bytes)); // 提交字节流
        HttpHelper.getInstance().HttpGet("https://www.bestlinker" +
                ".cn/apptv/fg/member/list?sessionID" +
                "=KFTmXkKmLDxiKXBvgj9XpXL1D20Wxv1Yvpo9YiVYqH50Mwb_5q9Vxw==",1, this);
//        https://auth.bestlinker.net/app-logout?sessionID=KFTmXkKmLDxiKXBvgj9XpXL1D20Wxv1Yvpo9YiVYqH50Mwb_5q9Vxw==
        AjaxParams params = new AjaxParams();
        params.put("username", "13316890663");
        params.put("password","8ddcff3a80f4189ca1c9d4d902c3c909");
        params.put("ttlseconds","604800");
        params.put("apptype","1");
        showWait();
        HttpHelper.getInstance().HttpPost("https://auth.bestlinker.net/app-login", params, 2, this);

        BitMapHelper.getInstance().display(img,"https://p.ssl.qhimg.com/dmsmfl/120_75_/t0189027858ebfad923.webp?size=50x50&phash=-4590505077101179853");
    }

    public void clickTest(View v){
        DBHelper.getInstance().deleteAll(User.class);
        List<User> users =DBHelper.getInstance().findAll(User.class);
        User user = new User();
        user.setEmail("afinal@tsz.net");
        user.setName("探索者");
        user.setAge("18");
        DBHelper.getInstance().save(user);
        users = DBHelper.getInstance().findAll(User.class);

        User user1 = new User();
        user1.setEmail("afinal@tsz.net");
        user1.setName("小妹");
        user1.setAge("16");


        User user2 = new User();
        user2.setEmail("afinal@tsz.net");
        user2.setName("大哥");
        user2.setAge("24");

        /**增*/
        DBHelper.getInstance().save(user1);
        users = DBHelper.getInstance().findAll(User.class);
        DBHelper.getInstance().save(user2);
        users = DBHelper.getInstance().findAll(User.class);
        /**改*/
        DBHelper.getInstance().update(user, "name='小妹'");
        /**查*/
        users = DBHelper.getInstance().findAll(User.class);
        User u = DBHelper.getInstance().findById(16, User.class);
        users = DBHelper.getInstance().findAll(User.class, "age");
        users = DBHelper.getInstance().findAll(User.class, "age desc");
        users = DBHelper.getInstance().findAllByWhere(User.class, "name='大哥'");
        /**删*/
        DBHelper.getInstance().deleteById(User.class, 16);
        users = DBHelper.getInstance().findAll(User.class);
        DBHelper.getInstance().save(user);
        users = DBHelper.getInstance().findAll(User.class);
        DBHelper.getInstance().deleteByWhere(User.class, "name='小妹'");
        users = DBHelper.getInstance().findAll(User.class);
        DBHelper.getInstance().deleteAll(User.class);
        users = DBHelper.getInstance().findAll(User.class);


    }


    @Override
    public void onSuccess(int code, String result) {
        switch (code){
            case 1:
                ToastUtil.show("getmembe:" + result);
                break;
            case 2:
                closeWait();
                LoginResponse loginResponse = JSON.parseObject(result,LoginResponse.class);
                if (ResponseUtil.getInstance().isSuccess(loginResponse)){
                    ToastUtil.show("login:"+result);
                }else {
                    ToastUtil.show(ResponseUtil.getInstance().getErrorMsg(loginResponse));
                }

                break;
        }
    }

    @Override
    public void onFailure(int code, String msg) {
        closeWait();
    }
}
