package com.lizhiyu.sell.repository;

import com.lizhiyu.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lzy on 17-8-13.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
