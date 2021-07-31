package main.java.com.ljd.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.java.com.ljd.crm.pojo.Linkman;
import main.java.com.ljd.crm.pojo.LinkmanExample;

public interface LinkmanMapper {
    long countByExample(LinkmanExample example);

    int deleteByExample(LinkmanExample example);

    int deleteByPrimaryKey(Long lkmId);

    int insert(Linkman record);

    int insertSelective(Linkman record);

    List<Linkman> selectByExample(LinkmanExample example);

    Linkman selectByPrimaryKey(Long lkmId);

    int updateByExampleSelective(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByExample(@Param("record") Linkman record, @Param("example") LinkmanExample example);

    int updateByPrimaryKeySelective(Linkman record);

    int updateByPrimaryKey(Linkman record);
}