import React from 'react';
import Logo from '../assets/Logo.png';

const LoginPage = () => {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-tr from-[#0b0125] via-[#220438] to-[#470133] text-white font-sans rounded-2xl py-30">
      <div className="w-full max-w-6xl flex rounded-2xl overflow-hidden shadow-2xl bg-[#0f012c]">

        {/* Left: Replaced with Jira-style Login */}
        <div className="w-1/2 p-10 bg-[#0b0125] flex flex-col justify-center items-center text-center">
          <div className="mb-6">
            <img
              src={Logo}
              alt="Logo"
              className="w-28 h-auto mx-auto"
            />
          </div>

          <h1 className="text-3xl font-bold mb-2">Welcome back, Asif</h1>
          <p className="text-sm text-gray-400 mb-6">
            It’s free for up to 10 users - no credit card needed.
          </p>

          <div className="flex items-center justify-center border border-green-400 rounded px-4 py-2 mb-6 bg-transparent w-full max-w-md">
            <input
              type="text"
              value="asifshoaib625-1749134815222"
              className="bg-transparent outline-none text-white w-full"
              readOnly
            />
            <span className="text-gray-400">.atlassian.net</span>
            <svg
              className="w-5 h-5 text-green-400 ml-2"
              fill="none"
              stroke="currentColor"
              strokeWidth="2"
              viewBox="0 0 24 24"
            >
              <path strokeLinecap="round" strokeLinejoin="round" d="M5 13l4 4L19 7" />
            </svg>
          </div>

          <button className="bg-blue-600 hover:bg-blue-700 text-white px-6 py-2 rounded-full font-semibold">
            Continue
          </button>
        </div>

        {/* Right: Taskify Branding Content */}
        <div className="w-1/2 relative bg-[#0f012c] p-10 flex flex-col justify-between items-center text-center">

          <div className="mb-8">
            <h1 className="text-4xl font-bold mb-4">Welcome to Taskify</h1>
            <p className="mb-6 px-4 text-gray-300">
              Supercharge your team's productivity. Taskify helps you manage projects, assign tasks, track progress, and stay in sync — all in one modern dashboard.
            </p>
            <ul className="text-left text-gray-400 text-sm space-y-2 px-4">
              <li>✅ Easy drag-and-drop task board</li>
              <li>✅ Real-time collaboration</li>
              <li>✅ Smart notifications & reminders</li>
              <li>✅ Analytics & progress tracking</li>
            </ul>
          </div>

          <p className="text-sm text-gray-400">
            Don’t have an account? <a href="#" className="text-cyan-400 hover:underline">Sign up here</a>
          </p>

          {/* Background Visual */}
          <div className="absolute top-0 right-0 w-full h-full z-[-1] bg-[radial-gradient(ellipse_at_center,_var(--tw-gradient-stops))] from-[#9f44d3] via-transparent to-transparent blur-3xl opacity-50" />
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
