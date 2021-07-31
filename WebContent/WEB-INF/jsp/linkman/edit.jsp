<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改联系人</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#name").val('${linkman.lkmName}');
    $("#gender").val('${linkman.lkmGender}');
    $("#phone").val('${linkman.lkmPhone}');
    $("#mobile").val('${linkman.lkmMobile}');
    $("#email").val('${linkman.lkmEmail}');
    $("#wechat").val('${linkman.lkmWechat}');
    $("#position").val('${linkman.lkmPosition}');
    $("#memo").val('${linkman.lkmMemo}');
});
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM name="form1" id="form1" action="${pageContext.request.contextPath }/linkman_update?lkmId=${linkman.lkmId}" method="post">

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
								<TD class=manageHead>当前位置：联系人管理 &gt; 修改联系人</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>所属客户：</td>
								<td colspan="3">
                                    <div>
                                        <select name="lkmCustId" id="select">
                                        <c:forEach var="customer" items="${customer_list}">
                                        <option value='${customer.custId}'>${customer.custName} </option>
                                        </c:forEach>
                                        </select>
                                </div>
                                </td>
							</tr>
							<TR>
								<td>联系人名称：</td>
								<td>
								    <INPUT class=textbox id=name
                                                        style="WIDTH: 180px" maxLength=50 name="lkmName">
								</td>
								<td>联系人性别：</td>
								<td>
								    <input id=gender type="radio" name="lkmGender" value='1'>男
                                    <input id=gender type="radio" name="lkmGender" value='2'>女
								</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
                                <td>
                                    <INPUT class=textbox id=phone
                                                        style="WIDTH: 180px" maxLength=50 name="lkmPhone">
                                </td>
                                <td>联系人手机 ：</td>
                                <td>
                                    <INPUT class=textbox id=mobile
                                                        style="WIDTH: 180px" maxLength=50 name="lkmMobile">
                                </td>
                                <td>联系人邮箱 ：</td>
                                <td>
                                    <INPUT class=textbox id=email
                                                        style="WIDTH: 180px" maxLength=50 name="lkmEmail">
                                </td>
                                <td>联系人微信 ：</td>
                                <td>
                                    <INPUT class=textbox id=wechat
                                                        style="WIDTH: 180px" maxLength=50 name="lkmWechat">
                                </td>
                                <td>联系人职位 ：</td>
                                <td>
                                    <INPUT class=textbox id=position
                                                        style="WIDTH: 180px" maxLength=50 name="lkmPosition">
                                </td>
                                <td>联系人备注 ：</td>
                                <td>
                                    <textarea id=memo name="lkmMemo" rows="3" cols="20"></textarea>
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
