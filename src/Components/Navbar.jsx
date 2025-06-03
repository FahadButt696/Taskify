import { Link } from 'react-router-dom';
import React from 'react';
import Logo from '../assets/Logo.png'


const Navbar = () => {
  return (
    <nav className="fixed top-0 left-0 w-full h-20 bg-[#0b0125] shadow-md z-50">
      <div className="max-w-screen-xl mx-auto flex items-center justify-between px-6 py-6">

        {/* Logo */}
        <Link to="/">
  <img src={Logo} alt="Taskify Logo" className="h-10 w-auto" />
</Link>



        {/* Navigation Links */}
        <ul className="flex space-x-8 text-lg text-white">
          <li><Link to="/" className="hover:underline">Home</Link></li>
          <li><Link to="/product-guide" className="hover:underline">Product Guide</Link></li>
          <li><Link to="/template" className="hover:underline">Template</Link></li>
        </ul>

        {/* Buttons */}
        <div className="space-x-3">
          <Link to="/signin">
            <button className="bg-gray-800 hover:bg-gray-600 text-white text-sm px-4 py-1 rounded">
              Sign In
            </button>
          </Link>
          <Link to="/login">
            <button className="bg-gray-800 hover:bg-gray-600 text-white text-sm px-4 py-1 rounded">
              Login
            </button>
          </Link>
        </div>

      </div>
    </nav>
  );
};

export default Navbar;
