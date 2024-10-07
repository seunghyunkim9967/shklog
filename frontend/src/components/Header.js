import React from 'react';
import logo from '../image/logo.jpg'; // 로고 이미지 경로

const categories = [
    { name: '홈', link: '#' },
    { name: '전자제품', link: '#' },
    { name: '패션', link: '#' },
    { name: '생활용품', link: '#' },
    { name: '식료품', link: '#' },
    { name: '뷰티', link: '#' },
];

const Header = () => {
    return (
        <header style={{ padding: '10px 20px', background: '#FFCC00', display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
            <img src={logo} alt="로고" style={{ height: '40px' }} />
            <nav style={{ display: 'flex', gap: '20px' }}>
                {categories.map((category) => (
                    <a key={category.name} href={category.link} style={{ color: 'black', textDecoration: 'none', padding: '10px', borderRadius: '5px', background: 'white', transition: 'background 0.3s' }}
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