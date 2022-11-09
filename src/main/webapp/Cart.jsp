<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/10/2022
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Cart</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="h-screen bg-gray-300">
    <div class="py-12 ">
        <div class="max-w-md mx-auto bg-gray-100 shadow-lg rounded-lg  md:max-w-5xl">
            <div class="md:flex ">
                <div class="w-full p-4 px-5 py-5">

                    <div class="md:grid md:grid-cols-3 gap-2 overflow-hidden h-[40rem] ">

                        <div class="col-span-2 p-5">

                            <h1 class="text-xl font-medium ">Shopping Cart</h1>
                            <div class="overflow-y-scroll h-[50vh]">
                            <c:forEach var="C" items="${cart}">
                            <div class="flex justify-between items-center mt-6 pt-6 border-t">
                                <div class="flex  items-center">
                                    <img src="./image/${C.productImg}" width="60" class="rounded-full ">

                                    <div class="flex flex-col ml-3">
                                        <span class="md:text-md font-medium">${C.productName}</span>
                                        <span class="text-xs font-light text-gray-400">#${C.id}</span>
                                    </div>
                                </div>
                                <div class="flex justify-center items-center">
                                    <div class="pr-8 flex ">

                                        <p type="text"
                                               class=" bg-gray-100h-6 w-8  text-sm px-2 mx-2"
                                          >${C.quantity}</p>

                                    </div>
                                    <div class="pr-8 ">
                                        <span class="text-xs font-medium">$${C.price}</span>
                                    </div>
                                    <div>
                                        <a href="delete?id=${C.id}" class="fa fa-close text-xs font-medium">Delete</a>
                                    </div>
                                </div>

                            </div>
                            </c:forEach>
                            </div>
                            <div class="flex justify-between items-center mt-6 pt-6 border-t">
                                <div class="flex items-center">
                                    <i class="fa fa-arrow-left text-sm pr-2"></i>
                                    <a href="index.jsp" class="text-md  font-medium text-blue-500">Continue Shopping</a>
                                </div>

                                <div class="flex justify-center items-end">
                                    <span class="text-sm font-medium text-gray-400 mr-1">Subtotal:</span>
                                    <span class="text-lg font-bold text-gray-800 "> $${total}</span>

                                </div>

                            </div>


                        </div>
                        <div class=" p-5 bg-gray-800 rounded overflow-visible">

                            <span class="text-xl font-medium text-gray-100 block pb-3">Paying Method</span>
                            <form action="Checkout" method="get">
                                    <div class="flex pt-2">
                                    <label class="block w-[5rem] text-gray-500 text-sm md:text-right mb-1 md:mb-0 pr-4" >
                                        Full Name
                                    </label>
                                    <input class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-[10rem] h-[25px] py-2  text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"  type="text" placeholder="Enter your Fullname" name="fullname">
                                    </div>
                                    <div class="flex pt-2">
                                        <label class="block w-[5rem] text-gray-500 text-sm md:text-right mb-1 md:mb-0 pr-4" >
                                           Email
                                        </label>
                                        <input class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-[10rem] h-[25px] py-2 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"  type="text" placeholder="Email" name="email" >
                                    </div>
                                    <div class="flex pt-2">
                                        <label class="block w-[5rem] text-gray-500 text-sm md:text-right mb-1 md:mb-0 pr-4" >
                                           Phone Number
                                        </label>
                                        <input class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-[10rem] h-[25px] py-2  text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500" type="text" placeholder="Phone number" name="phone" >
                                    </div>
                                    <div class="flex pt-2">
                                    <label class="block w-[5rem] text-gray-500 text-sm md:text-right mb-1 md:mb-0 pr-4" >
                                        Address
                                    </label>
                                    <input class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-[10rem] h-[25px] py-2  text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"  type="text" placeholder="Address" name="address" >
                                </div>
                            <div class=" ">
                                    <div class="form-check">
                                        <input class="form-check-input appearance-none rounded-full h-4 w-4 border border-gray-300 bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer" type="radio" name="paymethod" value="Momo" id="flexRadioDefault1">
                                        <label class="text-base inline-block font-medium text-gray-100 block pb-3">Momo</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input appearance-none rounded-full h-4 w-4 border border-gray-300 bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer" type="radio" name="paymethod" value="Paypal" id="flexRadioDefault2">
                                        <label class="text-base  inline-block font-medium text-gray-100 block pb-3">Paypal</label>
                                    </div>
                                <div class="form-check">
                                    <input class="form-check-input appearance-none rounded-full h-4 w-4 border border-gray-300 bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer" type="radio" name="paymethod" value="Cod" id="flexRadioDefault3">
                                    <label class="text-base  inline-block font-medium text-gray-100 block pb-3">Paying Cash</label>

                                </div>
                            </div>
                            <button type="submit"  class="h-12 w-full bg-blue-500 rounded focus:outline-none text-white hover:bg-blue-600">
                                <p>Check Out</p>
                            </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
