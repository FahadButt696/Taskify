import React from 'react';
import image4 from '../assets/image4.webp';
import image5 from '../assets/image5.webp';
import image6 from '../assets/image6.webp';
import image7 from '../assets/image7.webp';

const JiraFeatures = () => {
  return (
    <section className="py-16 px-6 bg-gray-900 rounded-3xl">
      <div className="max-w-screen-xl mx-auto grid grid-cols-1 md:grid-cols-2 gap-8">

        {/* Block 1 */}
        <div className="bg-white rounded-xl shadow-md overflow-hidden">
          <img src={image6} alt="Backlog Feature" className="w-full object-cover" />
          <div className="p-6">
            <h3 className="text-xl font-bold text-gray-900 mb-2">Sprints & backlog</h3>
            <p className="text-gray-600">
              Agile teams can utilize Taskify backlog to prioritize all their work, and tackle a subset of the work in their next sprint.
            </p>
          </div>
        </div>

        {/* Block 2*/}
        <div className="bg-white rounded-xl shadow-md overflow-hidden">
          <img src={image7} alt="Timeline Feature" className="w-full object-cover" />
          <div className="p-6">
            <h3 className="text-xl font-bold text-gray-900 mb-2">Timeline</h3>
            <p className="text-gray-600">
              See how all work rolls up to the big picture. Understand timing, duration, and dependencies in a single project or across multiple.
            </p>
          </div>
        </div>

        {/* Block 3 */}
        <div className="bg-white rounded-xl shadow-md overflow-hidden">
          <img src={image4} alt="Roadmap Feature" className="w-full object-cover" />
          <div className="p-6">
            <h3 className="text-xl font-bold text-gray-900 mb-2">List View</h3>
            <p className="text-gray-600">
              Swap out the spreadsheets. Organize work into a single list view and update, sort, and prioritize on the fly with in-line editing.
            </p>
          </div>
        </div>

        {/* Block 4 */}
        <div className="bg-white rounded-xl shadow-md overflow-hidden">
          <img src={image5} alt="Reporting Feature" className="w-full object-cover" />
          <div className="p-6">
            <h3 className="text-xl font-bold text-gray-900 mb-2">Calender</h3>
            <p className="text-gray-600">
              Use Taskify calendar view to easily visualize work over time and teams to hit every deadline, together.
            </p>
          </div>
        </div>

      </div>
    </section>
  );
};

export default JiraFeatures;
