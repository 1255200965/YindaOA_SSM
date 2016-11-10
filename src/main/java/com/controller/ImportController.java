package com.controller;

import com.service.IImportService;
import com.util.DateUtil;
import com.util.ExcelToMysql;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/Import")
public class ImportController {

    @RequestMapping("/navigator.do")
    public String navigator(HttpServletRequest request) throws IOException {
        return "/upload";
    }

}
