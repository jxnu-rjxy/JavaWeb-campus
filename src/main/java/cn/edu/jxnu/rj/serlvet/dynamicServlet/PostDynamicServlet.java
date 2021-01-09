package cn.edu.jxnu.rj.serlvet.dynamicServlet;

import cn.edu.jxnu.rj.domain.Dynamic;
import cn.edu.jxnu.rj.service.DynamicService;
import cn.edu.jxnu.rj.service.Impl.DynamicServiceImpl;
import cn.edu.jxnu.rj.util.FileUpload;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 用户发表动态,动态表插入记录
 *p
 */
@WebServlet(name = "postDynamicServlet",urlPatterns="/postDynamic")
public class PostDynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dynamicContent = null;
        System.out.println("开始发布动态。。。。。");
        int dynamicStatus = 0;
        int dynamicId = 0;

        //获取动态内容
        FileUpload fileUpload = new FileUpload(request);
        Map<String, Object> formText = fileUpload.getFormText();
        for(Map.Entry<String,Object> entry : formText.entrySet()){
            if(entry.getKey().equals("dynamicContent")){
                dynamicContent = (String) entry.getValue();
            }
            if(entry.getKey().equals("dynamicStatus")){
                if((Boolean) entry.getValue()==true){
                    dynamicStatus = 1;
                }else {
                    dynamicStatus = 0;
                }
            }
            if(entry.getKey().equals("dynamicId")){
                dynamicId = (int) entry.getValue();
            }
        }
        System.out.println(dynamicContent+"===="+dynamicStatus);
        //发表动态

        DynamicService dynamicService = new DynamicServiceImpl();
        Dynamic dynamic = dynamicService.post(new Dynamic(dynamicId, dynamicContent, 0, dynamicStatus, fileUpload.getImagePath()));
        System.out.println("刚刚发布的动态是"+dynamic);
        /*将发表的动态传给前端显示*/
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(dynamic);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
