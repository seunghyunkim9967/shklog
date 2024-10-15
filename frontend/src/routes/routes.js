import React from 'react';
import { Route } from 'react-router-dom';
import PostForm from '../components/PostForm'; // 경로 확인
import PostList from '../components/PostList'; // 경로 확인
import Login from '../components/Login'; // 경로 확인
import Signup from '../components/Signup'; // 경로 확인
import Main from '../components/Main'; // 경로 확인

const routes = (
    <>
        <Route path="/" element={<Login />} />  {/* 기본 경로 */}
        <Route path="/Signup" element={<Signup />} />  {/* 회원가입 */}
        <Route path="/posts/list" element={<PostList />} />  {/* 게시글 목록 경로 */}
        <Route path="/posts/new" element={<PostForm />} />  {/* 게시글 등록 경로 */}
        <Route path="/main" element={<Main />} />
    </>
);

export default routes;