package core.utils;

import java.util.List;

import com.github.pagehelper.Page;

/**
 * 功能概要：设置页
 * 
 * @author linbingwen
 * @since  2015年10月22日 
 */


public class BeanUtil {

    public static <T> PageInfo<T> toPageInfo(List<T> datas) {
    	PageInfo<T> result = new PageInfo<T>();
        if (datas instanceof Page) {
            Page page = (Page) datas;
            result.setNowpage(page.getPageNum());
            result.setTotalpage(page.getPages());
            result.setRows(page.getResult());
            result.setTotal((int)page.getTotal());
            result.setPagesize(page.getPageSize());
        }
        else {
            result.setNowpage(1);
            result.setPagesize(datas.size());
            result.setRows(datas);
            result.setTotal(datas.size());
        }
        return result;
    }

}
