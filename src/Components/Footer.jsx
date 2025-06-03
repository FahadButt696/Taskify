import React from 'react';
// import logo from './assets/logo.png'; // Replace with your logo path

const Footer = () => {
  return (
    <footer className="bg-white  text-black px-8 py-12 rounded-2xl max-w-7xl mx-auto ">
      <div className="grid grid-cols-2 md:grid-cols-5 gap-12">

        {/* Logo + Company */}
        <div>
          {/* <img src={logo} alt="Logo" className="h-6 mb-6" /> */}
          <ul className="space-y-6 text-sm font-semibold">
            <li><a></a></li>
            <li>Company</li>
            <li>Careers</li>
            <li>Events</li>
            <li>Blogs</li>
            <li>Investor Relations</li>
            <li>Atlassian Foundation</li>
            <li>Contact us</li>
          </ul>
        </div>

        {/* Products */}
        <div>
          <h4 className="font-bold mb-3">PRODUCTS</h4>
          <ul className="space-y-6 text-sm">
            <li><a href="#">Rovo</a></li>
            <li><a href="#">Jira</a></li>
            <li><a href="#">Jira Align</a></li>
            <li><a href="#">Jira Service Management</a></li>
            <li><a href="#">Confluence</a></li>
            <li><a href="#">Trello</a></li>
            <li><a href="#">Bitbucket</a></li>
          </ul>
          
        </div>

        {/* Resources */}
        <div>
          <h4 className="font-bold mb-3">RESOURCES</h4>
          <ul className="space-y-6 text-sm">
            <li><a href="#">Technical support</a></li>
            <li><a href="#">Purchasing & licensing</a></li>
            <li><a href="#">Atlassian Community</a></li>
            <li><a href="#">Knowledge base</a></li>
            <li><a href="#">Marketplace</a></li>
            <li><a href="#">My account</a></li>
          </ul>
          
        </div>

        {/* Learn */}
        <div>
          <h4 className="font-bold mb-3">LEARN</h4>
          <ul className="space-y-6 text-sm">
            <li><a href="#">Partners</a></li>
            <li><a href="#">Training & certification</a></li>
            <li><a href="#">Documentation</a></li>
            <li><a href="#">Developer resources</a></li>
            <li><a href="#">Enterprise services</a></li>
          </ul>
         
        </div>
      </div>
       <footer className="py-10 bg-gray-100 text-center text-sm text-gray-500">
        &copy; 2025 Taskify . All rights reserved.
      </footer>
    </footer>
  );
};

export default Footer;
