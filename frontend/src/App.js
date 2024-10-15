import React from 'react';
import { BrowserRouter as Router, Routes, Route, useLocation } from 'react-router-dom'; // Routes와 Route를 import
import routes from './routes/routes'; // 기존 라우트 import
import Header from './components/Header';
import Main from './components/Main';
import Footer from './components/Footer';
import Signup from './components/Signup';
import Login from './components/Login';

function App() {
    const location = useLocation();

    // 로그인 페이지와 회원가입 페이지 경로 확인
    const isAuthPage = location.pathname === '/' || location.pathname === '/signup';

    return (
            <div>
                {!isAuthPage && <Header />} {/* 인증 페이지가 아닐 때 Header 표시 */}
                <Routes>
                    {routes}
                </Routes>
                <Footer />
            </div>
    );
}

const AppWrapper = () => (
    <Router>
        <App />
    </Router>
);

export default AppWrapper;