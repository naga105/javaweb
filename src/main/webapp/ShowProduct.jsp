<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/6/2022
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <script src="script.js" ></script>

        <link rel="stylesheet" href="style.css">
        <script src="https://cdn.tailwindcss.com"></script>
        <title>JSP - Hello World</title>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    </head>
<body>
<%@include file="components/navbar.jsp"%>
<div class="container mt-8 px-6">
    <h3 class="text-gray-700 text-2xl font-medium">${catagories}</h3>
    <span class="mt-3 text-sm text-gray-500">${listAll.size()}</span>
    <div class="grid gap-6 grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 mt-6">
     <c:forEach var="D" items="${listProduct}">
         <div class="w-full max-w-sm mx-auto rounded-md  shadow-md overflow-hidden">
            <img class="flex items-end justify-end h-56 w-full bg-cover" src="./image/${D.productImg}">
            <div class="flex justify-between">
            <div class="pl-2 py-10 ">
                <h3 class="text-gray-700 uppercase">${D.productName}</h3>
                <span class="text-xs font-light text-gray-400">#${D.id}</span>
                <span class="text-gray-500 mt-2">$${D.price}</span>
            </div>
            <div class=" pt-[15px] pr-[1rem] gap-2 ">
                <a href="ProductPage?productId=${D.id}" class=" flex bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">More detail</a>
                <a onclick="handleSubmit()" href="addCart?productId=${D.id}" class="my-[15px] flex bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">
                    Add to Cart
                </a>
            </div>
            </div>
        </div>
     </c:forEach>
    </div>
    <div class="flex justify-center">
        <div class="flex rounded-md mt-8 mb-8">
<%--            <a href="Product?page=1" class="py-2 px-4 leading-tight bg-white border border-gray-200 text-blue-700 border-r-0 ml-0 rounded-l hover:bg-blue-500 hover:text-white"><span>1</span></a></a>--%>
<%--            <a href="Product?page=2" class="py-2 px-4 leading-tight bg-white border border-gray-200 text-blue-700 border-r-0 hover:bg-blue-500 hover:text-white"><span>2</span></a>--%>
<%--            <a href="Product?page=3" class="py-2 px-4 leading-tight bg-white border border-gray-200 text-blue-700 border-r-0 hover:bg-blue-500 hover:text-white"><span>3</span></a>--%>
<%--            <a href="Product?page=4" class="py-2 px-4 leading-tight bg-white border border-gray-200 text-blue-700 border-r-0 hover:bg-blue-500 hover:text-white"><span>4</span></a>--%>
<%--            <a href="Product?page=5" class="py-2 px-4 leading-tight bg-white border border-gray-200 text-blue-700 rounded-r hover:bg-blue-500 hover:text-white"><span>5</span></a>--%>
    <c:forEach var="P"  begin="1" end="${PageSize}">
    <a href="Product?page=${P}" class="py-2 px-4 leading-tight bg-white border border-gray-200 text-blue-700 rounded-r hover:bg-blue-500 hover:text-white"><span>${P}</span></a>
    </c:forEach>
        </div>
    </div>
</div>
</body>
    <script>const handleSubmit =(e)=>{
        e.preventDefault();
    }</script>
</html>
