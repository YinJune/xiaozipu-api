package com.xiaozipu.client.service.category;

import com.xiaozipu.common.enums.StatusEnum;
import com.xiaozipu.common.enums.CategoryLevelEnum;
import com.xiaozipu.dao.entity.TCategory;
import com.xiaozipu.dao.entity.TCategoryExample;
import com.xiaozipu.dao.mapper.TCategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: YinJunJie
 * @date: 2020/1/20 20:58
 * @description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private TCategoryMapper categoryMapper;

    /**
     * 查询分类
     *
     * @param categoryId
     * @return
     */
    @Override
    public List<TCategory> getCategoryList(Integer categoryId) {
        List<TCategory> categoryList = null;
        TCategoryExample categoryExample = new TCategoryExample();
        if (categoryId == null) {
            categoryExample.createCriteria().andStatusEqualTo(StatusEnum.VALID.getKey()).andDeletedEqualTo(StatusEnum.INVALID.getKey()).andLevelEqualTo(CategoryLevelEnum.ONE.getKey());
        } else {
            categoryExample.createCriteria().andStatusEqualTo(StatusEnum.VALID.getKey()).andDeletedEqualTo(StatusEnum.INVALID.getKey()).andParentIdEqualTo(categoryId);
        }
        categoryList = categoryMapper.selectByExample(categoryExample);
        return categoryList;
    }
}
