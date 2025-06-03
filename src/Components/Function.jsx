import React from 'react';

const Function = () => {
  return (
    <section className="py-5 px-6 border-amber-100 ">
      <div className="max-w-screen-xl mx-auto grid grid-cols-1 md:grid-cols-4 gap-6">
        
        {/* Block 1: Experience and Expertise */}
        <div className="flex flex-col items-center text-center p-6 border hover:bg-black">
          <img
            src="https://img.icons8.com/ios-filled/100/000000/bookmark-ribbon.png"
            alt="Experience Icon"
            className="w-16 h-16 mb-4"
          />
          <h3 className="text-lg font-semibold mb-2">Experience and Expertise</h3>
          <p className="text-white text-sm">
            Non distinctio magni ut expedita culpa sit sapiente omnis vel consectetur sapiente quo quos omnis cum mollitia provident.
          </p>
        </div>

        {/* Block 2: Strategic Marketing */}
        <div className="flex flex-col items-center text-center p-6 border">
          <img
            src="https://img.icons8.com/ios-filled/100/000000/combo-chart.png"
            alt="Marketing Icon"
            className="w-16 h-16 mb-4"
          />
          <h3 className="text-lg font-semibold mb-2">Strategic Marketing</h3>
          <p className="text-white text-sm">
            Non distinctio magni ut expedita culpa sit sapiente omnis vel consectetur sapiente quo quos omnis cum mollitia provident.
          </p>
        </div>

        {/* Block 3: Customer Focused */}
        <div className="flex flex-col items-center text-center p-6 border">
          <img
            src="https://img.icons8.com/ios-filled/100/000000/user.png"
            alt="Customer Icon"
            className="w-16 h-16 mb-4"
          />
          <h3 className="text-lg font-semibold  mb-2">Customer Focused</h3>
          <p className="text-white text-sm">
            Non distinctio magni ut expedita culpa sit sapiente omnis vel consectetur sapiente quo quos omnis cum mollitia provident.
          </p>
        </div>

        {/* Block 4: Honesty and Integrity */}
        <div className="flex flex-col items-center text-center p-6 border">
          <img
            src="https://img.icons8.com/ios-filled/100/000000/umbrella.png"
            alt="Integrity Icon"
            className="w-16 h-16 mb-4"
          />
          <h3 className="text-lg font-semibold  mb-2">Honesty and Integrity</h3>
          <p className="text-white text-sm">
            Non distinctio magni ut expedita culpa sit sapiente omnis vel consectetur sapiente quo quos omnis cum mollitia provident.
          </p>
        </div>

      </div>
    </section>
  );
};

export default Function;
