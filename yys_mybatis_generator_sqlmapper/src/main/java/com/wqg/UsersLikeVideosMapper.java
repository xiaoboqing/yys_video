package com.wqg;

import com.wqg.UsersLikeVideos;
import com.wqg.UsersLikeVideosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersLikeVideosMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    int countByExample(UsersLikeVideosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    int deleteByExample(UsersLikeVideosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    int insert(UsersLikeVideos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    int insertSelective(UsersLikeVideos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    List<UsersLikeVideos> selectByExample(UsersLikeVideosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    UsersLikeVideos selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UsersLikeVideos record, @Param("example") UsersLikeVideosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UsersLikeVideos record, @Param("example") UsersLikeVideosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UsersLikeVideos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UsersLikeVideos record);
}
