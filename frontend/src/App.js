import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Routes와 Route를 import
import routes from './routes/routes'; // 기존 라우트 import
import Header from './components/Header';
import MainContent from './components/Main';
import Footer from './components/Footer';

function App() {
    return (
        <Router>
            <div>
                <Header />
                <Routes>
                    {routes}
                </Routes>
                <Footer />
            </div>
        </Router>
    );
}

export default App;