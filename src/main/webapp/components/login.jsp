<div class="flex z-index-front items-center min-h-screen p-4  lg:justify-center">
    <div
            class="flex flex-col overflow-hidden bg-white rounded-md shadow-lg max md:flex-row md:flex-1 lg:max-w-screen-md"
    >
        <div
                class="p-4 py-6 text-white bg-blue-500 md:w-80 md:flex-shrink-0 md:flex md:flex-col md:items-center md:justify-evenly"
        >
            <div class="my-3 text-4xl font-bold tracking-wider text-center">
                <a href="#">HighSense</a>
            </div>
            <p class="mt-6 font-normal text-center text-gray-300 md:mt-0">
                The ultimate platform to purchase sell and consume all product about entertainment and office tools
            </p>
            <p class="flex flex-col items-center justify-center mt-10 text-center">
                <span>Don't have an account?</span>
                <a href="#" class="underline">Get Started!</a>
            </p>
            <p class="mt-6 text-sm text-center text-gray-300">
                Read our <a href="#" class="underline">terms</a> and <a href="#" class="underline">conditions</a>
            </p>
        </div>
        <div class="p-5 bg-white md:flex-1">
            <h3 class="my-4 text-2xl font-semibold text-gray-700">Account Login</h3>
            <form action="LoginServlet" method="post" class="flex flex-col space-y-5">
                <div class="flex flex-col space-y-1">
                    <label class="text-sm font-semibold text-gray-500">Username</label>
                    <input
                            type="text"
                            autofocus
                            class="px-4 py-2 transition duration-300 border border-gray-300 rounded focus:border-transparent focus:outline-none focus:ring-4 focus:ring-blue-200"
                    />
                </div>
                <div class="flex flex-col space-y-1">
                    <div class="flex items-center justify-between">
                        <label for="password" class="text-sm font-semibold text-gray-500">Password</label>
                        <a href="#" class="text-sm text-blue-600 hover:underline focus:text-blue-800">Forgot
                            Password?</a>
                    </div>
                    <input
                            type="password"
                            id="password"
                            class="px-4 py-2 transition duration-300 border border-gray-300 rounded focus:border-transparent focus:outline-none focus:ring-4 focus:ring-blue-200"
                    />
                </div>
                <div class="flex items-center space-x-2">
                    <input
                            type="checkbox"
                            id="remember"
                            class="w-4 h-4 transition duration-300 rounded focus:ring-2 focus:ring-offset-0 focus:outline-none focus:ring-blue-200"
                    />
                    <label for="remember" class="text-sm font-semibold text-gray-500">Remember me</label>
                </div>
                <div>
                    <input
                            type="submit"
                            value="Login"
                            class="w-full px-4 py-2 text-lg font-semibold text-white transition-colors duration-300 bg-blue-500 rounded-md shadow hover:bg-blue-600 focus:outline-none focus:ring-blue-200 focus:ring-4"
                    >
                </div>
                <div class="flex flex-col space-y-5">
              <span class="flex items-center justify-center space-x-2">
                <span class="h-px bg-gray-400 w-14"></span>
                <span class="font-normal text-gray-500">or login with</span>
                <span class="h-px bg-gray-400 w-14"></span>
              </span>
                    <div class="flex flex-col space-y-4">
                        <a
                                href="#"
                                class="flex items-center justify-center px-4 py-2 space-x-2 transition-colors duration-300 border border-gray-800 rounded-md group hover:bg-gray-800 focus:outline-none"
                        >
                  <span>
                   <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.0" x="0px" y="0px" width="20" height="20" viewBox="0 0 50 50" style="null" class="icon icons8-Facebook-Filled w-5 h-5 text-gray-800 fill-current group-hover:text-white" >    <path d="M40,0H10C4.486,0,0,4.486,0,10v30c0,5.514,4.486,10,10,10h30c5.514,0,10-4.486,10-10V10C50,4.486,45.514,0,40,0z M39,17h-3 c-2.145,0-3,0.504-3,2v3h6l-1,6h-5v20h-7V28h-3v-6h3v-3c0-4.677,1.581-8,7-8c2.902,0,6,1,6,1V17z"></path></svg>

                  </span>
                            <span class="text-sm font-medium text-gray-800 group-hover:text-white">Facebook</span>
                        </a>
                        <a
                                href="#"
                                class="flex items-center justify-center px-4 py-2 space-x-2 transition-colors duration-300 border border-blue-500 rounded-md group hover:bg-blue-500 focus:outline-none"
                        >
                  <span>
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class=" w-5 h-5 text-gray-800 fill-current group-hover:text-white" viewBox="0 0 16 16">
  <path d="M15.545 6.558a9.42 9.42 0 0 1 .139 1.626c0 2.434-.87 4.492-2.384 5.885h.002C11.978 15.292 10.158 16 8 16A8 8 0 1 1 8 0a7.689 7.689 0 0 1 5.352 2.082l-2.284 2.284A4.347 4.347 0 0 0 8 3.166c-2.087 0-3.86 1.408-4.492 3.304a4.792 4.792 0 0 0 0 3.063h.003c.635 1.893 2.405 3.301 4.492 3.301 1.078 0 2.004-.276 2.722-.764h-.003a3.702 3.702 0 0 0 1.599-2.431H8v-3.08h7.545z"/>
</svg>
                  </span>
                            <span class="text-sm font-medium text-blue-500 group-hover:text-white">Google</span>
                        </a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>