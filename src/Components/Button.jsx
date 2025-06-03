import React from 'react';

const Button = () => {
  return (
    <div className="  text-black min-h-screen font-sans">
      {/* Hero Section */}
      <section className="flex flex-col justify-center items-center text-center px-4 min-h-screen">
        <h1 className="text-4xl sm:text-5xl md:text-6xl font-bold leading-tight max-w-4xl">
          Where devs, marketers, and every team in<br />
          between get work done
        </h1>

        {/* Button Row */}
        <div className="flex flex-wrap justify-center gap-4 mt-8">
          {['Plan', 'Track', 'Collaborate', 'Launch', 'Report'].map((label, i) => (
            <button
              key={label}
              className={`px-6 py-3 rounded-full font-semibold transition ${
                i === 0
                  ? 'border-2 bg-white text-black shadow hover:shadow-md'
                  : 'bg-white text-black shadow hover:shadow-md'
              }`}
            >
              {label}
            </button>
          ))}
        </div>
      </section>

      {/* Feature Section */}
      <section className="py-2 text-center">
        <h2 className="text-3xl text-black font-bold mb-10">What you can do</h2>
        <div className=" text-white flex flex-wrap justify-center gap-8 max-w-5xl mx-auto px-4">
          {[
            {
              title: 'Team Planning',
              desc: 'Plan tasks, goals, and deliverables with shared clarity.',
            },
            {
              title: 'Real-Time Tracking',
              desc: 'Monitor progress with dynamic dashboards.',
            },
            {
              title: 'Team Collaboration',
              desc: 'Chat, comment, and work together in one place.',
            },
          ].map((feature) => (
            <div
              key={feature.title}
              className="w-64 p-6 border rounded-lg shadow hover:shadow-lg text-white"
            >
              <h3 className="text-xl font-semibold mb-2">{feature.title}</h3>
              <p className="text-sm text-gray-600">{feature.desc}</p>
            </div>
          ))}
        </div>
      </section>

      {/* Footer */}
      {/* <footer className="py-10 bg-gray-100 text-center text-sm text-gray-500">
        &copy; 2025 Your Company Name. All rights reserved.
      </footer> */}
    </div>
  );
};

export default Button;
