import React from "react";
import image8 from "../assets/image8.png";
import image9 from "../assets/image9.png";
import image10 from "../assets/image10.png";
import image11 from "../assets/image11.png";
import image12 from "../assets/image12.png";
import image13 from "../assets/image13.png";
import image14 from "../assets/image14.png";
import Navbar from "../Components/Navbar";
import Footer from "../Components/Footer";

const templates = [
  { icon: "sync_alt", label: "Software Development" },
  { icon: "campaign", label: "Marketing" },
  { icon: "edit", label: "Design" },
  { icon: "business", label: "Sales" },
  { icon: "settings", label: "Operations" },
  { icon: "chat", label: "Service Management" },
  { icon: "person", label: "Human Resources" },
  { icon: "attach_file", label: "Legal" },
  { icon: "desktop_windows", label: "IT Operations" },
  { icon: "attach_money", label: "Finance" },
];

export default function Template() {
  return (
    <>
      <Navbar />

      {/* Header & Categories Section */}
      <section className="min-h-screen flex flex-col items-center px-4 py-20 space-y-4">
        <h1 className="text-4xl md:text-5xl font-bold text-center text-black mb-4">
          There’s a Taskify template for that
        </h1>
        <p className="text-center text-lg text-gray-950 max-w-2xl mb-10">
          No need to start from scratch – choose from dozens of ready-made
          templates and get your project started quickly.
        </p>

        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6 max-w-6xl w-full">
          {templates.map((template, index) => (
            <div
              key={index}
              className="flex items-center gap-3 px-4 py-3 bg-white shadow rounded-md hover:shadow-lg transition"
            >
              <span className="material-icons text-blue-600 text-xl">
                {template.icon}
              </span>
              <span className="font-semibold text-gray-800 uppercase text-sm">
                {template.label}
              </span>
            </div>
          ))}
        </div>
      </section>

      {/* Featured Section */}
      <section className="bg-[#0B1F3A] py-20 px-6 md:px-20 flex flex-col lg:flex-row items-center justify-between gap-10">
        {/* Image */}
        <div className="w-full lg:w-1/2">
          <img
            src={image8}
            alt="Scrum template preview"
            className="rounded-lg shadow-lg"
          />
        </div>

        {/* Text Content */}
        <div className="w-full lg:w-1/2 text-white space-y-6">
          <p className="text-sm uppercase tracking-wide text-gray-400">
            Template of the Month
          </p>
          <h2 className="text-4xl font-bold">Scrum</h2>
          <p className="text-lg text-gray-300 leading-relaxed">
            The scrum template is pre-formatted to help teams organize and plan
            their work within the Scrum framework. Scrum is one of the most
            popular frameworks for implementing agile. With scrum, the product
            is built in a series of fixed-length iterations called sprints that
            give teams a framework for shipping on a regular cadence.
          </p>

          <div className="flex flex-col sm:flex-row gap-4 pt-4">
            <button className="bg-yellow-400 hover:bg-yellow-500 text-black font-medium py-2 px-4 rounded">
              Use template
            </button>
            <button className="text-white underline hover:text-yellow-400">
              Learn more →
            </button>
          </div>
        </div>
      </section>

      {/* Popular Templates Section */}
      <section className="px-6 md:px-20 py-20 bg-white mb-24">
        <h2 className="text-3xl font-bold text-gray-900 mb-10">
          Most popular templates
        </h2>

        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8">
          {[image9, image10, image11, image12, image13, image14].map(
            (img, i) => {
              const titles = [
                "Scrum",
                "Kanban",
                "Bug tracking",
                "Timeline",
                "Toolchain",
                "List",
              ];
              const descriptions = [
                "Visualize, track, and manage your work easily from sprint to sprint.",
                "Manage a continuous delivery of work on a powerful board.",
                "Capture, track, and resolve bugs quickly.",
                "Plan your work on a timeline for better visibility.",
                "Integrate with your favorite dev tools.",
                "Manage tasks in a detailed list view.",
              ];
              return (
                <div
                  key={i}
                  className="bg-white shadow-md rounded-lg overflow-hidden border border-gray-100 hover:shadow-xl transition"
                >
                  <img
                    src={img}
                    alt={titles[i]}
                    className="w-full h-48 object-cover"
                  />
                  <div className="p-4">
                    <h3 className="text-lg font-semibold text-gray-900">
                      {titles[i]}
                    </h3>
                    <p className="text-sm text-gray-600 mt-1">
                      {descriptions[i]}
                    </p>
                  </div>
                </div>
              );
            }
          )}
        </div>
      </section>

      {/* Footer with spacing */}
      <Footer />
    </>
  );
}
