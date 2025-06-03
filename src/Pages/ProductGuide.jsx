import React from "react";
import image18 from "../assets/image18.png";
import image19 from "../assets/image19.svg";
import image20 from "../assets/image20.png";
import image21 from "../assets/image21.png";
import image22 from "../assets/image22.png";
import Navbar from "../Components/Navbar";
import Footer from "../Components/Footer";


const ProductGuide = () => {
  return (
    <>
    <Navbar/>
    <div className="px-6 py-20 max-w-5xl mx-auto">
      {/* Welcome Header */}
      <h1 className="text-4xl font-bold text-white mb-6">Welcome to Taskify</h1>

      {/* Section: Everything you need to know */}
      <div className="flex flex-col md:flex-row items-center md:justify-between gap-10 mb-12">
        <div className="md:w-1/2">
          <h2 className="text-2xl font-semibold text-Black mb-4">
            Everything you’ll need to know
          </h2>
          <p className="text-white text-base">
            Whether you've used it in a past life, or have never heard of it,
            we'll help you navigate choosing the right product, setting it up,
            and learning the best practices. So grab your team and let's go!
          </p>
        </div>
        <div className="md:w-1/2">
          {/* Placeholder image — replace with your actual image */}
          <img
            src={image18}
            alt="Taskify Introduction"
            className="w-full max-w-md mx-auto"
          />
        </div>
      </div>

      <hr className="my-10 border-gray-300" />

      {/* Section: What is Taskify? */}
      <div>
        <h2 className="text-2xl font-semibold text-white mb-4">What is Taskify?</h2>
        <p className="text-white text-base">
          Taskify is the #1{" "}
          <a
            href="#"
            className="text-blue-600 underline hover:text-blue-800 transition"
          >
            agile project management
          </a>{" "}
          tool used by teams to plan, track, release and support world-class
          software with confidence. It is the single source of truth for your
          entire development lifecycle, empowering autonomous teams with the
          context to move quickly while staying connected to the greater
          business goal. Whether used to manage simple projects or to power
          your DevOps practices, it makes it easy for teams to move work
          forward, stay aligned, and communicate in context.{" "}
          <a
            href="#"
            className="text-blue-600 underline hover:text-blue-800 transition"
          >
            Sign up for a live demo of Taskify.
          </a>
        </p>
      </div>
    </div>

     <div className="px-6 py-12 max-w-5xl mx-auto">
      {/* Header */}
      <h2 className="text-2xl font-semibold text-white mb-4">Who uses Taskify?</h2>

      {/* Description */}
      <p className="text-white text-base mb-6">
        Taskify launched in 2002 as an issue tracking and project management tool for teams.
        Since then, 300,000+ companies globally have adopted Taskify for its flexibility to
        support any type of project and extensibility to work with thousands of apps and integrations.
      </p>

      {/* List of Users */}
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-x-10 gap-y-2 text-white text-base list-disc list-inside">
        <ul>
          <li>Agile teams</li>
          <li>Bug tracking teams</li>
          <li>DevOps teams</li>
        </ul>
        <ul>
          <li>Product management teams</li>
          <li>Project management teams</li>
          <li>Software development teams</li>
        </ul>
      </div>
    </div>



        {/* Last Section: Features */}
    <div className="px-6 py-12 max-w-5xl mx-auto bg-gray-950 rounded-2xl mb-24"> {/* 👈 added mb-24 */}
      {/* Heading */}
      <h2 className="text-2xl font-semibold text-white mb-4">
        Dig into specific features
      </h2>

      {/* Description */}
      <p className="text-white text-base mb-10">
        Taskify supports any agile project management methodology for software development that your team might need.
        From agile planning to fully customizable Kanban and{" "}
        <a
          href="#"
          className="text-blue-600 underline hover:text-blue-800 transition"
        >
          Scrum boards
        </a>
        , Taskify gives you the tools you need to estimate, report and measure
        velocity with workflows designed to fit your frameworks.
      </p>

      {/* Features Grid */}
      <div className="grid grid-cols-1 md:grid-cols-2 gap-12 mb-12">
        {/* Feature 1 */}
        <div className="flex flex-col items-start text-white">
          <img src={image19} alt="Boards" className="mb-4 w-24 h-auto" />
          <h3 className="text-lg font-semibold mb-1">Boards</h3>
          <p className="mb-2">
            Manage your work with powerful Scrum and Kanban agile boards.
          </p>
          <a href="#" className="text-blue-600 underline hover:text-blue-800">
            Quick look
          </a>
        </div>

        {/* Feature 2 */}
        <div className="flex flex-col items-start text-white">
          <img src={image20} alt="Timeline" className="mb-4 w-24 h-auto" />
          <h3 className="text-lg font-semibold mb-1">Timeline</h3>
          <p className="mb-2">
            Plan and track work in the timeline view to ensure your team stays in sync and ahead of dependencies.
          </p>
          <a href="#" className="text-blue-600 underline hover:text-blue-800">
            Quick look
          </a>
        </div>

        {/* Feature 3 */}
        <div className="flex flex-col items-start text-white">
          <img src={image21} alt="Performance" className="mb-4 w-24 h-auto" />
          <h3 className="text-lg font-semibold mb-1">Reports & Metrics</h3>
          <p className="mb-2">
            Visualize your team’s performance with built-in reports and insights to optimize future sprints.
          </p>
          <a href="#" className="text-blue-600 underline hover:text-blue-800">
            Quick look
          </a>
        </div>

        {/* Feature 4 */}
        <div className="flex flex-col items-start text-white">
          <img src={image22} alt="Integrations" className="mb-4 w-24 h-auto" />
          <h3 className="text-lg font-semibold mb-1">Integrations</h3>
          <p className="mb-2">
            Seamlessly connect with your favorite tools to extend Taskify’s capabilities across your workflow.
          </p>
          <a href="#" className="text-blue-600 underline hover:text-blue-800">
            Quick look
          </a>
        </div>
      </div>
    </div>

    {/* Footer now has visual space above */}
    <Footer />

    </>
  );
};

export default ProductGuide;
