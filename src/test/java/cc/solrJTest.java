package cc;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: cc
 * @Date: Created in 14:05 2018/1/15
 */
public class solrJTest {

    @Autowired
    private SolrClient solrClient;
    /**
     * 添加修改文档
     * @throws Exception
     */
    @Test
    public  void  addDocument()throws Exception{
        //创建文档对象
        SolrInputDocument document = new SolrInputDocument();
        //把文档对象写入索引库
        document.addField("id","005");
        document.addField("userName","测试测试测试");
        document.addField("password","11111111");
        document.addField("phone","88888888");
        solrClient.add(document);
        //提交
        solrClient.commit();
    }

    /**
     *  删除
     * @throws Exception
     */
    @Test
    public  void deleteDocument()throws Exception{
        //单个id删除
        //solrServer.deleteById();
        //多个id删除
        //solrServer.deleteById();
        solrClient.deleteByQuery("*:*");
        solrClient.commit();
    }

}
