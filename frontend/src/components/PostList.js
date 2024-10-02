// src/components/PostList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom'; // Link를 import 추가

const PostList = () => {
    const [posts, setPosts] = useState([]); // 게시글 상태를 저장할 변수

    // 컴포넌트가 마운트될 때 API 호출
    useEffect(() => {
        const fetchPosts = async () => {
            try {
                const response = await axios.get('http://localhost:8080/posts'); // Spring Boot API 주소
                setPosts(response.data); // 받아온 데이터로 상태 업데이트
            } catch (error) {
                console.error('Error fetching posts:', error); // 에러 처리
            }
        };
        fetchPosts();
    }, []); // 빈 배열로 설정하여 컴포넌트가 마운트될 때만 호출

    return (
        <div>
            <h1>게시글 목록</h1>
            <ul>
                {posts.map(post => (
                    <li key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.content}</p>
                    </li>
                ))}
            </ul>
            {/* 게시글 등록 페이지로 이동하는 버튼 추가 */}
            <Link to="/posts/new">
                <button style={{ padding: '10px 15px', backgroundColor: '#007bff', color: '#fff', border: 'none', borderRadius: '5px' }}>
                    게시글 등록
                </button>
            </Link>
        </div>
    );
};

export default PostList;
