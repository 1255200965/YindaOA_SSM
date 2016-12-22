<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<div align="center" style="font-size: 12px">
	<p>
		<span class="STYLE33">每页${page.pageSize}条当前是[第 ${page.pageNo}&nbsp;页 /
			共有&nbsp;${page.totalCount}<span class="STYLE7">&nbsp;</span>页]
		</span> <span class="STYLE15"><span class="STYLE20">
		        <a href="javascript:movePage(1)">首页</a> 
		        <a href="javascript:movePage(${page.pageNo -1  < 1? 1: page.pageNo-1})">上一页</a>
				<a href="javascript:movePage(${page.pageNo+1> page.totalCount? page.totalCount: page.pageNo+1 })">下一页</a>
				<a href="javascript:movePage(${page.totalCount})">末页 </a></span></span>				
	</p>
	
		
</div>
	
