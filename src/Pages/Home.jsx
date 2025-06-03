import React from 'react'
import Navbar from '../components/Navbar';
import Header from '../components/Header';
import Function from '../components/Function';
import Projects from '../components/Projects';
import Footer from '../components/Footer';

function Home() {
  return (
    <div>
      <Navbar/>
      <Header/>
       <Function/>
      <Projects/>
      <Footer/> 
    </div>
  )
}

export default Home
