<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户拜访记录查询</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript">

</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<form id="form1" name="form1" action="${pageContext.request.contextPath }/salevisit_query" method="post">
		

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
								<TD class=manageHead>当前位置：综合查询 &gt; 客户拜访记录查询</TD>
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
								        <option value=''>无 </option>
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
                                        <option value=''>无 </option>
                                        <c:forEach var="user" items="${user_list}">
                                        <option value='${user.userId}'>${user.userName} </option>
                                        </c:forEach>
                                        </select>
                                </div>
                                </td>
                            </tr>
							<TR>
								<td>拜访地点 ：</td>
								<td>
								    <INPUT class=textbox id=sChannel2
                                                        style="WIDTH: 180px" maxLength=50 name="visitAddr">
								</td>
							</TR>
							<TR>
								<td>拜访详情 ：</td>
								<td>
								    <INPUT class=textbox id=sChannel2
                                                        style="WIDTH: 180px" maxLength=50 name="visitDetail">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="查询 " name=sButton2>
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
	</form>
</BODY>
</HTML>
