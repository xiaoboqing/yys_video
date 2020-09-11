package com.wqg.yys_mapper;

import com.wqg.yys_pojo.Bgm;
import com.wqg.yys_pojo.BgmExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface BgmMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    int countByExample(BgmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    int deleteByExample(BgmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    int insert(Bgm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    int insertSelective(Bgm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    List<Bgm> selectByExample(BgmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    Bgm selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Bgm record, @Param("example") BgmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Bgm record, @Param("example") BgmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Bgm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bgm
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Bgm record);

    /**
     * 获取所有bgm
     * @return
     */
    @Select("SELECT * FROM bgm")
    List<Bgm> queryBgm();
}
