<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改记录</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $('#time1').val('${salevisit.visitTime}');
    $("#visitAddr").val('${salevisit.visitAddr}');
    $("#visitDetail").val('${salevisit.visitDetail}');
    $('#time2').val('${salevisit.visitNexttime}');
});
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM name="form1" id="form1" action="${pageContext.request.contextPath }/salevisit_update?visitId=${salevisit.visitId}" method="post">

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：拜访记录管理 &gt; 修改记录</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>拜访客户：</td>
								<td colspan="3">
                                    <div>
                                        <select name="visitCustId" id="select">
                                        <c:forEach var="customer" items="${customer_list}">
                                        <option value='${customer.custId}'>${customer.custName} </option>
                                        </c:forEach>
                                        </select>
                                </div>
                                </td>
							</tr>
							<tr>
                                <td>业务员名称：</td>
                                <td colspan="3">
                                    <div>
                                        <select name="visitUserId" id="select">
                                        <c:forEach var="sysuser" items="${sysuser_list}">
                                        <option value='${sysuser.userId}'>${sysuser.userName} </option>
                                        </c:forEach>
                                        </select>
                                </div>
                                </td>
                            </tr>
                            <TR>
                                <td>拜访时间 ：</td>
                                <td>
                                    <INPUT id="time1" type="date" name="time1">
                                </td>
                                <td>拜访地点 ：</td>
                                <td>
                                    <INPUT class=textbox id=visitAddr
                                                        style="WIDTH: 180px" maxLength=50 name="visitAddr">
                                </td>
                            </TR>
                            <TR>
                                <td>拜访详情 ：</td>
                                <td>
                                    <INPUT class=textbox id=visitDetail
                                                        style="WIDTH: 180px" maxLength=50 name="visitDetail">
                                </td>
                                <td>下次拜访时间 ：</td>
                                <td>
                                    <INPUT id="time2" type="date" name="time2">
                                </td>
                            </TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="保存 " name=sButton2>
								</td>
								<td><span>${msg}</span></td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
