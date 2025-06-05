import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './Components/Navbar';
import Home from './Pages/Home';
import ProductGuide from './Pages/ProductGuide';
import Template from './Pages/Template';
import SignIn from './Pages/SignIn';
import LoginPage from './Pages/LoginPage';
import SidePage from './Pages/SidePage';
import TemplateSelection from './Pages/TemplateSelection'

function App() {
  return (
    // <Router>
    //   <Navbar />
    //   <Routes>
    //     <Route path="/" element={<Home />} />
    //     <Route path="/product-guide" element={<ProductGuide />} />
    //     <Route path="/template" element={<Template />} />
    //     <Route path="/signin" element={<SignIn />} />
    //     <Route path="/login" element={<LoginPage />} />
    //   </Routes>
    // </Router>
    // <SidePage/>
    <TemplateSelection/>
  );
}

export default App;
