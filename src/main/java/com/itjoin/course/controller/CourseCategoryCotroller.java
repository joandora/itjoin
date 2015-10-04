/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.itjoin.course.controller; 

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itjoin.course.model.Course;
import com.itjoin.course.model.CourseCategory;
import com.itjoin.course.repositories.CourseCategoryRepos;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz14121005 
 * @date	2015-10-4 上午10:06:06
 * @version      
 */
@Controller
@RequestMapping("/CourseCategory")
public class CourseCategoryCotroller {

    @Resource
   private  CourseCategoryRepos courseCategoryRepos;
    
    /**
     * <p>
     * 
     *增加课程分类
     *
     * </p>
     * @param courseCategory
     *  
     * @author	hz14121005 
     * @date	2015-10-4 上午10:32:12
     * @version      
     */ 
    @RequestMapping("/addCourseCategory")
    public @ResponseBody void save(CourseCategory courseCategory){
	 courseCategoryRepos.save(courseCategory);
    }
    
    /**
     * <p>
     * 
     *获取所有课程分类列表
     *
     * </p>
     * @return
     *  
     * @author	hz14121005 
     * @date	2015-10-4 上午10:31:30
     * @version      
     */ 
    @RequestMapping("/getAllCourseCategory")
    public @ResponseBody Object getAllCourseCategory(){
	return courseCategoryRepos.find(new Query());
    }
    
    /**
     * <p>
     * 
     *删除某个课程分类
     *
     * </p>
     * @param id
     *  
     * @author	hz14121005 
     * @date	2015-10-4 上午10:35:53
     * @version      
     */ 
    @RequestMapping("/delete")
    public @ResponseBody void delete(@PathVariable("id")String id){
	CourseCategory courseCategory=new CourseCategory();
	courseCategory.setId(id);
	courseCategoryRepos.deleteById(courseCategory);
    }
    
	
}
 