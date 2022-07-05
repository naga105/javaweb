<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/27/2022
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="style.css">
  <title>Sign Up</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
<div class="flex z-index-front items-center min-h-screen p-4  lg:justify-center bg-black opacity-90">
  <div class="bg-white p-16 rounded shadow-2xl w-2/3">

    <h2 class="text-3xl font-bold mb-10 text-gray-800">Create Your Account</h2>

    <form class="space-y-5" action="LogServlet" method="post">

      <div>
        <label class="block mb-1 font-bold text-gray-500">Name</label>
        <input type="text" class="w-full border-2 border-gray-200 p-3 rounded outline-none focus:border-purple-500" placeholder="Enter your Name" name="fullname">
      </div>

      <div>
        <label class="block mb-1 font-bold text-gray-500">Username</label>
        <input type="text" class="w-full border-2 border-gray-200 p-3 rounded outline-none focus:border-purple-500" name="name" placeholder="Enter your userName">
      </div>

      <div>
        <label class="block mb-1 font-bold text-gray-500">Password</label>
        <input type="password" class="w-full border-2 border-gray-200 p-3 rounded outline-none focus:border-purple-500" name="password" placeholder="Enter your Password">
      </div>

      <div class="flex items-center">
        <input type="checkbox" id="agree">
        <label for="agree" class="ml-2 text-gray-700 text-sm">I agree to the terms and privacy.</label>
      </div>

      <input type="submit" class=" cursor-pointer block w-40 text-center  items-center h-10 text-white transition-colors duration-300 bg-blue-500 rounded-md shadow hover:bg-blue-600 focus:outline-none focus:ring-blue-200 focus:ring-4" value="Sign up">

    </form>
</div>
<video autoplay muted loop id="myVideo">
  <source src="components/videoplayback.mp4" type="video/mp4">
</video>
</div>
</body>
</html>
