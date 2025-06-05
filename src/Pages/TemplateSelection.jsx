import React, { useState } from 'react';
import Logo from '../assets/Logo.png';
import KanbanImage from '../assets/kanban.png';
import ScrumImage from '../assets/scrum.png';   

const TemplateSelection = () => {
  const [selectedTemplate, setSelectedTemplate] = useState('kanban');

  const templates = [
    {
      id: 'kanban',
      name: 'Kanban',
      description: 'Visualize work and maximize efficiency with a kanban board.',
      tags: ['Agile', 'Continuous Flow', 'Visual'],
      image: KanbanImage,
    },
    {
      id: 'scrum',
      name: 'Scrum',
      description: 'Plan, prioritize, and schedule sprints using the scrum framework.',
      tags: ['Sprints', 'Teamwork', 'Planning'],
      image: ScrumImage,
    },
  ];

  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-tr from-[#0b0125] via-[#220438] to-[#470133] p-6">
      <div className="bg-white text-gray-800 rounded-xl shadow-2xl max-w-5xl w-full p-10">
        <div className="text-center mb-10">
          <img src={Logo} alt="Logo" className="w-20 mx-auto mb-4" />
          <h1 className="text-3xl font-bold">Select a template to get started</h1>
          <p className="text-gray-500 text-sm">You can always change this later. Selecting a template won’t limit what you can do.</p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          {templates.map((template) => (
            <div
              key={template.id}
              onClick={() => setSelectedTemplate(template.id)}
              className={`cursor-pointer border rounded-lg p-5 transition-all duration-200 hover:shadow-lg ${
                selectedTemplate === template.id
                  ? 'border-blue-600 bg-blue-50'
                  : 'border-gray-200'
              }`}
            >
              <img
                src={template.image}
                alt={`${template.name} Template`}
                className="w-full h-40 object-cover rounded mb-4"
              />
              <h2 className="text-xl font-semibold mb-1">{template.name}</h2>
              <p className="text-sm text-gray-600 mb-2">{template.description}</p>
              <div className="flex flex-wrap gap-2">
                {template.tags.map((tag) => (
                  <span key={tag} className="text-xs bg-gray-200 px-2 py-1 rounded-full">
                    {tag}
                  </span>
                ))}
              </div>
            </div>
          ))}
        </div>

        <div className="mt-10 text-center">
          <button className="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700 transition">
            Continue
          </button>
          <p className="text-xs text-gray-400 mt-2">You can customize your workspace after selecting a template.</p>
        </div>
      </div>
    </div>
  );
};

export default TemplateSelection;
