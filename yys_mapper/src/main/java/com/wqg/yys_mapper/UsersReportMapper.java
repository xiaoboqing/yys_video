package com.wqg.yys_mapper;

import com.wqg.yys_pojo.UsersReport;
import com.wqg.yys_pojo.UsersReportExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UsersReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    int countByExample(UsersReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    int deleteByExample(UsersReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    int insert(UsersReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    int insertSelective(UsersReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    List<UsersReport> selectByExample(UsersReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    UsersReport selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UsersReport record, @Param("example") UsersReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UsersReport record, @Param("example") UsersReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UsersReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UsersReport record);
}
