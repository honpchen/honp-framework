package ink.honp.core.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author jeffchen
 * date    2023/12/29 16:14
 */
@Data
@Accessors(chain = true)
public class PageInfo <T> {

    /** 当前页 **/
    private Long page;

    /** 每页大小 **/
    private Long size;

    /** 总页数 **/
    private Long pages;

    /** 总数 **/
    private Long totalCount;

    /** 数据 **/
    private List<T> content;

}
