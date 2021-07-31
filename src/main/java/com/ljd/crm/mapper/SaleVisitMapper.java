package main.java.com.ljd.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.java.com.ljd.crm.pojo.SaleVisit;
import main.java.com.ljd.crm.pojo.SaleVisitExample;

public interface SaleVisitMapper {
    long countByExample(SaleVisitExample example);

    int deleteByExample(SaleVisitExample example);

    int deleteByPrimaryKey(Long visitId);

    int insert(SaleVisit record);

    int insertSelective(SaleVisit record);

    List<SaleVisit> selectByExample(SaleVisitExample example);

    SaleVisit selectByPrimaryKey(Long visitId);

    int updateByExampleSelective(@Param("record") SaleVisit record, @Param("example") SaleVisitExample example);

    int updateByExample(@Param("record") SaleVisit record, @Param("example") SaleVisitExample example);

    int updateByPrimaryKeySelective(SaleVisit record);

    int updateByPrimaryKey(SaleVisit record);
}