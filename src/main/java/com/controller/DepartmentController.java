package com.controller;

import com.model.Department;
import com.model.DepartmentExample;
import com.model.TreeModel;
import com.model.User;
import com.service.IDepartmentService;
import com.util.treeModelGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ma on 2016/10/19.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

        @Resource
        private IDepartmentService depService;

        @RequestMapping("/GetDepList.do")
        public @ResponseBody
        Map<String,Object> GetDepartmentList(HttpServletRequest request){
            //获取部门列表
            DepartmentExample example = new DepartmentExample();
            List<Department> listdep =  depService.selectByExample(example);
            //转换成treemodel
            Map<String,Object> map = new HashMap<String,Object>();
            List<TreeModel> result = treeModelGenerator.GetDepartmentList(listdep);

            if(result != null){
                map.put("msg", "成功");
            }else{
                map.put("msg", "失败");
            }
            map.put("dep",result);
            return map;
        }
}
