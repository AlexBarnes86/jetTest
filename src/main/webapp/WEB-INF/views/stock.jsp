<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Stock</h1>
<c:choose>
<c:when test="${stock != null}">
	Code: ${stock.stockCode}
	Name: ${stock.stockName}
</c:when>
<c:otherwise>
	No Stock Available
</c:otherwise>
</c:choose>
