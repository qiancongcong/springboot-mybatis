//package com.cc.controller;
//
//import com.cc.pojo.User;
//import com.cc.pojo.UserQuery;
//import com.cc.service.impl.UserService;
//import com.cc.util.ResponseJson;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.log4j.Log4j;
//import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.response.QueryResponse;
//import org.apache.solr.common.SolrDocument;
//import org.apache.solr.common.SolrDocumentList;
//import org.apache.solr.common.SolrInputDocument;
//import org.apache.solr.common.params.ModifiableSolrParams;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @Author: cc
// * @Date: Created in 14:36 2018/1/15
// */
//@RestController
//@RequestMapping("/solr")
//@Api(description = "solr")
//@Log4j
//public class SolrController {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private SolrClient solrClient;
//
//    /**
//     * 将数据放入solr中
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.POST)
//    @ApiOperation(value = "保存数据到solr服务中")
//    public ResponseJson ImportAllResource(){
//        UserQuery userQuery = new UserQuery();
//            try {
//                List<User> users = userService.querUser(userQuery);
//                for (User user: users) {
//                    SolrInputDocument document = new SolrInputDocument();
//                    document.addField("id", user.getId());
//                    document.addField("loginName", user.getNickName());
//                    document.addField("phone", user.getPhone());
//                    solrClient.add(document);
//                 }
//                solrClient.commit();
//            } catch (Exception e) {
//                e.printStackTrace();
//                return ResponseJson.failed("失败"+e.getStackTrace());
//            }
//            return ResponseJson.ok();
//    }
//
//    @RequestMapping(value = "/querySolrById",method = RequestMethod.GET)
//    @ApiOperation(value = "根据id从solr中查询数据")
//    public ResponseJson querySolrById(){
//        SolrDocument solrDocument = new SolrDocument();
//        try {
//            solrDocument = solrClient.getById("1");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseJson.failed("失败"+e.getStackTrace());
//        }
//        return ResponseJson.ok(solrDocument);
//    }
//
//    @RequestMapping(value = "/querySolr",method = RequestMethod.GET)
//    @ApiOperation(value = "从solr中取数据")
//    public ResponseJson querySolr(){
//        try {
//            //查询参数对象，继承了SolrParams抽象类
//            ModifiableSolrParams params =new ModifiableSolrParams();
//            SolrQuery solrQuery = new SolrQuery();
//            solrQuery.setQuery("*:*");
////            solrQuery.addFilterQuery("phone:158");
////            solrQuery.addFilterQuery("password:123");
//            solrQuery.addFilterQuery("userName:测试");
//            //分页
//            /*solrQuery.setStart(1);
//            solrQuery.setRows(1);*/
//            //默认搜索域
//           /* solrQuery.set("df","item_keywords");
//            //设置高亮显示
//            solrQuery.setHighlight(true);
//            solrQuery.addHighlightField("userName");
//            solrQuery.setHighlightSimplePre("<em style=\"color:red\">");
//            solrQuery.setHighlightSimplePost("</em>");*/
//            params.add(solrQuery);
//            //QueryResponse query = solrClient.query(params);
//            QueryResponse query = solrClient.query(solrQuery);
//            //查询结果
//            SolrDocumentList results = query.getResults();
//            //将查询结果直接转化为List，这里有个坑，对象每个属性必须要加 @Field("id") 属性，包为import org.apache.solr.client.solrj.beans.Field;
//            //如果不加属性的话，会返回相等长度的的List，但是List里面每个对象的值均为空
//            List<UserQuery> beans = query.getBeans(UserQuery.class);
//            return ResponseJson.ok(beans);
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseJson.failed("失败");
//        }
//    }
//
//    @RequestMapping(value = "solrDelete",method = RequestMethod.POST)
//    @ApiOperation(value = "删除")
//    public  ResponseJson deleteDocument(){
//        //单个id删除
//        //solrServer.deleteById();
//        //多个id删除
//        //solrServer.deleteById();
//        try {
//            solrClient.deleteByQuery("*:*");
//            solrClient.commit();
//            return ResponseJson.ok();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseJson.failed("失败"+e.getStackTrace());
//        }
//    }
//
//}
