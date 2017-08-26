package crm.controller;

import com.alibaba.druid.support.json.JSONUtils;
import crm.domain.chart;
import crm.page.PageResult;
import crm.query.PotentialcustomerQueryObject;
import crm.service.IPotentialcustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerchartController {
    @Autowired
    private IPotentialcustomerService customerchartservice;
    PotentialcustomerQueryObject qo=new PotentialcustomerQueryObject();
    PageResult result=null;
    @RequestMapping("/customerchart")
    public String customerchart(){
        return "customerchart";
    }
    @RequestMapping("/customerchart_list")
    @ResponseBody
    public PageResult list(HttpServletRequest request)  {
        try {
            qo.setPage(Integer.valueOf(request.getParameter("page")));
            qo.setRows(Integer.valueOf(request.getParameter("rows")));
            if (request.getParameter("groupType")==null){
                qo.setGroupType("month");
            }else {
                qo.setGroupType(request.getParameter("groupType"));
            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (request.getParameter("beginDate")==null){
                qo.setBeginDate(null);
            }else {
                qo.setBeginDate(df.parse(request.getParameter("beginDate")));
            }
            if (request.getParameter("endDate")==null){
                qo.setEndDate(null);
            }else{
                qo.setEndDate(df.parse(request.getParameter("endDate")));
            }
        }catch (Exception e){
        }
        result=customerchartservice.queryByCondition5(qo);
        return result;
    }
    @RequestMapping("/cchart")
    public String cchart(HttpServletRequest request) throws ParseException {
        String groupType="月份";
        List<String> groupTypes=new ArrayList<>();
        List<Long> numbers=new ArrayList<>();
        qo.setPage(null);
        qo.setGroupType(request.getParameter("groupType"));
        result=customerchartservice.queryByCondition5(qo);
        List<chart> all=result.getRows();
        if (request.getParameter("groupType")==null){
            groupType="月份";
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
            for (chart a : all) {
                groupTypes.add(dateFormater.format(a.getGroupType()));
                numbers.add(a.getNumber());
            }
        }else {
            if (request.getParameter("groupType").equals("month")) {
                groupType="月份";
                SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
                for (chart a : all) {
                    groupTypes.add(dateFormater.format(a.getGroupType()));
                    numbers.add(a.getNumber());
                }
            }
            if (request.getParameter("groupType").equals("year")) {
                groupType="年份";
                SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy");
                for (chart a : all) {
                    groupTypes.add(dateFormater.format(a.getGroupType()));
                    numbers.add(a.getNumber());
                }
            }
        }
        request.setAttribute("groupTypes", JSONUtils.toJSONString(groupTypes));
        request.setAttribute("numbers", numbers);
        request.setAttribute("group",JSONUtils.toJSONString(groupType));
        return "cchart";
    }
    @RequestMapping("/cchart2")
    public String cchart2(HttpServletRequest request) throws ParseException {
        String groupType="月份";
        List datas=new ArrayList();
        qo.setPage(null);
        qo.setGroupType(request.getParameter("groupType"));
        result=customerchartservice.queryByCondition5(qo);
        List<chart> all=result.getRows();
        if (request.getParameter("groupType")==null){
            groupType="月份";
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
            for (chart a : all) {
                datas.add("['"+dateFormater.format(a.getGroupType())+"'");
                datas.add(a.getNumber()+"]");
            }
        }else {
            if (request.getParameter("groupType").equals("month")) {
                groupType="月份";
                SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
                for (chart a : all) {
                    datas.add("['"+dateFormater.format(a.getGroupType())+"'");
                    datas.add(a.getNumber()+"]");
                }
            }
            if (request.getParameter("groupType").equals("year")) {
                groupType="年份";
                SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy");
                for (chart a : all) {
                    datas.add("['"+dateFormater.format(a.getGroupType())+"'");
                    datas.add(a.getNumber()+"]");
                }
            }
        }
        request.setAttribute("datas",datas);
        request.setAttribute("group",JSONUtils.toJSONString(groupType));
        return "cchart2";
    }
    @RequestMapping("/ccchart")
    public String ccchart(HttpServletRequest request) throws ParseException {
        String groupType="月份";
        List datas=new ArrayList();
        qo.setPage(null);
        qo.setGroupType(request.getParameter("groupType"));
        result=customerchartservice.queryByCondition5(qo);
        List<chart> all=result.getRows();
        if (request.getParameter("groupType")==null){
            groupType="月份";
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
            for (chart a : all) {
                datas.add("['"+dateFormater.format(a.getGroupType())+"'");
                datas.add(a.getNumber()+"]");
            }
        }else {
            if (request.getParameter("groupType").equals("month")) {
                groupType="月份";
                SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM");
                for (chart a : all) {
                    datas.add("['"+dateFormater.format(a.getGroupType())+"'");
                    datas.add(a.getNumber()+"]");
                }
            }
            if (request.getParameter("groupType").equals("year")) {
                groupType="年份";
                SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy");
                for (chart a : all) {
                    datas.add("['"+dateFormater.format(a.getGroupType())+"'");
                    datas.add(a.getNumber()+"]");
                }
            }
        }
        request.setAttribute("datas",datas);
        request.setAttribute("group",JSONUtils.toJSONString(groupType));
        return "ccchart";
    }
}
