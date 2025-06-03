import React from 'react';
import Logo from '../assets/Logo.png';

const LoginPage = () => {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-tr from-[#0b0125] via-[#220438] to-[#470133] text-white font-sans rounded-2xl">
      <div className="w-full max-w-6xl flex rounded-2xl overflow-hidden shadow-2xl bg-[#0f012c]">

        {/* Left: Form Panel */}
        <div className="w-1/2 p-10 bg-[#0b0125] flex flex-col justify-center">
          
          {/* Logo Placeholder */}
          <div className="mb-6">
            <img
               src={Logo}
              alt="Logo"
              className="w-32 h-auto"
            />
          </div>

          {/* Sign In Heading */}
          <h2 className="text-3xl font-bold text-center text-white mb-6">Sign In</h2>

          {/* User Icon */}
          <div className="text-center text-cyan-400 mb-4 text-4xl">👤</div>

          {/* First Name */}
          <input
            type="text"
            placeholder="First Name"
            className="mb-4 px-4 py-2 rounded border border-gray-600 bg-transparent text-white placeholder-gray-400 focus:outline-none"
          />

          {/* Last Name */}
          <input
            type="text"
            placeholder="Last Name"
            className="mb-4 px-4 py-2 rounded border border-gray-600 bg-transparent text-white placeholder-gray-400 focus:outline-none"
          />

          {/* Email */}
          <input
            type="email"
            placeholder="Email"
            className="mb-4 px-4 py-2 rounded border border-gray-600 bg-transparent text-white placeholder-gray-400 focus:outline-none"
          />

          {/* Password */}
          <input
            type="password"
            placeholder="Password"
            className="mb-4 px-4 py-2 rounded border border-gray-600 bg-transparent text-white placeholder-gray-400 focus:outline-none"
          />

          {/* Sign In Button */}
          <button className="bg-pink-600 hover:bg-pink-700 py-2 rounded text-white font-bold mb-2">
            Sign In
          </button>

          {/* Remember Me / Forgot Password */}
          <div className="flex justify-between text-sm text-gray-400">
            <label>
              <input type="checkbox" className="mr-1" />
              Remember me
            </label>
            <a href="#" className="hover:underline">Forgot your password?</a>
          </div>
        </div>

        {/* Right: Welcome Panel with Enhancements */}
        <div className="w-1/2 relative bg-[#0f012c] p-10 flex flex-col justify-between items-center text-center">

          {/* Optional CTA Button */}
          <button className="self-end bg-cyan-500 hover:bg-cyan-600 px-4 py-1 rounded text-white mb-4">
            Login
          </button>

          {/* Welcome Text */}
          <div>
            <h1 className="text-5xl font-bold mb-4">Welcome to Taskify</h1>
            <p className="mb-6 px-4">
              Manage your tasks, track bugs, and collaborate seamlessly with your team.
              Taskify helps you stay organized and productive with powerful tools and clean interfaces.
            </p>

            {/* Tagline or Quote */}
            <blockquote className="italic text-gray-400 mb-6">
              "Productivity is never an accident. It is always the result of a commitment to excellence."
            </blockquote>

            {/* CTA for Sign Up */}
            <p className="text-sm text-gray-300">
              Don’t have an account? <a href="#" className="text-cyan-400 hover:underline">Sign up here</a>
            </p>
          </div>

         

          {/* Decorative Swirl Effect */}
          <div className="absolute top-0 right-0 w-full h-full z-[-1] bg-[radial-gradient(ellipse_at_center,_var(--tw-gradient-stops))] from-[#9f44d3] via-transparent to-transparent blur-3xl opacity-50" />
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
