import React, { useState, useEffect } from 'react';
import '../css/Header.css'; // 스타일을 위한 CSS 파일
import logo from '../image/logo.jpg'; // 로고 이미지 경로

const categories = [
    { name: '홈', link: '/main' },
    { name: '전자제품', link: '/main' },
    { name: '패션', link: '#' },
    { name: '생활용품', link: '#' },
    { name: '식료품', link: '#' },
    { name: '뷰티', link: '#' },
];

const Header = () => {
    const [scrollProgress, setScrollProgress] = useState(0);

    const handleScroll = () => {
        const totalHeight = document.documentElement.scrollHeight - window.innerHeight;
        const scrollPosition = window.scrollY;
        const progress = (scrollPosition / totalHeight) * 100;
        setScrollProgress(progress);
    };

    useEffect(() => {
        window.addEventListener('scroll', handleScroll);
        return () => {
            window.removeEventListener('scroll', handleScroll);
        };
    }, []);

    // 배경 색상 계산 (초록색이 왼쪽에서 시작)
    const backgroundColor = `linear-gradient(to right, green ${scrollProgress}%, #FFCC00 ${scrollProgress}%)`;

    return (
        <header style={{
            padding: '10px 20px',
            background: backgroundColor,
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'space-between',
            position: 'fixed',
            top: 0,
            left: 0,
            right: 0,
            zIndex: 1000
        }}>
            <img src={logo} alt="로고" style={{ height: '40px' }} />
            <nav style={{ display: 'flex', gap: '20px' }}>
                {categories.map((category) => (
                    <a key={category.name} href={category.link}
                       style={{ color: 'black', textDecoration: 'none', padding: '10px', borderRadius: '5px', background: 'white', transition: 'background 0.3s' }}
                       onMouseOver={(e) => e.currentTarget.style.background = '#f0f0f0'}
                       onMouseOut={(e) => e.currentTarget.style.background = 'white'}>
                        {category.name}
                    </a>
                ))}
            </nav>
        </header>
    );
};

export default Header;
