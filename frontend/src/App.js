import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Routes와 Route를 import
import routes from './routes/routes'; // 기존 라우트 import

function App() {
    return (
        <Router>
            <div>
                <Routes>
                    {routes}
                </Routes>
            </div>
        </Router>
    );
}

export default App;