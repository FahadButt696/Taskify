import React from 'react';
 import image3 from '../assets/image3.webp'; // Uncomment and set correct path when ready

const Header = () => {
  return (
    <section className=" py-50 px-6">
      <div className="max-w-screen-xl mx-auto flex flex-col md:flex-row items-center justify-between gap-10">
        
        {/* === Text Section (Left) === */}
        <div className="md:w-1/2 text-center md:text-left">
          <h2 className="text-4xl font-extrabold text-white leading-tight">
            Project management<br />
            features for all teams
          </h2>
          <p className="mt-4 text-lg text-white">
            Built for every team, this system helps modern organizations take work from to-do to done.
          </p>
          <button className="mt-6 px-6 py-3 text-base font-medium text-white bg-blue-600 hover:bg-blue-700 rounded-full">
            Try it free
          </button>
        </div>

        {/* === Image Section (Right) === */}
        
        <div className="md:w-1/2">
          <img 
            src={image3} 
            alt="Project Feature Preview" 
            className="w-full rounded-md shadow-lg" 
          />
        </div> 
       

      </div>
    </section>
  );
};

export default Header;
