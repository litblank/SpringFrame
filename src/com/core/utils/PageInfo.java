package core.utils;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @description：分页实体类 (结合jqery easyui)
 * @author：Wangzhixuan
 * @date：2015年4月23日 上午1:41:46
 */
public class PageInfo<T> {

    private final static int PAGESIZE = 10; //默认显示的记录数 

    private int total; // 总记录数
    private List<?> rows; //显示的记录  

    @JsonIgnore
    private int from;
    
    private int totalpage;//总页数
    
    private int nowpage; // 当前页 
    
    private int pagesize; //每页记录数
    @JsonIgnore
    private Map<String, Object> condition; //查询条件

    @JsonIgnore
    private String sort = "seq";// 排序字段
    @JsonIgnore
    private String order = "asc";// asc，desc mybatis Order 关键字
    

    public PageInfo() {}

    //构造方法
    public PageInfo(int nowpage, int pagesize) {
        //计算当前页  
        if (nowpage <= 0) {
            this.nowpage = 1;
        } else {
            //当前页
            this.nowpage = nowpage;
        }
        //记录每页显示的记录数  
        if (pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else if(pagesize>10000){
        	pagesize = 10000;
        } else {
            this.pagesize = pagesize;
        }
    }

    // 构造方法
    public PageInfo(int nowpage, int pagesize, String sort, String order) {
        // 计算当前页  
        if (nowpage < 0) {
            this.nowpage = 1;
        } else {
            // 当前页
            this.nowpage = nowpage;
        }
        //记录每页显示的记录数  
        if (pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else if(pagesize>10000){
        	pagesize = 10000;
        } else {
            this.pagesize = pagesize;
        }
        
        // 排序字段，正序还是反序
        this.sort = sort;
        this.order = order;
    }
    

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }
    

    public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getNowpage() {
        return nowpage;
    }

    public void setNowpage(int nowpage) {
        this.nowpage = nowpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
