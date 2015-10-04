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
import com.itjoin.course.repositories.CourseRepos;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz14121005 
 * @date	2015-10-2 下午11:21:42
 * @version      
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    
    @Resource
    private CourseRepos courseRepos;
   
    
    @RequestMapping("/save")
    public @ResponseBody void save(Course course){
	courseRepos.save(course);
    }
    
    @RequestMapping("/viewById")
    public @ResponseBody Object viewById(@PathVariable("id")String id){
	return courseRepos.findById(id);
    }
    
    @RequestMapping("/getAllCourseByCategoryId")
    public @ResponseBody Object getAllCourseByCategoryId(@PathVariable("categoryId")String categoryId){
	Course course=new Course();
	course.setCategoryId(categoryId);
	return courseRepos.findByCondition(course); 
    }

}
 