package star.demo.fastdfs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import star.demo.fastdfs.db.ImgDao;
import star.demo.fastdfs.model.Img;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ImgController {

    @Autowired
    private ImgDao imgDao;

    @RequestMapping("/index")
    public String index(
            @RequestParam(value="page", required=false, defaultValue="1") int page,
            @RequestParam(value="pagesize", required=false, defaultValue="10") int pagesize,
            Model model
    ){
        Map map = new HashMap();
        map.put("page", page);
        map.put("pagesize", pagesize);
        List<Img> list = imgDao.findImgList(map);
        model.addAttribute("list", list);
        return "index";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(
            String name
    ){

        return "true";
    }

}
