import React from 'react';
import Logo from '../assets/Logo.png';

const LoginPage = () => {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-tr from-[#0b0125] via-[#220438] to-[#470133] text-white font-sans rounded-2xl py-30">
      <div className="w-full max-w-6xl flex rounded-2xl overflow-hidden shadow-2xl bg-[#0f012c]">

        {/* Left: Login Form */}
        <div className="w-1/2 p-10 bg-[#0b0125] flex flex-col justify-center">
          {/* Logo or Branding */}
          <div className="mb-6 text-center">
            <img
              src={Logo}
              alt="Logo"
              className="w-28 h-auto mx-auto"
            />
          </div>

          <h2 className="text-3xl font-bold text-center text-white mb-8">Login</h2>

          <div className="space-y-4">
            <input
              type="text"
              placeholder="Username"
              className="w-full px-4 py-2 rounded border border-gray-600 bg-transparent text-white placeholder-gray-400 focus:outline-none"
            />
            <input
              type="password"
              placeholder="Password"
              className="w-full px-4 py-2 rounded border border-gray-600 bg-transparent text-white placeholder-gray-400 focus:outline-none"
            />
          </div>

          <button className="mt-6 bg-pink-600 hover:bg-pink-700 py-2 rounded text-white font-bold">
            Login
          </button>

          <div className="flex justify-between mt-4 text-sm text-gray-400">
            <label>
              <input type="checkbox" className="mr-1" />
              Remember me
            </label>
            <a href="#" className="hover:underline">Forgot your password?</a>
          </div>
        </div>

        {/* Right: Welcome Panel */}
        <div className="w-1/2 relative bg-[#0f012c] p-10 flex flex-col justify-between items-center text-center">

          {/* Top Right CTA Button */}
          <button className="self-end bg-cyan-500 hover:bg-cyan-600 px-4 py-1 rounded text-white mb-4">
            Sign In
          </button>

          {/* Welcome Message */}
          <div>
            <h1 className="text-5xl font-bold mb-4">Welcome to Taskify</h1>
            <p className="mb-6 px-4">
              Manage your tasks, track bugs, and collaborate seamlessly with your team.
              Taskify helps you stay organized and productive with powerful tools and clean interfaces.
            </p>

            <blockquote className="italic text-gray-400 mb-6">
              "Efficiency is doing better what is already being done."
            </blockquote>

            <p className="text-sm text-gray-300">
              Don’t have an account? <a href="#" className="text-cyan-400 hover:underline">Sign up here</a>
            </p>
          </div>

          {/* Background Effect */}
          <div className="absolute top-0 right-0 w-full h-full z-[-1] bg-[radial-gradient(ellipse_at_center,_var(--tw-gradient-stops))] from-[#9f44d3] via-transparent to-transparent blur-3xl opacity-50" />
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
