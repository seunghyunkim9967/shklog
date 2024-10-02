// src/components/PostForm.js
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom'; // useNavigate import

const PostForm = () => {
    const [title, setTitle] = useState(''); // 제목 상태
    const [content, setContent] = useState(''); // 내용 상태
    const navigate = useNavigate(); // useNavigate 훅 사용하여 navigate 선언

    const handleSubmit = async (e) => {
        e.preventDefault(); // 기본 폼 제출 방지
        try {
            const response = await axios.post('http://localhost:8080/posts', {
                title,
                content,
            }); // 게시글 등록 API 호출
            console.log('게시글 등록 성공:', response.data);
            // 등록 후 폼 초기화
            setTitle('');
            setContent('');
            // 게시글 등록 성공 후 게시글 목록 페이지로 이동
            navigate('/'); // '/' 경로로 리다이렉트
        } catch (error) {
            console.error('게시글 등록 실패:', error); // 에러 처리
        }
    };

    return (
        <div>
            <h1>게시글 등록</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>제목:</label>
                    <input
                        type="text"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>내용:</label>
                    <textarea
                        value={content}
                        onChange={(e) => setContent(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">등록</button>
            </form>
        </div>
    );
};

export default PostForm;
